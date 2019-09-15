package co.edu.uan.empleados.vista;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import co.edu.uan.empleados.modelo.Empleado;
import co.edu.uan.spring.service.ServicioEmpleado;

@ManagedBean(name = "manejadorEmpleado")
@SessionScoped
public class ManejadorEmpleado {
	@ManagedProperty("#{servicioEmpleado}")
	private ServicioEmpleado servicioEmpleado;
	private Empleado empleado = new Empleado();
	private List<Empleado> listaEmpleados;

	public String register() {
		// Calling Business Service
		servicioEmpleado.register(empleado);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("El empleado " + this.empleado.getNombre() + " ha sido registrado con éxito"));
		return "";
	}

	public ServicioEmpleado getServicioEmpleado() {
		return servicioEmpleado;
	}

	public void setServicioEmpleado(ServicioEmpleado servicioEmpleado) {
		this.servicioEmpleado = servicioEmpleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getListaEmpleados() {
		return servicioEmpleado.obtenerEmpleados();
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
}
