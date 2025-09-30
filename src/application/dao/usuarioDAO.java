package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import application.ConexaoMySQL;
public class usuarioDAO {
    
	public boolean autenticar(String usuario, String senha)
	{
	try(Connection conn = ConexaoMySQL.getConnection()){
		String sql ="select*from funcionarios where usuario=? and senha=?";
		
		PreparedStatement query = conn.prepareStatement(sql);
		query.setString(1, usuario);
		query.setString(2, senha);
		
		ResultSet rs=query.executeQuery();
		return rs.next();
		
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
}
	
}
