package mapa;

import org.junit.Assert;
import excepciones.*;
import org.junit.Test;

import unidades.Aldeano;

import static org.junit.Assert.*;

public class MapaTest {

    private Mapa mapa;


    public MapaTest ()
    {
        mapa = new Mapa();

    }

    @Test
    public void seCreaConCasillerosVacios()
    {

        for(int i=0;i<mapa.obtenerTamanioFilas();i++)
        {
            for(int j=0;j<mapa.obtenerTamanioColumnas();j++)
            {
                Assert.assertTrue(mapa.obtenerCasillero(i,j).estaLibre());
            }
        }
    }


    @Test
    public void seCambiaContenidoDePrimerCasillero() throws CasilleroLleno
    {
        Aldeano aldeano = new Aldeano(0,0,mapa);
        Assert.assertEquals(aldeano,mapa.obtenerElemento(0,0));

    }

    @Test
    public void obtenerSegundaFilaDevuelveLaSegundaFilaDelMapa()
    {
        Fila segundaFila = mapa.obtenerFilas().get(1);

        for(int i=0;i<mapa.obtenerTamanioColumnas();i++)
        {
            Assert.assertEquals(mapa.obtenerCasillero(1,i),segundaFila.obtenerCasillero(i));
        }
    }

    @Test
    public void obtenerPrimerColumnaDevuelveLaPrimerColumnaDelMapa()
    {
        Columna primerColumna = mapa.obtenerColumnas().get(0);

        for(int i=0;i<mapa.obtenerTamanioFilas();i++)
        {
            Assert.assertEquals(mapa.obtenerCasillero(i,0),primerColumna.obtenerCasillero(i));
        }
    }

    @Test
    public void obtenerPrimerCajaDevuelveLaPrimerCajaDelMapa()
    {
        Caja primerCaja = mapa.obtenerCajas().get(0);
        int k=0;

        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                Assert.assertEquals(mapa.obtenerCasillero(i,j), primerCaja.obtenerCasillero(k));
                k++;
            }
        }
    }

    @Test
    public void obtenerCajaAPartirDeTercerCasilleroDevuelveTercerCaja() throws casilleroInvalido
    {
        Caja tercerCaja = mapa.obtenerCajas().get(4);
        Casillero tercerCasillero = mapa.obtenerCasillero(1,0);
        try{mapa.asignarCajaACasillero(tercerCasillero);}
        catch(casilleroInvalido c)
        {
            System.out.println("La prueba no paso. El casillero elegido no es valido");
            //hacer fallar test manualmente
        }

        Caja cajaRetornada = mapa.asignarCajaACasillero(tercerCasillero);
        Assert.assertEquals(cajaRetornada,tercerCaja);
    }

    @Test(expected = casilleroInvalido.class)
    public void obtenerCajaAPartirDeCasilleroLimiteLanzaExcepcion() throws casilleroInvalido
    {
        Casillero casilleroLimite = mapa.obtenerCasillero(4,4);
        mapa.asignarCajaACasillero(casilleroLimite);
    }

}