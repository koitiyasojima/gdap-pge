package com.example.gdg_pge;

import gov.gdg.modelo.Usuario;
import gov.gdg.modelo.tipos.TipoPeso;
import gov.gdg.seguranca.SHA1Util;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class TestLocal {

	
	public static void main(String[] args){
		JPAContainer<Usuario> c = JPAContainerFactory.make(Usuario.class, "gdg-pge");
		
		Usuario u = new Usuario();
		u.setNome("Koiti");
		u.setCpf("99999999999");
		u.setDigito(2);
		u.setMatricula("123");
		u.setSenha(SHA1Util.criptografaSenha("123"));
		u.setPeso(TipoPeso.SUPERIOR);
		
		c.addEntity(u);
	}
}
