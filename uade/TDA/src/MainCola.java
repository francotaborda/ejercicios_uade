public class MainCola 
{
	public static void PasarCola(Cola origen, Cola destino)
	{
		while (!origen.ColaVacia())
		{
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	public static void CopiarCola(Cola origen, Cola destino)
	{
		Cola auxCola = new Cola();
		auxCola.Inicializar();
		
		PasarCola(origen, auxCola);
		
		while (!auxCola.ColaVacia())
		{
			destino.Acolar(auxCola.Primero());
			origen.Acolar(auxCola.Primero());
			auxCola.Desacolar();
		}
	}
	
	public static void InvertirColaConPila(Cola origen)
	{
		PilaEstatica auxPila = new PilaEstatica();
		auxPila.Inicializar();
		
		while (!origen.ColaVacia())
		{
			auxPila.Apilar(origen.Primero());
			origen.Desacolar();
		}
		
		while (!auxPila.PilaVacia())
		{
			origen.Acolar(auxPila.Tope());
			auxPila.Desapilar();
		}
	}
	
	public static void InvertirColaSinPila(Cola origen)
	{
		int array[] = new int[100];
		int size = 0;
		
		while (!origen.ColaVacia())
		{
			array[size] = origen.Primero();
			size++;
			origen.Desacolar();
		}
		
		for (int i = size - 1; i >= 0; --i)
			origen.Acolar(array[i]);
	}
	
	public static void MostrarCola(Cola origen)
	{
		Cola auxCola = new Cola();
		auxCola.Inicializar();
		
		CopiarCola(origen, auxCola);
		
		while (!auxCola.ColaVacia())
		{
			System.out.print(auxCola.Primero() + ", ");
			auxCola.Desacolar();
		}
		
		System.out.println();
	}
	
	public static boolean EsCapicua(Cola origen)
	{
		Cola auxCola = new Cola();
		Cola auxCola2 = new Cola();
		
		auxCola.Inicializar();
		auxCola2.Inicializar();
		
		CopiarCola(origen, auxCola);
		CopiarCola(origen, auxCola2);
		InvertirColaSinPila(auxCola);
		
		while (!auxCola.ColaVacia())
		{
			if (auxCola.Primero() != auxCola2.Primero())
				return false;
			
			auxCola.Desacolar();
			auxCola2.Desacolar();
		}
		
		return true;
	}
	
	public static boolean ColaInversaDeOtra(Cola origen, Cola destino)
	{
		Cola c3 = new Cola();
		Cola c4 = new Cola();
		
		c3.Inicializar();
		c4.Inicializar();
		
		CopiarCola(origen, c3);
		CopiarCola(destino, c4);
		
		InvertirColaSinPila(c3);
		
		while (!c3.ColaVacia())
		{
			if (c3.Primero() != c4.Primero())
				return false;
			
			c3.Desacolar();
			c4.Desacolar();
		}
		
		if (!c4.ColaVacia())
			return false;
	
		return true;
	}

	public static void main(String[] args)
	{
		Cola cola1 = new Cola();
		Cola cola2 = new Cola();
		
		cola2.Inicializar();
		cola1.Inicializar();
		
		int[] array = new int[] {5, 3, 10, 8,10, 3, 5};
		
		for (int i = 0; i < 7; ++i)
			cola1.Acolar(array[i]);
		
		System.out.println("Es Capicua:" + EsCapicua(cola1));
		
		cola1 = null;
		
		cola1 = new Cola();
		cola1.Inicializar();
		
		for (int i = 2; i < 10; i += 2)
		{
			cola1.Acolar(i);
		}
		
		CopiarCola(cola1, cola2);
		
		MostrarCola(cola2);
		System.out.println("Es Capicua:" + EsCapicua(cola2));
		InvertirColaSinPila(cola1);
		MostrarCola(cola1);
		
		
		boolean esInversa = ColaInversaDeOtra(cola1, cola2);
		
		System.out.println("Cola Inversa: " + esInversa);
	}
}
