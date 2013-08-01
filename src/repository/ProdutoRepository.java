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
		 * o m�todo flush() que envia imediatamente para o banco de dados as altera��es realizadas dentro 
		 * da transa��o corrente sem confirm�-las. 
		 * (a confirma��o s� ocorre na chamada do m�todo commit()).
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
