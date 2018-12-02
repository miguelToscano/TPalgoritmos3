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

public class ContenedorStatsJugadores extends HBox {

	public ContenedorStatsJugadores(Jugador jugador1, Jugador jugador2, int width, int height) {
		
		Label nombreJugador1 = new Label(jugador1.obtenerNombre());
		nombreJugador1.setTranslateX(10);
		nombreJugador1.setTranslateY(height);
		
		Label oroJugador1 = new Label();
		oroJugador1.setTranslateX(0);
		oroJugador1.setTranslateY(height + 15);
		oroJugador1.setText("Oro: " + jugador1.obtenerOro());
		
		Label poblacionJugador1 = new Label();
		poblacionJugador1.setTranslateX(10);
		poblacionJugador1.setTranslateY(height + 30);
		poblacionJugador1.setText("Poblacion: " + jugador1.obtenerPoblacion());

		Label nombreJugador2 = new Label(jugador2.obtenerNombre());
		nombreJugador2.setTranslateX(width - 80);
		nombreJugador2.setTranslateY(height);
		
		Label oroJugador2 = new Label();
		oroJugador2.setTranslateX(width - 480);
		oroJugador2.setTranslateY(height + 15);
		oroJugador2.setText("Oro: " + jugador2.obtenerOro());
		
		Label poblacionJugador2 = new Label();
		poblacionJugador2.setTranslateX(width - 80);
		poblacionJugador2.setTranslateY(height + 30);
		poblacionJugador2.setText("Poblacion: " + jugador2.obtenerPoblacion());

		getChildren().addAll(nombreJugador1, oroJugador1, poblacionJugador1, nombreJugador2, oroJugador2, poblacionJugador2);
	}
}
