package oms.UD24.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD24.dto.Empleado;
import oms.UD24.dto.Empleado.Trabajo;

public interface IEmpleadoDAO extends JpaRepository<Empleado,Integer> {
	List<Empleado> findByTrabajo(Trabajo t);
}
