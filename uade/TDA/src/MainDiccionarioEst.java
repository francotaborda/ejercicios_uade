import java.util.Random;

public class MainDiccionarioEst 
{
	public static DiccionarioSimpleEst CopiarDiccionario(DiccionarioSimpleEst origen)
	{
		DiccionarioSimpleEst copia = new DiccionarioSimpleEst();
		copia.Inicializar();
		ConjuntoEst claves = origen.Claves();
		
		while (!claves.ConjuntoVacio())
		{
			int clave = claves.Elegir();
			int valor = origen.Recuperar(clave);
			copia.Agregar(clave, valor);
			claves.Sacar(clave);
		}
		
		return copia;
	}
	
	public static void MostrarDiccionario(DiccionarioSimpleEst origen)
	{
		ConjuntoEst claves = origen.Claves();
		
		System.out.print("\nMostrar Diccionario\n\n");
		while (!claves.ConjuntoVacio())
		{
			int clave = claves.Elegir();
			int valor = origen.Recuperar(clave);
			System.out.print("Clave: " + clave + ", " + "Valor: " + valor + '\n');
			claves.Sacar(clave);
		}
		System.out.print("\nFin Mostrar Diccionario\n");
	}
	
	public static void main(String[] args)
	{
		DiccionarioSimpleEst dict = new DiccionarioSimpleEst();
		dict.Inicializar();
		
		Random rand = new Random();
		
		for (int i = 0; i < 5; ++i)
		{
			int valor = rand.nextInt(10);
			int clave = i + 1;
			
			dict.Agregar(clave, valor);
		}
		
		MostrarDiccionario(dict);
		dict.Agregar(3, 50);
		MostrarDiccionario(dict);
		dict.Eliminar(3);
		MostrarDiccionario(dict);
	}
}
