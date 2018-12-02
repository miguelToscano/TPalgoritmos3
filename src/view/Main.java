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
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class Main extends Application {

	Scene menuInicio;
	Scene partida;
	
	public void start(Stage ventana) {
		
		Image imagen = new Image("backgroundFinal.jpg");
		ImageView fondo = new ImageView(imagen);
		fondo.setFitHeight(650);
		fondo.setFitWidth(1200);
	
		Button iniciar = new Button("Iniciar Partida");
		iniciar.setPrefSize(300, 30);
		iniciar.setTranslateY(600 * 0.7);
		iniciar.setTranslateX(1200 * 0.35);
		iniciar.setEffect(new InnerShadow());
		iniciar.setStyle("-fx-base: darkblue");
		
		Button instrucciones = new Button("Instrucciones");
		instrucciones.setPrefSize(300, 30);
		instrucciones.setTranslateY(600 * 0.8);
		instrucciones.setTranslateX(1200 * 0.35);
		instrucciones.setEffect(new InnerShadow());
		instrucciones.setStyle("-fx-base: darkblue");
		
		Button salir = new Button("Salir");
		salir.setPrefSize(300, 30);
		salir.setTranslateY(600 * 0.9);
		salir.setTranslateX(1200 * 0.35);
		salir.setEffect(new InnerShadow());
		salir.setStyle("-fx-base: darkblue");
		salir.setOnAction(evento -> {
			ventana.close();
		});
		
		Group layoutMenuInicio = new Group();
		layoutMenuInicio.getChildren().addAll(fondo, iniciar, instrucciones, salir);
		
		this.menuInicio = new Scene(layoutMenuInicio, 1200, 650);
		
		Button hola = new Button("Hola");
		hola.setPrefSize(300, 30);
		hola.setTranslateY(600 * 0.9);
		hola.setTranslateX(1200 * 0.35);
		hola.setEffect(new InnerShadow());
		hola.setStyle("-fx-base: darkblue");
		
		
		ImageView fondoMapa = new ImageView(new Image("fondoPasto.jpg"));
		fondoMapa.setFitHeight(1200);
		fondoMapa.setFitWidth(650);
		fondoMapa.setSmooth(true);
		
		Group layoutPartida = new Group();
//		layoutPartida.getChildren().add(fondoMapa);
		
		iniciar.setOnAction(e -> {
			try {
				ventana.setScene(new Scene(iniciarPartida()));
			} catch (tamanioDeMapaInvalido | casilleroInvalido | cajaEstaOcupada | superaLimitePoblacional e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (casilleroEstaOcupado e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		this.partida = new Scene(layoutPartida, 1200, 650);
		
		ventana.setScene(menuInicio);
		ventana.setTitle("Algo Empires");
		ventana.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public Parent iniciarPartida() throws tamanioDeMapaInvalido, casilleroInvalido, cajaEstaOcupada, superaLimitePoblacional, casilleroEstaOcupado {
		
		Jugador jugador1 = new Jugador("Ingleses");
		Jugador jugador2 = new Jugador("Celtas");
		Juego juego = new Juego(jugador1, jugador2, 15, 15);
		
		int width = 600;
		int height = 600;
		
		ContenedorStatsJugadores statsJugadores = new ContenedorStatsJugadores(jugador1, jugador2, width, height);
		
		Label nombreJugador1 = new Label(jugador1.obtenerNombre());
		nombreJugador1.setTranslateX(10);
		nombreJugador1.setTranslateY(height);
		
		Label oroJugador1 = new Label();
		oroJugador1.setTranslateX(10);
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
		oroJugador2.setTranslateX(width - 80);
		oroJugador2.setTranslateY(height + 15);
		oroJugador2.setText("Oro: " + jugador1.obtenerOro());
		
		Label poblacionJugador2 = new Label();
		poblacionJugador2.setTranslateX(width - 80);
		poblacionJugador2.setTranslateY(height + 30);
		poblacionJugador2.setText("Poblacion: " + jugador2.obtenerPoblacion());
		
		Pane mapa = new Pane();
		mapa.setPrefSize(width, height + 50);
		
		ImageView backgroundMapa = new ImageView(new Image("TexturaLlanura.jpg"));
		backgroundMapa.setFitWidth(width);
		backgroundMapa.setFitHeight(height);
		mapa.getChildren().add(backgroundMapa);
		mapa.getChildren().add(oroJugador1);
		mapa.getChildren().add(nombreJugador1);
		mapa.getChildren().add(poblacionJugador1);
		mapa.getChildren().add(oroJugador2);
		mapa.getChildren().add(nombreJugador2);
		mapa.getChildren().add(poblacionJugador2);
		
		// Crea Todas las celdas del mapa
		
		ArrayList<Entidad> entidadesYaDibujadas = new ArrayList<Entidad>();
		
		for (int i = 0; i < juego.obtenerFilas(); i++) {
			
			for (int j = 0; j < juego.obtenerColumnas(); j++) {
				
				Entidad entidadActual = juego.getMapa().obtenerCasillero(i, j).obtenerElemento();
				
				Bloque bloque = new Bloque(mapa, entidadActual, i, j);
				bloque.setTranslateX(i * width/juego.obtenerFilas());
				bloque.setTranslateY(j * height/juego.obtenerColumnas());
				
				bloque.establecerImagen(entidadesYaDibujadas, entidadActual);
				if (!entidadesYaDibujadas.contains(entidadActual))
					entidadesYaDibujadas.add(entidadActual);
				
				mapa.getChildren().add(bloque);
			}
		}
		
		Button pasarTurno = new Button("Pasar turno");
		pasarTurno.setTranslateX(width/2 - 45);
		pasarTurno.setTranslateY(height + 10 );
		
		Label turno = new Label();
		turno.setTranslateX(width / 2 + 45);
		turno.setTranslateY(height + 15);
		turno.setText("Turno: ");
		mapa.getChildren().addAll(pasarTurno, turno);
		
		return mapa;
	}
}
