package edificios;
import java.util.ArrayList;

import junit.framework.Assert;
import mapa.*;
import unidades.Aldeano;

import java.util.ArrayList;

import org.junit.Test;

public class PlazaCentralTest {
	
	private Caja caja;
    private Mapa mapa;
    private Casillero celda;
    private int fila;
    private int columna;
    private PlazaCentral plaza;
    

    public PlazaCentralTest() {
    	
    	mapa = new Mapa(16,16);
    	celda = mapa.obtenerCasillero(fila, columna);
    	caja = mapa.asignarCajaACasillero(celda);
    	
    	

  }
    
    @Test
    public void seCreaConCajaComoParametro () {
    	
    	plaza =  new PlazaCentral(caja);

        Assert.assertEquals(caja, plaza.obtenerEspacioOcupado());

    }

    @Test
    public void seCreaConCasilleroComoParametro() {
    	plaza = new PlazaCentral (celda,mapa);
        Assert.assertEquals(caja, plaza.obtenerEspacioOcupado());

    }
    // danio
    @Test
    public void seCreaAldeanoConRallyLibre() {
    	
    	plaza =  new PlazaCentral(caja);
    	plaza.crearAldeano();
    	celda = plaza.getPuntoRally();
    	ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
    	
    	Assert.assertEquals(aldeanos.get(0) , celda.obtenerElemento());

    	
    }
   @Test
   public void seReparaEdificio() {
   	plaza = new PlazaCentral (celda,mapa);
   	plaza.recibirDanio(40);
   	plaza.crearAldeano();
	ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
	aldeanos.get(0).repararEdificio(plaza);
	Assert.assertEquals(plaza.getVida(), 450-40+25);
	
  
   }
   
   @Test
   public void seReparaEdificio() {
   	plaza = new PlazaCentral (celda,mapa);
   	plaza.recibirDanio(60);
   	
	Assert.assertEquals(plaza.getVida(), 450-60);
	
  
   }
}
