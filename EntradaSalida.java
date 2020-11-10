package paquete.accesomysql;

import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {

	public static final int SALIR = 5;
	public static final int NUEVO_VEHICULO = 1;
	public static final int LISTAR_VEHICULOS = 2;
	public static final int BUSCAR_VEHICULO = 3;
	public static final int EXPORTAR_CSV = 4;
	
	public static int mostrarMenu() {
		System.out.println(NUEVO_VEHICULO+" Nuevo vehiculo");
		System.out.println(LISTAR_VEHICULOS+" Listar vehiculo");
		System.out.println(BUSCAR_VEHICULO+" Buscar vehiculo");
		System.out.println(EXPORTAR_CSV+" Exportar a CSV");
		System.out.println(SALIR+" Salir");
		Scanner sc=new Scanner(System.in);
		int opcion=sc.nextInt();
		return opcion;
		
		
	}

	public static Vehiculo pedirDatosVehiculo() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce la marca");
		String marca=sc.nextLine();
		System.out.println("Introduce el modelo");
		String modelo=sc.nextLine();
		System.out.println("Introduce la matrícula");
		String matricula=sc.nextLine();
		Vehiculo v=new Vehiculo(marca, modelo, matricula);
		return v;
	}

	public static void mostrarCoches(ArrayList<Vehiculo> lista_coches) {
		for(Vehiculo v:lista_coches)
		{
			System.out.println(v.getMarca()+" "+v.getModelo()+" "+v.getMatricula());
		}
		
	}

	public static void indicarError() {
		System.out.println("Algo ha ido mal");
		
	}

	public static String pedirMatricula() {
		System.out.println("Introduzca la matrícula");
		Scanner sc=new Scanner(System.in);
		String matricula=sc.nextLine();
		return matricula;
	}

}
