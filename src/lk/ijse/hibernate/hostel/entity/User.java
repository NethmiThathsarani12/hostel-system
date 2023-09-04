package lk.ijse.hibernate.hostel.entity;

import lk.ijse.hibernate.hostel.dto.UserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_name", length = 20)
    private String UserName;
    @Column(name = "user_password")
    private String PassWord;

    public UserDTO toDto(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(this.UserName);
        userDTO.setPassWord(this.PassWord);
        return userDTO;
    }

    public User() {
    }

    public User(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }
}
