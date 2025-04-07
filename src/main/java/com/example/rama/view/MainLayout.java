package com.example.rama.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createDrawer();
    }

    private void createDrawer() {
        Image logo = new Image("images/logo.png","logo");
        logo.setWidth("180px");
        Span title = new Span("Sistema de Gestión");
        title.getStyle().set("margin-center", "20px");
        title.getStyle()
        .set("color", "Black")
        .set("font-family", "'Georgia', serif")
        .set("font-size", "26px");

        VerticalLayout layout = new VerticalLayout(logo, title);
        layout.getStyle().set("background-color", "#fdf5e6");
        layout.getStyle().set("height", "100vh");
        layout.setPadding(true);
        layout.setSpacing(true);
        layout.setAlignItems(Alignment.CENTER);

        RouterLink gruposLink = new RouterLink("Grupo", GrupoView.class);
        gruposLink.getStyle()
        .set("color", "Black")
        .set("font-family", "'Georgia', serif")
        .set("font-size", "16px");
        RouterLink MateriasLink = new RouterLink("Materia", MateriaView.class);
        MateriasLink.getStyle()
        .set("color", "Black")
        .set("font-family", "'Georgia', serif")
        .set("font-size", "16px");
        RouterLink ActividadesLink = new RouterLink("Actividades", classActivitiesView.class);
        ActividadesLink.getStyle()
        .set("color", "Black")
        .set("font-family", "'Georgia', serif")
        .set("font-size", "16px");

        layout.add(MateriasLink, ActividadesLink, gruposLink);
        addToDrawer(layout);
    }
}

