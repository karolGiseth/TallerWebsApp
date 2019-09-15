package co.edu.uan.spring.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uan.empleados.modelo.Empleado;

@Component
public class ServicioEmpleado {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void register(Empleado emp) {
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		// Save employee, saving behavior get done in a transactional manner
		session.save(emp);
	}

	@Transactional
	public List<Empleado> obtenerEmpleados() {
		@SuppressWarnings("unchecked")
		List<Empleado> list = getSessionFactory().getCurrentSession().createQuery("from Empleado").list();
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

}
