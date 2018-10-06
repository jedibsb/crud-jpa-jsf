package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.SelecaoDAO;
import com.algaworks.curso.jpa2.modelo.Selecao;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Selecao.class)
public class SelecaoConverter implements Converter {

	private SelecaoDAO selecaoDAO;
	
	public SelecaoConverter() {
		this.selecaoDAO = CDIServiceLocator.getBean(SelecaoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Selecao retorno = null;

		if (value != null) {
			retorno = this.selecaoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Selecao) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}