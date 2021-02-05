interface DiccionarioSimpleDinamicoTDA
{
	void Inicializar();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	int Recuperar(int clave);
	ConjuntoDinamico Claves();
}

class ElementoDict
{
	int clave;
	int valor;
}

public class DiccionarioSimpleDinamico implements DiccionarioSimpleDinamicoTDA
{
	class NodoSimple
	{
		ElementoDict info;
		NodoSimple sgt;
	}
	
	private NodoSimple origen;
	
	private NodoSimple Clave2Ind (int clave) 
	{
		NodoSimple elemento = null;
		NodoSimple cursor = origen;
		
		while (cursor != null && cursor.info.clave != clave)
			cursor = cursor.sgt;
		
		if (cursor != null) // Clave encontrada
			elemento = cursor;
		
		return elemento;
	}
	
	@Override
	public void Inicializar() 
	{
		// TODO Auto-generated method stub
		origen = null;
	}

	@Override
	public void Agregar(int clave, int valor) 
	{
		// TODO Auto-generated method stub
		NodoSimple elemento = Clave2Ind(clave);
		
		// Clave no encontrada
		if (elemento == null)
		{
			elemento = new NodoSimple();
			elemento.info = new ElementoDict();
			elemento.info.clave = clave;
			elemento.info.valor = valor;
			elemento.sgt = origen;
			origen = elemento;
		}
		else
			elemento.info.valor = valor;
	}

	@Override
	public void Eliminar(int clave) 
	{
		// TODO Auto-generated method stub
		NodoSimple elemento = Clave2Ind(clave);
		
		// Clave no encontrada
		if (elemento == null)
			return;
		
		NodoSimple cursor = origen;
		
		// La clave esta en el primer elemento
		if (elemento == cursor)
		{
			origen = origen.sgt;
			return;
		}
		
		// Obtenemos el nodo anterior al nodo a eliminar
		while (cursor != null && cursor.sgt != elemento)
			cursor = cursor.sgt;
		
		
		cursor.sgt = elemento.sgt;
		elemento = null;
	}

	@Override
	public int Recuperar(int clave) 
	{
		NodoSimple elemento = Clave2Ind(clave);
		// TODO Auto-generated method stub
		
		if (elemento == null)
			return -1000; /// Se asume que -1000 es un valor nulo para los enteros
		
		return elemento.info.valor;
	}

	@Override
	public ConjuntoDinamico Claves() 
	{
		ConjuntoDinamico claves = new ConjuntoDinamico();
		NodoSimple cursor = origen;
		
		while (cursor != null)
		{
			claves.Agregar(cursor.info.clave);
			cursor = cursor.sgt;
		}
		
		
		return claves;
	}
	
}
