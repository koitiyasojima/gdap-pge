package gov.gdg.messages;

import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

public class Display {

	public static void displayErrorMsg(String msg, String details) {
		Notification notif = new Notification(msg, details, Type.ERROR_MESSAGE);

		notif.setDelayMsec(10000);
		notif.setPosition(Position.TOP_CENTER);

		notif.show(Page.getCurrent());
	}

	public static void displayTrayMsg(String msg, String details) {
		Notification.show(msg, details, Type.TRAY_NOTIFICATION);
	}
}
