package lk.ijse.hibernate.hostel.dto;

import lk.ijse.hibernate.hostel.entity.User;

public class UserDTO {
    private String UserName;
    private String PassWord;

    public User toEntity(){
        User user = new User();
        user.setUserName(this.UserName);
        user.setPassWord(this.PassWord);
        return user;
    }

    public UserDTO() {
    }

    public UserDTO(String userName, String passWord) {
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
        return "UserDTO{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }
}
