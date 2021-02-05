import java.util.Random;

interface ConjuntoDinamicoTDA
{
	void Inicializar();
	void Agregar(int x);
	int Elegir();
	boolean ConjuntoVacio();
	void Sacar(int x);
	boolean Pertenece(int x);
}

public class ConjuntoDinamico implements ConjuntoDinamicoTDA
{
	class NodoSimple
	{
		public int clave;
		public NodoSimple sgt;
	}
	
	NodoSimple primero;
	NodoSimple ultimo;
	int cant;
	
	public void Inicializar()
	{
		primero = null;
		ultimo = null;
		cant = 0;
	}
	
	public void Agregar(int x)
	{
		NodoSimple nodo = new NodoSimple();
		nodo.clave = x;
		
		if (ConjuntoVacio())
		{
			primero = nodo;
			ultimo = nodo;
		}
		else
		{
			ultimo.sgt = nodo;
			ultimo = nodo;
		}
		
		cant++;
	}
	
	public int Elegir()
	{
		Random gen = new Random();
		int randomIdx = gen.nextInt(cant);
		
		int i = 0;
		
		NodoSimple cursor = primero;
		
		while (cursor != null && i < randomIdx)
		{
			i++;
			cursor = cursor.sgt;
		}
			
		
		return cursor.clave;
	}
	
	public boolean Pertenece(int x)
	{
		NodoSimple cursor = primero;
		
		while (cursor != null && cursor.clave != x)
			cursor = cursor.sgt;
		
		return cursor != null;
	}
	
	public void Sacar(int x)
	{
		if (ConjuntoVacio())
			return;
		
		NodoSimple cursor = primero;
		
		if (cursor.clave == x)
		{
			primero = primero.sgt;
			
			if (primero == null)
				ultimo = null;
			
			cant--;
		}
		else
		{
			while (cursor.sgt != null && cursor.sgt.clave != x)
				cursor = cursor.sgt;
			
			// Busqueda Fallida
			if (cursor.sgt == null && cursor.clave != x)
				return;
			
			NodoSimple aux = cursor.sgt.sgt;
			cursor.sgt = null;
			cursor.sgt = aux;
			
			if (cursor.sgt == null) // Final de la lista
				ultimo = cursor;
			
			cant--;
		}		
	}
	
	public boolean ConjuntoVacio()
	{
		return primero == null;
	}
}
