package ut6_1_JoseMariaDelgadoFernandez;

public class Contacto {
	private String nombre;
	private String apellido;
	private String numero;
	private String correo;
	private Fecha fecha;
	private String dni;
	private String descripcion;
	public Contacto(String nombre, String apellido, String numero, String correo, Fecha fecha, String dni,
			String descripcion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.correo = correo;
		this.fecha = fecha;
		this.dni = dni;
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return  nombre + "," + apellido + "," + numero + "," + correo
				+ "," + fecha + "," + dni + "," + descripcion;
	}
	
}
