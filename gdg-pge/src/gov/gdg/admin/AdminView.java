package gov.gdg.admin;

import gov.gdg.messages.Display;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;

public class AdminView extends CustomComponent implements View {

	public static final String VIEW_NAME = "admin";

	private CustomLayout layout;
	private MenuBar bar;

	private TabSheet mainTabSheet;

	public AdminView() {
		buildUI();
	}

	private void buildUI() {
		layout = new CustomLayout("content");
		bar = new MenuBar();

		bar.addItem("Usuários", FontAwesome.USER, null);
		bar.addItem("Diretorias", FontAwesome.BUILDING, null);
		bar.addItem("Metas", FontAwesome.BARS, null);
		bar.addItem("Grupos", FontAwesome.USERS, null);
		bar.addItem("Resultados", FontAwesome.STAR, null);
		bar.addItem("Avaliações", FontAwesome.PENCIL, null);
		bar.addItem("Relatórios", FontAwesome.INFO, null);

		mainTabSheet = new TabSheet();

		mainTabSheet.addTab(new Label("Teste"), "1111");
		mainTabSheet.addTab(new Label("Teste2"), "222");

		layout.addComponent(bar, "menu");
		layout.addComponent(mainTabSheet, "content");
		setCompositionRoot(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Object matricula = VaadinSession.getCurrent().getAttribute("matricula");

		if (matricula == null || !matricula.equals("123")) {
			UI.getCurrent().getNavigator().navigateTo("");
			Display.displayErrorMsg("Permissão Negada",
					"Você está tentando acessar uma área restrita");
		}
	}

}
