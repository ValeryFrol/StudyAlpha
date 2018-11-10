package coreClasses;

public class UserManager {

    public User createNewUserWithoutAccount(String name, String surname, int individORcorporate, String sex, String passportData, String address, String phone, String email, int id, String dateOfBirth, boolean block) {
        User user = new User(name, surname, individORcorporate, sex, passportData, address, phone, email, id, dateOfBirth, block);
        return user;
    }

    public User blockOrUnblockUser(User user, boolean block) {
        User newUser = new User(user.getName(), user.getSurname(), user.getIndividORcorporate(), user.getSex(), user.getPassportData(), user.getAddress(), user.getPhone(), user.getEmail(), user.getId(), user.getDateOfBirth(), block);
        return newUser;
    }

    public User changeUserName(User user, String name) {
        User newUser = new User(name, user.getSurname(), user.getIndividORcorporate(), user.getSex(), user.getPassportData(), user.getAddress(), user.getPhone(), user.getEmail(), user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changeUserSurname(User user, String surname) {
        User newUser = new User(user.getName(), surname, user.getIndividORcorporate(), user.getSex(), user.getPassportData(), user.getAddress(), user.getPhone(), user.getEmail(), user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changeIndividOrCorporate(User user, int individOrCorporate) {
        User newUser = new User(user.getName(), user.getSurname(), individOrCorporate, user.getSex(), user.getPassportData(), user.getAddress(), user.getPhone(), user.getEmail(), user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changePassportData(User user, String passportData) {
        User newUser = new User(user.getName(), user.getSurname(), user.getIndividORcorporate(), user.getSex(), passportData, user.getAddress(), user.getPhone(), user.getEmail(), user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changeAddress(User user, String address) {
        User newUser = new User(user.getName(), user.getSurname(), user.getIndividORcorporate(), user.getSex(), user.getPassportData(), address, user.getPhone(), user.getEmail(), user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changePhone(User user, String phone) {
        User newUser = new User(user.getName(), user.getSurname(), user.getIndividORcorporate(), user.getSex(), user.getPassportData(), user.getAddress(), phone, user.getEmail(), user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changeEmail(User user, String email) {
        User newUser = new User(user.getName(), user.getSurname(), user.getIndividORcorporate(), user.getSex(), user.getPassportData(), user.getAddress(), user.getPhone(), email, user.getId(), user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public User changeId(User user, int id) {
        User newUser = new User(user.getName(), user.getSurname(), user.getIndividORcorporate(), user.getSex(), user.getPassportData(), user.getAddress(), user.getPhone(), user.getEmail(), id, user.getDateOfBirth(), user.getBlocked());
        return newUser;
    }

    public boolean removeUser(User user) {
        //go to DB and delete all info about this user from working bases and transfer it to the archive
        //check if it was deleted and transfered, then return true or false (if exceptions take place, catch them and process them
        user = null;
        return true;
    }
}
