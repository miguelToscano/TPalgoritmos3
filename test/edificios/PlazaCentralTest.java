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
    private PlazaCentral plaza;
    

    public PlazaCentralTest()  throws casilleroInvalido
    {

        this.mapa = new Mapa(16, 16);
        this.celda = mapa.obtenerCasillero(0, 0);
        this.caja = mapa.asignarCajaACasillero(celda);
    }
    
    @Test
    public void seCreaEnLaPrimerCaja()
    {
    	this.plaza =  new PlazaCentral(this.caja);
        Assert.assertEquals(this.caja, this.plaza.obtenerEspacioOcupado());

    }

    @Test
    public void seCreaConCasilleroComoParametro()
    {
    	this.plaza = new PlazaCentral (caja);
        Assert.assertEquals(caja, plaza.obtenerEspacioOcupado());

    }
    // danio
    @Test
    public void seCreaAldeanoConRallyLibre()
    {

    	plaza =  new PlazaCentral(caja);
    	plaza.crearAldeano();
    	celda = plaza.getPuntoRally();
    	ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
    	
    	Assert.assertEquals(aldeanos.get(0) , celda.obtenerElemento());

    	
    }
   @Test
   public void seReparaEdificio()
   {
   	    plaza = new PlazaCentral (this.caja);
   	    plaza.recibirDanio(40);
   	    plaza.crearAldeano();
	    ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
	    aldeanos.get(0).repararEdificio(plaza);
	    Assert.assertEquals(plaza.getVida(), 450-40+25);
	
  
   }
   
   @Test
   public void seRecibeDanio()
   {
       plaza = new PlazaCentral (this.caja);
       plaza.recibirDanio(60);
   	
       Assert.assertEquals(plaza.getVida(), 450-60);

   }
}
