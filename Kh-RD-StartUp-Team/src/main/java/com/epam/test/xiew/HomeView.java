package com.epam.test.xiew;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "greet")
public class HomeView extends Div
        implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
add(new TextArea("sdddd"));
    }

}
