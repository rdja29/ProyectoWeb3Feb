package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBBDD extends Conexion {

	public String verificarPassword(String usuario) throws ClassNotFoundException, SQLException {
		// Declarar las variables
		System.out.println("--Acceso BBDD --");
		String sql = "call verificarPassword(?);";
		CallableStatement st;
		ResultSet rs;
		String password = null;

		// Abrir la conexion
		abrirConexion();

		// Obtener el comando
		st = miConexion.prepareCall(sql);

		// Asignar el valor al parametro de entrada

		st.setString(1, usuario);

		// Ejecutar el comando

		rs = st.executeQuery();

		if (rs.next()) {
			System.out.println("entra al if");
			password = rs.getString("password");
		}

		// Cerrar la conexion

		cerrarConexion();
		System.out.println("--- saliendo --" + password);
		return password;

	}
}
