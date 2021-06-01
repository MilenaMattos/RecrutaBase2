package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExemplosSelenium {

    @Test
    public void helloWorld(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        Assert.assertEquals("Google", driver.getTitle());

      driver.quit();
    }
    //acessar osistema mantis
    //preencher usuario
    //prencher senha
    //clicar em login
    //usuario autenticado com sucesso
    @Test
    public void efetuarLoginComSucesso(){
        //linha de baixo, chama o google chrome
        WebDriver driver = new ChromeDriver();

        //linha de baixo, navega até o site
        driver.navigate().to("http://mantis-prova.base2.com.br");


        //WebElement mostra como encontro o elemento
        WebElement usernameFild = driver.findElement(By.name("username"));
        WebElement passwordFild = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));

        //na linha de baixo, send_keys envia o texto para onde quero. e o click clica no botao
        usernameFild.sendKeys("treinamento01");
        passwordFild.sendKeys("123456");
        loginButton.click();

        WebElement usuarioLogadoText = driver.findElement(By.xpath("//td[@class='login-info-left']/span[@class='italic']"));
        String usuarioLogado = usuarioLogadoText.getText();
        Assert.assertEquals("Treinamento01",usuarioLogado);

    }

    @Test
    public void exemploSincronizacao(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://blackmirror.crowdtest.me.s3-website-us-east-1.amazonaws.com/register/device");

        WebElement prosseguirButton = driver.findElement(By.linkText("Prosseguir"));
        prosseguirButton.click();

        WebElement emailField = driver.findElement(By.id("login"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement entrarButton = driver.findElement(By.xpath("//button[text()='ENTRAR']"));

        emailField.sendKeys("jose.mario@base2.com.br");
        passwordField.sendKeys("123456");
        entrarButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);


        WebElement erroText = driver.findElement(By.xpath("//p[@class='login-error']/span[@class='error-msg']"));
        wait.until(ExpectedConditions.visibilityOf(erroText));
        String erroExibido= erroText.getText();
        Assert.assertEquals("E-mail ou senha inválidos.",erroExibido);


    }
}
