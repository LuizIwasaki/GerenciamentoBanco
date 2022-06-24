
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ClienteDAO;
import br.edu.ifsp.pep.modelo.Cliente;
import br.edu.ifsp.pep.util.Util;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ControleCliente implements Serializable {
    
    private Cliente cliente = new Cliente();
    @Inject 
    private ClienteDAO dao;
    private List<Cliente> clientes;
    private Cliente clienteAutenticado;
    private Cliente clienteSelecionado;
    public void cadastrarCliente()
    {
        //criando um boolean para receber os dados do cadastro, já que com object ele está retornando null
            boolean vrf;
                        if(cliente.getNomeCliente().isEmpty() || cliente.getSenhaCliente().isEmpty()
                                || cliente.getCpfCliente().isEmpty() || cliente.getDataNascimento() == null
                                || cliente.getRuaCliente().isEmpty() || cliente.getNumeroCliente().isEmpty())
            {
                Util.addMessageError("Faltam dados a serem preenchidos");
            }
            else{
                       vrf =  dao.addLogin(cliente.getNomeCliente(),cliente.getCpfCliente(),
                               cliente.getRuaCliente(),cliente.getNumeroCliente(),cliente.getDataNascimento(),cliente.getSenhaCliente());
            if(vrf)   
            {
                Util.addMessageInformation("O usuário foi cadastrado com sucesso");
                System.out.println("Entrou cert");
            }
            else    
            {
                Util.addMessageError("Usuario nao pode ser cadastrado.");
            }     
             }
            
    }
    public String logar()
    {   
        clienteAutenticado = dao.
                checklogin(cliente.getNomeCliente(), cliente.getSenhaCliente());
        
        if (clienteAutenticado != null) {
            Util.addMessageInformation("Usuário autenticado...");
            return "homeCliente.xhtml";
        }
        else {
            Util.addMessageError("Login ou Senha inválidos.");
        }
        this.cliente = new Cliente();
        return "loginCliente.xhtml";
    }
        

    public Cliente getCliente() {
        return cliente;
    }

    public ClienteDAO getDao() {
        return dao;
    }

    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }
    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<Cliente> getClientes() {
        return dao.buscarTodos();
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getClienteAutenticado() {
        return clienteAutenticado;
    }

    public void setClienteAutenticado(Cliente clienteAutenticado) {
        this.clienteAutenticado = clienteAutenticado;
    }
    
    
}
