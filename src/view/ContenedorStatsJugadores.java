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

public class ContenedorStatsJugadores extends HBox {

	ArrayList<Node> elementos;
	
	public ContenedorStatsJugadores(Juego juego, Jugador jugador1, Jugador jugador2, int width, int height) {
		
		this.elementos = new ArrayList<Node>();
		
		Label nombreJugador2 = new Label(jugador2.obtenerNombre());
		nombreJugador2.setTranslateX(10);
		nombreJugador2.setTranslateY(height);
		
		elementos.add(nombreJugador2);
		
		Label oroJugador2 = new Label();
		oroJugador2.setTranslateX(10);
		oroJugador2.setTranslateY(height + 15);
		oroJugador2.setText("Oro: " + jugador2.obtenerOro());
		
		elementos.add(oroJugador2);
		
		Label poblacionJugador2 = new Label();
		poblacionJugador2.setTranslateX(10);
		poblacionJugador2.setTranslateY(height + 30);
		poblacionJugador2.setText("Poblacion: " + jugador2.obtenerPoblacion());

		elementos.add(poblacionJugador2);
		
		Label nombreJugador1 = new Label(jugador1.obtenerNombre());
		nombreJugador1.setTranslateX(width - 80);
		nombreJugador1.setTranslateY(height);
		
		elementos.add(nombreJugador1);
		
		Label oroJugador1 = new Label();
		oroJugador1.setTranslateX(width - 80);
		oroJugador1.setTranslateY(height + 15);
		oroJugador1.setText("Oro: " + jugador1.obtenerOro());
		
		elementos.add(oroJugador1);
		
		Label poblacionJugador1 = new Label();
		poblacionJugador1.setTranslateX(width - 80);
		poblacionJugador1.setTranslateY(height + 30);
		poblacionJugador1.setText("Poblacion: " + jugador1.obtenerPoblacion());
			
		elementos.add(poblacionJugador1);
		
		Button pasarTurno = new Button("Pasar turno");
		pasarTurno.setTranslateX(width/2 - 45);
		pasarTurno.setTranslateY(height + 10 );
		
		elementos.add(pasarTurno);
		
		Label turno = new Label();
		turno.setText("Turno: " + juego.obtenerGestorDeTurno().obtenerJugadorActual().obtenerNombre());
		turno.setTranslateX(width / 2 + 45);
		turno.setTranslateY(height + 15);
	
		elementos.add(turno);
	}
		
	public ArrayList<Node> obtenerStatsJugadores() {
		return this.elementos;
	}
}
