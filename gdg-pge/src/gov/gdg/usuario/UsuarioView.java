package gov.gdg.usuario;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UsuarioView extends VerticalLayout implements View {

	public static final String VIEW = "usuario";
	
	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new Label("Teste ok"));
	}


}
