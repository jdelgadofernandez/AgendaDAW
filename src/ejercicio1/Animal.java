package ejercicio1;

public class Animal extends SerVivo{

	private double peso;
	private double altura;
	
	public Animal(String nombreCientifico, String nombreComun, double peso, double altura) {
		super(nombreCientifico, nombreComun);
		this.peso=peso;
		this.altura=altura;
	}
	
	protected void alimentarse() {
		System.out.println("chom chom");
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Animal [nombreCientifico=" + nombreCientifico + ", nombreComun=" + nombreComun +"peso=" + peso + ", altura=" + altura + "]";
	}
	
}
