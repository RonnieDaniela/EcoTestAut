package EcoTestAut.EcoTestAut;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase04 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..//EcoTestAut//Drivers//chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize(); // Maximiza la ventana
		
		// Paso 1: Ingresar el correo 
		driver.findElement(By.id("email_create")).sendKeys("correo" + Math.random() + "@gmail.com");
		
		/* Otra forma de escribir el correo sería:
		 * WebElement txtEmail = driver.findElement(By.id("email_create"));
		 * txtEmail.sendKeys("correo07062022@mailinator.com");
		 */
				
		// Paso 2: Hacer clic en el botón Create an Account
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Es necesaria una espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tiempo máximo
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1"))); // Condicion de parada
		
		// Paso 3: Completar el formulario (Personal Information)
		driver.findElement(By.cssSelector("#id_gender1")).click(); // Clic sobre el radio button
		
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Arturo"); // Nombre
		
		driver.findElement(By.id("customer_lastname")).sendKeys("Torres"); // Apellido
		
		// Ingresar Contraseña
		WebElement txtPassword = driver.findElement(By.name("passwd"));
		txtPassword.clear();
		txtPassword.sendKeys("1q2w3e4r5t");
		
		// Selección del día
		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByValue("18");
		
		// Selección del mes
		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByVisibleText("June ");
		
		// Selección del año
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByIndex(30);
		
		driver.findElement(By.name("newsletter")).click(); // CheckBox Newsletter
		
		driver.findElement(By.cssSelector("#optin")).click(); // CheckBox Offers
		
		// Paso 4: Completar el formulario (My Address)
		driver.findElement(By.cssSelector("#company")).sendKeys("EcoSistemas");
		driver.findElement(By.cssSelector("#address1")).sendKeys("martin rodriguez,420");
		driver.findElement(By.cssSelector("#address2")).sendKeys("san martin 969");
		driver.findElement(By.cssSelector("#city")).sendKeys("CABA");
		
		Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
		state.selectByValue("6");
		
		driver.findElement(By.cssSelector("#postcode")).sendKeys("11596");
		driver.findElement(By.cssSelector("#other")).sendKeys("Esto es una Automatizacion JIJI");
		driver.findElement(By.cssSelector("#phone")).sendKeys("1133333333");
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("1166666666");
		driver.findElement(By.cssSelector("#alias"));
		txtPassword.clear();
		txtPassword.sendKeys("Aut "+Math.random());
		
		// Paso 5: Hacer clic en el botón Register
		driver.findElement(By.id("submitAccount")).click();
	}

}
