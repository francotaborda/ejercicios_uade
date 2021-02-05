interface ColaTDA
{
	public void Inicializar();
	public void Acolar(int x);
	public void Desacolar();
	public boolean ColaVacia();
	public int Primero();
}

public class Cola implements ColaTDA
{
	private int[] array;
	private int size;
	
	public void Inicializar() 
	{
		array = new int[100];
		size = 0;
	}
	
	public void Acolar(int x)
	{
		if (size >= 100)
			return;
		
		for (int i = size; i > 0; --i)
			array[i] = array[i - 1];
		
		array[0] = x;
		size++;
	}
	
	public void Desacolar()
	{
		size--;
	}
	
	public boolean ColaVacia()
	{
		return size == 0;
	}
	
	public int Primero()
	{
		return array[size - 1];
	}
}
