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


public class ContenedorInformacionJuego {
	
	private ArrayList<Node> elementos;
	
	public ContenedorInformacionJuego(Juego juego, Jugador jugador1, Jugador jugador2, int width, int height) {
		
		this.elementos = new ArrayList<Node>();
		
		Button pasarTurno = new Button("Pasar turno");
		pasarTurno.setTranslateX(width/2 - 45);
		pasarTurno.setTranslateY(height + 10 );
		
		elementos.add(pasarTurno);
		
		Label turno = new Label();
		turno.setTranslateX(width / 2 + 45);
		turno.setTranslateY(height + 15);
		turno.setText("Turno: " + juego.obtenerGestorDeTurno().obtenerJugadorActual().obtenerNombre());
	
		elementos.add(turno);
	}
	
	public ArrayList<Node> obtenerInformacionJuego() {
		return this.elementos;
	}
}
