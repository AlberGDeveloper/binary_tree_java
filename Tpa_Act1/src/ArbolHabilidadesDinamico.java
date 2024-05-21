import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArbolHabilidadesDinamico<T extends Habilidad> {
	private T raiz;
	private Nodo<T> nodoRaiz;

	public ArbolHabilidadesDinamico(T raiz) {

		this.nodoRaiz = new Nodo<>(raiz);
		this.raiz = raiz;
	}

	public class Nodo<T extends Habilidad> {
		T habilidad;
		Nodo<T> izquierdo;
		Nodo<T> derecho;

		public Nodo(T habilidad) {
			this.habilidad = habilidad;
			this.izquierdo = null;
			this.derecho = null;
		}
	}

	// Método para agregar habilidades en el árbol. Este es un ejemplo básico y debe
	// ser expandido.
	// Aquí deberías implementar la lógica para encontrar al padre y agregar las
	// habilidades hijas.
	public void agregarHabilidad(T padre, T habilidadIzquierda, T habilidadDerecha) {
		if (padre == null) {
			System.out.println("No se puede agregar una habilidad a un nodo nulo.");
			return;
		}

		Nodo<T> nodoPadre = buscarNodo(padre, nodoRaiz);
		if (nodoPadre != null) {
			if (habilidadIzquierda != null) {
				nodoPadre.izquierdo = new Nodo<>(habilidadIzquierda);
			}
			if (habilidadDerecha != null) {
				nodoPadre.derecho = new Nodo<>(habilidadDerecha);
			}
		} else {
			System.out.println("No se encontró el nodo padre con el valor especificado.");
		}
	}

	private Nodo<T> buscarNodo(T habilidad, Nodo<T> nodoActual) {
		if (nodoActual == null)
			return null;
		if (nodoActual.habilidad.equals(habilidad))
			return nodoActual;

		Nodo<T> nodoIzquierdo = buscarNodo(habilidad, nodoActual.izquierdo);
		if (nodoIzquierdo != null)
			return nodoIzquierdo;

		return buscarNodo(habilidad, nodoActual.derecho);
	}

	public T getRaiz() {
		return raiz; // Retorna la raíz del árbol
	}

	/*
	 * Métodos de búsqueda según el orden de recorrido: IRD (Inorden - Izquierda,
	 * Raíz, Derecha): Visita primero el subárbol izquierdo, luego el nodo actual, y
	 * finalmente el subárbol derecho. RID (Preorden - Raíz, Izquierda, Derecha):
	 * Visita primero el nodo actual, luego el subárbol izquierdo y finalmente el
	 * subárbol derecho. IDR (Postorden - Izquierda, Derecha, Raíz): Visita primero
	 * el subárbol izquierdo, luego el subárbol derecho, y finalmente el nodo
	 * actual. Anchura: Visita los nodos nivel por nivel, de izquierda a derecha.
	 */

	// Método para buscar una habilidad por nombre.
	public T buscarHabilidadIRD(Nodo<T> nodo, String nombre) {
		if (nodo == null)
			return null;
		System.out.println("Buscando en RID: " + nodo.habilidad.getNombre());
		T encontrado = buscarHabilidadIRD(nodo.izquierdo, nombre);
		if (encontrado != null)
			return encontrado;
		if (nodo.habilidad.getNombre().equals(nombre))
			return nodo.habilidad;
		return buscarHabilidadIRD(nodo.derecho, nombre);

	}

	public T buscarHabilidadRID(Nodo<T> nodo, String nombre) {
		if (nodo == null)
			return null;
		if (nodo.habilidad.getNombre().equals(nombre))
			return nodo.habilidad;
		T encontrado = buscarHabilidadRID(nodo.izquierdo, nombre);
		if (encontrado != null)
			return encontrado;
		return buscarHabilidadRID(nodo.derecho, nombre);
	}

	public T buscarHabilidadIDR(Nodo<T> nodo, String nombre) {
		if (nodo == null)
			return null;
		T encontrado = buscarHabilidadIDR(nodo.izquierdo, nombre);
		if (encontrado != null)
			return encontrado;
		encontrado = buscarHabilidadIDR(nodo.derecho, nombre);
		if (encontrado != null)
			return encontrado;
		if (nodo.habilidad.getNombre().equals(nombre))
			return nodo.habilidad;
		return null;
	}

	public T buscarHabilidadAnchura(String nombre) {
		if (nodoRaiz == null)
			return null;
		Queue<Nodo<T>> cola = new LinkedList<>();
		cola.add(nodoRaiz);

		while (!cola.isEmpty()) {
			Nodo<T> actual = cola.poll();
			if (actual.habilidad.getNombre().equals(nombre)) {
				return actual.habilidad;
			}

			if (actual.izquierdo != null)
				cola.add(actual.izquierdo);
			if (actual.derecho != null)
				cola.add(actual.derecho);
		}
		return null;
	}

	public List<Habilidad> getHabilidadesDeAtaque() {
		List<Habilidad> habilidades = new ArrayList<>();
		if (nodoRaiz != null && nodoRaiz.izquierdo != null) {
			agregarHabilidadesEspecificas(nodoRaiz.izquierdo, (List<T>) habilidades,
					"Ataque especifico de una rama de talentos");
		}
		return habilidades;
	}

	public List<Habilidad> getHabilidadesDeDefensa() {
		List<Habilidad> habilidades = new ArrayList<>();
		if (nodoRaiz != null && nodoRaiz.derecho != null) {
			agregarHabilidadesEspecificas(nodoRaiz.derecho, (List<T>) habilidades,
					"Defensa especifica de una rama de talentos");
		}
		return habilidades;
	}

	private void agregarHabilidadesEspecificas(Nodo<T> nodo, List<T> lista, String tipo) {
		if (nodo != null) {
			if (nodo.habilidad.getTipo().equals(tipo)) {
				lista.add(nodo.habilidad);
			}
			agregarHabilidadesEspecificas(nodo.izquierdo, lista, tipo);
			agregarHabilidadesEspecificas(nodo.derecho, lista, tipo);
		}
	}

	public void imprimirArbol() {
		if (nodoRaiz == null) {
			System.out.println("El árbol está vacío.");
			return;
		}
		Queue<Nodo<T>> cola = new LinkedList<>();
		cola.add(nodoRaiz);
		int nivel = 0;
		while (!cola.isEmpty()) {
			int nivelSize = cola.size();
			int espacio = (int) Math.pow(2, (4 - nivel)) * 10;
			for (int i = 0; i < nivelSize; i++) {
				Nodo<T> actual = cola.poll();
				System.out.print("-".repeat(espacio) + actual.habilidad.getNombre() + "-".repeat(espacio));
				if (actual.izquierdo != null)
					cola.add(actual.izquierdo);
				if (actual.derecho != null)
					cola.add(actual.derecho);
			}
			System.out.println();
			nivel++;
		}
	}

}