package Model;


public class User {
    String name, surname, password, creditCard;
    String birthDate;
    int balance;
    Long tcNumber;

    public User() {
    }

    public User(String name, String surName, String password, String birthDate, String creditCard, int balance, Long tcNumber) {
        this.name = name;
        this.surname = surName;
        this.password = password;
        this.birthDate = birthDate;
        this.creditCard = creditCard;
        this.balance = balance;
        this.tcNumber = tcNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (this.getPassword().contains(this.getBirthDate())) {
            throw new IllegalStateException("User Password doesn't contains birthdate");
        } else {
            this.password = password;
        }

    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(Long tcNumber) {
        this.tcNumber = tcNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", creditCard=" + creditCard +
                ", balance=" + balance +
                ", tcNumber=" + tcNumber +
                '}';
    }
}
