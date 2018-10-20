package coreClasses;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String surname;
    private int individORcorporate;
    private String sex;
    private String passportData;
    private String address;
    private String phone;
    private String email;
    private int id;
    private String dateOfBirth;
    private Map<String, Account> allUserAccounts = new HashMap<String, Account>();

    public User(String name, String surname, int individORcorporate, String sex, String passportData, String address, String phone, String email, int id, String dateOfBirth, HashMap allUserAccounts) {
        this.name = name;
        this.surname = surname;
        this.individORcorporate = individORcorporate;
        this.sex = sex;
        this.passportData = passportData;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.allUserAccounts = allUserAccounts;
    }

    public User(String name, String surname, int individORcorporate, String sex, String passportData, String address, String phone, String email, int id, String dateOfBirth, HashMap allUserAccounts, Account account) {
        this.name = name;
        this.surname = surname;
        this.individORcorporate = individORcorporate;
        this.sex = sex;
        this.passportData = passportData;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.allUserAccounts.put(account.createAccountNumber(), account);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public int getIndividORcorporate() {
        return individORcorporate;
    }

    public String getSex() {
        return sex;
    }

    public String getPassportData() {
        return passportData;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Map<String, Account> getAllUserAccounts() {
        return allUserAccounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public void setAllUserAccounts(Map<String, Account> allUserAccounts) {
        this.allUserAccounts = allUserAccounts;
    }


    //why cannot i place an annotation here? like @override

    public int hashCode(String dateOfBirth, String sex) {
        int hash = 5;
        hash = 31 * hash + (dateOfBirth == null ? 0 : dateOfBirth.hashCode());
        hash = 31 * hash + (sex == null ? 0 : sex.hashCode());
        return hash;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return this.name.equals(user.name) &&
                this.surname.equals(user.surname) &&
                this.individORcorporate == user.individORcorporate &&
                this.sex.equals(user.sex) &&
                this.passportData.equals(user.passportData) &&
                this.address.equals(user.address) &&
                this.phone.equals(user.phone) &&
                this.email.equals(user.email) &&
                this.id == user.id &&
                this.dateOfBirth.equals(user.dateOfBirth) &&
                this.allUserAccounts.keySet().equals(user.allUserAccounts.keySet());
    }

    public void addAccount(Account account) {
        this.allUserAccounts.put(account.createAccountNumber(), account);
    }

    public boolean closeAccount(Account account) {
        boolean remove = this.allUserAccounts.remove(account.createAccountNumber(), account);
        return remove;
    }

}
