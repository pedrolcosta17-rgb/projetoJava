
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import application.ConexaoMySQL;
import application.model.Usuario;
import controller.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

	public class Tela_Cadastro_Usuario_Controller {

		   @FXML
		    private TextField Bairro;

		    @FXML
		    private Button Bt_Alterar;

		    @FXML
		    private Button Bt_Excluir;

		    @FXML
		    private Button Bt_Fechar;

		    @FXML
		    private Button Bt_Inserir;

		    @FXML
		    private Button Bt_Pesquisar;

		    @FXML
		    private TextField Celular;

		    @FXML
		    private TextField Cep;

		    @FXML
		    private TextField Cidade;

		    @FXML
		    private TextField Cpf;

		    @FXML
		    private TextField Email;

		    @FXML
		    private TextField Endereco;

		    @FXML
		    private TextField Estado;

		    @FXML
		    private TableView<Usuario> Id_Tabela_Usu;

		    @FXML
		    private TableColumn<Usuario, Integer> Id_Viw_Usuario;

		    @FXML
		    private TableColumn<Usuario, String> Id_Viw_Infor;

		    @FXML
		    private TextField Login;

		    @FXML
		    private TextField Nome_Cadastro;

		    @FXML
		    private TextField Rg;

		    @FXML
		    private TextField Senha_Login;

		    @FXML
		    private TextField Telefone;
		    
		    @FXML
		    public void initialize() {
		        carregarUsuarios();
		        Id_Tabela_Usu.setOnMouseClicked(e->{
		        	Usuario usuario = Id_Tabela_Usu.getSelectionModel().getSelectedItem();
		        	if(usuario != null) {
		        		Nome_Cadastro.setText(usuario.getNome());
		        		Email.setText(usuario.getEmail());
		        		Cpf.setText(usuario.getCpf());
		        		Endereco.setText(usuario.getEndereco());
		        		Rg.setText(usuario.getRg());
		        		Bairro.setText(usuario.getBairro());
		        		Celular.setText(usuario.getCelular());
		        		Cidade.setText(usuario.getCidade());
		        		Telefone.setText(usuario.getTelefone());
		        		Login.setText(usuario.getLogin());
		        		Cep.setText(usuario.getCep());
		        		Estado.setText(usuario.getEstado());
		        		Senha_Login.setText(usuario.getSenha());
		        	}
		        });
		    }
	    
	    @FXML
	    private void onBtInserirAction() {
	    	
	    	try(Connection conn = ConexaoMySQL.getConnection()){
	    		String sql ="INSERT INTO usuario (nome,email,cpf, endereco, rg, bairro, celular, cidade, telefone, login, cep, estado,senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    		 PreparedStatement stmt = conn.prepareStatement(sql);
	    		 stmt.setString(1, Nome_Cadastro.getText());
	             stmt.setString(2, Email.getText());
	             stmt.setString(3, Cpf.getText());
	             stmt.setString(4, Endereco.getText());
	             stmt.setString(5, Rg.getText());
	             stmt.setString(6, Bairro.getText());
	             stmt.setString(7, Celular.getText());
	             stmt.setString(8, Cidade.getText());
	             stmt.setString(9, Telefone.getText());
	             stmt.setString(10, Login.getText());
	             stmt.setString(11, Cep.getText());
	             stmt.setString(12, Estado.getText());
	             stmt.setString(13, Senha_Login.getText());
	             
	             int linhasAfetadas = stmt.executeUpdate();
	             if (linhasAfetadas > 0) {
	                 Alerts.showAlert("Sucesso", null, "Usuário cadastrado com sucesso!", AlertType.INFORMATION);
	                 carregarUsuarios();
	                 limparCampos();
	             } else {
	                 Alerts.showAlert("Erro", null, "Não foi possível cadastrar o usuário.", AlertType.ERROR);
	             }
	    	} catch (Exception e) {
	            e.printStackTrace();
	            //Alerts.showAlert("Erro", null, "Erro ao conectar com o banco de dados.", AlertType.ERROR);
	        }
	    }
	    
	    private void limparCampos() {
	        Nome_Cadastro.clear();
	        Email.clear();
	        Cpf.clear();
	        Endereco.clear();
	        Rg.clear();
	        Bairro.clear();
	        Celular.clear();
	        Cidade.clear();
	        Telefone.clear();
	        Login.clear();
	        Cep.clear();
	        Estado.clear();
	        Senha_Login.clear();
	    }

	    
	    private void carregarUsuarios() {
	        ObservableList<Usuario> lista = FXCollections.observableArrayList();

	        try (Connection conn = ConexaoMySQL.getConnection()) {
	            String sql = "SELECT * FROM usuario";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                lista.add(new Usuario(
	                    rs.getInt("id"),
	                    rs.getString("nome"),
	                    rs.getString("senha"),
	                    rs.getString("email"),
	                    rs.getString("cpf"),
	                    rs.getString("endereco"),
	                    rs.getString("rg"),
	                    rs.getString("bairro"),
	                    rs.getString("celular"),
	                    rs.getString("cidade"),
	                    rs.getString("telefone"),
	                    rs.getString("login"),
	                    rs.getString("cep"),
	                    rs.getString("estado")
	                ));
	            }

	            // 🔗 Ligando colunas aos atributos do modelo
	            Id_Viw_Usuario.setCellValueFactory(new PropertyValueFactory<>("id"));
	            Id_Viw_Infor.setCellValueFactory(new PropertyValueFactory<>("nome"));

	            Id_Tabela_Usu.setItems(lista);

	        } catch (Exception e) {
	            e.printStackTrace();}
	        }
	        @FXML
	        private void onBtAlterarAction() {
	            // Verifica se um usuário foi selecionado na tabela
	            Usuario usuarioSelecionado = Id_Tabela_Usu.getSelectionModel().getSelectedItem();

	            if (usuarioSelecionado == null) {
	                Alerts.showAlert("Aviso", null, "Selecione um usuário na tabela para alterar.", AlertType.WARNING);
	                return;
	            }

	            try (Connection conn = ConexaoMySQL.getConnection()) {
	                String sql = "UPDATE usuario SET nome = ?, email = ?, cpf = ?, endereco = ?, rg = ?, bairro = ?, celular = ?, cidade = ?, telefone = ?, login = ?, cep = ?, estado = ?, senha = ? WHERE id = ?";
	                PreparedStatement stmt = conn.prepareStatement(sql);

	                // Pega os valores dos campos do formulário
	                stmt.setString(1, Nome_Cadastro.getText());
	                stmt.setString(2, Email.getText());
	                stmt.setString(3, Cpf.getText());
	                stmt.setString(4, Endereco.getText());
	                stmt.setString(5, Rg.getText());
	                stmt.setString(6, Bairro.getText());
	                stmt.setString(7, Celular.getText());
	                stmt.setString(8, Cidade.getText());
	                stmt.setString(9, Telefone.getText());
	                stmt.setString(10, Login.getText());
	                stmt.setString(11, Cep.getText());
	                stmt.setString(12, Estado.getText());
	                stmt.setString(13, Senha_Login.getText());

	                // ID do usuário que será atualizado
	                stmt.setInt(14, usuarioSelecionado.getId());

	                int linhasAfetadas = stmt.executeUpdate();

	                if (linhasAfetadas > 0) {
	                    Alerts.showAlert("Sucesso", null, "Usuário atualizado com sucesso!", AlertType.INFORMATION);
	                    carregarUsuarios();
	                    limparCampos();
	                } else {
	                    Alerts.showAlert("Erro", null, "Não foi possível atualizar o usuário.", AlertType.ERROR);
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	                Alerts.showAlert("Erro", null, "Erro ao atualizar no banco de dados.", AlertType.ERROR);}
	            

	}
	        @FXML
	        private void onBtExcluirAction() {
	            // Verifica se um usuário foi selecionado na tabela
	            Usuario usuarioSelecionado = Id_Tabela_Usu.getSelectionModel().getSelectedItem();

	            if (usuarioSelecionado == null) {
	                Alerts.showAlert("Aviso", null, "Selecione um usuário na tabela para excluir.", AlertType.WARNING);
	                carregarUsuarios();
	                return;
	            }

	            // Confirmação antes de excluir
	            Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
	            confirmAlert.setTitle("Confirmação");
	            confirmAlert.setHeaderText(null);
	            confirmAlert.setContentText("Tem certeza que deseja excluir o usuário \"" + usuarioSelecionado.getNome() + "\"?");
	            
	            // Espera a resposta do usuário
	            Optional<ButtonType> result = confirmAlert.showAndWait();
	            if (result.isPresent() && result.get() == ButtonType.OK) {
	                try (Connection conn = ConexaoMySQL.getConnection()) {
	                    String sql = "DELETE FROM usuario WHERE id = ?";
	                    PreparedStatement stmt = conn.prepareStatement(sql);
	                    stmt.setInt(1, usuarioSelecionado.getId());

	                    int linhasAfetadas = stmt.executeUpdate();

	                    if (linhasAfetadas > 0) {
	                        Alerts.showAlert("Sucesso", null, "Usuário excluído com sucesso!", AlertType.INFORMATION);
	                        carregarUsuarios(); // Atualiza a tabela
	                        limparCampos();     // Limpa os campos do formulário
	                    } else {
	                        Alerts.showAlert("Erro", null, "Não foi possível excluir o usuário.", AlertType.ERROR);
	                    }

	                } catch (Exception e) {
	                    e.printStackTrace();
	                    Alerts.showAlert("Erro", null, "Erro ao excluir no banco de dados.", AlertType.ERROR);
	                }
	            }
	        }
	}
	   
