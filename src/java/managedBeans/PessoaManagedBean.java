/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;


import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessao.PessoaFacate;
import entidades.Pessoa;
import javax.faces.model.ListDataModel;

/**
 *
 * @author fabricio
 */
@Named(value = "pessoaManagedBean")
@ManagedBean
@SessionScoped
public class PessoaManagedBean {

    @EJB
    private PessoaFacate pessoaFacate;
    private Pessoa pessoa;
    
    private ListDataModel pessoas;

    public ListDataModel getPessoas() {
        return pessoas;
    }

    public void setPessoas(ListDataModel pessoas) {
        this.pessoas = pessoas;
    }
    

    public void recuperarPessoas(){
        this.pessoas = new ListDataModel(pessoaFacate.recuperarTodos());
    }
    
    
    public Pessoa getPessoa(){
        if(pessoa == null){
            pessoa = new Pessoa();
        }
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    
    public String inserir(){
        this.pessoaFacate.salvar(pessoa);
        return "/pessoa/listar";
    }
    
    public String montarPaginaSalvar(){
        return "/pessoa/inserir";
    }
    
    public String montarPaginaListar(){
        return "/pessoa/listar";
    }
    
    
    public PessoaManagedBean() {
    }
    
}
