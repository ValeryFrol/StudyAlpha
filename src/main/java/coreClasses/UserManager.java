package coreClasses;

public class UserManager {

    public User createNewUserWithoutAccount(String name, String surname, int individORcorporate, String sex, String passportData, String address, String phone, String email, int id, String dateOfBirth){
        User user = new User(name,surname,individORcorporate,sex,passportData,address,phone,email,id,dateOfBirth);
        return user;
    }
    public User createNewUserWithAccount(String name, String surname, int individORcorporate, String sex, String passportData, String address, String phone, String email, int id, String dateOfBirth, Account account){
        User user = new User(name,surname,individORcorporate,sex,passportData,address,phone,email,id,dateOfBirth,account);
        return user;

    }
    //todo add remove and update methods

}
