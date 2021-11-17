package br.com.StartHair.util;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Hibernate;

import br.com.StartHair.model.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ConversorClientes implements Converter, Serializable {

	private static final Object Cliente = null;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if (id != null && !id.isEmpty()) {
			return (Cliente) HibernateUtil.getCurrentSession().get(Cliente.class, new Integer(id));
		}
		return id;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		if (objeto != null) {
			Cliente c = (Cliente) objeto;
			return c.getId() != null && c.getId() > 0 ? c.getId().toString() : null;
		}
		return null;
	}

}
