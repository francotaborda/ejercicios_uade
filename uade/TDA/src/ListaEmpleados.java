class Empleado
{
	int legajo;
	String nombre;
	float sueldo;
	
	public String toString()
	{
		String str = new String();
		
		str += "Datos Empleado: \n";
		str += "Legajo: " + legajo + '\n';
		str += "Nombre: " + nombre + '\n';
		str += "Sueldo: " + sueldo + '\n';
		str += "------------------\n";
		
		return str;
	}
}


interface ListaEmpleadosTDA
{
	void Inicializar();
	void AgregarEnInicio(Empleado x);
	void AgregarEnFin(Empleado x);
	void Eliminar(Empleado x);
	Empleado ObtenerElemento(int legajo);
	boolean ListaVacia();
	Empleado VerInicio();
	Empleado VerFin();
}

class ListaEmpleados implements ListaEmpleadosTDA
{
	class NodoSimple
	{
		Empleado info;
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
	public void AgregarEnInicio(Empleado x) 
	{
		NodoSimple nodo = new NodoSimple();
		nodo.info = x;
		
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
	public void AgregarEnFin(Empleado x) 
	{
		// TODO Auto-generated method stub
		NodoSimple nodo = new NodoSimple();
		nodo.info = x;
		
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
	public void Eliminar(Empleado x)
	{
		if (ListaVacia())
			return;
		
		// TODO Auto-generated method stub
		NodoSimple cursor = primero;
		
		// Lista con 1 elemento
		if (primero == ultimo && primero.info.legajo == x.legajo)
		{
			primero = null;
			ultimo = null;
			return;
		}
		
		// Si el elemento esta en el inicio
		if (primero.info.legajo == x.legajo)
		{
			primero = primero.sgt;
			return;
		}
		
		// Avance desde el inicio hasta la posicion previa a donde esta
		// el elemento
		while (cursor.sgt != null && cursor.sgt.info.legajo != x.legajo)
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
	public Empleado ObtenerElemento(int legajo) 
	{
		if (ListaVacia())
			return null;
		
		NodoSimple cursor = primero;
		
		while (cursor != null && cursor.info.legajo != legajo)
			cursor = cursor.sgt;
		
		if (cursor != null)
			return cursor.info;
		
		// TODO Auto-generated method stub
		return null; /// Se asume que -1000 es un valor no existente en la lista
	}

	@Override
	public boolean ListaVacia() 
	{
		// TODO Auto-generated method stub
		return primero == null;
	}

	@Override
	public Empleado VerInicio() 
	{
		// TODO Auto-generated method stub
		
		return primero.info;
	}

	@Override
	public Empleado VerFin() 
	{
		// TODO Auto-generated method stub
		return ultimo.info;
	}
	
}