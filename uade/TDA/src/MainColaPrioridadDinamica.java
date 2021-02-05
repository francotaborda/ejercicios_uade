import java.util.Random;


public class MainColaPrioridadDinamica 
{
	public static ColaDePrioridadDinamica CopiarColaDePrioridad(ColaDePrioridadDinamica origen)
	{
		ColaDePrioridadDinamica copia = new ColaDePrioridadDinamica();
		ColaDePrioridadDinamica aux = new ColaDePrioridadDinamica();
		
		copia.Inicializar();
		aux.Inicializar();
		
		while (!origen.ColaVacia())
		{
			int valor 		= origen.Primero();
			int prioridad 	= origen.Prioridad();
			
			copia.Acolar(valor, prioridad);
			aux.Acolar(valor, prioridad);
			
			origen.Desacolar();
		}
		
		while (!aux.ColaVacia())
		{
			int valor 		= aux.Primero();
			int prioridad 	= aux.Prioridad();
			
			origen.Acolar(valor, prioridad);
			aux.Desacolar();
		}
		
		return copia;
	}
	
	public static boolean ColasIdenticas(ColaDePrioridadDinamica C1, ColaDePrioridadDinamica C2)
	{
		ColaDePrioridadDinamica auxCola 	= CopiarColaDePrioridad(C1);
		ColaDePrioridadDinamica auxCola2 	=  CopiarColaDePrioridad(C2);
		
		while (!auxCola.ColaVacia())
		{
			int valor1 = auxCola.Primero();
			int prioridad1 = auxCola.Prioridad();
			
			if (auxCola2.ColaVacia())
				return false;
			
			int valor2 = auxCola2.Primero();
			int prioridad2 = auxCola2.Prioridad();
			
			if (valor1 != valor2 || prioridad1 != prioridad2)
				return false;	
		}
		
		return true;
	}
	
	public static ColaDePrioridadDinamica CombinarColas(ColaDePrioridadDinamica CP1, ColaDePrioridadDinamica CP2)
	{
		ColaDePrioridadDinamica auxCP1 = CopiarColaDePrioridad(CP1);
		ColaDePrioridadDinamica auxCP2 = CopiarColaDePrioridad(CP2);
		
		ColaDePrioridadDinamica combinada = new ColaDePrioridadDinamica();
		combinada.Inicializar();
		
		while (!auxCP1.ColaVacia())
		{
			int valor = auxCP1.Primero();
			int prioridad = auxCP1.Prioridad();
			
			combinada.Acolar(valor, prioridad);
			auxCP1.Desacolar();
		}
		
		while (!auxCP2.ColaVacia())
		{
			int valor = auxCP2.Primero();
			int prioridad = auxCP2.Prioridad();
			
			combinada.Acolar(valor, prioridad);
			auxCP2.Desacolar();
		}
		
		return combinada;
	}
	
	public static void MostrarCola(ColaDePrioridadDinamica CP1)
	{
		ColaDePrioridadDinamica auxCola = CopiarColaDePrioridad(CP1);
		
		while (!auxCola.ColaVacia())
		{
			System.out.print("(");
			System.out.print(auxCola.Primero() + ", " + auxCola.Prioridad());
			System.out.print(")\n");
			auxCola.Desacolar();
		}
	}
	
	public static void main(String[] args)
	{
		ColaDePrioridadDinamica CP1 = new ColaDePrioridadDinamica();
		CP1.Inicializar();
		
		ColaDePrioridadDinamica CP2 = new ColaDePrioridadDinamica();
		CP2.Inicializar();

		Random rand = new Random();
		
		int j = 2;
		for (int i = 1; i < 11; i += 2, j += 2)
		{
			int valor = i;
			int prioridad = rand.nextInt(100);
			
			System.out.println("Valores: " + valor + ", " + prioridad);
			
			CP1.Acolar(valor, prioridad);
			CP2.Acolar(i + 1, j-1);
			
			//MostrarCola(CP1);
		}
		
		System.out.println("Cola de Prioridad 1:");
		MostrarCola(CP1);
		System.out.println("Cola de Prioridad 2:");
		MostrarCola(CP2);
		System.out.println("Cola de Prioridad Combinada:");
		ColaDePrioridadDinamica CP3 = CombinarColas(CP1, CP2);
		MostrarCola(CP3);
		System.out.println("Son Identicas: " + ColasIdenticas(CP1, CP2));
	}
}
