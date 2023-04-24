package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		SerVivo sv= new SerVivo("hoal","asdsd");
		SerVivo perro = new Animal("ei","oal",2.0,3.5);
		SerVivo plant = new Vegetal("hoja","ros",0.1);
		System.out.println(sv);
		System.out.println(perro);
		System.out.println(plant);
		perro.alimentarse();
		plant.alimentarse();
	}

}
