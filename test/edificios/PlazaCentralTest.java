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

        this.mapa = new Mapa();
        this.celda = mapa.obtenerCasillero(0, 2);
        this.caja = mapa.asignarCajaACasillero(celda);
        this.plaza = new PlazaCentral(this.celda,mapa);
    }

    
    @Test
    public void seCreaEnLaPrimerCaja() throws casilleroInvalido
    {
    	this.plaza =  new PlazaCentral(this.celda,this.mapa);
        Assert.assertEquals(this.caja, this.plaza.obtenerEspacioOcupado());

    }

    @Test
    public void seCreaConCasilleroComoParametro() throws casilleroInvalido
    {
    	this.plaza = new PlazaCentral (this.celda,this.mapa);
        Assert.assertEquals(caja, plaza.obtenerEspacioOcupado());

    }
    // danio
    @Test
    public void seCreaAldeanoConRallyLibre() throws casilleroInvalido
    {

    	plaza =  new PlazaCentral(this.celda,this.mapa);
    	plaza.crearAldeano();
    	celda = plaza.getPuntoRally();
    	ArrayList<Aldeano> aldeanos = plaza.getAldeanos();
    	
    	Assert.assertEquals(aldeanos.get(0) , celda.obtenerElemento());

    	
    }
   @Test
   public void seReparaEdificio() throws casilleroInvalido
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
}
