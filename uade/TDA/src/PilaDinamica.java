interface PilaDinamicaTDA 
{
	void Inicializar();
	void Desapilar();
	void Apilar(int key);
	int Tope();
	boolean PilaVacia();
}


public class PilaDinamica implements PilaDinamicaTDA
{
	class NodoSimple
	{
		int clave;
		NodoSimple sgt;
	}
	
	NodoSimple tope;
	
	public void Inicializar()
	{
		tope = null;
	}
	
	public int Tope()
	{
		return tope.clave;
	}
	
	public void Apilar(int key)
	{
		NodoSimple nodo = new NodoSimple();
		nodo.clave = key;
		
		if (tope == null)
			tope = nodo;
		else
		{
			nodo.sgt = tope;
			tope = nodo;
		}
	}
	
	public void Desapilar()
	{
		if (PilaVacia())
			return;
		
		tope = tope.sgt;
	}
	
	public boolean PilaVacia()
	{
		return tope == null;
	}
}
