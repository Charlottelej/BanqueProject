package fr.banque;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    @Test
    public void ajouteBienClient(){
    Bank bank = new Bank();
    Customer marc = new Customer("Marc","Narf", 0101010101, "Boulevard de la villette, 75019 Paris", 40, "Developper","test@test.com");
    bank.addClient(marc);
    assertThat(bank.isCustomer(marc)).isTrue();
    }

    @Test
    public void supprimeBienClient(){}

    @Test
    public void updateBienClient(){

    }

    @Test
    public void recupereBienListeClient(){}


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
