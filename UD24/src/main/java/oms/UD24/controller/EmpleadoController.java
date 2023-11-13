package oms.UD24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.UD24.dto.Empleado;
import oms.UD24.dto.Empleado.Trabajo;
import oms.UD24.services.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/all")
	public List<Empleado> listarEmpleados(){
		return empleadoServiceImpl.listarEmpleados();
	}
	
	@GetMapping("/job/{trabajo}")
	public List<Empleado> empleadoXtrabajo(@PathVariable(name="trabajo") String trabajo){
		return empleadoServiceImpl.empleadoXtrabajo(Trabajo.valueOf(trabajo.toUpperCase()));
	}
	
	@PostMapping("/add")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		empleado.setSalario(empleado.getTrabajo().getSalario());
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}
	
	
	@GetMapping("/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") Integer id) {
		
		Empleado empleado_xid= new Empleado();
		
		empleado_xid=empleadoServiceImpl.empleadoXID(id);
		
		System.out.println("Empleado XID: "+empleado_xid);
		
		return empleado_xid;
	}
	
	@PutMapping("/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Integer id,@RequestBody Empleado empleado) {
		
		Empleado empleado_seleccionado= new Empleado();
		Empleado empleado_actualizado= new Empleado();
		
		empleado_seleccionado= empleadoServiceImpl.empleadoXID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setTrabajo(empleado.getTrabajo());
		empleado_seleccionado.setSalario(empleado.getTrabajo().getSalario());
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El empleado actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")Integer id) {
		empleadoServiceImpl.eliminarEmpleado(id);
		System.out.println("Empleado eliminado");
	}
}
