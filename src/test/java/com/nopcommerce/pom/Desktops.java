package com.nopcommerce.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Desktops extends Base {
	//Localizador del link para ingresar a la página de "COMPUTERS"
	By computersLinkLocator = By.xpath("//a[@href='/computers']"); 
	
	//página de "DESKTOPS"
	By desktopsLinkLocator = By.linkText("Desktops"); 
	
	//localizador electronicos
	By electronicsLinkLocator = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"); 
	
	//localizador camara por texto
	By cameraLinkLocator = By.linkText("Camera & photo"); 
	
	//Verificador de página de "Desktops"
	By desktopsPageLocator = By.xpath("//img[@src='https://demo.nopcommerce.com/images/thumbs/0000020_build-your-own-computer_415.jpeg']"); 
	
	//Verificador de página de "Computers"
	By computersPageLocator = By.xpath("//img[@src='https://demo.nopcommerce.com/images/thumbs/0000002_desktops_450.jpg']"); 
	
	//verificador de pagina camara
	By cameraPageLocator = By.xpath("//img[@src='https://demo.nopcommerce.com/images/thumbs/0000006_camera-photo_450.jpeg']");
	
	//verificar que existe el link para entrar al "Leica"
	By leicaPageLocator = By.linkText("Leica T Mirrorless Digital Camera");
	
	//boton que permite agregar a "Leica" al carrito
	By addLeicaToCarLocator = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]");
	
	//carrito de el "Build your own"
	By addToCarBtnLocator = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]"); 
	
	//Verificador de página de "Build your own"
	By buildPageLocator = By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[1]"); 
	
	//Localizador de la lista desplegable de la RAM
	By dropListRamLocator = By.id("product_attribute_2");
	
	//localizador de la lista desplegable de procesador
	By dropListCpuLocator = By.id("product_attribute_1"); 
	
	//Localizador del radio button del HDD	
	By radioBtnLocator = By.id("product_attribute_3_7"); 
	
	//localizador del disco duro en texto
	By hddLocator = By.xpath("//*[@id=\"product_attribute_input_3\"]/ul/li[2]/label");

	//localizador del os
	By osLocator = By.xpath("//*[@id=\"product_attribute_input_4\"]/ul/li[2]/label");
	
	//localizador software
	By soft1Locator = By.xpath("//*[@id=\"product_attribute_input_5\"]/ul/li[1]/label");
	
	//localizador software
	By soft2Locator = By.xpath("//*[@id=\"product_attribute_input_5\"]/ul/li[2]/label");
	
	//localizador del precio
	By priceLocator = By.id("price-value-1");
	
	//Localizador del radio button del OS
	By radioBtnLocator2 = By.id("product_attribute_4_9"); 
	
	//Localizador del checklist del Software
	By checkListLocator = By.id("product_attribute_5_11"); 
	
	//Localizador del carro del "build your own" al elegir partes
	By addCarBtnLocatorFinished = By.id("add-to-cart-button-1"); 
	
	//localizador mensaje de alerta por id para camara
	By alertMessageLocator = By.id("bar-notification");
	
	//Localizador general del Carrito de compras
	By shoppingCartBtnLocator = By.linkText("Shopping cart"); 
	
	//localizador precio camara "Leica"
	By cameraPriceLocator = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[1]/span");
	
	//localizador del resume de la compra del Desktop en el carrito
	By shopCartDesktopResume = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/div[1]");
	
	//localizador del precio del desktop en el carrito
	By shopCartDesktopPrice = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[4]/span");

	//localizador del resume de la camara en el carrito
	By shopCartCameraResume = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[3]/a");
	
	//localizador del precio de la camra en el carrito
	By shopCartCameraPrice = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[4]/span");
	
	//localizador del pc en el carrito en caso de que haya sido agregado
	By dektopCarLocator = By.linkText("Build your own computer");
	
	
	public Desktops(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	String descripDesktop, priceDesktop ,descripCamera, priceCamera, priceDesktopCar, priceCameraCar, descripDesktopCar,descripCameraCar;
	
	public boolean isDesktopInCar() throws InterruptedException{
		Thread.sleep(1000);
		return isDisplayed(dektopCarLocator);
	}
	
	public boolean isCameraInCar() throws InterruptedException{
		Thread.sleep(1000);
		return isDisplayed(leicaPageLocator);
	}
	
	//metodo que obtiene los valores del equipo mientras es creado
	public void getDataDesktop() {
		String cpu,ram, hdd, os, soft1, soft2;
		Select selectRamListDrop = new Select(findElement(dropListRamLocator));
		ram = selectRamListDrop.getFirstSelectedOption().getText();
		
		Select selectCpuListDrop = new Select(findElement(dropListCpuLocator));
		cpu = selectCpuListDrop.getFirstSelectedOption().getText();
		
		hdd = findElement(hddLocator).getText();
		
		os = findElement(osLocator).getText();
		
		soft1 = findElement(soft1Locator).getText();
				
		soft2 = findElement(soft2Locator).getText();
		
		priceDesktop = findElement(priceLocator).getText();
		
		
		
		System.out.print(	"Processor: " 	+ cpu 	+ "\n" + 
							"RAM: " 		+ ram 	+ "\n" +
							"HDD: " 		+ hdd 	+ "\n" +
							"OS: " 			+ os 	+ "\n" +
							"Software: " 	+ soft1 + "\n" +
							"Software: " 	+ soft2 + "\n" + 
							"precio: " 		+ priceDesktop);
		
		descripDesktop = (	
					"Processor: " 	+ cpu 	+ "\n" + 
					"RAM: " 		+ ram 	+ "\n" +
					"HDD: " 		+ hdd 	+ "\n" +
					"OS: " 			+ os 	+ "\n" +
					"Software: " 	+ soft1 + "\n" +
					"Software: " 	+ soft2);
	}
	
	public void getDataCamera() {
		descripCamera = findElement(leicaPageLocator).getText();
		priceCamera = findElement(cameraPriceLocator).getText();
		
		System.out.print(descripCamera +"\n"+ 
						priceCamera);
		
	}
	
	public void getDataDesktopCar() {
		descripDesktopCar = findElement(shopCartDesktopResume).getText();
		priceDesktopCar = findElement(shopCartDesktopPrice).getText();
	}
	
	public void getDataCameraCar() {
		descripCameraCar = findElement(shopCartCameraResume).getText();
		priceCameraCar = findElement(shopCartCameraPrice).getText();
	}
	
	//Método para ingresar al link de Desktops
	public void getInDesktops() throws InterruptedException { 
		click(computersLinkLocator);
		Thread.sleep(2000);
		if(isDisplayed(computersPageLocator)) {
			click(desktopsLinkLocator);
			click(addToCarBtnLocator);
			Thread.sleep(2000);
		}else {
			System.out.println("Desktops pages was not found");
		}
	}
	
	//Método para ingresar al link de Camera & photo
	public void getInCamera() throws InterruptedException { 
		click(electronicsLinkLocator);
		Thread.sleep(2000);
		if(isDisplayed(cameraPageLocator)) {
			click(cameraLinkLocator);
			Thread.sleep(2000);
		}else{
			System.out.println("Camera page was not found");
		}
	}
	
	//Ingresa en la elección de leica
	public void getInLeica() throws InterruptedException {
		if(isDisplayed(leicaPageLocator)) {
			click(addLeicaToCarLocator);
		}
		else{
		System.out.println("Leica page was not found");
		}
	}
	
	//Método para verificar que si esté en la pantalla de Desktops
	public boolean isDesktopsDisplayed() { 
		return isDisplayed(desktopsPageLocator); 
	}
	
	//Método para verificar que si esté en la pantalla de "Build your own computer"
	public String isBuildDisplayed() { 
		return getText(buildPageLocator);
	}
	
	//Metodo leica se esta presentando en pantalla
	public String leicaDisplayed() {
		return getText(leicaPageLocator);
	}
	
	//Método para automatizar la selección de la lista desplegable de la RAM
	public void selectList() throws InterruptedException {  
		Thread.sleep(2000);
		Select selectListDrop = new Select(findElement(dropListRamLocator));
		selectListDrop.selectByIndex(2);	
	}
	
	//Método para seleccionar una opción en HDD y OS, seleccionar una segunda opción en Software y agregar al carro de compras
	public void selectRadioButton() throws InterruptedException {		
		click(radioBtnLocator);
		click(radioBtnLocator2);
		click(checkListLocator);
		Thread.sleep(3000);
	}
	
	//Metodo para terminar el proceso de compra de "BYO"
	public void selectFinished() throws InterruptedException {
		Thread.sleep(2000);
		click(addCarBtnLocatorFinished);
	}
	
	//Método para verificar que si el mensaje de alerta se está ejecutando
	public boolean isMessageDisplayed() { 
		return isDisplayed(alertMessageLocator);
	}
	
	//Método para seleccionar una opción en HDD y OS, seleccionar una segunda opción en Software y agregar al carro de compras
	public void getInShoppingCar() throws InterruptedException {		
		Thread.sleep(2000);
		click(shoppingCartBtnLocator);
	}
	

}
