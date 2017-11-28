package fr.banque;

import fr.util.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;

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
    public void ajouteBienCompte(){}

    @Test
    public void supprimeBienCompte(){}

    @Test
    public void updateBienCompte(){}

    @Test
    public void recupereBienListeCompte(){}

    @Test
    public void retireBienArgentDuCompte(){}

    @Test
    public void ajouteBienArgentDuCompte(){}

    @Test
    public void lieBienComptesAClient(){}

    @Test
    public void recupereBienComptesDuClient(){
    }

    @Test
    public void retourneSommeSoldeDesComptesDuClient(){

    }

}
