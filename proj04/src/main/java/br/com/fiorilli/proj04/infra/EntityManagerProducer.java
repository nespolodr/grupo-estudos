package br.com.fiorilli.proj04.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class EntityManagerProducer {

	@Inject
	@PersistenceUnitName("default")
	private EntityManagerFactory entityManagerFactory;

	@Produces
	@RequestScoped
	protected EntityManager createEntityManager() {
		
		Properties configuracaoValida;
		
		Properties configuracaoExternaProperties = new Properties();
		try {
			configuracaoExternaProperties.load(new FileInputStream(new File("C:\\fiorilli\\banco.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResourceBundle resourceInterno = ResourceBundle.getBundle("banco-dados");
		Properties configuracaoInternaProperties = convertResourceBundleToProperties(resourceInterno);
		
		if(configuracaoExternaProperties.isEmpty())
		{
			configuracaoValida = configuracaoInternaProperties;
		} else {
			configuracaoValida = configuracaoExternaProperties;
		}
		
		String ip = configuracaoValida.getProperty("jdbc_ip_value");
		String port = configuracaoValida.getProperty("jdbc_port_value");
		String database = configuracaoValida.getProperty("jdbc_database");
		String urlProperties = configuracaoValida.getProperty("jdbc_url_value");
		
		String urlTratada = MessageFormat.format(urlProperties, ip, port, database);

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("javax.persistence.jdbc.user", configuracaoValida.getProperty("jdbc_user_value"));
		jpaProperties.setProperty("javax.persistence.jdbc.password", configuracaoValida.getProperty("jdbc_password_value"));
		jpaProperties.setProperty("javax.persistence.jdbc.driver", configuracaoValida.getProperty("jdbc_driver_value"));
		jpaProperties.setProperty("hibernate.dialect", configuracaoValida.getProperty("dialect_value"));
		jpaProperties.setProperty("javax.persistence.jdbc.url", urlTratada);
		
		return entityManagerFactory.createEntityManager(jpaProperties);
	}

	public void closeEntityManager(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
	
	   private static Properties convertResourceBundleToProperties(ResourceBundle resource) {
	        Properties properties = new Properties();
	 
	        Enumeration<String> keys = resource.getKeys();
	        while (keys.hasMoreElements()) {
	            String key = keys.nextElement();
	            properties.put(key, resource.getString(key));
	        }
	 
	        return properties;
	    }
}
