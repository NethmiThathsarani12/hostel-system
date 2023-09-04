package lk.ijse.hibernate.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.hostel.bo.BOFactory;
import lk.ijse.hibernate.hostel.bo.custom.UserBO;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.util.Navigation;

import java.io.IOException;

public class UserFormController {
    public TextField txtCurrentUsername;
    public TextField txtNewUsername;
    public TextField txtNewPassword;
    public TextField txtConfirmPassword;
    public Label txtUsername;
    public Label txtContact;
    public Label txtPassword;
    public Label txtName;

    UserBO userBO = (UserBO) BOFactory.getBO(BOFactory.BOTypes.USER);

    public void dashboardOnActio(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DashboardForm.fxml",event);
    }

    public void btnSaveChangesOnAction(ActionEvent event) {
        if(txtUsername.getText() .equals(txtCurrentUsername.getText())){
            if(txtNewPassword.getText() .equals(txtConfirmPassword.getText())){
                userBO.updateUser(new UserDTO(txtCurrentUsername.getText(), txtConfirmPassword.getText(), txtName.getText(), txtContact.getText()));
                new Alert(Alert.AlertType.CONFIRMATION,"Username and Password Updated Successfully").show();
                UserDTO user = userBO.searchUser(LoginFormController.username);

                txtName.setText(user.getName());
                txtUsername.setText(user.getUserName());
                txtPassword.setText(user.getPassword());
                txtContact.setText(user.getTel());
            }else{
                new Alert(Alert.AlertType.WARNING,"Passwords are not match").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Invalid Username").show();
        }

    }
}
