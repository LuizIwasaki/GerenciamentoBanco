package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Funcionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author biers
 */
@Stateless
public class FuncionarioDAO {
     @PersistenceContext(unitName = "GerenciamentoBancoPU")
    private EntityManager em;
     
     public Funcionario checkLogin(String nome,String cpf,String senha)
     {
         
                         TypedQuery<Funcionario> query = em.createQuery(
                "Select f FROM Funcionario f WHERE f.nomeFuncionario = :nome "
                     + "AND f.cpfFuncionario = :cpf AND f.senhaFuncionario = :senha",
                Funcionario.class);
        query.setParameter("nome", nome);
        query.setParameter("cpf", cpf);
        query.setParameter("senha", senha);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
     }
     public boolean addLogin(String nome, String cpf,String telefone,String cargo, String senha)
   {
       boolean vrf;
       try{
       em.createNativeQuery("INSERT INTO funcionario(nome, cpf,telefone, cargo, senha) VALUES (?,?,?,?,?)")
      .setParameter(1, nome)
      .setParameter(2, cpf)
      .setParameter(3, telefone)
      .setParameter(4, cargo)
      .setParameter(5, senha)
      .executeUpdate();
        vrf=true;
        
       }catch(Exception e){
           vrf=false;
           System.out.println("Erro:"+e.toString());
       }
       System.out.println("verificou:"+vrf);
       return vrf;
   }
}
