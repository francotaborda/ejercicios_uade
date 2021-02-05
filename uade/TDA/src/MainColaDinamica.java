
public class MainColaDinamica 
{
	public static void main(String[] args)
	{
		ColaDinamica cola1 = new ColaDinamica();
		
		cola1.Inicializar();
		
		int[] array = new int[] {2, 4, 7, 30, 65, 12};
		
		for (int i = 0; i < 6; ++i)
			cola1.Acolar(array[i]);
		
		
		MostrarCola(cola1);
	}
	
	public static void PasarCola(ColaDinamica origen, ColaDinamica destino)
	{
		while (!origen.ColaVacia())
		{
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	public static void CopiarCola(ColaDinamica origen, ColaDinamica destino)
	{
		ColaDinamica auxCola = new ColaDinamica();
		auxCola.Inicializar();
		
		PasarCola(origen, auxCola);
		
		while (!auxCola.ColaVacia())
		{
			destino.Acolar(auxCola.Primero());
			origen.Acolar(auxCola.Primero());
			auxCola.Desacolar();
		}
	}
	
	public static void MostrarCola(ColaDinamica origen)
	{
		ColaDinamica auxCola = new ColaDinamica();
		auxCola.Inicializar();
		
		CopiarCola(origen, auxCola);
		
		while (!auxCola.ColaVacia())
		{
			System.out.print(auxCola.Primero() + ", ");
			auxCola.Desacolar();
		}
		
		System.out.println();
	}
}
