package ut6_1_JoseMariaDelgadoFernandez;
/**
 * Creado por Jose Maria Delgado Fernandez
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.File;

public class Principal {
	
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		ArrayList<Contacto> agenda= new ArrayList<>();
		leerAgenda(agenda);
		menu(agenda);
		guardar(agenda);
	}
	
	public static void guardar(ArrayList<Contacto> agenda) throws IOException{
		FileWriter fichero =null;
		try {
			fichero=new FileWriter("src/ut6_1_JoseMariaDelgadoFernandez/agenda.txt");
			for (int i=0; i<agenda.size();i++) {
				fichero.write(agenda.get(i).toString()+"\n");
			}
		}catch (Exception e) {
			System.out.println("ERROR AL ABRIR EL FICHERO");
		}
		finally {
			fichero.close();
		}
	}
	public static void leerAgenda(ArrayList<Contacto> agenda) throws IOException {
		File fichero = new File("src/ut6_1_JoseMariaDelgadoFernandez/agenda.txt");
		Scanner s=null;
		try {
			s = new Scanner(fichero);
			while(s.hasNextLine()){
				String linea=s.nextLine();
				String[] valores = linea.split(",");
				String[] fValores = valores[4].split("-");
				Fecha nacimiento = new Fecha(Integer.parseInt(fValores[0]), Integer.parseInt(fValores[1]), Integer.parseInt(fValores[2]));
				Contacto anadido = new Contacto(valores[0],valores[1],valores[2],valores[3],nacimiento,valores[5],valores[6]);
				agenda.add(anadido);
			}
		}
		catch (Exception e) {
			System.out.println("ERROR AL LEER EL FICHERO");
		}
		finally {
			try {
				if (s!=null) {	
					s.close();
				}
				}
				catch(Exception ex2) {
					System.out.println("Mensaje2: " + ex2.getMessage());
				}
		}
	}
	public static void menu(ArrayList<Contacto> agenda) {
		boolean fin=false;
		int opcion;
		System.out.println("Copyright @ Jose Maria Delgado Soluciones S.A");
		System.out.println("Bienvenido a tu agenda personal !");
		while (!fin) {
			System.out.println("Elige una opcion");
			System.out.println("1. Mostrar todos los contactos");
			System.out.println("2. Mostrar un contacto");
			System.out.println("3. Mostrar contactos por caracteres");
			System.out.println("4. Crear un nuevo contacto");
			System.out.println("5. Eliminar contacto");
			System.out.println("6. Actualizar contacto");
			System.out.println("7. Salir");
			try {
				opcion = sc.nextInt();
				switch (opcion){
				case 1:
					mostrar(agenda);
					sc.nextLine();
				break;
				case 2:
					sc.nextLine();
					unContacto(agenda);
					break;
				case 3:
					sc.nextLine();
					buscador(agenda);
					break;
				case 4:
					sc.nextLine();
					anadir(agenda);
					break;
				case 5:	
					sc.nextLine();
					eliminar(agenda);
					break;
				case 6:
					sc.nextLine();
					actualizar(agenda);
					break;
				case 7:
					System.out.println("Nos vemos pronto !");
					System.out.println("Copyright @ Jose Maria Delgado Soluciones S.A");
					fin=true;
					break;
				default:
				System.out.println("NUMERO INTRODUCIDO ERRONEO VUELVA A INTENTARLO");;
				break;
				}
			}
			catch(Exception e){
				System.out.println("Entrada por teclado incorrecta. Intentelo de nuevo");
				sc.nextLine();
			}
			
		}
	}



	public static void mostrar(ArrayList<Contacto> agenda) {
		ArrayList<Contacto> ordenado = new ArrayList<>();
		for (int i=0; i<agenda.size();i++) {
			System.out.println("Contacto " + (i+1)  + " " +agenda.get(i).toString());
			
		}
	}
	public static void unContacto(ArrayList<Contacto> agenda) {
		String introducido="";
		boolean encontrado=false;
		System.out.println("Por favor inserte el DNI o numero del contacto que quiera ver.");
		try {
			introducido = sc.nextLine();
			if(introducido.substring(introducido.length()-1).matches("[0-9]+")) {
				for (int i=0; i<agenda.size();i++) {
					if (introducido.equals(agenda.get(i).getNumero())){
						System.out.println("Contacto con el numero " + introducido);
						System.out.println(agenda.get(i).toString());
						encontrado=true;
					}
					else {
						System.out.println("Contacto no encontrado");
					}
				}
			}
			else if (introducido.substring(introducido.length()-1).matches("[a-zA-Z]+")) {
				for (int i=0; i<agenda.size();i++) {
					if (introducido.equals(agenda.get(i).getDni())){
						System.out.println("Contacto con el DNI " + introducido);
						System.out.println(agenda.get(i).toString());
						encontrado=true;
					}
					else {
						System.out.println("Contacto no encontrado");
					}
				}
			}
			else {
				System.out.println("Formato de DNI o telefono incorrecto");
			}
			if (!encontrado){
				System.out.println("Contacto no encotrado.");
			}
		}
		catch (Exception e) {
			System.out.println("Entrada por teclado incorrecta. Volviendo al menu principal.");
		}
	}
	public static void buscador(ArrayList<Contacto> agenda) {
		String introducido="";
		int tamanio=0;
		int encontrados=0;
		System.out.println("Por favor inserte el nombre por el que empiece el/los contacto que quiera buscar");
		try {
			introducido = sc.nextLine().toUpperCase();
			tamanio=introducido.length();
			for (int i=0; i<agenda.size();i++) {
				if(introducido.equals(agenda.get(i).getNombre().substring(0, tamanio).toUpperCase())){
					System.out.println(agenda.get(i).toString());
					encontrados++;
				}
			}
			if(encontrados>0) {
				System.out.println("Contactos que empiecen por " + introducido + " : " + encontrados);
			}
			else {
				System.out.println("No se han encontrado coincidencias");
			}
		}
		catch (Exception e) {
			System.out.println("Entrada por teclado incorrecta. Volviendo al menu principal.");
		}
	}
	public static void anadir(ArrayList<Contacto> agenda) {
		int bien=0;
		String nombre="";
		String apellido="";
		String numero="";
		String correo="";
		Fecha fecha;
		String dni="";
		String descripcion="";
		try {
			while(bien==0) {
				bien=1;
				System.out.println("Inserta el nombre del nuevo contacto");
			nombre=sc.nextLine();
			for (int i = 0; i < nombre.length(); i++) {
				char letra = nombre.charAt(i);
				if (Character.isDigit(letra)) {
					bien = 0;
				}
			}
			// Si se ha encontrado algun caracter raro o no ha metido nada, salta el error
			if (bien == 0 || nombre.length() == 0) {
				System.out.println("Nombre incorrecto o vacio, por favor vuelva a introducirlo.");
				bien=0;
			}
		}
		}
		catch(Exception e) {
			System.out.println("Entrada por teclado incorrecta. Intentalo de nuevo.");
		}
		finally {
			bien=0;
		}
	
		try {
			while(bien==0) {
				System.out.println("Inserta el Apellido del nuevo contacto");
			bien=1;
			apellido=sc.nextLine();
			for (int i = 0; i < apellido.length(); i++) {
				char letra = apellido.charAt(i);
				if (Character.isDigit(letra)) {
					bien = 0;
				}
			}
			// Si se ha encontrado algun caracter raro o no ha metido nada, salta el error
			if (bien == 0 || apellido.length() == 0) {
				System.out.println("Apellido incorrecto o vacio, por favor vuelva a introducirlo.");
				bien=0;
			}
			}
		}
		catch(Exception e) {
			System.out.println("Entrada por teclado incorrecta. Intentalo de nuevo.");
			
		}
		finally {
			bien=0;
		}

		try {
			while(bien==0) {
				System.out.println("Inserta el numero de telefono del nuevo contacto");
				bien=1;
			numero=sc.nextLine();
			for (int i = 0; i < numero.length(); i++) {
				char letra = numero.charAt(i);
				if (Character.isAlphabetic(letra)) {
					bien = 0;
				}
			}
			// Si se ha encontrado algun caracter raro o no ha metido nada, salta el error
			if (bien == 0 || numero.length() != 9 ) {
				System.out.println("numero incorrecto o de longitud incorrecta, por favor vuelva a introducirlo.");
				bien=0;
			}
		}
		}
		catch(Exception e) {
			System.out.println("Entrada por teclado incorrecta. Intentalo de nuevo.");
		}
		finally {
			bien=0;
		}

		try {
			while(bien==0){
				System.out.println("Inserta el correo del nuevo contacto");
				bien=1;
			correo=sc.nextLine();
			for (int i = 0; i < correo.length(); i++) {
				char letra = correo.charAt(i);
				if (Character.isDigit(letra)) {
					bien = 0;
				}
			}
			// Si se ha encontrado algun caracter raro o no ha metido nada, salta el error
			if (bien == 0 || correo.length() == 0 ) {
				System.out.println("correo incorrecto o vacio, por favor vuelva a introducirlo.");
				bien=0;
			}
		}
		}
		catch(Exception e) {
			System.out.println("Entrada por teclado incorrecta. Intentalo de nuevo.");
		}
		finally {
			bien=0;
		}
		
		
		try {
			while(bien==0) {
				System.out.println("Inserta el dni del nuevo contacto");
				bien=1;
				dni=sc.nextLine();
			for (int i = 0; i < dni.length(); i++) {
				char letra = dni.charAt(i);
				if (Character.isAlphabetic(letra) && i!=dni.length()-1) {
					bien = 0;
				}
				else if (Character.isDigit(letra) && i==dni.length()-1) {
					bien = 0;
				}
			}
			
			// Si se ha encontrado algun caracter raro o no ha metido nada, salta el error
			if (bien == 0 || dni.length() != 9 ) {
				System.out.println("dni incorrecto, vacio o longitud erronea, por favor vuelva a introducirlo.");
				bien=0;
			}
		}
		}
		catch(Exception e) {
			System.out.println("Entrada por teclado incorrecta. Intentalo de nuevo.");
		}
		finally {
			bien=0;
		}
		System.out.println("Inserta una descripcion del nuevo contacto (Poner - si se quiere dejar vacion)");
		try {
			descripcion=sc.nextLine();
			if(descripcion.equals("-")) {
				descripcion="";
			}
		}
		catch(Exception e) {
			System.out.println("Entrada por teclado incorrecta. Intentalo de nuevo.");
		}
		finally {
			bien=0;
		}
		fecha=sacarFecha();
		
		Contacto nuevo =  new Contacto(nombre,apellido,numero,correo,fecha,dni,descripcion);
		agenda.add(nuevo);
		System.out.println("El contacto " + nombre +" con numero " + numero + " ha sido añadido");
	}

	public static void eliminar(ArrayList<Contacto> agenda) {
		String introducido="";
		boolean encontrado=false;
		System.out.println("Por favor inserte el DNI o numero del contacto que quiera ver.");
		try {
			introducido = sc.nextLine();
			if(introducido.substring(introducido.length()-1).matches("[0-9]+")) {
				for (int i=0; i<agenda.size();i++) {
					if (introducido.equals(agenda.get(i).getNumero())){
						System.out.println("Contacto con el numero " + introducido + "eliminado");
						agenda.remove(i);
						guardar(agenda);
						encontrado=true;
					}
				}
			}
			else if (introducido.substring(introducido.length()-1).matches("[a-zA-Z]+")) {
				for (int i=0; i<agenda.size();i++) {
					if (introducido.equals(agenda.get(i).getDni())){
						System.out.println("Contacto con el DNI " + introducido + "eliminado");
						System.out.println(agenda.get(i).toString());
						agenda.remove(i);
						guardar(agenda);
						encontrado=true;
					}
				}
			}
			else {
				System.out.println("Formato de DNI o telefono incorrecto");
			}
			if (!encontrado){
				System.out.println("Contacto no encotrado.");
			}
		}
		catch (Exception e) {
			System.out.println("Entrada por teclado incorrecta. Volviendo al menu principal.");
		}	
	}
	
	public static void actualizar(ArrayList<Contacto> agenda) {
		int opcion;
		int salir=0;
		try {
			while(salir==0) {
				System.out.println("Que desea actualizar ?");
			opcion=sc.nextInt();
			switch (opcion) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				salir=1;
				System.out.println("Volviendo al menu");
				break;
			}
		}
		}
		catch (Exception e) {
			
		}

		
	}
	
	
	public static Fecha sacarFecha() {
		int bien = 0;
		int anio = 0;
		int mes = 0;
		int dia = 0;
		int bis = 0;
		// Pedimos primero el año para poder comprobar primero si es año bisiesto o no
		System.out.println("Indica el año de nacimiento del jugador EJEMPLO:1998");
		// While comprobando que no nos metan un año sinsentido
		while (bien == 0) {
			bien = 1;
			anio = Integer.parseInt(sc.nextLine());
			if (anio > 2006 || anio < 1979) {
				System.out.println("Año incorrecto, por favor vuelva a introducirlo.");
				bien = 0;
			}
		}
		// if para comprobar si es bisiesto o no
		if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
			bis = 1;
		}
		bien = 0;
		// Ahora pedimos el mes para que compruebe que cantidad de dias tiene
		System.out.println("Indica el mes de nacimiento del jugador EJEMPLO:1 para Enero, 2 para Febrero etc");
		while (bien == 0) {
			bien = 1;
			mes = Integer.parseInt(sc.nextLine());
			// Comprobacion de que no nos emtan un mes que no existe
			if (mes > 12 || mes < 1) {
				System.out.println("mes incorrecto, por favor vuelva a introducirlo.");
				bien = 0;
			}
		}
		bien = 0;
		// Finalmente el dia de nacimiento que lo compararemos con el mes y con la
		// variable bis si es año bisiesto
		System.out.println("Indica el dia de nacimiento del jugador");
		// bucle de comprobacion para ver si mete un dia correcto.
		while (bien == 0) {
			bien = 1;
			dia = Integer.parseInt(sc.nextLine());
			if (bis == 1 && mes == 2 && (dia > 29 || dia < 0)) {
				System.out.println("dia incorrecto, por favor vuelva a introducirlo.");
				bien = 0;
			} else if (mes == 2 && (dia > 28 || dia < 0) && bis == 0) {
				System.out.println("dia incorrecto, por favor vuelva a introducirlo.");
				bien = 0;
			} else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia > 31
					|| dia < 0)) {
				System.out.println("dia incorrecto, por favor vuelva a introducirlo.");
				bien = 0;
			} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30 || dia < 0)) {
				System.out.println("dia incorrecto, por favor vuelva a introducirlo.");
				bien = 0;
			} else if (dia < 0 || dia > 31) {
				System.out.println("dia incorrecto o vacio, por favor vuelva a introducirlo.");
				bien = 0;
			}
		}
		// Finalmente creamos el objeto nacido con los datos recogidos anteriormente y
		// lo returnamos.
		Fecha nacido = new Fecha(dia, mes, anio);
		return nacido;
	}

}
