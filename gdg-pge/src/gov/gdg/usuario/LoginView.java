package gov.gdg.usuario;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends CustomComponent implements View {

	private CustomLayout layout;

	private FormLayout loginLayout;
	private VerticalLayout logoutLayout;

	private TextField matriculaField;
	private PasswordField senhaField;
	private Button loginBt;
	private Button logoutBt;

	public LoginView() {
		buildUI();
	}

	private void buildUI() {
		layout = new CustomLayout("main");

		loginLayout = new FormLayout();

		loginBt = new Button("Login");

		matriculaField = new TextField("Matrícula");
		matriculaField.setInputPrompt("Insira sua matrícula");
		matriculaField.setRequired(true);
		matriculaField.setNullRepresentation("");

		senhaField = new PasswordField("Senha");
		senhaField.setDescription("Insira sua senha");
		senhaField.setRequired(true);
		senhaField.setNullRepresentation("");

		loginLayout.addComponent(matriculaField);
		loginLayout.addComponent(senhaField);
		loginLayout.addComponent(loginBt);

		logoutBt = new Button("Logout");
		logoutLayout = new VerticalLayout();
		logoutLayout.addComponent(logoutBt);

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

	public Button getLogoutBt() {
		return logoutBt;
	}

	public FormLayout getFormLayout() {
		return loginLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Object matricula = VaadinSession.getCurrent().getAttribute("matricula");
		if (matricula != null) {
			layout.addComponent(logoutLayout, "login");
		} else {
			layout.addComponent(loginLayout, "login");
		}
	}

}
