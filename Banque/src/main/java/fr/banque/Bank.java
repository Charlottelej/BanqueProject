package fr.banque;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Bank {
    private String name;
    private String bankCode;
    private Map<Customer, Set<Account>> accountBook;
    private Map<Long, Customer> customers;
    private Set<Movement> movements;

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
        this.accountBook = new HashMap<>();
        this.customers = new HashMap<>();
        this.movements = new HashSet<>();
    }

    public Bank() {
        this.accountBook = new HashMap<>();
        this.customers = new HashMap<>();
        this.movements = new HashSet<>();
    }

    public void addClient (Customer customer){
        Long intKey= 0L;

            for(Long keys : this.customers.keySet()){
                intKey = keys;
            }

      intKey+=1;
        this.customers.putIfAbsent(intKey,customer);
    }

    public void deleteClient(Customer customer){
       Long intCustomer = null;
        if(isCustomer(customer)){
            for(Map.Entry<Long, Customer> entry : this.customers.entrySet()){
                if(entry.getValue().equals(customer)){
                    intCustomer= entry.getKey();
                }
            }
            this.customers.remove(intCustomer);
        }
    }
    public boolean isCustomer(Customer customer){
        return this.customers.containsValue(customer);
    }

    public void updateClient(Customer customer){
        Long intCustomer = null;
        for(Map.Entry<Long, Customer> entry : this.customers.entrySet()){
            if(entry.getValue().equals(customer)){
                customers.replace(entry.getKey(), entry.getValue(), customer);
            }
        }
    }

    public List<Customer> listClients() {
        return new ArrayList<>(this.customers.values());
    }

    public void addAccount(Account account){}
    public void deleteAccount(Account account){}

    public void updateAccount (Account account){}

    public Set<Account> listAccount (){throw new NotImplementedException();}

    public void withdrawMoney(double money, Account account){}

    public void depositMoney (double money, Account account){}

    public void linkAccountToCustomer (Customer customer, Account account){}

    public Set<Account> listAccountsByCustomer (Customer customer){ throw  new NotImplementedException();}

    public double sumBalanceAllAccountofCustomer (Customer customer){ throw  new  NotImplementedException();}

    public Map<Long, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Long, Customer> customers) {
        this.customers = customers;
    }
}
