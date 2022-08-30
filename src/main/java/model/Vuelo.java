package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vuelos database table.
 * 
 */
@Entity
@Table(name="vuelos")
@NamedQuery(name="Vuelo.findAll", query="SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVuelo;
	private int categoria; 
	private int disponible;
	private String origen;
	private String destino;
	private double precio;
	@Override
	
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", categoria=" + categoria + ", disponible=" + disponible + ", origen="
				+ origen + ", destino=" + destino + ", precio=" + precio + "]";
	}

	public Vuelo() {
	}
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getDisponible() {
		return disponible;
	}
	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}