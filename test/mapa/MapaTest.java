package mapa;

import org.junit.Assert;
import org.junit.Test;

import unidades.Aldeano;

import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void seCreaConCasillerosVacios()
    {
        Mapa mapa = new Mapa();
        for(int i=0;i<mapa.obtenerTamanioFilas();i++)
        {
            for(int j=0;j<mapa.obtenerTamanioColumnas();j++)
            {
                Assert.assertTrue(mapa.obtenerCasillero(i,j).estaLibre());
            }
        }
    }

    @Test
    public void seCambiaContenidoDePrimerCasillero()
    {
        Mapa mapa = new Mapa();
        Aldeano aldeano = new Aldeano();
        mapa.cambiarContenidoDeCasillero(0,0,aldeano);
        Assert.assertEquals(aldeano,mapa.obtenerElemento(0,0));

    }

    @Test
    public void obtenerSegundaFilaDevuelveLaSegundaFilaDelMapa()
    {
        Mapa mapa = new Mapa();
        Fila segundaFila = mapa.obtenerFilas().get(1);

        for(int i=0;i<mapa.obtenerTamanioColumnas();i++)
        {
            Assert.assertEquals(mapa.obtenerCasillero(1,i),segundaFila.obtenerCasillero(i));
        }
    }

    @Test
    public void obtenerPrimerColumnaDevuelveLaPrimerColumnaDelMapa()
    {
        Mapa mapa = new Mapa();
        Columna primerColumna = mapa.obtenerColumnas().get(0);

        for(int i=0;i<mapa.obtenerTamanioFilas();i++)
        {
            Assert.assertEquals(mapa.obtenerCasillero(i,0),primerColumna.obtenerCasillero(i));
        }
    }

    @Test
    public void obtenerPrimerCajaDevuelveLaPrimerCajaDelMapa()
    {
        Mapa mapa = new Mapa();
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
}