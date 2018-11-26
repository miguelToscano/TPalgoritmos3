package juego;
import edificios.*;
import unidades.*;
import mapa.Fila;

import java.util.ArrayList;

public class Jugador
{
    private Castillo castillo;
    private ArrayList<PlazaCentral> plazas;
    private ArrayList<Cuartel> cuarteles;
    private ArrayList<Aldeano> aldeanos;
    private ArrayList<ArmaDeAsedio> armas;
    private ArrayList<Arquero> arqueros;
    private ArrayList<Espadachin> espadachines;

    public void asignarCastillo(Castillo castillo)
    {
        this.castillo = castillo;
    }

    public Castillo getCastillo()
    {
        return this.castillo;
    }
}
