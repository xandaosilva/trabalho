package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="categoria")
@Entity
@Table(name="Categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@NotNull(message="O campo nome � obrigat�rio .")
	@Size(min=10,message="O campo nome dever�r ter ao menos 10 caracteres .")
	@Column(name="nome",unique=true)
	private String nome;
	
	@NotNull(message="O campo % do curso � obrigat�rio .")
	@Max(100)
	@Min(10)
	@Column(name="porcentagemDoCurso")
	private Integer porcentagemDoCurso;
	
	@NotNull(message="O campo % por atividade � obrigat�rio .")
	@Max(100)
	@Min(10)
	@Column(name="porcentagemPorAtividade")
	private Integer porcentagemPorAtividade;
	
	@NotNull(message="O campo descri��o � obrigat�rio .")
	@Column(name="descricao")
	private String descricao;
	
	@NotNull(message="O campo regulamento � obrigat�rio .")
	@Column(name="regulamento")
	private String regulamento;
	
	@ManyToOne
	@JoinColumn(name="modalidade",referencedColumnName="codigo")
	private Modalidade modalidade;

	public Categoria() {
	}

	public Categoria(Integer codigo, String nome, Integer porcentagemDoCurso, Integer porcentagemPorAtividade,
			String descricao, String regulamento, Modalidade modalidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.porcentagemDoCurso = porcentagemDoCurso;
		this.porcentagemPorAtividade = porcentagemPorAtividade;
		this.descricao = descricao;
		this.regulamento = regulamento;
		this.modalidade = modalidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPorcentagemDoCurso() {
		return porcentagemDoCurso;
	}

	public void setPorcentagemDoCurso(Integer porcentagemDoCurso) {
		this.porcentagemDoCurso = porcentagemDoCurso;
	}

	public Integer getPorcentagemPorAtividade() {
		return porcentagemPorAtividade;
	}

	public void setPorcentagemPorAtividade(Integer porcentagemPorAtividade) {
		this.porcentagemPorAtividade = porcentagemPorAtividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRegulamento() {
		return regulamento;
	}

	public void setRegulamento(String regulamento) {
		this.regulamento = regulamento;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + ", porcentagemDoCurso=" + porcentagemDoCurso
				+ ", porcentagemPorAtividade=" + porcentagemPorAtividade + ", descricao=" + descricao + ", regulamento="
				+ regulamento + "]";
	}
}