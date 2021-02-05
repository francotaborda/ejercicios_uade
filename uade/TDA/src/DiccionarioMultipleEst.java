interface DiccionarioMultipleEstTDA
{
	void Inicializar();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	ConjuntoEst Recuperar(int clave);
	ConjuntoEst Claves();
}


public class DiccionarioMultipleEst implements DiccionarioMultipleEstTDA
{
	class Elemento
	{
		ConjuntoEst valores;
		int clave;
	}
	
	Elemento[] elementos;
	int cant;
	
	private int Clave2Ind (int clave) 
	{
		int i = cant-1;
		
		while (i >= 0 && elementos[i].clave != clave)
			i--;
		
		return i;
	}
	
	public void Inicializar()
	{
		elementos = new Elemento[100];
		cant = 0;
	}
	
	public void Agregar(int clave, int valor)
	{
		int pos = Clave2Ind(clave);
		 
		 if (pos != -1)
		 {
			 Elemento e = new Elemento();
			 e.clave = clave;
			 e.valores = new ConjuntoEst();
			 elementos[pos] = e;
		 }
		 else
		 {
			 pos = cant;
			 elementos[pos].valores.Agregar(valor);
			 cant++;
		 }
	}
	
	public void Eliminar(int clave)
	{
		int pos = Clave2Ind(clave);
		
		if (pos != -1)
		{
			elementos[pos] = elementos[cant - 1];
			cant--;
		}
	}

	public ConjuntoEst Recuperar(int clave) 
	{
		int pos = Clave2Ind(clave);
		return elementos[pos].valores;
	}
	
	public ConjuntoEst Claves()
	{
		ConjuntoEst claves = new ConjuntoEst();
		claves.Inicializar();
		
		for (int i = 0; i < cant; ++i)
			claves.Agregar(elementos[i].clave);
		
		return claves;
	}
}
