package ejercicio2;

import java.util.Arrays;

class Bus extends Vehiculo{
	private int asientos;

	protected Bus(int id, String marca, String modelo, int anio, String[] lista_componentes, String combustible,
			double consumo, int asientos) {
		super(id, marca, modelo, anio, lista_componentes, combustible, consumo);
		this.asientos = asientos;
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	@Override
	public String toString() {
		return "Bus [asientos=" + asientos + ", id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio
				+ ", lista_componentes=" + Arrays.toString(lista_componentes) + ", combustible=" + combustible
				+ ", consumo=" + consumo + "]";
	}
	
}
