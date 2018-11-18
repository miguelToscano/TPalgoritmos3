package unidades;

public class Arquero extends Militar
{
	public Arquero()
	{
		this.danioAEdificios = 10;
		this.danioAUnidades = 15;
		this.radioAtaque = 3;
		this.vida = 75;
		this.costo = 75;
	}
	
	/*public Arquero (int[] posicion) {
			
			this.espacioOcupado = posicion;
			this.danioAtaque= 15; // el -5 de bonus  en clase ataque
			
			cantidad += 1;
		}
		*/
		public void atacar()
		{
			System.out.println("Ataca a una unidad o edificio");
		}

}
