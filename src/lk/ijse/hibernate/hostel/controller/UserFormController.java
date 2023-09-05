package lk.ijse.hibernate.hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.hostel.bo.BOFactory;
import lk.ijse.hibernate.hostel.bo.custom.UserBO;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.util.Navigation;
import lk.ijse.hibernate.hostel.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {


    public TextField txtUserId;
    public TextField txtUserName;
    public TextField txtPass;
    public TextField txtRePass;
    public Label txtName;

    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);

    public void dashboardOnActio(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DashboardForm.fxml",event);
    }


    public void onActionCreateAccount(ActionEvent event) {
    String pass = txtPass.getText();
    String rePass = txtRePass.getText();
    String userId = txtUserId.getText();
    String userName = txtUserName.getText();

    if (checkDuplidate()){
        if (checkDuplidate()){
            if (pass.equals(rePass)){
                userBO.saveUser(new UserDTO(
                        userId,
                        userName,
                        pass
                ));
                new Alert(Alert.AlertType.CONFIRMATION, "USER ACCOUNT CREATE SUCCESS").show();
                    clearFeilds();
                    setUserId();
            } else {
                new Alert(Alert.AlertType.ERROR,"Check your pass word and try again").show();

            }
        }
    }else {
        new Alert(Alert.AlertType.ERROR,"This user id already get").show();
            clearFeilds();
    }


    }

    public boolean checkDuplidate(){
        String userId=txtUserId.getText ();
        List<UserDTO> allRoom = userBO.loadAll ();
        for (UserDTO u : allRoom) {
            if (userId.equals (u.getUserId ())){
                return false;
            }
        }
        return  true;
    }

    public void clearFeilds(){
        txtRePass.clear ();
        txtPass.clear ();
        txtUserId.clear ();
        txtUserName.clear ();
    }

    public String nextUserID() {
        Session session = SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction = session.beginTransaction ();

        Query query = session.createQuery ("select userId from User order by userId desc");

        String nextId = "U001";

        if (query.list ().size () == 0) {
            return nextId;
        } else {
            String id = (String) query.list ().get (0);

            String[] SUs = id.split ("U00");

            for (String a : SUs) {
                id = a;
            }

            int idNum = Integer.valueOf (id);

            id = "U00" + (idNum + 1);

            transaction.commit ();
            session.close ();

            return id;
        }
    }

    public void setUserId(){
        String userID=nextUserID ();
        txtUserId.setText (userID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUserId();
    }
}
