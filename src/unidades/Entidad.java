package unidades;

import mapa.Mapeable;
import mapa.Casillero;

public abstract class Entidad
{
    protected int vida;
	protected int costo;
	protected boolean construible;
	protected int turnosConstruccion;

    public Entidad()
    {
        //this.vida=0;
        //this.costo=0;
        this.construible=true;//?
        //this.turnosConstruccion = 3;
    }
	 
    public int getVida()
    {
		return this.vida;
	}
	
	public int getCosto()
    {
		return this.costo;
	}
	
	public int getTurnosConstruccion()
    {
		return this.turnosConstruccion;
	}
 
	public boolean estaVivo ()
    {
		return (this.vida > 0 );
	}
	
	public abstract void ubicar(Mapeable mapeable);
 }