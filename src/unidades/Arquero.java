package unidades;

public class Arquero extends Militar {
	
	// override costos
	
	protected int costo = 75;
	
	/*public Arquero (int[] posicion) {
			
			this.espacioOcupado = posicion;
			this.danioAtaque= 15; // el -5 de bonus  en clase ataque
			this.radioAtaque = 3;
			this.vida = 75;
			
			cantidad += 1;
		}
		*/
		public void atacar() {
			System.out.println("Ataca a una unidad o edificio");
		}

}
