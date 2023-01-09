package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Saida implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSaida;
	@Column
	private String tipoSaida;
	@Column
	private Double valorSaida;
	@Temporal(TemporalType.DATE)
	private Date dataSaida;
	@Column
	private String descricaoSaida;

	public Saida() {
		// TODO Auto-generated constructor stub
	}

	public Saida(Integer idSaida, String tipoSaida, Double valorSaida, Date dataSaida, String descricaoSaida) {
		this.idSaida = idSaida;
		this.tipoSaida = tipoSaida;
		this.valorSaida = valorSaida;
		this.dataSaida = dataSaida;
		this.descricaoSaida = descricaoSaida;
	}

	public Integer getIdSaida() {
		return idSaida;
	}

	public void setIdSaida(Integer idSaida) {
		this.idSaida = idSaida;
	}

	public String getTipoSaida() {
		return tipoSaida;
	}

	public void setTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
	}

	public Double getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(Double valorSaida) {
		this.valorSaida = valorSaida;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDescricaoSaida() {
		return descricaoSaida;
	}

	public void setDescricaoSaida(String descricaoSaida) {
		this.descricaoSaida = descricaoSaida;
	}

}
