package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {
		private static final String URL = "jdbc:mysql://localhost:3306/login_do_usuario";
		private static final String USUARIO = "root";
		private static final String SENHA = "Pedrolucasswol12";
		
		public static Connection getConnection() throws Exception{
			return DriverManager.getConnection(URL,USUARIO,SENHA);
		}
	}

