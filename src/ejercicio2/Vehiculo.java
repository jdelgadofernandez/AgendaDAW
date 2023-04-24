package ejercicio2;

import java.util.Arrays;

public class Vehiculo {
	protected int id;
	protected String marca;
	protected String modelo;
	protected int anio;
	protected String[] lista_componentes;
	protected String combustible;
	protected double consumo;
	public Vehiculo(int id, String marca, String modelo, int anio, String[] lista_componentes, String combustible,
			double consumo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.lista_componentes = lista_componentes;
		this.combustible = combustible;
		this.consumo = consumo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String[] getLista_componentes() {
		return lista_componentes;
	}
	public void setLista_componentes(String[] lista_componentes) {
		this.lista_componentes = lista_componentes;
	}
	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio
				+ ", lista_componentes=" + Arrays.toString(lista_componentes) + ", combustible=" + combustible
				+ ", consumo=" + consumo + "]";
	}
	
}
