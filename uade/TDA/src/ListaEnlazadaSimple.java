interface ListaEnlazadaSimpleTDA
{
	void Inicializar();
	void AgregarEnInicio(int x);
	void AgregarEnFin(int x);
	void Eliminar(int x);
	int ObtenerElemento(int x);
	boolean ListaVacia();
	int VerInicio();
	int VerFin();
}

public class ListaEnlazadaSimple implements ListaEnlazadaSimpleTDA
{
	class NodoSimple
	{
		int clave;
		NodoSimple sgt;
	}
	
	NodoSimple primero;
	NodoSimple ultimo;
	
	@Override
	public void Inicializar() 
	{
		// TODO Auto-generated method stub
		primero = null;
		ultimo = null;
	}

	@Override
	public void AgregarEnInicio(int x) 
	{
		NodoSimple nodo = new NodoSimple();
		nodo.clave = x;
		
		// TODO Auto-generated method stub
		if (ListaVacia())
		{
			primero = nodo;
			ultimo = nodo;
		}
		else
		{
			nodo.sgt = primero;
			primero = nodo;
		}
		
	}

	@Override
	public void AgregarEnFin(int x) 
	{
		// TODO Auto-generated method stub
		NodoSimple nodo = new NodoSimple();
		nodo.clave = x;
		
		// TODO Auto-generated method stub
		if (ListaVacia())
		{
			primero = nodo;
			ultimo = nodo;
		}
		else
		{
			ultimo.sgt = nodo;
			ultimo = nodo;
		}
	}

	@Override
	public void Eliminar(int x) 
	{
		if (ListaVacia())
			return;
		
		// TODO Auto-generated method stub
		NodoSimple cursor = primero;
		
		// Lista con 1 elemento
		if (primero == ultimo && primero.clave == x)
		{
			primero = null;
			ultimo = null;
			return;
		}
		
		// Si el elemento esta en el inicio
		if (primero.clave == x)
		{
			primero = primero.sgt;
			return;
		}
		
		// Avance desde el inicio hasta la posicion previa a donde esta
		// el elemento
		while (cursor.sgt != null && cursor.sgt.clave != x)
			cursor = cursor.sgt;
		
		// Elemento no encontrado
		if (cursor.sgt == null)
			return;
		
		cursor.sgt = cursor.sgt.sgt;
		
		// Nuevo ultimo elemento
		if (cursor.sgt == null)
			ultimo = cursor;
	}

	@Override
	public int ObtenerElemento(int x) 
	{
		if (ListaVacia())
			return -1000;
		
		NodoSimple cursor = primero;
		
		while (cursor != null && cursor.clave != x)
			cursor = cursor.sgt;
		
		if (cursor != null)
			return cursor.clave;
		
		// TODO Auto-generated method stub
		return -1000; /// Se asume que -1000 es un valor no existente en la lista
	}

	@Override
	public boolean ListaVacia() 
	{
		// TODO Auto-generated method stub
		return primero == null;
	}

	@Override
	public int VerInicio() 
	{
		// TODO Auto-generated method stub
		
		return primero.clave;
	}

	@Override
	public int VerFin() 
	{
		// TODO Auto-generated method stub
		return ultimo.clave;
	}
	
}
