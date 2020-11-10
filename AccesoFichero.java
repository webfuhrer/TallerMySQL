package paquete.accesomysql;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoFichero {
static String ruta="T:\\ficheros\\vehiculos.csv";
	public static int exportarVehiculos(ArrayList<Vehiculo> coches_exportacion) {
		
		int respuesta=0;
		try {
			FileWriter fw=new FileWriter(ruta, false);
			String linea="";
			for(Vehiculo v: coches_exportacion)
			{
				linea+=v.toCSV()+"\n";
			}
			fw.write(linea);
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
			respuesta=1;
		}
		return respuesta;
	}

}
