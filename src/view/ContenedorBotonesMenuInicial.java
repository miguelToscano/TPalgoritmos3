package view;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

import juego.*;
import excepciones.*;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class ContenedorBotonesMenuInicial {

	ArrayList<Node> botones;
	
	public ContenedorBotonesMenuInicial(Stage ventana) {
		
		this.botones = new ArrayList<Node>();
		
		TextField ingresoJugador1 = new TextField("nombre Jugador 1");
		ingresoJugador1.setPrefSize(140, 30);
		ingresoJugador1.setTranslateY(600 * 0.63);
		ingresoJugador1.setTranslateX(1200 * 0.35);
		ingresoJugador1.setEffect(new InnerShadow());
		ingresoJugador1.setStyle("-fx-base: darkblue");
		
		this.botones.add(ingresoJugador1);
		
		TextField ingresoJugador2 = new TextField("nombre Jugador 2");
		ingresoJugador2.setPrefSize(140, 30);
		ingresoJugador2.setTranslateY(600 * 0.63);
		ingresoJugador2.setTranslateX(1200 * 0.35 + 150);
		ingresoJugador2.setEffect(new InnerShadow());
		ingresoJugador2.setStyle("-fx-base: darkblue");
		
		this.botones.add(ingresoJugador2);
		
		Button iniciar = new Button("Iniciar Partida");
		iniciar.setPrefSize(300, 30);
		iniciar.setTranslateY(600 * 0.7);
		iniciar.setTranslateX(1200 * 0.35);
		iniciar.setEffect(new InnerShadow());
		iniciar.setStyle("-fx-base: darkblue");
		
		iniciar.setOnAction(e -> {
			try {
				ventana.setScene(new Scene(iniciarPartida(ventana, ingresoJugador1.getText(), ingresoJugador2.getText())));
			} catch (tamanioDeMapaInvalido | casilleroInvalido | cajaEstaOcupada | SuperaLimitePoblacional e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (casilleroEstaOcupado e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		
		this.botones.add(iniciar);
		
		Button instrucciones = new Button("Instrucciones");
		instrucciones.setPrefSize(300, 30);
		instrucciones.setTranslateY(600 * 0.8);
		instrucciones.setTranslateX(1200 * 0.35);
		instrucciones.setEffect(new InnerShadow());
		instrucciones.setStyle("-fx-base: darkblue");
		
		this.botones.add(instrucciones);
		
		Button salir = new Button("Salir");
		salir.setPrefSize(300, 30);
		salir.setTranslateY(600 * 0.9);
		salir.setTranslateX(1200 * 0.35);
		salir.setEffect(new InnerShadow());
		salir.setStyle("-fx-base: darkblue");
		salir.setOnAction(evento -> {
			ventana.close();
		});
		
		this.botones.add(salir);
	}
	
	public ArrayList<Node> obtenerBotones() {
		return this.botones;
	}
	
	public Parent iniciarPartida(Stage ventana, String nombreJugador1, String nombreJugador2) throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, SuperaLimitePoblacional, casilleroEstaOcupado {
		
		Jugador jugador1 = new Jugador(nombreJugador1);
		Jugador jugador2 = new Jugador(nombreJugador2);
		Juego juego = new Juego(jugador1, jugador2, 15, 15);
		
		int width = 600;
		int height = 600;
		
		Pane tablero = new Pane();
		tablero.setPrefSize(width, height + 50);
		
		ContenedorStatsJugadores statsJugadores = new ContenedorStatsJugadores(juego, jugador1, jugador2, width, height);
		ContenedorInformacionJuego informacionJuego = new ContenedorInformacionJuego(juego, jugador1, jugador2, width, height);
		ContenedorBloques bloques = new ContenedorBloques(ventana, juego, tablero, width, height);
		ContenedorBackgroundTablero backgroundTablero = new ContenedorBackgroundTablero(width, height);
		
		tablero.getChildren().addAll(statsJugadores.obtenerStatsJugadores());
		tablero.getChildren().addAll(informacionJuego.obtenerInformacionJuego());
		tablero.getChildren().addAll(backgroundTablero.obtenerBackgroundTablero());
		tablero.getChildren().addAll(bloques.obtenerBloques());
		
		return tablero;
	}
}
