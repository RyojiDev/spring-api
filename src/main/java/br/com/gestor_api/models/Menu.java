package br.com.gestor_api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema = "Academico", name = "menu")
public class Menu implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int parent_id; 
	
	private int  ordering;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Column(nullable=true, length=100)
	private String slug ;
	
	@Column(nullable=false, length=100)
	private String link ;
	
	private boolean permissao;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "menus")	
	private Set<Cliente> clientes;
		
	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isPermissao() {
		return permissao;
	}

	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}
	
//	public List<Cliente> getClientes() {
//		return clientes;
//	}
//
//	public void setClientes(List<Cliente> clientes) {
//		this.clientes = clientes;
//	}


}
