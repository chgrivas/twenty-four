package com.twentyfour.ui.components;

import com.ejt.vaadin.loginform.LoginForm;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class LoginComponent extends CustomComponent {

    private static final long serialVersionUID = -1594300081042483217L;

    public LoginComponent() {
//        VerticalLayout panelContent = new VerticalLayout();
//        panelContent.setMargin(true);
//        panelContent.setSizeFull();
//        panelContent.addComponent(loginForm);
//        panelContent.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
//
        Label bigLabel1 = new Label("BIG LABEL1");
        Label bigLabel2 = new Label("BIG LABEL2");
        Label bigLabel3 = new Label("BIG LABEL3");

//        bigLabel.setHeight(Page.getCurrent().getBrowserWindowHeight()*2, Unit.PIXELS);
//        
//        Panel panel = new Panel();
//        panel.setContent(panelContent);
//        panel.setSizeFull();

        HorizontalLayout h1 = new HorizontalLayout();
        h1.addComponent(bigLabel1);
        h1.addComponent(bigLabel2);
        h1.addComponent(bigLabel3);
        h1.setHeight(3, Unit.EM);
        
        VerticalLayout root = new VerticalLayout();
        root.addComponent(h1);
//        root.addComponent(panel);
//        root.setMargin(true);
        
        root.setHeight(Page.getCurrent().getBrowserWindowHeight()*4, Unit.PIXELS);
        
        setCompositionRoot(root);
    }

}
