public class MainPilaDinamica 
{
	public static void main(String[] args)
	{
		PilaDinamica pila = new PilaDinamica();
		
		pila.Inicializar();
		
		for (int i = 2; i < 10; i += 2)
			pila.Apilar(i);
		
		while (!pila.PilaVacia())
		{
			System.out.print(pila.Tope() + ", ");
			pila.Desapilar();
		}
	}
}
