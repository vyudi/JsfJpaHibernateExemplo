package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import entities.Produto;

public class ProdutoRepository {
	private EntityManager entityManager;
	
	public ProdutoRepository(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void save(Produto produto){
		this.entityManager.persist(produto);
		this.entityManager.flush();
		/*
		 * o método flush() que envia imediatamente para o banco de dados as alterações realizadas dentro 
		 * da transação corrente sem confirmá-las. 
		 * (a confirmação só ocorre na chamada do método commit()).
		 */
	}
	
	public void remove(Produto produto){
		this.entityManager.remove(produto);
	}
	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos(){
		return this.entityManager.createNamedQuery("Produto.findAll").getResultList();
//		Query consulta1 = this.entityManager.createQuery("select p from Produto p");
//		for (Produto produto: (List<Produto>)consulta1.getResultList()){
//			JOptionPane.showMessageDialog(null,produto.getNome());
//		}
//		JOptionPane.showMessageDialog(null, "entrou");
//		return consulta1.getResultList();
	}

}
