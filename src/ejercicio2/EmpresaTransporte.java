package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;


public class EmpresaTransporte {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	ArrayList<Vehiculo> lista = new ArrayList<>();
	String[] componentes= {"volante","rueda"};
	Camion cam1 = new Camion(1,"Volvo","FX",1990,componentes,"gasoil",6.6,3000.0);
	Bus bus1 = new Bus(1,"Scania","BS",1990,componentes,"gasoil",6.6,5);
	String[] componentesC= {"volante","rueda","puerta"};
	Auto coc1 = new Auto(1,"Mercedes","ClaseC",1990,componentes,"gasoil",6.6,5, componentesC);
	lista.add(coc1);
	lista.add(bus1);
	lista.add(cam1);
	
	}
}
