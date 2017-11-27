package fr.banque;

public class Customer {
    private String lastName;
    private String firstName;
    private long phone;
    private String adress;
    private int age;
    private String job;
    private String mail;

    public Customer(String lastName, String firstName, long phone, String adress, int age, String job, String mail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.adress = adress;
        this.age = age;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (phone != customer.phone) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (adress != null ? !adress.equals(customer.adress) : customer.adress != null) return false;
        if (job != null ? !job.equals(customer.job) : customer.job != null) return false;
        return mail != null ? mail.equals(customer.mail) : customer.mail == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (int) (phone ^ (phone >>> 32));
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer : " +
                "lastName = " + lastName +
                ", firstName = " + firstName +
                ", phone =" + phone +
                ", adress = " + adress +
                ", age = " + age +
                ", job = " + job  +
                ", mail = " + mail + ";";
    }
}
