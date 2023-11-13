package oms.UD24.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oms.UD24.dto.Empleado;
import oms.UD24.dto.Empleado.Trabajo;
import oms.UD24.dao.IEmpleadoDAO;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	IEmpleadoDAO iEmpleadoDAO;

	//Listar todos
		public List<Empleado> listarEmpleados(){
			return iEmpleadoDAO.findAll();
		};

		//Listar por trabajo
		public List<Empleado> empleadoXtrabajo(Trabajo trabajo) {
			return iEmpleadoDAO.findByTrabajo(trabajo);
		}; 
		
		//Listar por id
		public Empleado empleadoXID(Integer id) {
			return iEmpleadoDAO.findById(id).get();
		}; 
		
		//Guardar
		public Empleado guardarEmpleado(Empleado empleado) {
			return iEmpleadoDAO.save(empleado);
		};
		
		//Actualizar
		public Empleado actualizarEmpleado(Empleado empleado) {
			return iEmpleadoDAO.save(empleado);
		};
		
		//Eliminar
		public void eliminarEmpleado(Integer id) {
			iEmpleadoDAO.deleteById(id);
		};
}
