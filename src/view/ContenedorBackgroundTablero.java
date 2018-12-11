package view;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import unidades.*;

import java.util.ArrayList;

import edificios.*;
import juego.*;
import excepciones.*;
import mapa.*;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;


public class ContenedorBackgroundTablero {

	ArrayList<ImageView> imagenes;
	
	public ContenedorBackgroundTablero(int width, int height) {
		
		this.imagenes = new ArrayList<ImageView>();
		
		ImageView backgroundTablero = new ImageView(new Image("TexturaLlanura.jpg"));
		backgroundTablero.setFitWidth(width);
		backgroundTablero.setFitHeight(height);	
		this.imagenes.add(backgroundTablero);
		this.iniciarJuego();
	}
	
	public ArrayList<ImageView> obtenerBackgroundTablero() {
		return this.imagenes;
	}
		public void iniciarJuego() {
		sonidoFondo = new MediaPlayer(new Media(new File("src/view/sonido/AgeMusic.mp3").toURI().toString()));
//		sonidoFondo.setOnEndOfMedia(new Runnable() {
//			public void run() {
//				sonidoFondo.seek(Duration.ZERO);
//			}
//		});
		sonidoFondo.play();
		
	}
}
