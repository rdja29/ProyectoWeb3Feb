package com.vipper.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection miConexion;

	public void abrirConexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String StringConexion = "jdbc:mysql://localhost:3306/abogados?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
		miConexion = DriverManager.getConnection(StringConexion, "root", "Curso2019$");
		System.out.println("la conexion se abri� con exito");
	}

	public void cerrarConexion() throws SQLException {
		miConexion.close();
	}
}
