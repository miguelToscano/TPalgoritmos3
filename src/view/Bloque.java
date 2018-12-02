package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
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

import java.util.ArrayList;


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
	Entidad entidadActual;
	Rectangle bordes;
	ContextMenu acciones;
	
	public Bloque(Pane mapa, Entidad entidadActual, int fila, int columna) {
	
		this.entidadActual = entidadActual;		
		this.fila = fila;
		this.columna = columna;
		this.estaOcupado = false;
		this.bordes = new Rectangle(40, 40);
		
		bordes.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(bordes);
	
		this.setOnMouseClicked(e -> {
			System.out.println("Fila: " + this.fila + " Columna: " + this.columna);
			if (this.entidadActual instanceof Aldeano)
				System.out.println("Aldeano");
			else if (this.entidadActual instanceof Castillo)
				System.out.println("Castillo");
			else if (this.entidadActual instanceof PlazaCentral)
				System.out.println("Plaza central");
			
			this.establecerAcciones(mapa);
			
		});
		
		
	}
	
	public void establecerImagen(ArrayList<Entidad> entidadesYaDibujadas, Entidad entidadActual) {
		
		if (entidadActual instanceof Aldeano) {
			
			Image img = new Image("aldeanoAlfa.jpg");
			bordes.setFill(new ImagePattern(img));
		}
		
		else if (entidadActual instanceof PlazaCentral && !entidadesYaDibujadas.contains(entidadActual)) {
			Image img = new Image("PlazaCentral.jpg");
			bordes.setFill(new ImagePattern(img));
			bordes.setWidth(40 * 2);
			bordes.setHeight(40 * 2);
		}
		
		else if (entidadActual instanceof Castillo && !entidadesYaDibujadas.contains(entidadActual)) {
			Image img = new Image("castillo.jpg");
			bordes.setFill(new ImagePattern(img));
			bordes.setWidth(40 * 4);
			bordes.setHeight(40 * 4);
		}
		
		else {
		
			bordes.setFill(null);
		}
	}
	
	private void establecerAcciones(Pane mapa) {
		if (this.entidadActual instanceof Aldeano) {
			this.acciones = new ContextMenu();
			MenuItem item1 = new MenuItem("Mover");
			MenuItem item2 = new MenuItem("Construir");
			MenuItem item3 = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(item1, item2, item3);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
		}
		
		else if (this.entidadActual instanceof Castillo) {
			this.acciones = new ContextMenu();
			MenuItem item1 = new MenuItem("Crear Arma de Asedio");
			MenuItem item2 = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(item1, item2);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
		}
		
		else if (this.entidadActual instanceof PlazaCentral) {
			this.acciones = new ContextMenu();
			MenuItem item1 = new MenuItem("Crear Aldeano");
			MenuItem item2 = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(item1, item2);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
		}
			
	}
}
