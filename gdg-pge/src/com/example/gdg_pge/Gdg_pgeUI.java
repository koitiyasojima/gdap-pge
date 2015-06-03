package com.example.gdg_pge;

import java.util.Collection;

import gov.gdg.modelo.Usuario;
import gov.gdg.seguranca.SHA1Util;
import gov.gdg.usuario.UsuarioView;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("gdg_pge")
public class Gdg_pgeUI extends UI {

	public static Navigator navigator;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Gdg_pgeUI.class)
	public static class Servlet extends VaadinServlet {

	}

	@Override
	protected void init(VaadinRequest request) {
		EntityManager u = JPAContainerFactory
				.createEntityManagerForPersistenceUnit("gdg-pge");

		JPAContainer<Usuario> teste = JPAContainerFactory.make(Usuario.class,
				"gdg-pge");

		getPage().setTitle("Navigation Example");

		// Create a navigator to control the views
		navigator = new Navigator(this, this);

		// Create and register the views
		navigator.addView("", new LoginView());
		navigator.addView(UsuarioView.VIEW, new UsuarioView());

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo(UsuarioView.VIEW);
			}
		});
		layout.addComponent(button);
	}

	public static void main(String[] args) {
		System.out.println(SHA1Util.criptografaSenha("admin"));
	}

}