package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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

public class Bloque extends StackPane {

	private boolean estaOcupado;
	int fila, columna;
	Unidad unidad;
//	Entidad entidadActual;
//	ImageView imagen;
	
	public Bloque(Entidad entidadActual, int fila, int columna) {
	
//		this.entidadActual = entidadActual;
		
//		if (entidadActual instanceof Aldeano) {
//			this.imagen = new ImageView(new Image("castillo.jpg"));
//		}
		
		this.fila = fila;
		this.columna = columna;
		this.estaOcupado = false;
		
//		private Rectangle rectangle;
//		Image img = new Image("/image/rifat.jpg");
//		rectangle.setFill(new ImagePattern(img));
		
		Rectangle bordes = new Rectangle(40, 40);
		
		if (entidadActual instanceof Aldeano) {
			
			Image img = new Image("aldeanoAlfa.jpg");
			bordes.setFill(new ImagePattern(img));
		} 
		
		else {
		
			bordes.setFill(null);
		}
//		Image img = new Image("castillo.jpg");
//		bordes.setFill(new ImagePattern(img));
		bordes.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(bordes);
		
		this.setOnMouseClicked(e -> {
			System.out.println("Fila: " + this.fila + " Columna: " + this.columna);
		});
		
		
	}
}
