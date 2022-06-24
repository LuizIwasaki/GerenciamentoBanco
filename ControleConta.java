package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ContaDAO;
import br.edu.ifsp.pep.modelo.Cliente;
import br.edu.ifsp.pep.modelo.Conta;
import br.edu.ifsp.pep.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ControleConta implements Serializable {

    private Conta conta = new Conta();
    @Inject
    private ContaDAO dao;
    private List<Conta> contas;
    
    public void cadastrarConta() {
        
       if(conta.getIdCliente() != -1)
        {
            
            if(dao.checklogin(conta.getAgencia(), conta.getConta()) == null)
            {
                List<Conta> contas = new ArrayList();
                contas.add(conta);
                Util.addMessageInformation("Cadastro Bem Sucedido.");
            }
            else{
                Util.addMessageWarning("Conta já cadastrada");
            }
            this.conta = new Conta();
            
        }
        else{
            Util.addMessageWarning("Selecione um cliente para Adicionar");
        }
       
    }
        
       public void autenticarSaque()
       {
           if(dao.checklogin(conta.getAgencia(), conta.getConta()).equals(true))
           {
               
           }
       }

public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

   
}
