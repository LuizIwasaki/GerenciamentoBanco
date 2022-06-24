package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author biers
 */
@Entity
@Table(name = "conta")
public class Conta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_conta;
    
    @Column(name = "idCliente")
    private long idCliente;
    @Column(name = "agencia", nullable = false)
    private String agencia;
    @Column(name = "conta", nullable = false)
    private String conta;
    @Column(name = "saldo", nullable = false)
    private double saldo;
     @Column(name = "limiite", nullable = false)
    private double limite;
    @Column(name = "saque", nullable = false)
    private double saque;
    @Column(name = "transferencia", nullable = false)
    private double transferencia;
    @Column(name = "deposito", nullable = false)
    private double deposito;
    @Column(name = "tipoconta", nullable = false)
    private int tipoConta;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    
    public long getId() {
        return id_conta;
    }
    public void setId(long id_conta) {
        this.id_conta = id_conta;
    }
    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }
    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public long getId_conta() {
        return id_conta;
    }

    public void setId_conta(long id_conta) {
        this.id_conta = id_conta;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
