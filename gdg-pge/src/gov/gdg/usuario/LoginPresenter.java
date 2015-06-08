package gov.gdg.usuario;

import gov.gdg.admin.AdminView;
import gov.gdg.database.DBConnection;
import gov.gdg.messages.Display;
import gov.gdg.modelo.Usuario;

import java.util.Collection;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.filter.And;
import com.vaadin.data.util.filter.Compare;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;

public class LoginPresenter {

	private LoginView view;
	private EntityItem<Usuario> model;

	public LoginPresenter(LoginView view) {
		this.view = view;
		this.model = DBConnection.getContainer(Usuario.class).createEntityItem(
				new Usuario());

		build();
	}

	private void build() {
		final FieldGroup binder = new FieldGroup(model);

		binder.bind(view.getMatriculaField(), "matricula");
		binder.bind(view.getSenhaField(), "senha");

		view.getLoginBt().addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					binder.commit();

					JPAContainer<Usuario> container = DBConnection
							.getContainer(Usuario.class);

					EntityItem<Usuario> item = (EntityItem<Usuario>) binder
							.getItemDataSource();

					And filter = new And(new Compare.Equal("matricula", item
							.getEntity().getMatricula()), new Compare.Equal(
							"senha", item.getEntity().getSenha()));

					container.addContainerFilter(filter);
					container.applyFilters();

					Collection<Object> ids = container.getItemIds();

					if (ids.isEmpty()) {
						view.getLoginBt().setComponentError(
								new UserError("Erro ao realizar login"));
						Display.displayErrorMsg("Erro ao realizar login",
								"Verifique com atenção as informações digitadas");
					} else {
						VaadinSession.getCurrent().setAttribute("matricula",
								item.getEntity().getMatricula());
						UI.getCurrent().getNavigator()
								.navigateTo(AdminView.VIEW_NAME);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		view.getLogoutBt().addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getPage().setLocation("/gdg-pge");
				UI.getCurrent().getSession().close();
			}
		});
	}

}
