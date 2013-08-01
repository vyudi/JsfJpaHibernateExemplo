package managedbeans;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import repository.ProdutoRepository;

import entities.Produto;

@ManagedBean
public class ProdutoBean {
	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager = Persistence.createEntityManagerFactory("PrimeiroTeste").createEntityManager();
	
	private Produto produto;
	private List<Produto> produtos;
	
	public void save(){
		ProdutoRepository produtoRepository = new ProdutoRepository(this.entityManager);
		produtoRepository.save(this.produto);
		
		this.produto = new Produto();
		this.produtos = null;
	}
	public void remove(Produto produto){
		ProdutoRepository produtoRepository = new ProdutoRepository(this.entityManager);
		produtoRepository.remove(produto);
		
		this.produtos = null;
	}
	public List<Produto> getProdutos(){
		
			ProdutoRepository produtoRepository = new ProdutoRepository(this.entityManager);
			this.produtos = produtoRepository.getProdutos();
		
		return this.produtos;
	}
	public Produto getProduto(){
		return this.produto;
	}
	public void setProduto(Produto produto){
		this.produto = produto;
	}
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
		
	}
	@SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute(" EntityManager ");
	}
}
