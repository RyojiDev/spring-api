package br.com.gestor_api.models;
//https://www.youtube.com/watch?v=LmqVHTOqcxs&index=2&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "Academico", name = "pessoa")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	//@ManyToOne
	private int cliente_id;
	
	@Column(nullable=false, length=1)
	private String fisica_juridica;
	
	@Column(nullable=false, length=100)
	private String nome_ou_razao;
	
	@Column(nullable=false, length=100)
	private String nome_social_ou_fantasia;

	@Column(nullable=false, length=14)
	private int cpf_ou_cnpj;
	
	private int inscricao_municipal;
	
	private int	cep;
	
	@Column(nullable=false, length=100)
	private String logradouro;
	
	private int	numero;
	
	@Column(nullable=false, length=30)
	private String complemento;
	
	@Column(nullable=false, length=50)
	private String bairro;
	
	private int cidade_uf_id;
	
	@Column(nullable=false, length=100)
	private String email;
	
	@Column(nullable=false, length=100)
	private String senha;
	
	@Column(nullable=false, length=12)
	private int	telefone1; 
	
	@Column(nullable=false, length=12)
	private int telefone2;
	
	@Column(nullable=false, length=12)
	private int	telefone3;
	
	@Column(nullable=false, length=12)
	private int	telefone_trabalho;
	
	@Column(nullable=false, length=1)
	private String sexo;
	
	private Date nascimento;
	
	private boolean vivo;
	
	@Column(nullable=false, length=50)
	private String nacionalidade;
	
	private int cidade_uf_naturalidade_id ;//https://gist.github.com/letanure/3012978
	
	@Column(nullable=false, length=3)
	private String tipo_de_sangue;
	
	@Column(nullable=false, length=1)
	private String raca_cor;
	
	@Column(nullable=false, length=1)
	private String situacao_conjugal;
	
	private int identidade_numero;
	
	@Column(nullable=false, length=10)
	private String identidade_orgao;
	
	private int identidade_cidade_uf_id;
	
	private Date identidade_data_emissao;
	
	private boolean ex_aluno;
	
	@Column(nullable=false, length=1)
	private String religiao;
	
	@Column(nullable=false, length=100)
	private String foto;
	
	@Column(columnDefinition = "TEXT")
	private String observacao;	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getFisica_juridica() {
		return fisica_juridica;
	}
	public void setFisica_juridica(String fisica_juridica) {
		this.fisica_juridica = fisica_juridica;
	}
	public String getNome_ou_razao() {
		return nome_ou_razao;
	}
	public void setNome_ou_razao(String nome_ou_razao) {
		this.nome_ou_razao = nome_ou_razao;
	}
	public String getNome_social_ou_fantasia() {
		return nome_social_ou_fantasia;
	}
	public void setNome_social_ou_fantasia(String nome_social_ou_fantasia) {
		this.nome_social_ou_fantasia = nome_social_ou_fantasia;
	}
	public int getCpf_ou_cnpj() {
		return cpf_ou_cnpj;
	}
	public void setCpf_ou_cnpj(int cpf_ou_cnpj) {
		this.cpf_ou_cnpj = cpf_ou_cnpj;
	}
	public int getInscricao_municipal() {
		return inscricao_municipal;
	}
	public void setInscricao_municipal(int inscricao_municipal) {
		this.inscricao_municipal = inscricao_municipal;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCidade_uf_id() {
		return cidade_uf_id;
	}
	public void setCidade_uf_id(int cidade_uf_id) {
		this.cidade_uf_id = cidade_uf_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(int telefone1) {
		this.telefone1 = telefone1;
	}
	public int getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}
	public int getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(int telefone3) {
		this.telefone3 = telefone3;
	}
	public int getTelefone_trabalho() {
		return telefone_trabalho;
	}
	public void setTelefone_trabalho(int telefone_trabalho) {
		this.telefone_trabalho = telefone_trabalho;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getCidade_uf_naturalidade_id() {
		return cidade_uf_naturalidade_id;
	}
	public void setCidade_uf_naturalidade_id(int cidade_uf_naturalidade_id) {
		this.cidade_uf_naturalidade_id = cidade_uf_naturalidade_id;
	}
	public String getTipo_de_sangue() {
		return tipo_de_sangue;
	}
	public void setTipo_de_sangue(String tipo_de_sangue) {
		this.tipo_de_sangue = tipo_de_sangue;
	}
	public String getRaca_cor() {
		return raca_cor;
	}
	public void setRaca_cor(String raca_cor) {
		this.raca_cor = raca_cor;
	}
	public String getSituacao_conjugal() {
		return situacao_conjugal;
	}
	public void setSituacao_conjugal(String situacao_conjugal) {
		this.situacao_conjugal = situacao_conjugal;
	}
	public int getIdentidade_numero() {
		return identidade_numero;
	}
	public void setIdentidade_numero(int identidade_numero) {
		this.identidade_numero = identidade_numero;
	}
	public String getIdentidade_orgao() {
		return identidade_orgao;
	}
	public void setIdentidade_orgao(String identidade_orgao) {
		this.identidade_orgao = identidade_orgao;
	}
	public int getIdentidade_cidade_uf_id() {
		return identidade_cidade_uf_id;
	}
	public void setIdentidade_cidade_uf_id(int identidade_cidade_uf_id) {
		this.identidade_cidade_uf_id = identidade_cidade_uf_id;
	}
	public Date getIdentidade_data_emissao() {
		return identidade_data_emissao;
	}
	public void setIdentidade_data_emissao(Date identidade_data_emissao) {
		this.identidade_data_emissao = identidade_data_emissao;
	}
	public boolean isEx_aluno() {
		return ex_aluno;
	}
	public void setEx_aluno(boolean ex_aluno) {
		this.ex_aluno = ex_aluno;
	}
	public String getReligiao() {
		return religiao;
	}
	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
