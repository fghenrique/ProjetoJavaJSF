/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author fabricio
 */
public abstract class AbstractFacade<T> {


    private Class<T> entityClasse;
    
    public AbstractFacade(Class<T> entityClass){
        this.entityClasse = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
   public void salvar(T entity){
       getEntityManager().persist(entity);
   }
   
   public void editar(T entity){
       getEntityManager().merge(entity);
   }
   
   public void excluir(T entity){
       getEntityManager().remove(getEntityManager().merge(entity));
   }
    
    
}
