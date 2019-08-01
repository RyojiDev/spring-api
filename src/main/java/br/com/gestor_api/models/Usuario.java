package br.com.gestor_api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "Academico", name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	//@ManyToOne
	private int pessoa_id;
	private Date validade;
	private boolean desativado;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPessoa_id() {
		return pessoa_id;
	}
	public void setPessoa_id(int pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public boolean isDesativado() {
		return desativado;
	}
	public void setDesativado(boolean desativado) {
		this.desativado = desativado;
	}
	

}
