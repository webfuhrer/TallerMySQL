package paquete.accesomysql;

public class Vehiculo {
private String marca, modelo, matricula;

public Vehiculo(String marca, String modelo, String matricula) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.matricula = matricula;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getMatricula() {
	return matricula;
}

public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public String toCSV()
{
	return marca+","+modelo+","+matricula;
}
}
