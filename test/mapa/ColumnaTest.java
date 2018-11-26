package mapa;

import juego.*;
import excepciones.*;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;
import org.junit.Assert;
import org.junit.Test;

import mapa.excepcionesMapa.casilleroEstaOcupado;
import unidades.Aldeano;

public class ColumnaTest
{
    private Mapa mapa;
    public Jugador jugador;

    public ColumnaTest() throws tamanioDeMapaInvalido
    {
        mapa = new Mapa(15,15);
        jugador = new Jugador();
    }

    @Test
    public void estaLibreDevuelveTrueParaSegundaColumnaDeMapaVacio()
    {
        Columna columna = mapa.obtenerColumnas().get(1);
        Assert.assertTrue(columna.estaLibre());
    }

    @Test
    public void estaLibreDevuelveFalseParaColumnaOcupadaDelMapa() throws casilleroEstaOcupado, superaLimitePoblacional
    {
        Aldeano aldeano = new Aldeano(0,1,mapa, jugador);
        Columna columna = mapa.obtenerColumnas().get(1);
        Assert.assertFalse(columna.estaLibre());

    }
}