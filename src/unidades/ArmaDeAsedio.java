package unidades;

public class ArmaDeAsedio extends Militar {
	
	protected int costo = 200;
	private boolean montada =  true;
	
	public ArmaDeAsedio (int[] posicion) {
			
			this.espacioOcupado = posicion;
			this.danioAtaque= 0; // el +75 de bonus  en clase ataque
			this.radioAtaque = 5;
			this.vida = 150;
			
			cantidad += 1;
		}
		
		public void atacar() {
			System.out.println("Ataca a una unidad o edificio");
		}
		
		public void desmontar() {
			montada = false;
		}
		
		public void montar() {
			montada = true;
		}
		
		
}

