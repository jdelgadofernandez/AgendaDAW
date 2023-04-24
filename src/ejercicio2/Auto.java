package ejercicio2;

import java.util.Arrays;

class Auto extends Vehiculo{
	private int puertas;
	private String[] compCoches;
	protected Auto(int id, String marca, String modelo, int anio, String[] lista_componentes, String combustible,
			double consumo, int puertas, String[] compCoches) {
		super(id, marca, modelo, anio, lista_componentes, combustible, consumo);
		this.puertas = puertas;
		this.compCoches = compCoches;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public String[] getCompCoches() {
		return compCoches;
	}
	public void setCompCoches(String[] compCoches) {
		this.compCoches = compCoches;
	}
	@Override
	public String toString() {
		return "Auto [puertas=" + puertas + ", compCoches=" + Arrays.toString(compCoches) + ", id=" + id + ", marca="
				+ marca + ", modelo=" + modelo + ", anio=" + anio + ", lista_componentes="
				+ Arrays.toString(lista_componentes) + ", combustible=" + combustible + ", consumo=" + consumo + "]";
	}
	
}
