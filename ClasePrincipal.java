package paquete.accesomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		//1-Sacar menu
		ejecutarPrograma();
	}

	private static void ejecutarPrograma() {
		int opcion=EntradaSalida.mostrarMenu();
		
		while(opcion!=EntradaSalida.SALIR)
		{
			switch (opcion)
			{
			case EntradaSalida.NUEVO_VEHICULO:
			Vehiculo v=EntradaSalida.pedirDatosVehiculo();
			AccesoBD.grabarVehiculo(v);
			break;
			case EntradaSalida.LISTAR_VEHICULOS:
			ArrayList<Vehiculo> lista_coches=AccesoBD.recuperarVehiculos(null);
					if (lista_coches!=null)
					{
					EntradaSalida.mostrarCoches(lista_coches);
					}
					else
					{
						EntradaSalida.indicarError();
					}
					break;
			case EntradaSalida.BUSCAR_VEHICULO:
				String matricula_buscada=EntradaSalida.pedirMatricula();
				ArrayList<Vehiculo> coches_buscados=AccesoBD.recuperarVehiculos(matricula_buscada);
				if(coches_buscados!=null)
				{
				EntradaSalida.mostrarCoches(coches_buscados);
				}
				else
				{
					EntradaSalida.indicarError();
				}
				break;
			case EntradaSalida.EXPORTAR_CSV:
				ArrayList<Vehiculo> coches_exportacion=AccesoBD.recuperarVehiculos(null);
				int codigo_respuesta=AccesoFichero.exportarVehiculos(coches_exportacion);
				break;
			
			}
			
			opcion=EntradaSalida.mostrarMenu();
			
		}
	}

}
