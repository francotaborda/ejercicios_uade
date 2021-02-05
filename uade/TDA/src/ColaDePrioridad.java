interface ColaPrioridadTDA
{
	void Inicializar();
	void Acolar(int valor, int prioridad);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	int Prioridad();
}

class ElementoCola
{
	public int Valor;
	public int Prioridad;
}


public class ColaDePrioridad implements ColaPrioridadTDA
{
	ElementoCola[] elementos;
	int tam;
	
	public void Inicializar()
	{
		elementos = new ElementoCola[100];
		tam = 0;
	}
	
	public void Acolar(int valor, int prioridad)
	{
		int j = tam;
		
		// Estrategia de Insercion
		/*
		 * - Buscar primero posicion definita desde el final de la cola
		 * - Desplazar elementos con prioridad mayor al elemento insertado a la derecha
		 * - Insertar elemento en la posicion definitiva
		 * - Incrementar Tamaño de la cola
		 */
		while (j > 0 && elementos[j - 1].Prioridad > prioridad)
		{
			elementos[j] = elementos[j-1];
			j--;
		}
		
		ElementoCola key = new ElementoCola();
		
		key.Valor = valor;
		key.Prioridad = prioridad;
		
		elementos[j] = key;
		tam++;
	}
	
	public void Desacolar()
	{
		tam--;
	}
	
	public boolean ColaVacia()
	{
		return tam == 0;
	}
	
	public int Primero()
	{
		if (ColaVacia())
			return elementos[-1].Valor;
		
		return elementos[tam-1].Valor;
	}
	
	public int Prioridad()
	{
		if (ColaVacia())
			return elementos[-1].Prioridad;
		
		return elementos[tam-1].Prioridad;
	}
}
