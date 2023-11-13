package oms.UD24.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {

	public enum Trabajo{
		CARPINTERO(1000),
		ESCULTOR(2000),
		COCINERO(3000); 
		
		private int salario;
		
		private Trabajo(int salario){
			this.salario = salario;
		}
		
		public int getSalario() {
			return salario;
		}
	}
	
	//Atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	@Enumerated(EnumType.STRING)
	private Trabajo trabajo;
	private int salario;

	//Constructores de clase
	public Empleado() {
		
	}
	
	public Empleado(int id, String nombre, Trabajo trabajo, int salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.trabajo = trabajo;
		this.salario = trabajo.getSalario();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + "]";
	}
	
}
