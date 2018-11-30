package edificios;

import juego.Jugador;
import mapa.excepcionesMapa.cajaEstaOcupada;
import mapa.excepcionesMapa.casilleroEstaOcupado;
import mapa.excepcionesMapa.casilleroInvalido;
import unidades.Entidad;
import mapa.*;
import excepciones.superaLimitePoblacional;

import java.util.ArrayList;

public abstract class Edificio extends Entidad {

	protected Caja cajaOcupada;
	
	protected Casillero puntoRally; // aca se crean las unidades

	protected int velocidadReparacion;
	
	protected boolean construido=false;

	public Edificio (Caja lugarOcupado, Mapa mapa, Jugador jugador) throws cajaEstaOcupada
    {
        this.jugador = jugador;
        this.ubicarEn(lugarOcupado);
        this.settearPuntoRally(mapa);// ojo que para castillo puede estar en el medio
	}

	public Edificio (Casillero casilleroInicial, Mapa mapa, Jugador jugador) throws casilleroInvalido, cajaEstaOcupada
																					
    {
        this.jugador = jugador;
    	Caja caja = mapa.asignarCajaACasillero(casilleroInicial);
    	this.ubicarEn(caja);
    	this.settearPuntoRally(mapa);
	}
	
	public void settearPuntoRally (Mapa mapa)
    {
        //Ofrezco los casilleros circundantes posibles
        ArrayList<Casillero> casilleros = mapa.obtenerCasillerosCircundantes(this.cajaOcupada);

        //Opcion provisoria: Elijo el primero libre
        for(Casillero casillero: casilleros)
        {
            if(casillero.estaLibre())
                this.puntoRally = casillero;

        } //AGREGAR EXCEPCION
		//int puntoRallyFila = mapa.obtenerFilaInt(cajaOcupada.obtenerCasillero(0));
		//int puntoRallyColumna = mapa.obtenerColumnaInt(cajaOcupada.obtenerCasillero(0))+2;
		
		// pongo el +2 ahi. La idea seria abrir un GUI que permita elegir el RP
		
		//puntoRally = mapa.obtenerCasillero(puntoRallyFila, puntoRallyColumna);

	}
	
	private Caja fijarCaja(Casillero casilleroInicial, Mapa mapa) throws casilleroInvalido
    {
		return mapa.asignarCajaACasillero(casilleroInicial); // 4 para todos los edficios construibles
	}

	public void reparar()
	{
		this.vida += this.velocidadReparacion;
		if (this.vida > this.vidaCompleta)
			vida = vidaCompleta;
	}
	public boolean reparacionCompleta()
	{
		return (this.vida == this.vidaCompleta);
	}
	public Casillero getPuntoRally()
    {
		return this.puntoRally ;
	}
	
	public Caja obtenerEspacioOcupado()
	{
		return this.cajaOcupada;
	}
	
	public void mostrarConstruido() {
		this.construido=true;
	}
	
	public boolean estaEnRango (int rango, Casillero casillero)
	{
		for	(Casillero celda: this.cajaOcupada.getLista())
		{
			if	(Math.abs(celda.getFila() - casillero.getFila()) <= rango  || Math.abs(celda.getColumna() - casillero.getColumna()) <= rango )
				return true;
		}
		return false;
	}

	public void ubicarEn(Mapeable mapeable) throws cajaEstaOcupada
	{
		Caja caja = (Caja) mapeable;
		if (caja.estaOcupada())
		{
			throw new cajaEstaOcupada();
		}
		this.cajaOcupada = caja;
		caja.llenar(this);
	}

	
	public void matar () {
		this.vida = 0;
				
	}
	
	public void recibirDanio( int danioUnidades, int danioEdificios)
	{
		this.vida = this.vida - danioEdificios;
		if (!this.estaVivo()) {
			this.vida = 0;
			this.matar();
		}
	}

	public boolean destruidoTotalmente() {
		return (!this.estaVivo());		
	}
	/*
	public boolean puedoColocar(Casillero casillero,Mapa mapa) throws cajaEstaOcupada,casilleroInvalido
	{
		return mapa.puedoColocarEdificio(casillero);
	}
	*/
}


