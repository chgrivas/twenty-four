package com.twentyfour.ui.views;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {

    public static final String NAME = "";

    Navigator navigator;

    public MainView() {
    }

    @Override
    public void enter(ViewChangeEvent event) {
        System.out.println("Inside " + NAME);

        TextField text = new TextField("Post a question or a statement.");
        text.addTextChangeListener(new TextChangeListener() {
            
            @Override
            public void textChange(TextChangeEvent event) {

                System.out.println("text changed");                
            }
        });;
        
        text.addValueChangeListener(new ValueChangeListener(){

            @Override
            public void valueChange(ValueChangeEvent event) {

                System.out.println("value changed");                
                
            }
            
        });
        Button button = new Button("Submit", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                event.getComponent().getParent().
                System.out.println("button pressed");
            }
        });

        button.
        addComponent(text);
        addComponent(button);

    }

}
