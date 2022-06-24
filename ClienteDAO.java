package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Cliente;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "GerenciamentoBancoPU")
    private EntityManager em;

    public Cliente checklogin(String nome, String senha) {
        System.out.println(nome);
        System.out.println(senha);
        TypedQuery<Cliente> query = em.createQuery(
                "Select c FROM Cliente c WHERE c.nomeCliente = :nome AND c.senhaCliente = :senha",
                Cliente.class);
        query.setParameter("nome", nome);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }

    public boolean addLogin(String nome, String cpf, String rua, String numero, Date dataNascimento, String senha) {
        boolean vrf;
        try {
            em.createNativeQuery("INSERT INTO cliente(nome,cpf,rua,numero,dataNascimento,senha) VALUES (?,?,?,?,?,?)")
                    .setParameter(1, nome)
                    .setParameter(2, cpf)
                    .setParameter(3, rua)
                    .setParameter(4, numero)
                    .setParameter(5, dataNascimento)
                    .setParameter(6, senha)
                    .executeUpdate();
            vrf = true;
        } catch (Exception e) {
            vrf = false;
            System.out.println("Erro:" + e.toString());
        }
        System.out.println("verificou:" + vrf);
        return vrf;
    }

    public List<Cliente> buscarTodos() {
        return em.createQuery("Select c FROM Cliente c",
                Cliente.class).getResultList();
    }

    public void remove(Cliente cli) {
        em.remove(em.find(Cliente.class, cli.getId_cliente()));
    }

}
