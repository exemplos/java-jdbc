package com.franciscocalaca.exemplos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Exemplo de conexao com banco de dados postgres em java
 * @author chico
 */
public class Exemplo01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/gti-bd-3", "postgres", "123456");
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from cep");
		while(rs.next()) {
			System.out.printf("%s  %s  %s  %s  \n", rs.getString("cep"), rs.getString("municipio"), rs.getInt("codigoibge"), rs.getString("uf"));
		}
		
	}
}
