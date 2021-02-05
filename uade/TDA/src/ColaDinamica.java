interface ColaDinamicaTDA {
	public void Inicializar();

	public void Acolar(int x);

	public void Desacolar();

	public boolean ColaVacia();

	public int Primero();
}

public class ColaDinamica implements ColaDinamicaTDA {
	class NodoSimple {
		int clave;
		NodoSimple sgt;
	}

	NodoSimple primero;
	NodoSimple ultimo;

	public void Inicializar() {
		primero = null;
		ultimo = null;
	}

	public void Acolar(int x) {
		NodoSimple nodo = new NodoSimple();
		nodo.clave = x;

		if (primero == null) // Cola Vacia
		{
			primero = nodo;
			ultimo = nodo;
		} else {
			ultimo.sgt = nodo;
			ultimo = nodo;
		}
	}

	public void Desacolar() {
		primero = primero.sgt;

		if (primero == null) // Cola Vacia
			ultimo = null;
	}

	public boolean ColaVacia() {
		return primero == null;
	}

	public int Primero() {
		return primero.clave;
	}
}
