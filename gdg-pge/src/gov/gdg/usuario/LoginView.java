package gov.gdg.usuario;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class LoginView extends CustomComponent implements View {

	private CustomLayout layout;

	private FormLayout formLayout;

	private TextField matriculaField;
	private PasswordField senhaField;
	private Button loginBt;

	public LoginView() {
		buildUI();
	}

	private void buildUI() {
		layout = new CustomLayout("main");

		formLayout = new FormLayout();
		loginBt = new Button("Login");

		matriculaField = new TextField("Matrícula");
		matriculaField.setInputPrompt("Insira sua matrícula");
		matriculaField.setRequired(true);
		matriculaField.setNullRepresentation("");

		senhaField = new PasswordField("Senha");
		senhaField.setDescription("Insira sua senha");
		senhaField.setRequired(true);
		senhaField.setNullRepresentation("");

		formLayout.addComponent(matriculaField);
		formLayout.addComponent(senhaField);
		formLayout.addComponent(loginBt);

		layout.addComponent(formLayout, "login");
		setCompositionRoot(layout);
	}

	public TextField getMatriculaField() {
		return matriculaField;
	}

	public PasswordField getSenhaField() {
		return senhaField;
	}

	public Button getLoginBt() {
		return loginBt;
	}

	public FormLayout getFormLayout() {
		return formLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
