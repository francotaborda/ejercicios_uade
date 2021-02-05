
public class MainListaEnlazadaSimple 
{
	public static void main(String[] args)
	{
		ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
		lista.Inicializar();
		
		for (int i = 0; i < 10; ++i)
			lista.AgregarEnFin(i);
		
		while (!lista.ListaVacia())
		{
			int fin = lista.VerInicio();
			System.out.print(fin + ", \n");
			lista.Eliminar(fin);
		}
		
		lista.Eliminar(10);
	}
}
