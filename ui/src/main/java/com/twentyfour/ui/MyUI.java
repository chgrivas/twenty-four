package com.twentyfour.ui;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.twentyfour.persistence.services.DatabaseServiceImpl;
import com.twentyfour.persistence.utils.TwentyFourConstants;
import com.twentyfour.service.DatabaseService;
import com.twentyfour.ui.views.MainView;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * Main UI class of the application.
 */
@Widgetset("com.twentyfour.widgetset.TwentyFourWidgetset")
@SuppressWarnings("serial")
public class MyUI extends UI {

    private Navigator navigator;

    EntityManager em = JPAContainerFactory.createEntityManagerForPersistenceUnit(TwentyFourConstants.PERSISTENCE_UNIT);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Twent-Four BETA");

        setImmediate(true);
        // Create navigator to control the views
        navigator = new Navigator(this, this);
        
        navigator.addView(MainView.NAME, MainView.class);
//        navigator.addView(LoginView.NAME, LoginView.class);
        
    }

    public static MyUI get() {
        return (MyUI) UI.getCurrent();
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet implements SessionInitListener, SessionDestroyListener {

        private static DatabaseService databaseService = new DatabaseServiceImpl();

        @Override
        protected void servletInitialized() throws ServletException {
            super.servletInitialized();
            getService().addSessionInitListener(this);
            getService().addSessionDestroyListener(this);

            // Init the database if it is not already initialized
            databaseService.init();
        }

        @Override
        public void sessionInit(SessionInitEvent event) throws ServiceException {
            System.out.println("Starting session...");
        }

        @Override
        public void sessionDestroy(SessionDestroyEvent event) {
            System.out.println("Ending session...");
        }
    }

}
