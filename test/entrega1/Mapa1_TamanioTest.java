package entrega1;


import org.junit.Assert;
import org.junit.Test;

import mapa.Mapa;
import mapa.excepcionesMapa.tamanioDeMapaInvalido;

public class Mapa1_TamanioTest {
	
    @Test
    public void seCreaConTamanioPasadoPorParametros() throws tamanioDeMapaInvalido {
    	
    	Mapa mapaPrueba= new Mapa(20, 20);

        Assert.assertEquals(400, mapaPrueba.obtenerTamanio());
    }

//    @Test(expected = tamanioDeMapaInvalido.class)
//    public void crearMapaConTamanioInvalidoLanzaError() throws tamanioDeMapaInvalido {
//        new Mapa(1, 15);
//    }
    
    @Test
    public void seCreaConCasillerosVacios() throws tamanioDeMapaInvalido {
    	
    	Mapa mapaPrueba= new Mapa(20, 20);
        for (int i = 0; i < mapaPrueba.obtenerTamanioFilas(); i++) {
            for (int j = 0; j < mapaPrueba.obtenerTamanioColumnas(); j++) {
                Assert.assertTrue(mapaPrueba.obtenerCasillero(i, j).estaLibre());
            }
        }
    }

}
