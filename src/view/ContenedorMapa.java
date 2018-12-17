package view;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
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
import edificios.*;
import juego.*;
import excepciones.*;
import mapa.*;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class ContenedorMapa extends Pane {

	Group mapa;
	Pane terreno;
	
	public ContenedorMapa(Juego juego, int width, int height) {
		
		this.mapa = new Group();
		
//		ImageView backgroundMapa = new ImageView(new Image("TexturaLlanura.jpg"));
//		backgroundMapa.setFitWidth(width);
//		backgroundMapa.setFitHeight(height);
//		mapa.getChildren().add(backgroundMapa);
//		
//		this.terreno = new Pane();
//		this.terreno.setPrefSize(width, height + 50);
//		mapa.getChildren().add(terreno);
//		
//		ContenedorBloques contenedorBloques = new ContenedorBloques(juego, this.terreno, width, height);
//		
//		// Crea Todas las celdas del mapa
//		for (int i = 0; i < juego.obtenerFilas(); i++) {
//			
//			for (int j = 0; j < juego.obtenerColumnas(); j++) {
//				
//				Bloque bloque = new Bloque(null, null, null, i, j, null);
//				bloque.setTranslateX(j * width/juego.obtenerFilas());
//				bloque.setTranslateY(i * height/juego.obtenerColumnas());
//				
//				mapa.getChildren().add(bloque);
//			}
//		}
//		
//		ImageView castilloJugador1 = new ImageView(new Image("castillo.jpg"));
//		castilloJugador1.setFitWidth((width/40) * 4);
//		castilloJugador1.setFitHeight((height/40) * 4);
//		castilloJugador1.setTranslateX(0);
//		castilloJugador1.setTranslateY(height - 60);
//		
//		mapa.getChildren().add(castilloJugador1);
//		
//		ImageView castilloJugador2 = new ImageView(new Image("castillo.jpg"));
//		castilloJugador2.setFitWidth((width/40) * 4);
//		castilloJugador2.setFitHeight((height/40) * 4);
//		castilloJugador2.setTranslateX(width - 60);
//		castilloJugador2.setTranslateY(0);
//		
//		mapa.getChildren().add(castilloJugador2);
	}
}
