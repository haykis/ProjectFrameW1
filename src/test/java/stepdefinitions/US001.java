package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.MedunnaMainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001 {

    MedunnaMainPage mainPage=new MedunnaMainPage();
    Faker faker = new Faker();

    @Given("madunna ana sayfasina gider")
    public void madunnaAnaSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("madunnaUrl"));
    }

    @And("ana sayfa giris ikonuna tiklar")
    public void anaSayfaGirisIkonunaTiklar() {

        mainPage.signInRegister.click();
        Driver.bekle(1);


    }

    @And("Register butonuna tiklar")
    public void registerButonunaTiklar() {
        mainPage.registerAnasayfa.click();
        Driver.bekle(1);


    }

    @And("SSN kutusuna uygun ssn girer")
    public void ssnKutusunaUygunSsnGirer() {
       // mainPage.SSN.sendKeys("256-56-8985"+ Keys.TAB);
        mainPage.SSN.sendKeys
          (faker.random().nextInt(100,899)+"-"+faker.random().nextInt(10,99)+"-"+faker.random().nextInt(1000,8999)+Keys.TAB);

    }

    @Then("hata nesajinin cikmadigini test eder")
    public void hataNesajininCikmadiginiTestEder() {
        Assert.assertTrue("Ssn bolune eksik/hatali giris",mainPage.SsnDogrula.isDisplayed());
    }

    @And("tarayiciyi kapatir")
    public void tarayiciyiKapatir() {
        Driver.closeDriver();
    }
}
