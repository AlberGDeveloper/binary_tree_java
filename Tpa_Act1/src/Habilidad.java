public class Habilidad {
	private String nombre;
	private String tipo;
	private int puntosAtaque;
	private int puntosDefensa;
	private int puntosSalud;

	public Habilidad(String nombre, String tipo, int puntosAtaque, int puntosDefensa, int puntosSalud) {

		this.nombre = nombre;
		this.tipo = tipo;
		this.puntosSalud = 100;
		generarAtaque();
		generarDefensa();
	}

	public void generarAtaque() {
		this.puntosAtaque = (int) (Math.random() * 15) + 3; // Genera puntos de ataque entre 3 y 15
	}

	public void generarDefensa() {
		this.puntosDefensa = (int) (Math.random() * 15) + 1; // Genera puntos de defensa entre 1 y 15
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPuntosAtaque() {
		return puntosAtaque;
	}

	public void setPuntosAtaque(int puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	public int getPuntosDefensa() {
		return puntosDefensa;
	}

	public void setPuntosDefensa(int puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}

	public int getPuntosSalud() {
		return puntosSalud;
	}

	public void setPuntosSalud(int puntosSalud) {
		this.puntosSalud = puntosSalud;
	}

	@Override
	public String toString() {
		return nombre + " (" + tipo + "): Ataque - " + puntosAtaque + ", Defensa - " + puntosDefensa + ", Salud - "
				+ puntosSalud;
	}
}
