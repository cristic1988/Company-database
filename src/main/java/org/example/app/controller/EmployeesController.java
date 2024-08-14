package org.example.app.controller;

import org.example.app.service.EmployeesService;
import org.example.app.utils.AppStarter;
import org.example.app.view.*;

public class EmployeesController {

    EmployeesService service = new EmployeesService();

    public void create() {
        EmployeesCreateView view = new EmployeesCreateView();
        view.getOutput(service.create(view.getData()));
        AppStarter.startApp();
    }

    public void read() {
        EmployeesReadView view = new EmployeesReadView();
        view.getOutput(service.read());
        AppStarter.startApp();
    }

    public void update() {
        EmployeesUpdateView view = new EmployeesUpdateView();
        view.getOutput(service.update(view.getData()));
        AppStarter.startApp();
    }

    public void delete() {

        EmployeesDeleteView view = new EmployeesDeleteView();
        view.getOutput(service.delete(view.getData()));
        AppStarter.startApp();
    }

    public void readById() {
        EmployeesReadByIdView view = new EmployeesReadByIdView();
        view.getOutput(service.readById(view.getData()));
        AppStarter.startApp();
    }
}
