
public class MainConjDinamico 
{
	public static void main(String[] args)
	{
		ConjuntoDinamico conj = new ConjuntoDinamico();
		conj.Inicializar();
		
		for (int i = 2; i < 12; i += 2)
			conj.Agregar(i);
		
		conj.Sacar(5);
		
		while (!conj.ConjuntoVacio())
		{
			int clave = conj.Elegir();
			System.out.print(clave + ", ");
			conj.Sacar(clave);
		}
	}
}
