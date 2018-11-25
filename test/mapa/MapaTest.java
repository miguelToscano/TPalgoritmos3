package mapa;

import edificios.*;
import mapa.excepcionesMapa.*;
import org.junit.Assert;
import org.junit.Test;

import unidades.Aldeano;
import unidades.Espadachin;


import static org.junit.Assert.*;

public class MapaTest {

    private Mapa mapa;


    public MapaTest() throws tamanioDeMapaInvalido {
        mapa = new Mapa(15, 15);
    }

    @Test
    public void seCreaConTamanioPasadoPorParametros() throws tamanioDeMapaInvalido {
        try {
            Mapa mapaPrueba = new Mapa(20, 20);
        } catch (tamanioDeMapaInvalido e) {
            fail("La prueba no paso. El tamanio del mapa no es valido");
        }
        Mapa mapaPrueba = new Mapa(20, 20);
        Assert.assertEquals(400, mapaPrueba.obtenerTamanio());
    }

    @Test(expected = tamanioDeMapaInvalido.class)
    public void crearMapaConTamanioInvalidoLanzaError() throws tamanioDeMapaInvalido {
        new Mapa(1, 15);
    }

    @Test
    public void seCreaConCasillerosVacios() {
        for (int i = 0; i < mapa.obtenerTamanioFilas(); i++) {
            for (int j = 0; j < mapa.obtenerTamanioColumnas(); j++) {
                Assert.assertTrue(mapa.obtenerCasillero(i, j).estaLibre());
            }
        }
    }


    @Test
    public void seColocaAldeanoEnPrimerCasillero() throws casilleroEstaOcupado
    {
        Aldeano aldeano = new Aldeano(0, 0, mapa);
        Assert.assertEquals(aldeano, mapa.obtenerElemento(0, 0));
    }

    @Test(expected = casilleroEstaOcupado.class)
    public void colocarAldeanoEnCasilleroOcupadoLanzaExcepcion() throws casilleroEstaOcupado
    {
        Aldeano unAldeano = new Aldeano(5,5,mapa);
        Aldeano otroAldeano = new Aldeano(5,5,mapa);
    }

    @Test
    public void seColocaEspadachinEnCasillero() throws casilleroEstaOcupado
    {
        Casillero casillero = mapa.obtenerCasillero(3,3);
        Espadachin espadachin = new Espadachin(casillero);
        Assert.assertEquals(espadachin, mapa.obtenerElemento(3, 3));
    }

    @Test(expected = casilleroEstaOcupado.class)
    public void colocarEspadachinEnCasilleroOcupadoLanzaExcepcion() throws casilleroEstaOcupado
    {
        Casillero casillero = mapa.obtenerCasillero(4,3);
        Espadachin unEspadachin = new Espadachin(casillero);
        Espadachin otroEspadachin = new Espadachin(casillero);
    }

    @Test
    public void seColocaPlazaCentralEnCajaDadaPorCasillero() throws cajaEstaOcupada, casilleroInvalido
    {
        Casillero casillero = mapa.obtenerCasillero(0,0);
        Caja caja = mapa.obtenerCajas().get(0);
        PlazaCentral plaza = new PlazaCentral(casillero,mapa);
        for(int i=0;i<mapa.obtenerTamanioCajas();i++)
        {
            Assert.assertEquals(caja.obtenerElemento(i),plaza);
        }

    }

    @Test(expected = cajaEstaOcupada.class)
    public void colocarCuartelEnCajaOcupadaLanzaExcepcion() throws casilleroInvalido, cajaEstaOcupada
    {
        Casillero casillero = mapa.obtenerCasillero(5,5);
        Cuartel unCuartel = new Cuartel(casillero,mapa);
        Cuartel otroCuartel = new Cuartel(casillero,mapa);
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
    public void obtenerTercerCajaAPartirDeTercerCasillero() throws casilleroInvalido
    {

        Caja tercerCaja = mapa.obtenerCajas().get(2);
        Casillero tercerCasillero = mapa.obtenerCasillero(0,2);
        try{mapa.asignarCajaACasillero(tercerCasillero);}
        catch(casilleroInvalido c)
        {
            fail("La prueba no paso. El casillero elegido no es valido");
        }

        Caja cajaRetornada = mapa.asignarCajaACasillero(tercerCasillero);
        Assert.assertEquals(cajaRetornada,tercerCaja);
    }

    @Test(expected = casilleroInvalido.class)
    public void obtenerCajaAPartirDeCasilleroLimiteLanzaExcepcion() throws casilleroInvalido
    {
        Casillero casilleroLimite = mapa.obtenerCasillero(mapa.obtenerTamanioFilas()-1,mapa.obtenerTamanioColumnas()-1);
        mapa.asignarCajaACasillero(casilleroLimite);
    }


}