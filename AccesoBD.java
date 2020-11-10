package paquete.accesomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoBD {

	public static void grabarVehiculo(Vehiculo v) {
	try {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?serverTimezone=UTC", "root", "");
		Statement stmt=c.createStatement();
		String sql="INSERT INTO taller VALUES ('"+v.getMarca()+"', '"+v.getModelo()+"', '"+v.getMatricula()+"')";
		stmt.executeUpdate(sql);
				//column count doesn´t match row count
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	public static ArrayList<Vehiculo> recuperarVehiculos(String matricula_buscada) {
		Connection c;
		ArrayList<Vehiculo> lista_coches=new ArrayList();
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?serverTimezone=UTC", "root", "");
			Statement stmt=c.createStatement();
			String sql="SELECT * FROM taller";
			if (matricula_buscada!=null)
			{sql+=" WHERE matricula LIKE '%"+matricula_buscada+"%'";}
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String marca=rs.getString("marca");
				String modelo=rs.getString("modelo");
				String matricula=rs.getString("matricula");
				Vehiculo v=new Vehiculo(marca, modelo, matricula);
				lista_coches.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			lista_coches=null;
		}
		
		return lista_coches;
	}

}
