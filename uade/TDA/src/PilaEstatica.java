interface PilaTDA 
{
	void Inicializar();
	void Desapilar();
	void Apilar(int key);
	int Tope();
	Boolean PilaVacia();
}

public class PilaEstatica implements PilaTDA
{
	private int[] array;
	private int cursor;
	
	public void Inicializar()
	{
		array = new int[100];
		cursor = -1;
	}
	
	public void Desapilar()
	{
		if (PilaVacia())
			return;
		
		cursor--;
	}
	
	public void Apilar(int key)
	{
		cursor++;
		array[cursor] = key;
	}
	
	public Boolean PilaVacia() 
	{ 
		return cursor < 0; 
	}
	
	public int Tope()
	{
		return array[cursor];
	}
	
	
}

