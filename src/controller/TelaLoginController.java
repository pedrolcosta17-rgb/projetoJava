package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.ConexaoMySQL;

import controller.util.Alerts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController {

    @FXML
    private Button btEntrar;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUsuario;
    
    @FXML
    private void onbtEntrarAction() {
    	String usuario = txtUsuario.getText();
    	String senha = txtSenha.getText();
    	
    	try(Connection conn = ConexaoMySQL.getConnection()){
    		String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
    		PreparedStatement stmt = conn.prepareStatement(sql);
    		stmt.setString(1, usuario);
    		stmt.setString(2, senha);
    		
    		ResultSet rs = stmt.executeQuery();
    		
    		if(rs.next()) {
    			//Alerts.showAlert(null, "Login bem - sucedido!", null, AlertType.INFORMATION);
    			btEntrar.getScene().getWindow().hide();
    			Parent root = FXMLLoader.load(getClass().getResource("Formulario_principal.fxml"));
    			Stage stage = new Stage();
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                stage.setTitle("Sistema - by Loja  | Página inicial ");
                stage.centerOnScreen();
                stage.setMaximized(true);
                stage.show();
                Alerts.showAlert(null, "Login bem - sucedido!", null, AlertType.INFORMATION);
    		}
    		else {
    			Alerts.showAlert(null, "Usuário ou senha incorretos!", null, AlertType.ERROR);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		//Alerts.showAlert(null, "Erro na conexão com o banco!", null, AlertType.ERROR);
    	}
    }

}

	 
	