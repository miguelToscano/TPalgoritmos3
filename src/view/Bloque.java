package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import unidades.*;

import java.util.ArrayList;


import edificios.*;
import juego.*;
import excepciones.*;
import mapa.*;
import mapa.excepcionesMapa.DistanciaInvalida;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;

public class Bloque extends StackPane {

	private boolean estaOcupado;
	int fila, columna;
	Unidad unidad;
	Entidad entidadActual;
	Rectangle bordes;
	ContextMenu acciones;
	Juego juego;
	Pane mapa;
	ContenedorBloques contenedor;
	Pane tablero;
	int width;
	int height;
	Stage ventana;
	
	public Bloque(Stage ventana, Juego juego, Pane mapa, Entidad entidadActual, int fila, int columna, ContenedorBloques contenedor, int width, int height) {
		
		this.ventana = ventana;
		this.width = width;
		this.height = height;
		this.contenedor = contenedor;
		this.juego = juego;
		this.entidadActual = entidadActual;		
		this.fila = fila;
		this.columna = columna;
		this.estaOcupado = false;
		this.bordes = new Rectangle(40, 40);
		this.mapa = mapa;
		
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
			
				this.establecerAcciones(mapa, this);
		});
	}
	
	public Rectangle obtenerBordes() {
		return this.bordes;
	}
	
	public Entidad obtenerEntidadActual() {
		return this.entidadActual;
	}
	
	public void establecerImagen(ArrayList<Entidad> entidadesYaDibujadas, Entidad entidadActual) {
		
		if (entidadActual != null && entidadActual.getVida() <= 0)
			bordes.setFill(null);
		
		else if (entidadActual instanceof Aldeano) {
			
			String imagenPath = "aldeano";
			
			if (entidadActual.obtenerJugador() == juego.obtenerJugador1())
				imagenPath += "Jugador1.jpg";
			else 
				imagenPath += "Jugador2.jpg";

			
			Image img = new Image(imagenPath);
			bordes.setFill(new ImagePattern(img));
		}
		
		else if (entidadActual instanceof PlazaCentral && !entidadesYaDibujadas.contains(entidadActual)) {
			
			PlazaCentral auxiliar =  (PlazaCentral) entidadActual;
			
			if (auxiliar.estaConstruido()) {
				
				String imagenPath = "PlazaCentral";
				
				if (entidadActual.obtenerJugador() == juego.obtenerJugador1())
					imagenPath += "Jugador1.jpg";
				else
					imagenPath += "Jugador2.jpg";
				
				Image img = new Image(imagenPath);
				bordes.setFill(new ImagePattern(img));
				bordes.setWidth(40 * 2);
				bordes.setHeight(40 * 2);
			}
				
			else {

				Image img = new Image("construccion.jpg");
				bordes.setFill(new ImagePattern(img));
				bordes.setWidth(40 * 2);
				bordes.setHeight(40 * 2);
			}
		}
		
		else if (entidadActual instanceof Arquero) {
			
			String imagenPath = "arquero";
			
			if (entidadActual.obtenerJugador() == juego.obtenerJugador1())
				imagenPath += "Jugador1.jpg";
			else
				imagenPath += "Jugador2.jpg";
			
			Image img = new Image(imagenPath);
			bordes.setFill(new ImagePattern(img));
			bordes.setWidth(40 * 1);
			bordes.setHeight(40 * 1);
		}
		
		else if (entidadActual instanceof Espadachin) {
			
			String imagenPath = "espadachin";
			
			if (entidadActual.obtenerJugador() == juego.obtenerJugador1())
				imagenPath += "Jugador1.jpg";
			else
				imagenPath += "Jugador2.jpg";
			
			Image img = new Image(imagenPath);
			bordes.setFill(new ImagePattern(img));
			bordes.setWidth(40 * 1);
			bordes.setHeight(40 * 1);
		}
		
		else if (entidadActual instanceof Castillo && !entidadesYaDibujadas.contains(entidadActual)) {
			
			String imagenPath = "castillo";
			
			if (entidadActual.obtenerJugador() == juego.obtenerJugador1())
				imagenPath += "Jugador1.jpg";
			else
				imagenPath += "Jugador2.jpg";
			
			Image img = new Image(imagenPath);
			bordes.setFill(new ImagePattern(img));
			bordes.setWidth(40 * 4);
			bordes.setHeight(40 * 4);
		}
		
		else if (entidadActual instanceof Cuartel && !entidadesYaDibujadas.contains(entidadActual)) {
			
			Cuartel auxiliar =  (Cuartel) entidadActual;
			
			if (auxiliar.estaConstruido()) {
				
				String imagenPath = "cuartel";
				
				if (entidadActual.obtenerJugador() == juego.obtenerJugador1())
					imagenPath += "Jugador1.jpg";
				else
					imagenPath += "Jugador2.jpg";
				
				Image img = new Image(imagenPath);
				bordes.setFill(new ImagePattern(img));
				bordes.setWidth(40 * 2);
				bordes.setHeight(40 * 2);
			}
				
			else {

				Image img = new Image("construccion.jpg");
				bordes.setFill(new ImagePattern(img));
				bordes.setWidth(40 * 2);
				bordes.setHeight(40 * 2);
			}
		}
		
		else {
		
			bordes.setFill(null);
		}
	}
	
	public void establecerEntidadActual(Entidad nuevaEntidad) {
		this.entidadActual = null;
	}
	
	private void establecerAcciones(Pane mapa, Bloque bloque) {
		
		if (this.entidadActual instanceof Aldeano) {
			this.acciones = new ContextMenu();
			MenuItem equipo = new MenuItem("Equipo: " + this.entidadActual.obtenerJugador().obtenerNombre());
			MenuItem vida = new MenuItem("Vida: " + this.entidadActual.getVida());
			MenuItem mover = new MenuItem("Mover");
			MenuItem construir = new MenuItem("Construir");
			MenuItem cancelar = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(equipo, vida, mover, construir, cancelar);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
			
			mover.setOnAction(e -> {
				this.mapa.setOnMouseClicked(event -> {
					double x = event.getX();
					double xAux = 0;
					for (int i = 0; i < this.width / this.juego.getMapa().obtenerTamanioFilas(); i++) {
						xAux = i * 40;
						if (xAux > x) {
							xAux = 40 * (i - 1);
							break;
						}
					}
					x = xAux;
					double y = event.getY();
					double yAux = 0;
					for (int i = 0; i < this.height / this.juego.getMapa().obtenerTamanioColumnas(); i++) {
						yAux = i * 40;
						if (yAux > y) {
							yAux = 40 * (i - 1);
							break;
						}
					}
					y = yAux;
					Unidad unidadActual =(Unidad) bloque.obtenerEntidadActual();
					try {
						unidadActual.mover(this.juego.getMapa().obtenerCasillero((int) xAux / 40, (int) yAux / 40));
					} catch (MovimientoInvalido | casilleroEstaOcupado | NoEsElTurnoDelJugador
							| PiezaDeshabilitadaEnTurno e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DistanciaInvalida e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
					this.mapa.setOnMouseClicked(event2 -> {
						
					});
				});	
			});
			
			construir.setOnAction(event -> {
				ContextMenu construibles = new ContextMenu();
				PlazaCentral auxiliarPlaza = new PlazaCentral();
				Cuartel auxiliarCuartel = new Cuartel();
				MenuItem construirPlazaCentral = new MenuItem("Plaza Central: " + auxiliarPlaza.getCosto() + " oro");
				MenuItem construirCuartel = new MenuItem("Cuartel: " + auxiliarCuartel.getCosto() + " oro");
				MenuItem cancelar2 = new MenuItem("Cancelar");
				construibles.setAnchorX(this.fila);
				construibles.setAnchorY(this.columna);
				construibles.setX(this.fila);
				construibles.setY(this.columna);
				construibles.setStyle("-fx-base: black");
				construibles.getItems().addAll(construirPlazaCentral, construirCuartel, cancelar2);
				construibles.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
			
				construirPlazaCentral.setOnAction(event1 -> {
					this.mapa.setOnMouseClicked(event2 -> {
						double x = event2.getX();
						double xAux = 0;
						for (int i = 0; i < this.width / this.juego.getMapa().obtenerTamanioFilas(); i++) {
							xAux = i * 40;
							if (xAux > x) {
								xAux = 40 * (i - 1);
								break;
							}
						}
						x = (int) xAux;
						double y = event2.getY();
						double yAux = 0;
						for (int i = 0; i < this.height / this.juego.getMapa().obtenerTamanioColumnas(); i++) {
							yAux = i * 40;
							if (yAux > y) {
								yAux = 40 * (i - 1);
								break;
							}
						}
						y = (int) yAux;
						
						System.out.println("x: " + x + " y: " + y);
			
							Aldeano aldeano = (Aldeano) this.entidadActual;
							try {
								aldeano.construirPlazaCentral(this.juego.getMapa().obtenerCasillero((int) x / 40, (int) y / 40), this.juego.getMapa(), this.entidadActual.obtenerJugador());
							} catch (CajaNoEstaPegadaAAldeano | cajaEstaOcupada | casilleroInvalido
									| PiezaDeshabilitadaEnTurno e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						this.actualizarPantalla(ventana, juego, this.mapa, fila, columna, contenedor, width, height);
						this.mapa.setOnMouseClicked(event3 -> {
							
						});
					});
				});
				
				construirCuartel.setOnAction(event1 -> {
					this.mapa.setOnMouseClicked(event2 -> {
						double x = event2.getX();
						double xAux = 0;
						for (int i = 0; i < this.width / this.juego.getMapa().obtenerTamanioFilas(); i++) {
							xAux = i * 40;
							if (xAux > x) {
								xAux = 40 * (i - 1);
								break;
							}
						}
						x = (int) xAux;
						double y = event2.getY();
						double yAux = 0;
						for (int i = 0; i < this.height / this.juego.getMapa().obtenerTamanioColumnas(); i++) {
							yAux = i * 40;
							if (yAux > y) {
								yAux = 40 * (i - 1);
								break;
							}
						}
						y = (int) yAux;
						
						System.out.println("x: " + x + " y: " + y);
					
						Aldeano aldeano = (Aldeano) this.entidadActual;
						try {
							aldeano.construirCuartel(this.juego.getMapa().obtenerCasillero((int) x / 40, (int) y / 40), this.juego.getMapa(), this.entidadActual.obtenerJugador());
						} catch (CajaNoEstaPegadaAAldeano | cajaEstaOcupada | casilleroInvalido
								| PiezaDeshabilitadaEnTurno e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						this.actualizarPantalla(ventana, juego, this.mapa, fila, columna, contenedor, width, height);
						this.mapa.setOnMouseClicked(event3 -> {
							
						});
					});
				});
			});
			
			
			
		}
		
		else if (this.entidadActual instanceof Militar) {
			this.acciones = new ContextMenu();
			MenuItem equipo = new MenuItem("Equipo: " + this.entidadActual.obtenerJugador().obtenerNombre());
			MenuItem vida = new MenuItem("Vida: " + this.entidadActual.getVida());
			MenuItem mover = new MenuItem("Mover");
			MenuItem atacar = new MenuItem("Atacar");
			MenuItem cancelar = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(equipo, vida, mover, atacar, cancelar);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
			
			mover.setOnAction(e -> {
				this.mapa.setOnMouseClicked(event -> {
					double x = event.getX();
					double xAux = 0;
					for (int i = 0; i < this.width / this.juego.getMapa().obtenerTamanioFilas(); i++) {
						xAux = i * 40;
						if (xAux > x) {
							xAux = 40 * (i - 1);
							break;
						}
					}
					x = xAux;
					double y = event.getY();
					double yAux = 0;
					for (int i = 0; i < this.height / this.juego.getMapa().obtenerTamanioColumnas(); i++) {
						yAux = i * 40;
						if (yAux > y) {
							yAux = 40 * (i - 1);
							break;
						}
					}
					y = yAux;
			
					Unidad unidadActual =(Unidad) bloque.obtenerEntidadActual();
					try {
						unidadActual.mover(this.juego.getMapa().obtenerCasillero((int) xAux / 40, (int) yAux / 40));
					} catch (MovimientoInvalido | casilleroEstaOcupado | NoEsElTurnoDelJugador
							| PiezaDeshabilitadaEnTurno | DistanciaInvalida e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
					this.mapa.setOnMouseClicked(event2 -> {
						
					});
				});	
			});
			
			atacar.setOnAction(e -> {
				this.mapa.setOnMouseClicked(event -> {
					double x = event.getX();
					double xAux = 0;
					for (int i = 0; i < this.width / this.juego.getMapa().obtenerTamanioFilas(); i++) {
						xAux = i * 40;
						if (xAux > x) {
							xAux = 40 * (i - 1);
							break;
						}
					}
					x = xAux;
					double y = event.getY();
					double yAux = 0;
					for (int i = 0; i < this.height / this.juego.getMapa().obtenerTamanioColumnas(); i++) {
						yAux = i * 40;
						if (yAux > y) {
							yAux = 40 * (i - 1);
							break;
						}
					}
					y = yAux;
			
					Militar unidadActual =(Militar) bloque.obtenerEntidadActual();
					Casillero casillero = this.juego.getMapa().obtenerCasillero((int) xAux / 40,(int) yAux / 40);
					Entidad objetivo = casillero.obtenerElemento();
					
					try {
						unidadActual.atacar(objetivo);
					} catch (FueraDeRango | UnidadAliada | NoEsElTurnoDelJugador | PiezaDeshabilitadaEnTurno e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
					this.mapa.setOnMouseClicked(event2 -> {
						
					});
				});	
			});
				
		}
		
		else if (this.entidadActual instanceof Castillo) {
			this.acciones = new ContextMenu();
			MenuItem equipo = new MenuItem("Equipo: " + this.entidadActual.obtenerJugador().obtenerNombre());
			MenuItem vida = new MenuItem("Vida: " + this.entidadActual.getVida());
			MenuItem crearArmaDeAsedio = new MenuItem("Crear Arma de Asedio");
			MenuItem cancelar = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(equipo, vida, crearArmaDeAsedio, cancelar);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
		}
		
		else if (this.entidadActual instanceof PlazaCentral) {
			this.acciones = new ContextMenu();
			Aldeano auxiliarAldeano = new Aldeano();
			MenuItem equipo = new MenuItem("Equipo: " + this.entidadActual.obtenerJugador().obtenerNombre());
			MenuItem vida = new MenuItem("Vida: " + this.entidadActual.getVida());
			MenuItem crearAldeano = new MenuItem("Crear Aldeano: " + auxiliarAldeano.getCosto() + " oro");
			MenuItem cancelar = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(equipo, vida, crearAldeano, cancelar);
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
			
			crearAldeano.setOnAction(event1 -> {
				
				PlazaCentral plaza = (PlazaCentral) this.entidadActual;
				
				try {
					plaza.crearAldeano(this.juego.getMapa());
				} catch (casilleroEstaOcupado | SuperaLimitePoblacional | NoHaySuficienteOro e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
			});
		}
		
		else if (this.entidadActual instanceof Cuartel) {
			this.acciones = new ContextMenu();
//			((Cuartel) this.entidadActual).setEstaConstruido(true);
			MenuItem equipo = new MenuItem("Equipo: " + this.entidadActual.obtenerJugador().obtenerNombre());
			MenuItem vida = new MenuItem("Vida: " + this.entidadActual.getVida());
			MenuItem crearEspadachin = new MenuItem("Crear espadachin");
			MenuItem crearArquero = new MenuItem("Crear arquero");
			MenuItem cancelar = new MenuItem("Cancelar");
			this.acciones.setAnchorX(this.fila);
			this.acciones.setAnchorY(this.columna);
			this.acciones.setX(this.fila);
			this.acciones.setY(this.columna);
			this.acciones.setStyle("-fx-base: black");
			acciones.getItems().addAll(vida, cancelar);
			if (((Cuartel) this.entidadActual).estaConstruido()) {
				acciones.getItems().clear();
				acciones.getItems().addAll(equipo, vida, crearEspadachin, crearArquero, cancelar);
			}
			this.acciones.show(mapa, this.fila * 40 + 15, this.columna * 40 + 15);
			
			crearArquero.setOnAction(event1 -> {
				
				Cuartel cuartel = (Cuartel) this.entidadActual;
				
				try {
					cuartel.crearArquero(this.juego.getMapa());
				} catch (casilleroEstaOcupado | SuperaLimitePoblacional | NoHaySuficienteOro e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
			});
			
			crearEspadachin.setOnAction(event1 -> {
				
				Cuartel cuartel = (Cuartel) this.entidadActual;
				
				try {
					cuartel.crearEspadachin(this.juego.getMapa());
				} catch (casilleroEstaOcupado | SuperaLimitePoblacional | NoHaySuficienteOro e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
			});
		}
		}
	
	
	private void establecerUnidadActual(Entidad nuevaEntidad) {
		this.entidadActual = nuevaEntidad;
	}
	
		
	public ArrayList<Bloque> obtenerBloquesDisponiblesMovimiento(Bloque bloqueActual) {
		
		ArrayList<Bloque> bloquesDisponibles = new ArrayList<Bloque>();
		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				Bloque aux = this.contenedor.obtenerBloque(i, j);
//				System.out.println("Fila: " + aux.fila + " Columna: " + aux.columna);
//				if (aux.obtenerEntidadActual() instanceof Castillo) {
//					System.out.println("Castillo");
//				}
//			}
//		}
		
		if (bloqueActual.obtenerEntidadActual() instanceof Unidad) {
			Unidad unidadActual = (Unidad) bloqueActual.obtenerEntidadActual();
			
			for (int i = unidadActual.obtenerCasilleroOcupado().getFila() - 1; i <= unidadActual.obtenerCasilleroOcupado().getFila() + 1; i++) {
				for (int j = unidadActual.obtenerCasilleroOcupado().getColumna() - 1; j <= unidadActual.obtenerCasilleroOcupado().getColumna() + 1; j++) {

					if (i >= 0 && i < this.juego.getMapa().obtenerTamanioFilas() && j >= 0 && j < this.juego.getMapa().obtenerTamanioColumnas()) {
						Bloque bloqueAuxiliar = this.contenedor.obtenerBloque(i, j);
						if (bloqueAuxiliar.obtenerEntidadActual() instanceof Entidad) {
							System.out.println("Estoy agarrando una entidad cuando no deberia");
						}
						
						if (!(bloqueAuxiliar.obtenerEntidadActual() instanceof Unidad)
								&& !(bloqueAuxiliar.obtenerEntidadActual() instanceof Edificio)
								&& bloqueAuxiliar.obtenerEntidadActual() != bloqueActual.obtenerEntidadActual()) {
							bloquesDisponibles.add(bloqueAuxiliar);						
						}
					}
				}
			}
		}
		
		return bloquesDisponibles;
	}
	
	private void ejecutarLogicaDeTurno(Juego juego, ContenedorBloques contenedor) {
		
		// Obtener TODOS los bloques y ejecutar las acciones correspondientes a lo que contenga ese bloque
		Jugador jugadorActual = juego.obtenerGestorDeTurno().obtenerJugadorActual();
		ArrayList<Bloque> bloques = contenedor.obtenerBloques();
		ArrayList<Entidad> entidadesYaEjecutadas = new ArrayList<Entidad>();
		
		for (int i = 0; i < bloques.size(); i++) {
			
			Entidad entidad = bloques.get(i).obtenerEntidadActual();
			
			if (entidad != null && !entidadesYaEjecutadas.contains(entidad) && entidad.obtenerJugador() == juego.obtenerGestorDeTurno().obtenerJugadorActual()) {
				
				if (entidad instanceof Unidad) {
					Unidad auxiliar = (Unidad) entidad;
					auxiliar.habilitar();
					if (auxiliar.getVida() <= 0)
						this.establecerEntidadActual(null);
				}
				
				entidad.ejecutarLogicaDeTurno();
				
				entidadesYaEjecutadas.add(entidad);
			}
		}
		
		bloques.clear();
		
		
	}

	public void actualizarPantalla() {
		this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
	}
	
	public void pasarTurno() throws HayUnGanador {
		this.juego.obtenerGestorDeTurno().finalizarTurno();
		this.ejecutarLogicaDeTurno(juego, contenedor);
		this.actualizarPantalla(ventana, juego, mapa, fila, columna, contenedor, width, height);
	}
	
	private void actualizarPantalla(Stage ventana, Juego juego, Pane mapa, int fila, int columna, ContenedorBloques contenedor, int width, int height) {
	
		Pane tableroActualizado = new Pane();
		Bloque auxiliar = null;
		
		ContenedorStatsJugadores statsJugadores = new ContenedorStatsJugadores(juego, juego.obtenerJugador1(), juego.obtenerJugador2(), width, height);
		ContenedorBloques bloques = new ContenedorBloques(ventana, juego, tableroActualizado, width, height);
		ContenedorInformacionJuego informacionJuego = new ContenedorInformacionJuego(juego, juego.obtenerJugador1(), juego.obtenerJugador2(), width, height, bloques.obtenerBloques().get(0));
		ContenedorBackgroundTablero backgroundTablero = new ContenedorBackgroundTablero(width, height);

		tableroActualizado.getChildren().addAll(statsJugadores.obtenerStatsJugadores());
		tableroActualizado.getChildren().addAll(informacionJuego.obtenerInformacionJuego());
		tableroActualizado.getChildren().addAll(backgroundTablero.obtenerBackgroundTablero());
		tableroActualizado.getChildren().addAll(bloques.obtenerBloques());
	
		tableroActualizado.setPrefSize(width, height + 50);
		
		ventana.setScene(new Scene(tableroActualizado));
	}
}