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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import unidades.*;

import com.sun.webkit.ContextMenu;

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
	
	public Bloque(int fila, int columna) {
		
		this.fila = fila;
		this.columna = columna;
		this.estaOcupado = false;
		
		Rectangle bordes = new Rectangle(15, 15);
		bordes.setFill(null);
		bordes.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(bordes);
		
		this.setOnMouseClicked(e -> {
			System.out.println("Fila: " + this.fila + " Columna: " + this.columna);
		});
		
		
	}
}
