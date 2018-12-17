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


public class ContenedorBloques {
	
	private ArrayList<Bloque> bloques;
	Juego juego;
	
	public ContenedorBloques(Stage ventana, Juego juego, Pane tablero, int width, int height) {
		this.bloques = new ArrayList<Bloque>();
		this.juego = juego;
		
		ArrayList<Entidad> entidadesYaDibujadas = new ArrayList<Entidad>();
		
		for (int i = 0; i < juego.obtenerFilas(); i++) {
			
			for (int j = 0; j < juego.obtenerColumnas(); j++) {
				
				Entidad entidadActual = juego.getMapa().obtenerCasillero(i, j).obtenerElemento();
				
				Bloque bloque = new Bloque(ventana, juego, tablero, entidadActual, i, j, this, width, height);
				bloque.setTranslateX(i * width/juego.obtenerFilas());
				bloque.setTranslateY(j * height/juego.obtenerColumnas());
				
				bloque.establecerImagen(entidadesYaDibujadas, entidadActual);
				if (!entidadesYaDibujadas.contains(entidadActual))
					entidadesYaDibujadas.add(entidadActual);
				this.bloques.add(bloque);
			}
		}
	}
	
	public ArrayList<Bloque> obtenerBloques() {
		return this.bloques;
	}
	
	public void agregarBloque(Bloque nuevoBloque) {
		this.bloques.add(nuevoBloque);
	}
	
	public Bloque obtenerBloque(int fila, int columna) {
		return this.bloques.get(fila * juego.obtenerFilas() + columna);
	}
}
