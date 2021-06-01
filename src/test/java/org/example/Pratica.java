package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pratica {
    //Cadastrar nova ocorrência com sucesso
    @Test
    public void cadastrarNovaOcorrencia(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");

        //efetuar login no sistema
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));

        usernameField.sendKeys("treinamento08");
        passwordField.sendKeys("123456");
        loginButton.click();

        //clicar em relatar caso

        WebElement relatarButton = driver.findElement(By.xpath("//a[@href='/bug_report_page.php']"));

        relatarButton.click();
        //selecionar categoria
        WebElement categoria = driver.findElement(By.name("category_id"));
        categoria.click();
        WebElement valorCategoria = driver.findElement(By.xpath("//option[@value='33']"));
        valorCategoria.click();

        //selecionarfrequencia
        WebElement frequencia = driver.findElement(By.name("reproducibility"));
        frequencia.click();
        WebElement valorFrequencia = driver.findElement(By.xpath("//option[@value='30']"));
        valorFrequencia.click();

        //selecionargravidade
        WebElement gravidade= driver.findElement(By.name("severity"));
        gravidade.click();
        WebElement valorGravidade = driver.findElement(By.xpath("//option[@value='20']"));
        valorGravidade.click();

        //Preencher Resumo
        WebElement resumo= driver.findElement(By.name("summary"));
        resumo.sendKeys("confirmado que foi sucesso");

        //Preencher Descricao
        WebElement descricao= driver.findElement(By.xpath("//td//textarea[@name='description']"));
        descricao.sendKeys("este nao funcionou so pelo name, tive que aprofundar");

        //Preencher Passos para reproduzir
        WebElement passos= driver.findElement(By.name("steps_to_reproduce"));
        passos.sendKeys("siga o passo a passo");

        //Clicar em enviar relatorio
        WebElement enviar= driver.findElement(By.xpath("//input[@class='button']"));
        enviar.click();

        //Verificar se é exibida a mensagem “Operação realizada com sucesso”
        WebElement mensagemSucesso= driver.findElement(By.xpath("//*[contains(text(), 'Operação realizada com sucesso.')]"));
        String recebeuSucesso = mensagemSucesso.getText();
        Assert.assertTrue(recebeuSucesso.contains("Operação realizada com sucesso."));

        //Verificar se a ocorrência foi salva com os dados informados



    }



}
