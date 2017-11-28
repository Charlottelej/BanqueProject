package fr.banque;

import fr.util.date.DateUtil;

import java.time.LocalDate;

public class Customer {
    private String lastName;
    private String firstName;
    private String phone;
    private String adress;
    private int age;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String job;
    private String mail;

    public Customer(String lastName, String firstName, String phone, String adress, LocalDate dateNaissance, String lieuNaissance, String job, String mail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.adress = adress;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.age = DateUtil.calculAge(LocalDate.now(), dateNaissance);
        this.job = job;
        this.mail = mail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (dateNaissance != null ? !dateNaissance.equals(customer.dateNaissance) : customer.dateNaissance != null)
            return false;
        return lieuNaissance != null ? lieuNaissance.equals(customer.lieuNaissance) : customer.lieuNaissance == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (dateNaissance != null ? dateNaissance.hashCode() : 0);
        result = 31 * result + (lieuNaissance != null ? lieuNaissance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone=" + phone +
                ", adress='" + adress + '\'' +
                ", age=" + age +
                ", dateNaissance=" + dateNaissance +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", job='" + job + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
