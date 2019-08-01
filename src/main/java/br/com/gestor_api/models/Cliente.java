package br.com.gestor_api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(schema = "Academico", name = "cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, length=14)
	private String cnpj;
	@Column(nullable=false, length=100)
	private String razao_social;
	@Column(nullable=false, length=100)
	private String nome_fantasia;
	private Date data_limite;
		
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
    @JoinTable(name = "menu_cliente", schema = "Academico", 
    	joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id"), 
    	inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))	
	private Set<Menu> menus;
	
	@OneToMany(mappedBy="cliente")
    private Set<Escola> escolas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public Date getData_limite() {
		return data_limite;
	}
	public void setData_limite(Date data_limite) {
		this.data_limite = data_limite;
	}
	
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	public Set<Escola> getEscolas() {
		return escolas;
	}
	
	public void setEscolas(Set<Escola> escolas) {
		this.escolas = escolas;
	}
}
