import java.util.ArrayList;
import java.util.List;

public class ArbolHabilidadesSecuencial<T extends Habilidad> {
	private T[] tree;

	@SuppressWarnings("unchecked")
	public ArbolHabilidadesSecuencial(T raiz) {
		int depth = 4;
		int capacity = (int) Math.pow(2, depth) - 1; 
		this.tree = (T[]) new Habilidad[capacity];
		this.tree[0] = raiz; 
	}

	public T getRaiz() {
		return tree[0]; 
	}


	public void agregarHabilidad(T padre, T habilidadIzquierda, T habilidadDerecha) {
		int indicePadre = -1;
		if (padre != null) {
			indicePadre = buscarHabilidad(padre);
			if (indicePadre == -1) {
				System.out.println("Padre no encontrado.");
				return;
			}
		} else
			indicePadre = 0;

		int indiceIzquierdo = 2 * indicePadre + 1;
		int indiceDerecho = 2 * indicePadre + 2;
		if (indiceIzquierdo < tree.length)
			tree[indiceIzquierdo] = habilidadIzquierda;
		if (indiceDerecho < tree.length)
			tree[indiceDerecho] = habilidadDerecha;
	}

	private int buscarHabilidad(T padre) {
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null && tree[i].equals(padre)) {
				return i;
			}
		}
		return -1; 
	}

	public List<T> getHabilidadesDeAtaque() {
	    List<T> habilidades = new ArrayList<>();
	    for (int i = 1; i < tree.length; i++) {
	        if (tree[i] != null && tree[i].getTipo().equals("Ataque especifico de una rama de talentos")) {
	            habilidades.add(tree[i]);
	        }
	    }
	    return habilidades;
	}

	public List<Habilidad> getHabilidadesDeDefensa() {
	    List<Habilidad> habilidades = new ArrayList<>();
	    for (int i = 0; i < tree.length; i++) {
	        if (tree[i] != null && tree[i].getTipo().equals("Defensa especifica de una rama de talentos")) {
	            habilidades.add(tree[i]);
	        }
	    }
	    return habilidades;
	}




	public void imprimirArbol2() {
		int itemsLevel = 1;
		int index = 0;

		while (index < tree.length) {
			for (int i = 0; i < itemsLevel && index < tree.length; i++) {
				System.out.print((tree[index] == null ? "NULL" : tree[index].getNombre()) + " ");
				index++;
			}
			System.out.println();
			itemsLevel *= 2;
		}
		System.out.println("_____________________________________________________________" + "\n");
	}

	// Método de impresión un poco "tramposo" ya que no es escalable a árboles con
	// más profundidad
	public void imprimirArbol() {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------"
						+ tree[0].getNombre()
						+ "-------------------------------------------------------------------------------------------------------------");
		System.out.print("------------------------------------------" + tree[1].getNombre()
				+ "------------------------------------------------------------------------------------------------------------------------------"
				+ tree[2].getNombre() + "------------------------------------------" + "\n");
		System.out.print(
				"------------" + tree[3].getNombre() + "------------------------------------------------------------"
						+ tree[4].getNombre() + "-----------------------------------------------------------");
		System.out.print(tree[5] == null ? "NULL------" + "------------"
				: tree[5].getNombre() + "------------------------------------------------------------");
		System.out.print(tree[6] == null ? "NULL------" : tree[6].getNombre() + "------------" + "\n");
		System.out.print(tree[7] == null ? "NULL------" : tree[7].getNombre() + "------");
		System.out.print(tree[8] == null ? "NULL------" : tree[8].getNombre() + "------------------------");
		System.out.print(tree[9] == null ? "NULL------" : tree[9].getNombre() + "------");
		System.out.print(tree[10] == null ? "NULL------" : tree[10].getNombre() + "--------------------------------");
		System.out.print(tree[11] == null ? "NULL------" : tree[11].getNombre() + "-------");
		System.out.print(tree[12] == null ? "NULL------" : tree[12].getNombre() + "-----------------------------");
		System.out.print(tree[13] == null ? "NULL------" : tree[13].getNombre() + "-------");
		System.out.print(tree[14] == null ? "NULL------" : tree[14].getNombre() + "" + "\n");
		System.out.println("");
	}

}
