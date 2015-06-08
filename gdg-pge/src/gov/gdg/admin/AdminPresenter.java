package gov.gdg.admin;

import java.util.List;

import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

public class AdminPresenter {

	private AdminView view;
	
	public AdminPresenter(AdminView view) {
		this.view = view;
		build();
	}
	
	private void build(){
		Command command = new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				String text = selectedItem.getText();
				switch (text) {
				case "Usu�rios":
					view.getLayout().addComponent(new Label("Usu�rios SELECTED"), "content");
					break;
				case "Diretorias":
					view.getLayout().addComponent(new Label("Diretorias SELECTED"), "content");
					break;
				case "Metas":
					view.getLayout().addComponent(new Label("Metas SELECTED"), "content");
					break;
				case "Grupos":
					view.getLayout().addComponent(new Label("Grupos SELECTED"), "content");
					break;
				case "Resultados":
					view.getLayout().addComponent(new Label("Resultados SELECTED"), "content");
					break;
				case "Avalia��es":
					view.getLayout().addComponent(new Label("Avalia��es SELECTED"), "content");
					break;
				case "Relat�rios":
					view.getLayout().addComponent(new Label("Relat�rios SELECTED"), "content");
					break;
				default:
					break;
				}
			}
		};
		
		List<MenuItem> items = view.getBar().getItems();
		for (MenuItem menuItem : items) {
			menuItem.setCommand(command);
		}
	}
	
}
