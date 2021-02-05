

public class MainConjuntoEstatico 
{
	static ConjuntoEst CopiarConjunto(ConjuntoEst origen)
	{
		ConjuntoEst copia = new ConjuntoEst();
		ConjuntoEst aux = new ConjuntoEst();
		
		copia.Inicializar();
		aux.Inicializar();
		
		while (!origen.ConjuntoVacio())
		{
			int valor = origen.Elegir();
			copia.Agregar(valor);
			aux.Agregar(valor);
			origen.Sacar(valor);
		}
		
		while (!aux.ConjuntoVacio())
		{
			int valor = aux.Elegir();
			origen.Agregar(valor);
			aux.Sacar(valor);
		}
		
		return copia;
	}
	
	public static ConjuntoEst UnionConjuntos(ConjuntoEst Conj1, ConjuntoEst Conj2)
	{
		ConjuntoEst union = new ConjuntoEst();
		union.Inicializar();
		
		ConjuntoEst aux1 = CopiarConjunto(Conj1);
		ConjuntoEst aux2 = CopiarConjunto(Conj2);
		
		while (!aux1.ConjuntoVacio())
		{
			int valor = aux1.Elegir();
			aux1.Sacar(valor);
			union.Agregar(valor);
		}
		
		while (!aux2.ConjuntoVacio())
		{
			int valor = aux2.Elegir();
			aux2.Sacar(valor);
			union.Agregar(valor);
		}
		
		return union;
	}
	
	public static ConjuntoEst InterseccionConjuntos(ConjuntoEst Conj1, ConjuntoEst Conj2)
	{
		ConjuntoEst interseccion = new ConjuntoEst();
		interseccion.Inicializar();
		
		ConjuntoEst aux1 = CopiarConjunto(Conj1);
		
		while (!aux1.ConjuntoVacio())
		{
			int valor = aux1.Elegir();
			
			if (Conj2.Pertenece(valor))
				interseccion.Agregar(valor);
			
			aux1.Sacar(valor);
		}
		
		return interseccion;
	}
	
	public static ConjuntoEst DiferenciaConjuntos(ConjuntoEst conj1, ConjuntoEst conj2)
	{
		ConjuntoEst diferencia = new ConjuntoEst();
		diferencia.Inicializar();
		
		ConjuntoEst aux1 = CopiarConjunto(conj1);
		
		while (!aux1.ConjuntoVacio())
		{
			int valor = aux1.Elegir();
			
			if (!conj2.Pertenece(valor))
				diferencia.Agregar(valor);
				
			aux1.Sacar(valor);
		}
		
		return diferencia;
	}
	
	public static void MostrarConjunto(ConjuntoEst conj)
	{
		System.out.print("\nMostrar\n");
		ConjuntoEst aux = CopiarConjunto(conj);
		
		while (!aux.ConjuntoVacio())
		{
			int valor = aux.Elegir();
			System.out.print(valor + ", ");
			aux.Sacar(valor);
		}
		
		System.out.print('\n');
		System.out.print("Fin de Mostrar");
	}
	
	public static void main(String[] args)
	{
		ConjuntoEst conj1 = new ConjuntoEst();
		ConjuntoEst conj2 = new ConjuntoEst();
		
		conj1.Inicializar();
		conj2.Inicializar();
		
		int j = 0;
		for (int i = 1; i < 7; i+=2, j+=2)
		{
			conj1.Agregar(i);
			conj2.Agregar(j);
		}
		
		MostrarConjunto(conj1);
		MostrarConjunto(conj2);
		conj2.Agregar(3);
		MostrarConjunto(DiferenciaConjuntos(conj1, conj2));
	}
}
