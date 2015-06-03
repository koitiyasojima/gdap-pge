package com.example.gdg_pge;

import gov.gdg.database.DBConnection;
import gov.gdg.modelo.Usuario;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends FormLayout implements View{

	private static final String VIEW = "login";
	
	private TextField matriculaField;
	private PasswordField senhaField;
	private Button loginBt;
	
	private FieldGroup binder;
	
	public LoginView() {
		super();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		loginBt = new Button("Login");
		
		matriculaField = new TextField("Matrícula");
		matriculaField.setInputPrompt("Insira sua matrícula");
		matriculaField.setRequired(true);
		matriculaField.setNullRepresentation("");
		
		senhaField = new PasswordField("Senha");
		senhaField.setDescription("Insira sua senha");
		senhaField.setRequired(true);
		senhaField.setNullRepresentation("");
		
		addComponent(matriculaField);
		addComponent(senhaField);
		addComponent(loginBt);
		
		JPAContainer<Usuario> c = DBConnection.getContainer(Usuario.class);
		EntityItem<Usuario> item = c.createEntityItem(new Usuario());
		
		binder = new FieldGroup(item);
	
		binder.bind(matriculaField, "matricula");
		binder.bind(senhaField, "senha");
	}

}
