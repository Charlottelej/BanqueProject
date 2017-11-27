package fr.banque;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Bank {
    private String name;
    private String bankCode;
    private Map<Customer, Set<Account>> accountBook;
    private Set<Movement> movements;

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
        this.accountBook = new HashMap<>();
        this.movements = new HashSet<>();
    }

    public Bank() {
        this.accountBook = new HashMap<>();
        this.movements = new HashSet<>();
    }

    public void addClient (Customer customer){
        this.accountBook.putIfAbsent(customer, new HashSet<>());
    }

    public void deleteClient(Customer customer){
    }

    public void updateClient(Customer customer){}

    public List<Customer> listClients() {throw new NotImplementedException();}

    public void addAccount(Account account){}
    public void deleteAccount(Account account){}

    public void updateAccount (Account account){}

    public Set<Account> listAccount (){throw new NotImplementedException();}

    public void withdrawMoney(double money, Account account){}

    public void depositMoney (double money, Account account){}

    public void linkAccountToCustomer (Customer customer, Account account){}

    public Set<Account> listAccountsByCustomer (Customer customer){ throw  new NotImplementedException();}

    public double sumBalanceAllAccountofCustomer (Customer customer){ throw  new  NotImplementedException();}
}
