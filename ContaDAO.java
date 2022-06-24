package br.edu.ifsp.pep.dao;


import br.edu.ifsp.pep.modelo.Conta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author biers
 */
@Stateless
public class ContaDAO {
    @PersistenceContext(unitName = "GerenciamentoBancoPU")
    private EntityManager em;

    public boolean addLogin(String agencia, String conta, int tipo,double saldo,double limite) {
    return false;
    }
        public Conta checklogin(String agencia, String conta) {
        
            try {
                return em.createQuery("Select cc FROM Conta cc WHERE CC.agencia = :agencia AND cc.conta = :conta",
                Conta.class)
  .setParameter("agencia", agencia)
     .setParameter("conta", conta)
                .getSingleResult();
            } catch (Exception e) {
                return null;
            }
    }
                public List<Conta> buscarTodos() {
        return em.createQuery("Select cc FROM Conta cc",
                Conta.class).getResultList();
    }
}
