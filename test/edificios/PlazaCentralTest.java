package edificios;
import java.util.ArrayList;

import junit.framework.Assert;
import mapa.*;
import mapa.excepcionesMapa.casilleroInvalido;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import unidades.Aldeano;

import org.junit.Test;

import mapa.excepcionesMapa.casilleroLleno;

public class PlazaCentralTest {
	
	private Caja caja;
    private Mapa mapa;
    private Casillero celda;
    private PlazaCentral plaza;
    private int fila,columna;
    

    public PlazaCentralTest()  throws tamanioDeMapaInvalido, casilleroInvalido
    {
    	fila = 4;
    	columna = 6;
        this.mapa = new Mapa(15,15);
        this.celda = mapa.obtenerCasillero(fila, columna);
        this.caja = mapa.asignarCajaACasillero(celda);
        this.plaza = new PlazaCentral(this.celda,mapa);
    }

    
    @Test
    public void seCreaEnLaPrimerCaja() throws casilleroInvalido
    {
    	this.plaza =  new PlazaCentral(this.caja, this.mapa);
        Assert.assertEquals(this.caja, this.plaza.obtenerEspacioOcupado());

    }

    @Test
    public void seCreaConCasilleroComoParametro() throws casilleroInvalido
    {
    	this.plaza = new PlazaCentral (this.celda,this.mapa);
        Assert.assertEquals(caja, plaza.obtenerEspacioOcupado());

    }
    // danio

    //Arreglar
    
    @Test
    public void seCreaAldeanoConRallyLibre() throws casilleroInvalido, casilleroLleno
    {

    	plaza =  new PlazaCentral(this.celda,this.mapa);
    	plaza.crearAldeano();
    	celda = plaza.getPuntoRally();
    	ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
    	
    	Assert.assertEquals(aldeanos.get(0) , celda.obtenerElemento());

    	
    }

    //Arreglar
    
   @Test
   public void seReparaEdificio() throws casilleroInvalido, casilleroLleno
   {
   	    plaza = new PlazaCentral (this.celda,this.mapa);
   	    plaza.recibirDanio(40);
   	    plaza.crearAldeano();
	    ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
	    aldeanos.get(0).repararEdificio(plaza);
	    Assert.assertEquals(plaza.getVida(), 450-40+25);
  
   }
   
   @Test
   public void seRecibeDanio() throws casilleroInvalido
   {
       plaza = new PlazaCentral (this.celda,this.mapa);
       plaza.recibirDanio(60);
   	
       Assert.assertEquals(plaza.getVida(), 450-60);

   }
   
   @Test 
   public void seCreaEnCajaYElMapaLaReconoceEnCadaCasillero(){
	   
   		this.plaza =  new PlazaCentral(this.caja, this.mapa);
   		Assert.assertEquals(celda.obtenerElemento(), plaza);
   		
   		this.celda = mapa.obtenerCasillero(fila+1, columna);
   		Assert.assertEquals(celda.obtenerElemento(), plaza);
   		
   		this.celda = mapa.obtenerCasillero(fila+1 , columna+1);
   		Assert.assertEquals(celda.obtenerElemento(), plaza);
   		
   		this.celda = mapa.obtenerCasillero(fila, columna+1);
   		Assert.assertEquals(celda.obtenerElemento(), plaza);
   	
   }
   
   @Test(expected = casilleroLleno.class)
   public void intentarCrearAldeanoConRallyPointOcupadoLanzaExcepcion() throws casilleroLleno,casilleroInvalido
   {
       plaza.crearAldeano();
       plaza.crearAldeano();

       
   }
}
