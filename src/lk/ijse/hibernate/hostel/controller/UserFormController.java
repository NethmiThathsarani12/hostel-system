package lk.ijse.hibernate.hostel.controller;

import javafx.event.ActionEvent;
import lk.ijse.hibernate.hostel.util.Navigation;

import java.io.IOException;

public class UserFormController {
    public void dashboardOnActio(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DashboardForm.fxml",event);
    }
}
