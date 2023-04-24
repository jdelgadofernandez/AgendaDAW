package ut6_1_JoseMariaDelgadoFernandez;

//Clase para la creacion de una fecha
public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	//Constructor de fecha con todas sus variables
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	//Getter de dia
	public int getDia() {
		return dia;
	}
	//Setter de dia
	public void setDia(int dia) {
		this.dia = dia;
	}
	//Getter de mes
	public int getMes() {
		return mes;
	}
	//Setter de mes
	public void setMes(int mes) {
		this.mes = mes;
	}
	//Getter de anio
	public int getAnio() {
		return anio;
	}
	//Setter de anio
	public void setAnio(int anio) {
		this.anio = anio;
	}
	@Override
	//Modulo toString de la clase fecha
	public String toString() {
		return dia + "-" + mes + "-" + anio;
	}
	
}
