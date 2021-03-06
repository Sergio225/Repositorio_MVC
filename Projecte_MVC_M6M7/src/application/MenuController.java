package application;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import resources.ControlErrores;

public class MenuController implements Initializable {

	@FXML private BorderPane paneArrel;
	@FXML private AnchorPane paneVista;

	@FXML private Menu menuServeis;

	@Override
	public void initialize(URL url, ResourceBundle rsrcs) {

	}

	public void carregarVista(Pane vista) {
		if (vista == null) return;

		if (checkSiVistaEstaCarregada(vista.getId())) return;

		/**
		 * Limpia lo del centro del BorderPane
		 */
		this.paneVista.getChildren().clear();
		this.paneVista.getChildren().add(vista);

		AnchorPane.setTopAnchor(vista,0.0);
		AnchorPane.setBottomAnchor(vista,0.0);
		AnchorPane.setLeftAnchor(vista, 0.0);
		AnchorPane.setRightAnchor(vista, 0.0);


	}

	private boolean checkSiVistaEstaCarregada(String id) {
		if (id == null || this.paneVista != null || this.paneVista.getChildren() != null) return false;

		Iterator<Node> fills = this.paneVista.getChildren().iterator();

		while (fills.hasNext()) {
			Node aux = fills.next();
			if (id.equals(aux.getId())) return true;
		}

		return false;
	}


	//Vistes.................................................................................

	@FXML
	public void obrirDoctors() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaDoctors.fxml"));
			this.carregarVista(vista);


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void obrirTotsPacients() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaTotsPacients.fxml"));
			this.carregarVista(vista);


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void obrirPacientsXDoctor() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaPacientsXDoctor.fxml"));
			this.carregarVista(vista);


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void obrirAbout() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaAbout.fxml"));
			this.carregarVista(vista);


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void obrirPerfilUsuari() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaPerfilUsuari.fxml"));
			this.carregarVista(vista);


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void obrirServeis() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaServeis.fxml"));
			this.carregarVista(vista);




		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void obrirAsistencies() {
		try {
			BorderPane vista = (BorderPane)FXMLLoader.load(getClass().getResource("VistaAsistencies.fxml"));
			this.carregarVista(vista);


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

	@FXML
	public void tancarSessio() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VistaLogin.fxml"));

			BorderPane root = (BorderPane) fxmlLoader.load();

			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.getIcons().add(new Image("/resources/logo.png"));


			stage.show();

			LoginController.getStage().close();


		} catch (IOException e) {
			ControlErrores.mostrarError("Error de carga de pantalla", "Hi ha hagut algun error de connexio torna a intentar-ho");
		}
	}

}
