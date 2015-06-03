package gov.gdg.database;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class DBConnection {
	private static String UNIT_NAME = "gdg-pge";
	
	public static JPAContainer getContainer(Class klass){
		return JPAContainerFactory.make(klass, UNIT_NAME);
	}
}
