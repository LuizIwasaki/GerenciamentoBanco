package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ClienteDAO;
import br.edu.ifsp.pep.dao.FuncionarioDAO;
import br.edu.ifsp.pep.modelo.Cliente;
import br.edu.ifsp.pep.modelo.Funcionario;
import br.edu.ifsp.pep.util.Util;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author biers
 */
@Named
@RequestScoped
public class ControleFuncionario implements Serializable {

    private Funcionario funcionario = new Funcionario();
    @Inject
    private FuncionarioDAO funcionarioDAO;
    private ClienteDAO clienteDAO;
    private boolean funcionarioCadastrado;
    private Funcionario funcionarioAutenticado;
    private Cliente clienteSelecionado;

    public void cadastrarFuncionario() {
        System.out.println("Nome:" + funcionario.getNomeFuncionario());
        System.out.println("CPF:" + funcionario.getCpfFuncionario());
        System.out.println("SENHA:" + funcionario.getSenhaFuncionario());
        if (funcionario.getNomeFuncionario().isEmpty() || funcionario.getCpfFuncionario().isEmpty()
                || funcionario.getSenhaFuncionario().isEmpty()
                || funcionario.getTelefoneFuncionario().isEmpty() || funcionario.getCargoFuncionario().isEmpty()) {
                Util.addMessageWarning("Existem campos não preenchidos");
           
        } else {
             this.funcionarioCadastrado = funcionarioDAO.addLogin(funcionario.getNomeFuncionario(), funcionario.getCpfFuncionario(),
                    funcionario.getTelefoneFuncionario(), funcionario.getCargoFuncionario(), funcionario.getSenhaFuncionario());
            if (this.funcionarioCadastrado) {
                Util.addMessageInformation("Cadastro Realizado com Sucesso!");
            }
        }
    }

    public String logarFuncionario() {
        funcionarioAutenticado = funcionarioDAO.
                checkLogin(funcionario.getNomeFuncionario(), funcionario.getCpfFuncionario(),
                        funcionario.getSenhaFuncionario());
        if (funcionarioAutenticado != null) {
            Util.addMessageInformation("Usuário Autenticado.");
            return "homeFuncionario.xhtml";
        } else {
            Util.addMessageWarning("Usuário não encontrado.");
        }
        return "loginFuncionario.xhtml";
    }

    public void excluirCliente() {
        if (clienteSelecionado != null) {
            this.clienteDAO.remove(clienteSelecionado);

            Util.addMessageInformation("Cliente Excluido.");
        } else {
            Util.addMessageWarning("Selecione um cliente.");
        }
    }

    public String cadastroDialog() {
        System.out.println("Entrou");
        return "cadastrar.xhtml";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

}
