interface ColaPrioridadDinamicaTDA
{
	void Inicializar();
	void Acolar(int valor, int prioridad);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	int Prioridad();
}

class ColaElemento
{
	int prioridad;
	int valor;
}

public class ColaDePrioridadDinamica implements ColaPrioridadDinamicaTDA
{

	class NodoSimple
	{
		ColaElemento info;
		NodoSimple sgt;
	}
	
	NodoSimple primero;
	
	@Override
	public void Inicializar() 
	{
		// TODO Auto-generated method stub
		primero = null;
	}

	@Override
	public void Acolar(int valor, int prioridad) 
	{	
		NodoSimple nuevo = new NodoSimple();
		nuevo.info = new ColaElemento();
		nuevo.info.prioridad = prioridad;
		nuevo.info.valor = valor;
		
		if (primero == null || primero.info.prioridad < prioridad)
		{
			nuevo.sgt = primero;
			primero = nuevo;
		}
		else
		{
			NodoSimple cursor = primero;
			
			while (cursor.sgt != null && cursor.sgt.info.prioridad > prioridad)
				cursor = cursor.sgt;
			
			nuevo.sgt = cursor.sgt;
			cursor.sgt = nuevo;
		}
	}

	@Override
	public void Desacolar() 
	{
		// TODO Auto-generated method stub
		primero = primero.sgt;
	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return primero == null;
	}

	@Override
	public int Primero() 
	{
		// TODO Auto-generated method stub
		return primero.info.valor;
	}

	@Override
	public int Prioridad() {
		// TODO Auto-generated method stub
		return primero.info.prioridad;
	}

}
