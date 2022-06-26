package EcoTestAut.EcoTestAut;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Clase02 {
	String url = "http://automationpractice.com/index.php";
	String chromeDriverPath = "..//EcoTestAut//Drivers//chromedriver.exe";
	
	@Test
	public void irAContactUs() {
		//Paso 1: Indicar donde esta el drivers
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		//Paso 2: Abrir el navegador en la pagina a probar
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url); //Es igual a drivers.get.(url)
		driver.manage().window().maximize(); //maximiza la ventana
		driver.manage().deleteAllCookies(); //borra los cookies
		
		//Paso 3: Hacer clic en el link Contact us
		driver.findElement(By.linkText("Contact us")).click();
		
		//Paso 4: Completar el formulario
		Select lista = new Select (driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Webmaster");
		driver.findElement(By.id("email")).sendKeys("correo2@correo.com.ar");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\fer_d\\Desktop");
		driver.findElement(By.cssSelector("#message")).sendKeys("Comentarios sobre el contacto");
		
		// Paso 5: Hacer clic en Send
		// driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
		
	}

}
