package unidades;

public class ArmaDeAsedio extends Militar {

	private boolean montada;

	public ArmaDeAsedio()
	{
		this.montada = false;
		this.vida = 150;
		this.radioAtaque = 5;
		this.danioAEdificios = 75;

	}
	
	/*public ArmaDeAsedio (int[] posicion) {
			
			this.espacioOcupado = posicion;
			this.danioAtaque= 0; // el +75 de bonus  en clase ataque
			
			cantidad += 1;
		}
		*/

	public void atacar()
    {
        System.out.println("Ataca a una unidad o edificio");
    }

    public void desmontar()
    {
        montada = false;
    }
    
    public void montar()
    {
        montada = true;
    }

		
}

