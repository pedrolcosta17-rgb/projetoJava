package controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaForm_Principal {
	   @FXML
	    private AnchorPane idForm_Principal;
	   
	   private void carregarTela(String fxmlFile, String tituloFuncionalidade) {
		   try {
			   Parent fxml = FXMLLoader.load(getClass().getResource(fxmlFile));
			   idForm_Principal.getChildren().clear();
			   idForm_Principal.getChildren().add(fxml);
			   
			   AnchorPane.setTopAnchor(fxml,0.0);
			   AnchorPane.setBottomAnchor(fxml,0.0);
			   AnchorPane.setLeftAnchor(fxml,0.0);
			   AnchorPane.setRightAnchor(fxml,0.0);
			   
			   Scene cena = idForm_Principal.getScene();
			   
			   if(cena != null) {
				   Stage stage = (Stage) cena.getWindow();
				   stage.setTitle("Sistema - by Pedro Lucas | " + tituloFuncionalidade);
			   }
		   }catch(IOException e) {
			   e.printStackTrace();
		   }
		   
	   }
	   @FXML
	   private void abrirCadastro_Usuario() {
		   carregarTela("Tela_Cadastro_Usuario.fxml", "Formulário de Cadastro");
		   
		   
	   }
}
