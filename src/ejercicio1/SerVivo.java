package ejercicio1;

import java.nio.file.spi.FileSystemProvider;

public class SerVivo {
	protected String nombreCientifico;
	protected String nombreComun;
	
	
	public SerVivo(String nombreCientifico, String nombreComun) {
		this.nombreCientifico = nombreCientifico;
		this.nombreComun = nombreComun;
	}


	public String getNombreCientifico() {
		return nombreCientifico;
	}


	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}


	public String getNombreComun() {
		return nombreComun;
	}


	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	protected void alimentarse () {
		System.out.println("nom nom");
	}

	@Override
	public String toString() {
		return "SerVivo [nombreCientifico=" + nombreCientifico + ", nombreComun=" + nombreComun + "]";
	}
	
	
}
