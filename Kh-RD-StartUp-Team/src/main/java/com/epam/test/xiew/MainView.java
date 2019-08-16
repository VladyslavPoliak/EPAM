package com.epam.test.xiew;

import com.epam.test.entity.Employee;
import com.epam.test.repo.EmployeeRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@Theme(value = Lumo.class, variant = Material.LIGHT)
public class MainView extends VerticalLayout {

    private final EmployeeRepo employeeRepo;

    private Grid<Employee> grid = new Grid<>(Employee.class);

    @Autowired
    public MainView(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
        grid.setItems(employeeRepo.findAll());
        grid.setHeight("200");
        add(grid);
        addButtons();
        addTextFields();
        routerLink();
        addLogin();
        addLoginFirm();
    }

    private void addLoginFirm() {
        LoginForm loginForm = new LoginForm();
        add(loginForm);
        loginForm.addLoginListener(event -> Notification.show(event.getPassword() + " " + event.getUsername()));

    }

    private void addLogin() {
        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.addLoginListener(e -> {
            loginOverlay.close();
            Notification.show("safsdf", 3000, Notification.Position.MIDDLE);
        });
        Button open = new Button("Open login overlay",
                e -> loginOverlay.setOpened(true));
        add(open);
    }

    private void routerLink() {
        Div menu = new Div();
        menu.add(new RouterLink("Home", HomeView.class, "default"));
        menu.add(new RouterLink("Greeting", GreetingComponent.class, "default"));
        add(menu);

    }

    private void addButtons() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setPadding(true);
        horizontalLayout.setSpacing(true);
        horizontalLayout.setSizeFull();

        Button button = new Button("Click ", VaadinIcon.ALARM.create());
        button.addThemeName("primary");
        Button button2 = new Button("Click ", VaadinIcon.AMBULANCE.create());
        Button button3 = new Button("Click ", VaadinIcon.FACEBOOK_SQUARE.create());
        Button button4 = new Button("Click ", VaadinIcon.YOUTUBE.create());
        Button button5 = new Button("Click ", VaadinIcon.USER_CHECK.create());
        RichTextEditor richTextEditor = new RichTextEditor();
        horizontalLayout.add(button, button3, button5, button4, button2);

        add(horizontalLayout);
        add(richTextEditor);
    }

    private void addTextFields() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.setPadding(true);
        horizontalLayout.setMargin(true);

        TextField textField = new TextField("ggg");
        textField.addFocusListener(e ->
                Notification.show("focus"));
        textField.addValueChangeListener(e ->
                Notification.show(textField.getValue())
        );
        horizontalLayout.add(textField);
        horizontalLayout.add(new TextField("hello"));
        horizontalLayout.add(new TextField("hello2"));

        add(horizontalLayout);


    }
}
