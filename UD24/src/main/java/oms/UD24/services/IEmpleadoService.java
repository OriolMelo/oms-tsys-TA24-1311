package oms.UD24.services;

import java.util.List;

import oms.UD24.dto.Empleado;
import oms.UD24.dto.Empleado.Trabajo;

public interface IEmpleadoService {

	//Listar todos
	public List<Empleado> listarEmpleados();

	//Listar por trabajo
	public List<Empleado> empleadoXtrabajo(Trabajo trabajo); 
	
	//Listar por id
	public Empleado empleadoXID(Integer id); 
	
	//Guardar
	public Empleado guardarEmpleado(Empleado empleado);
	
	//Actualizar
	public Empleado actualizarEmpleado(Empleado empleado);
	
	//Eliminar
	public void eliminarEmpleado(Integer id);
}
