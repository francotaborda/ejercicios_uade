import java.util.Random;

interface ConjuntoTDA
{
	void Inicializar();
	void Agregar(int x);
	int Elegir();
	boolean ConjuntoVacio();
	void Sacar(int x);
	boolean Pertenece(int x);
}

public class ConjuntoEst implements ConjuntoTDA
{
	private int[] valores;
	private int cantidad;
	
	public void Inicializar()
	{
		valores = new int[100];
		cantidad = 0;
		
	}
	
	public boolean Pertenece(int x)
	{
		for (int i = 0; i < cantidad; ++i)
		{
			if (valores[i] == x)
				return true;
		}
		
		return false;
	}
	
	public boolean ConjuntoVacio()
	{
		return cantidad == 0;
	}
	
	public void Agregar(int x)
	{
		for (int i = 0; i < cantidad; ++i)
		{
			if (valores[i] == x)
				return;
		}
		
		valores[cantidad] = x;
		cantidad++;
	}

	public int Elegir()
	{
		Random random = new Random();
		int rand_idx = random.nextInt(cantidad);
		
		return valores[rand_idx];
	}

	public void Sacar(int x)
	{
		int i = 0;
		int j = 0;
		boolean hallado = false;
		
		while (!hallado && i < cantidad)
		{
			if (valores[i] == x)
			{
				hallado = true;
				j = i;
			}
			
			i++;
		}
		
		if (!hallado)
			return;
		
		for (i = j; i < cantidad; i++)
			valores[i] = valores[i+1];
		
		cantidad--;
	}
}
