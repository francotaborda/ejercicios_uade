
public class MainPilaEstatica 
{
	public static void CopiarPila(PilaEstatica origen, PilaEstatica destino)
	{
		PilaEstatica auxStack = new PilaEstatica();
		auxStack.Inicializar();
		
		while (!origen.PilaVacia())
		{
			auxStack.Apilar(origen.Tope());
			origen.Desapilar();
		}
		
		while (!auxStack.PilaVacia())
		{
			origen.Apilar(auxStack.Tope());
			destino.Apilar(auxStack.Tope());
			auxStack.Desapilar();
		}
	}
	
	public static void PasarPila(PilaEstatica origen, PilaEstatica destino)
	{
		while (!origen.PilaVacia())
		{
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}
	
	public static void InvertirPila(PilaEstatica origen)
	{
		// Metodo 2
		PilaEstatica pilaAux = new PilaEstatica();
		pilaAux.Inicializar();
		
		while (!origen.PilaVacia())
		{
			pilaAux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		
		CopiarPila(pilaAux, origen);
	}
	
	public static void MostrarPila(PilaEstatica origen)
	{
		PilaEstatica pilaAux = new PilaEstatica();
		pilaAux.Inicializar();
		
		CopiarPila(origen, pilaAux);

		while (!pilaAux.PilaVacia())
		{
			System.out.println(pilaAux.Tope());
			pilaAux.Desapilar();
		}
	}
	
	public static int ContarElementos(PilaEstatica origen)
	{
		int cuenta = 0;
		
		while (!origen.PilaVacia())
		{
			cuenta++;
			origen.Desapilar();
		}
		
		return cuenta;
	}
	
	public static float ObtenerPromedio(PilaEstatica origen)
	{
		int cuenta = 0;
		float promedio = 0.0f;
		
		while (!origen.PilaVacia())
		{
			cuenta++;
			promedio += origen.Tope();
			origen.Desapilar();
		}
		
		return promedio / cuenta;
	}
	
	public static void ProbarPila()
	{
		PilaEstatica stack = new PilaEstatica();
		stack.Inicializar();
		
		PilaEstatica auxPila = new PilaEstatica();
		auxPila.Inicializar();
		
		for (int i = 10; i < 100; i += 10)
			stack.Apilar(i);
		
		System.out.println("Antes de Invertir");
		MostrarPila(stack);
		InvertirPila(stack);
		System.out.println("Despues de Invertir");
		MostrarPila(stack);
		CopiarPila(stack, auxPila);
		System.out.println("Cantidad de Elementos:" + ContarElementos(auxPila));
		CopiarPila(stack, auxPila);
		System.out.println("Promedio de Elementos:" + ObtenerPromedio(auxPila));
	}
	
	public static void main(String[] args)
	{
		
	}
}
