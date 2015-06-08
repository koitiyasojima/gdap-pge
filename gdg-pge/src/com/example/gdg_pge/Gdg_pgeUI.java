package com.example.gdg_pge;

import gov.gdg.admin.AdminPresenter;
import gov.gdg.admin.AdminView;
import gov.gdg.seguranca.SHA1Util;
import gov.gdg.usuario.LoginPresenter;
import gov.gdg.usuario.LoginView;
import gov.gdg.usuario.UsuarioView;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("gdg_pge")
public class Gdg_pgeUI extends UI implements View {
	
	private Navigator navigator;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Gdg_pgeUI.class, widgetset = "com.example.gdg_pge.widgetset.Gdg_pgeWidgetset")
	public static class Servlet extends VaadinServlet {

	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("GDAP - PGE");
		
		navigator =  new Navigator(this, this);
		
		LoginView loginview = new LoginView();
		LoginPresenter loginPresenter = new LoginPresenter(loginview);
		
		AdminView adminView = new AdminView();
		AdminPresenter adminPresenter = new AdminPresenter(adminView);
		
		navigator.addView("", loginview);
		navigator.addView(AdminView.VIEW_NAME, adminView);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}