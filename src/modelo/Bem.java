package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idBem;
	@Column
	private String descricao;
	@Column
	private Double valorUnitarioBem;
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	@Column
	private String localUso;
	@Column
	private String situacao;
	@Temporal(TemporalType.DATE)
	private Date dataDescarte;
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	@ManyToOne
	@JoinColumn(name = "nota_id")
	private Nota nota;

	public Bem() {
		// TODO Auto-generated constructor stub
	}

	public Bem(Integer idBem, String descricao, Double valorUnitarioBem, Date dataCompra, String localUso,
			String situacao, Date dataDescarte, Date dataVenda, Nota nota) {
		super();
		this.idBem = idBem;
		this.descricao = descricao;
		this.valorUnitarioBem = valorUnitarioBem;
		this.dataCompra = dataCompra;
		this.localUso = localUso;
		this.situacao = situacao;
		this.dataDescarte = dataDescarte;
		this.dataVenda = dataVenda;
		this.nota = nota;
	}

	public Integer getIdBem() {
		return idBem;
	}

	public void setIdBem(Integer idBem) {
		this.idBem = idBem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitarioBem() {
		return valorUnitarioBem;
	}

	public void setValorUnitarioBem(Double valorUnitarioBem) {
		this.valorUnitarioBem = valorUnitarioBem;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getLocalUso() {
		return localUso;
	}

	public void setLocalUso(String localUso) {
		this.localUso = localUso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataDescarte() {
		return dataDescarte;
	}

	public void setDataDescarte(Date dataDescarte) {
		this.dataDescarte = dataDescarte;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

}
