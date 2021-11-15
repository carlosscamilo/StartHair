package br.com.StartHair.util;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Hibernate;

import br.com.StartHair.model.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ConversorClientes implements Converter, Serializable{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if(id != null && id.isEmpty()) {
			return (Cliente)Hibernat;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		
		return null;
	}

}
