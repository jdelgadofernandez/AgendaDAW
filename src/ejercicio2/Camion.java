package ejercicio2;

import java.util.Arrays;

class Camion extends Vehiculo {
	private double peso;

	protected Camion(int id, String marca, String modelo, int anio, String[] lista_componentes, String combustible,
			double consumo, double peso) {
		super(id, marca, modelo, anio, lista_componentes, combustible, consumo);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Camion [peso=" + peso + ", id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio
				+ ", lista_componentes=" + Arrays.toString(lista_componentes) + ", combustible=" + combustible
				+ ", consumo=" + consumo + "]";
	}
	
	
}
