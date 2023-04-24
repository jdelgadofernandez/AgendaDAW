package ejercicio1;

public class Vegetal extends SerVivo{
	private double altura;

	public Vegetal(String nombreCientifico, String nombreComun, double altura) {
		super(nombreCientifico, nombreComun);
		this.altura=altura;
	}
	

	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	protected void alimentarse() {
		System.out.println("...");
	}
	
	@Override
	public String toString() {
		return "Vegetal [nombreCientifico=" + nombreCientifico + ", nombreComun=" + nombreComun +" altura=" + altura + "]";
	}
	
}
