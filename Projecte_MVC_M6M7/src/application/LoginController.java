package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DaoManager;
import dao.UsuarisDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pojos.Usuaris;
import resources.ControlErrores;

public class LoginController implements Initializable{

	@FXML private TextField et1; //usuari
	@FXML private TextField et2; //password
	@FXML private Button btEntrar;

	private static String tipusPerfil;
	private static String usuariDoctor;

	/**
	 * Ventana de l'aplicació que la guardarem per tancarla després.
	 */
	private static Stage stage;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void clickEntrar(ActionEvent event){
		try {

			if(this.checkLogin()){
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VistaAppMenu.fxml"));

				BorderPane root = (BorderPane) fxmlLoader.load();

				MenuController controllerGeneral = fxmlLoader.getController();

				stage = new Stage();
				stage.setScene(new Scene(root));
				stage.getIcons().add(new Image("/resources/logo.png"));

				controllerGeneral.obrirDoctors();

				stage.show();

				Node source = (Node) event.getSource();
				Stage stage2 = (Stage) source.getScene().getWindow();
				stage2.close();

			}else{
				ControlErrores.mostrarError("El usuari no existeix", "Usuari o contrasenya incorrectes");

			}

		} catch (Exception e) {
			ControlErrores.mostrarError("No s'ha pogut mostrar l'aplicació", e.getMessage());
		}
	}


	/**
	 * Checkea si el usuari existeix y quin tipus de perfil es
	 * @return Si existeix = true / Si no existeix = false
	 */
	private boolean checkLogin() throws SQLException{

		UsuarisDao usuariJDBC = DaoManager.getUsuarisDao();
		Usuaris usuari = null;

		/**
		 * Recollim el usuari que es va a logear
		 */
		usuari = usuariJDBC.getUsuari(et1.getText());

		if(usuari == null){
			return false;
		}else{
			if(et2.getText().equals(usuari.getPassword())){
				tipusPerfil = usuari.getPerfils().getDescripcio();
				usuariDoctor = usuari.getIdUsuari();
				return true;

			}else{
				return false;
			}
		}
	}

	public static String getTipusPerfil() {
		return tipusPerfil;
	}

	public static String getUsuariDoctor() {
		return usuariDoctor;
	}

	public static Stage getStage() {
		return stage;
	}


}
