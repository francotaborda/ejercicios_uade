

public class MainSimulacroParcial 
{
	public static ListaEmpleados CopiarLista(ListaEmpleados origen)
	{
		ListaEmpleados copia = new ListaEmpleados();
		ListaEmpleados aux = new ListaEmpleados();
		
		while (!origen.ListaVacia())
		{
			Empleado e = origen.VerInicio();
			
			copia.AgregarEnInicio(e);
			aux.AgregarEnInicio(e);
			
			origen.Eliminar(e);
		}
		
		while (!aux.ListaVacia())
		{
			Empleado e = aux.VerInicio();
			aux.Eliminar(e);
			origen.AgregarEnInicio(e);
		}
		
		return copia;
	}
	
	public static void mostrarSueldo(int legajo, ListaEmpleados empleados)
	{
		Empleado e = empleados.ObtenerElemento(legajo);
		
		if (e == null)
		{
			System.out.print("Empleado no encontrado");
			return;
		}
		
		String str = new String();
		
		str += "Datos Empleado: \n";
		str += "Nombre: " + e.nombre + '\n';
		str += "Sueldo: " + e.sueldo + '\n';
		str += "------------------\n";
		
		System.out.print(str);
	}
	
	public static void listarEmpleados(ListaEmpleados origen)
	{
		ListaEmpleados copia = CopiarLista(origen);
		
		while (!copia.ListaVacia())
		{
			Empleado e = copia.VerInicio();
			System.out.print(e.toString());
			copia.Eliminar(e);
		}
	}
	
	public static void main(String[] args)
	{
		ListaEmpleados empleados = new ListaEmpleados();
		
		empleados.Inicializar();
		
		String[] nombres = new String[]
		{
			"Pedro",
			"Maria",
			"Marta",
			"Antonio",
			"Hugo"
		};
		
		for (int i = 0; i < 5; ++i)
		{
			Empleado e = new Empleado();
			e.legajo = i + 2;
			e.sueldo = (i * 50.0f + 0.5f);
			e.nombre = nombres[i];
			empleados.AgregarEnInicio(e);
		}
		
		listarEmpleados(empleados);
		
		System.out.println("Mostrar Sueldo Empleado con legajo 3: \n");
		mostrarSueldo(3, empleados);
		
		Empleado e = new Empleado();
		e.legajo = 3;
		
		empleados.Eliminar(e);
		
		listarEmpleados(empleados);
	}
}
