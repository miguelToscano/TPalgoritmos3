package view;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import unidades.*;

import java.util.ArrayList;
import java.util.Optional;

import edificios.*;
import juego.*;
import excepciones.*;
import mapa.*;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class Main extends Application {

	Scene menuInicio;
	
	public void start(Stage ventana) {
		
		ContenedorBackgroundMenuInicial backgroundMenuInicial = new ContenedorBackgroundMenuInicial();
		ContenedorBotonesMenuInicial botonesMenuInicial = new ContenedorBotonesMenuInicial(ventana);
		
		Group layoutMenuInicio = new Group();
		
		layoutMenuInicio.getChildren().addAll(backgroundMenuInicial.obtenerBackgroundMenuInicial());
		layoutMenuInicio.getChildren().addAll(botonesMenuInicial.obtenerBotones());
		
		this.menuInicio = new Scene(layoutMenuInicio, 1200, 650);

		ventana.setScene(menuInicio);
		ventana.setTitle("Algo Empires");
		ventana.show();
		
		ventana.setOnCloseRequest(event -> {
			Alert closeConfirmation = new Alert(
	                Alert.AlertType.CONFIRMATION,
	                "Estas seguro que deseas salir?"
	        );
	        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
	                ButtonType.OK
	        );
	        exitButton.setText("Salir");
	        closeConfirmation.setHeaderText("Confirmar");
	        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
	        closeConfirmation.initOwner(ventana);
	        closeConfirmation.setX(ventana.getX() + 500);
	        closeConfirmation.setY(ventana.getY() + 100);

	        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
	        if (!ButtonType.OK.equals(closeResponse.get())) {
	            event.consume();
	        }
		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
