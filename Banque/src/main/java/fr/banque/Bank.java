package fr.banque;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Bank {

    private Map<Long, Set<Account>> accountBook;
    private Map<Long, Customer> customers;
    private Set<Movement> movements;


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
        accountBook.computeIfAbsent(intKey, k -> new HashSet<>());
    }
    public Long recoverKey(Customer customer){
        Long longKey= 0L;
        for(Map.Entry<Long, Customer> entry : this.customers.entrySet()){
            if(entry.getValue().equals(customer)){
                longKey= entry.getKey();
            }
        }
        return longKey;
    }
    public Long recoveryKeyAccounts(Set<Account> accounts){
        Long longkey = 0L;
        for(Long idClients : accountBook.keySet()){
            if(idClients.equals(accounts)){
                longkey= idClients;
            }
        }
        return longkey;
    }
    public Long recoveryKeyAccounts(Account account){
        Long id = 0L;
        for(Map.Entry<Long, Set<Account>> entry : accountBook.entrySet()){
            if(entry.getValue().contains(account)){
                id= entry.getKey();
            }
        }
        return id;
    }

    public void deleteClient(Customer customer){
        if(isCustomer(customer)){
            Long intCustomer= recoverKey(customer);
            this.customers.remove(intCustomer);
          this.accountBook.remove(intCustomer);
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

    public void addAccount(Account account, Long idClient){
        if(accountBook.entrySet().stream().noneMatch(c->c.getValue().equals(account))){
            Set<Account> accounts = accountBook.get(idClient);
            accounts.add(account);
            accountBook.replace(idClient, accountBook.get(idClient), accounts);
        }
    }
    public void deleteAccount(Account account){
          /*  for(Set<Account> accounts : accountBook.values()){
                if(accounts.contains(account)){
                   accounts.remove(account);
                }
            }*/
           accountBook.values().stream().filter(c->c.contains(account)).forEach(c->c.remove(account));
    }

    public void updateAccount (Account account){
        Long id = recoveryKeyAccounts(account);
        accountBook.get(id).removeIf(c->c.equals(account));
        if(!accountBook.get(id).contains(account) && !accountBook.entrySet().contains(account)) {
            accountBook.get(id).add(account);
        }
    }

    public Set<Account> listAccounts(){
        Set<Account> accounts= new HashSet<>();
       for(Map.Entry<Long, Set<Account>> entry : accountBook.entrySet()){
           accounts.addAll(entry.getValue());
       }
       return accounts;
        //throw new NotImplementedException();
    }
    public Set<Account> listAccountsByCustomer (Customer customer){
        return accountBook.get(recoverKey(customer)).stream().collect(Collectors.toSet());
        //throw new NotImplementedException();
    }

    public void withdrawMoney(double money, Account account){
        account.setBalance(account.getBalance()-money);
        updateAccount(account);
    }

    public void depositMoney (double money, Account account){
        account.setBalance(account.getBalance()+money);
        updateAccount(account);
    }
    public int recupMovementNumber(){
        return (movements.size()-1)+1;
    }
    public void addMovement(double money, Account recipientAccount, Account originalAccount){
        movements.add(new Movement(recupMovementNumber()+1, recipientAccount, originalAccount, money, LocalDate.now()));
        withdrawMoney(money, originalAccount);
        depositMoney(money, recipientAccount);
    }

    public Set<Movement> getAllMovements(){
        return movements;
    }

    public void linkAccountToCustomer (Customer customer, Account account){

    }


    public double sumBalanceAllAccountofCustomer (Customer customer){ throw  new  NotImplementedException();}
    
}
