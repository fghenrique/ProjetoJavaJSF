/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import javax.ejb.Stateless;
import entidades.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabricio
 */
@Stateless
public class PessoaFacate extends AbstractFacade<Pessoa>{

    @PersistenceContext(unitName = "ProjetoJavaJSFPU")
    private EntityManager em;
    
    
    public PessoaFacate(){
        super(Pessoa.class);
    }
    
    public List<Pessoa> recuperarTodos(){
       return em.createQuery("select p from Pessoa as p order by p.nome").getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
