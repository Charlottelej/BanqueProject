package fr.banque;

import fr.util.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    @Test
    public void ajouteBienClient() throws ParseException {
    Bank bank = new Bank();
    Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris",DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
    bank.addClient(marc);
    assertThat(bank.isCustomer(marc)).isTrue();
        System.out.println(bank.listClients());
    }

    @Test
    public void supprimeBienClient(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1972-01-24"),"Limoges","Developper","test@test.com");
        bank.addClient(marc);
        bank.deleteClient(marc);
        assertThat(bank.isCustomer(marc)).isFalse();

    }

    @Test
    public void updateBienClient(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1977-12-12"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1990-12-24"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Customer machine2 = new Customer("Marc","Narf", "01010101202", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1977-12-12"),"Limoges","Ambuliancier","tesMachin@test.com");
        bank.updateClient(machine2);
        assertThat(marc).isEqualToComparingFieldByField(machine2);
    }

    @Test
    public void recupereBienListeClient(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        System.out.println(bank.listClients());
        assertThat(bank.listClients().isEmpty()).isFalse();
    }

    @Test
    public void ajouteBienCompte(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(machin));
        System.out.println(bank.listAccountsByCustomer(marc));
        assertThat(bank.listAccountsByCustomer(marc).contains(account)).isTrue();
        assertThat(bank.listAccountsByCustomer(machin).contains(account2)).isTrue();
    }

    @Test
    public void supprimeBienCompte(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(machin));
        bank.deleteAccount(account2);
       assertThat(bank.listAccountsByCustomer(marc).isEmpty()).isFalse();
       assertThat(bank.listAccountsByCustomer(machin).isEmpty()).isTrue();
    }

    @Test
    public void updateBienCompte(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        Account account3 = new Account("5541Z75", 50, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(marc));
        bank.updateAccount(account3);
        assertThat(bank.listAccounts()).containsExactly(account3, account);
    }

    @Test
    public void recupereBienListeCompte(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account1 = new Account("5541YB75", 50, LocalDate.now());
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(marc));
        bank.addAccount(account1, bank.recoverKey(machin));
        assertThat(bank.listAccounts().isEmpty()).isFalse();
    }
    @Test
    public void recupereBienListeCompteByCustomer(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account1 = new Account("5541YB75", 50, LocalDate.now());
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(marc));
        bank.addAccount(account1, bank.recoverKey(machin));
        assertThat(bank.listAccountsByCustomer(marc).isEmpty()).isFalse();
        assertThat(bank.listAccountsByCustomer(machin).isEmpty()).isFalse();
        assertThat(bank.listAccountsByCustomer(marc).contains(account)).isTrue();
        assertThat(bank.listAccountsByCustomer(machin).contains(account1)).isTrue();
    }

    @Test
    public void ajouteBienArgentDuCompte(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(marc));
        bank.depositMoney(50, account2);

    }

    @Test
    public void retireBienArgentDuCompte(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        Customer machin = new Customer("Marc","Machin", "0101010101", "rue de la ville, 75001 Paris", DateUtil.parseDate("1977-12-12"),"Bruxelles","Facteur","test3@test.com");
        bank.addClient(marc);
        bank.addClient(machin);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(marc));
       // bank.withdrawMoney(50, account);
        bank.addMovement(50, account2, account);
        bank.addMovement(20, account2, account);
        assertThat(account2.getBalance()).isEqualTo(70);
    }

    @Test
    public void lieBienComptesAClient(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        bank.addClient(marc);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 0, LocalDate.now());
        bank.linkAccountToCustomer(marc, account);
        bank.linkAccountToCustomer(marc, account2);
        assertThat(bank.listAccountsByCustomer(marc).contains(account)).isTrue();
    }


    @Test
    public void retourneSommeSoldeDesComptesDuClient(){
        Bank bank = new Bank();
        Customer marc = new Customer("Marc","Narf", "0101010101", "Boulevard de la villette, 75019 Paris", DateUtil.parseDate("1990-12-24"),"Limoges","Developper","test@test.com");
        bank.addClient(marc);
        Account account = new Account("30B", 150.50, DateUtil.parseDate("2000-12-30"));
        Account account2 = new Account("5541Z75", 20, LocalDate.now());
        bank.addAccount(account, bank.recoverKey(marc));
        bank.addAccount(account2, bank.recoverKey(marc));
        assertThat(bank.sumBalanceAllAccountofCustomer(marc)).isEqualTo(170.50);
    }

}
