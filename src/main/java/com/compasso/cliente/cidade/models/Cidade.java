package com.compasso.cliente.cidade.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="TBL_CIDADE")
public class Cidade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8523857957321959163L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long idCidade;

	@NotNull
    private String nmCidade;
    private String idEstado;
	
    public Long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}
	public String getNmCidade() {
		return nmCidade;
	}
	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

}
