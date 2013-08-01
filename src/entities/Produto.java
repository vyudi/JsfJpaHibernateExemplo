package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="produto")
@SequenceGenerator(name="seqId",allocationSize=1)
@NamedQueries({
				@NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
				@NamedQuery(name = "Produto.count", query = "SELECT COUNT(p) FROM Produto p")				
				})
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqId")
	private int id;
	@Column(name="descricao")
    private String descricao;
	@Column(name="nome")
    private String nome;
	@Column(name = "valor_unitario")
    private double valorUnitario;    
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
    
    
}
