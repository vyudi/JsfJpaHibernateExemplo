package entities;

import java.io.PrintStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.sun.tools.ws.wsdl.document.Output;

import managedbeans.ProdutoBean;

public class Principal {	
	public static void main(String[] args) {
		PrintStream out = System.out;
//		Produto produto = new Produto();
//		produto.setId(3);
//		produto.setNome("Notebook");
//		produto.setDescricao("Notebook Dell Inspiron III");
//		produto.setValorUnitario(35.0);	
//		
//		EntityManager em = Persistence.createEntityManagerFactory("PrimeiroTeste").createEntityManager();
//		em.getTransaction().begin();
//		em.persist(produto);
//		em.getTransaction().commit();
		ProdutoBean p = new ProdutoBean();		
		for (Produto produto: (List<Produto>)p.getProdutos()){
			JOptionPane.showMessageDialog(null,produto.getNome());
		}
		JOptionPane.showMessageDialog(null, "entrou");
		
	}

}
