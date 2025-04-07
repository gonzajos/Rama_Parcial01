package com.example.rama.view;

import com.example.rama.model.ClassActivities;
import com.example.rama.service.ClassActivitiesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "actividades", layout = MainLayout.class)
@PageTitle("Actividades | Sistema")
public class classActivitiesView extends VerticalLayout {

    private final ClassActivitiesService service;
    private final Grid<ClassActivities> grid = new Grid<>(ClassActivities.class);

    private final TextField descriptionField = new TextField("Descripción");
    private final TextField docenteField = new TextField("Docente");
    private final TextField dateField = new TextField("Fecha");
    private final Button saveButton = new Button("Guardar");

    private ClassActivities selectedActivity;

    public classActivitiesView(ClassActivitiesService service) {
        this.service = service;

        add(new H1("Información de Actividades"));

        HorizontalLayout fieldsLayout = new HorizontalLayout(descriptionField, docenteField, dateField);
        fieldsLayout.setSpacing(true);

        saveButton.addClickListener(e -> saveOrUpdateActivity());
        saveButton.getStyle().set("background-color", "#007bff").set("color", "white");

        VerticalLayout formLayout = new VerticalLayout(fieldsLayout, saveButton);

        configureGrid();

        add(formLayout, grid);
        updateGrid();
    }

    private void configureGrid() {
        grid.removeAllColumns();
        grid.addColumn(ClassActivities::getDescription).setHeader("Descripción");
        grid.addColumn(ClassActivities::getDocente).setHeader("Docente");
        grid.addColumn(ClassActivities::getDate).setHeader("Fecha");

        grid.addComponentColumn(activity -> {
            Button editButton = new Button("Editar", e -> editActivity(activity));
            Button deleteButton = new Button("Eliminar", e -> {
                service.delete(activity);
                Notification.show("Actividad eliminada");
                updateGrid();
            });
            deleteButton.getStyle().set("color", "red");
            return new HorizontalLayout(editButton, deleteButton);
        }).setHeader("Acciones");

        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    }

    private void updateGrid() {
        grid.setItems(service.findAll());
        clearForm();
    }

    private void saveOrUpdateActivity() {
        if (selectedActivity == null) {
            selectedActivity = new ClassActivities();
        }

        selectedActivity.setDescription(descriptionField.getValue());
        selectedActivity.setDocente(docenteField.getValue());
        selectedActivity.setDate(dateField.getValue());

        service.save(selectedActivity);
        Notification.show("Actividad guardada o actualizada");
        updateGrid();
    }

    private void editActivity(ClassActivities activity) {
        this.selectedActivity = activity;
        descriptionField.setValue(activity.getDescription());
        docenteField.setValue(activity.getDocente());
        dateField.setValue(activity.getDate());
    }

    private void clearForm() {
        selectedActivity = null;
        descriptionField.clear();
        docenteField.clear();
        dateField.clear();
    }
} 
