class NodoSimple
{
	int info;
	NodoSimple sgt;
}
	
public class MainEliminarDuplicados 
{
	public static void MostrarLista(NodoSimple origen)
	{
		NodoSimple cursor = origen;
		
		while (cursor != null)
		{
			System.out.print(cursor.info + ", ");
			cursor = cursor.sgt;
		}
	}
	
	public static void main(String[] args)
	{
		int[] valores = new int[] {1, 3, 3, 1, 5, 7, 7, 3};
		
		ConjuntoEst conj = new ConjuntoEst();
		conj.Inicializar();
		NodoSimple origen = null;
		NodoSimple ultimo = null;
		
		for (int i = 0; i < 8; ++i)
		{
			int valorActual = valores[i];
			
			if (origen == null)
			{
				origen = new NodoSimple();
				origen.info = valorActual;
				conj.Agregar(valorActual);
				ultimo = origen;
			}
			else
			{
				if (!conj.Pertenece(valorActual))
				{
					NodoSimple nuevo = new NodoSimple();
					nuevo.info = valorActual;
					ultimo.sgt = nuevo;
					ultimo = nuevo;
					conj.Agregar(valorActual);
				}
			}
		}
		
		MostrarLista(origen);
	}
}
