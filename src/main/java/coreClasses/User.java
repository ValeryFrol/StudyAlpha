package coreClasses;

import java.util.*;

public final class User {
    private final String name;
    private final String surname;
    private final int individORcorporate;
    private final String sex;
    private final String passportData;
    private final String address;
    private final String phone;
    private final String email;
    private final int id;
    private final String dateOfBirth;
    private final HashSet<Account> allUserAccounts = new HashSet<Account>();
    private boolean blocked = false;

    public User(String name, String surname, int individORcorporate, String sex, String passportData, String address, String phone, String email, int id, String dateOfBirth,boolean blocked) {
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
        this.blocked = blocked;

    }

    public boolean getBlocked() {
        return blocked;
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

    public Object getAllUserAccounts() {
        return allUserAccounts.clone();
    }

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
                this.allUserAccounts.equals(user.allUserAccounts); //think over this equals of two hashsets, i think it's not good
    }

    public void addAccount(Account account) {
        this.allUserAccounts.add(account);
    }

    public boolean closeAccount(Account account) {
        boolean remove = this.allUserAccounts.remove(account);
        return remove;
    }
}
