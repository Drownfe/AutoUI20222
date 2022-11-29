package com.nopcommerce.pom;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Desktops_Test {
	private WebDriver driver;
	Desktops getDesktops;
	
	
	@Before
	public void setUp() throws Exception {
		getDesktops = new Desktops(driver);
		driver = getDesktops.chromeDriverConnection();
		driver.manage().window().maximize(); 			
		getDesktops.visit("https://demo.nopcommerce.com/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		getDesktops.getInDesktops();
		
		assertEquals("Build your own computer", getDesktops.isBuildDisplayed()); //Verificación que la pantalla "Build your own computer" se está ejecutando
		
		getDesktops.selectList(); 			//Selección de RAM
		
		getDesktops.selectRadioButton(); 	//Selección de HDD y OS, Selección del Software, Click Botón
		
		getDesktops.getDataDesktop();		//almacenar los datos durante la compra
		
		getDesktops.selectFinished();		//Agrega al carrito
		
		getDesktops.isMessageDisplayed();	//Verificación de que el mensaje de alerta se está presentando
		
		getDesktops.getInShoppingCar();		//Ingreso a la página del carrito de compras
		
		getDesktops.isDesktopInCar();		//verificar que esta agregado el build your own
		
		getDesktops.getDataDesktopCar();	//guardar valores del carrito para desktop
		
		//comparar cosas pc, lo que se tomo mientras era creado y lo que se ve en el carrito (RESUMEN DE PARTES)
		assertEquals(getDesktops.descripDesktop, getDesktops.descripDesktopCar);
		
		//comparar cosas pc, lo que se tomo mientras era creado y lo que se ve en el carrito (PRECIOS)
		assertEquals(getDesktops.priceDesktop, getDesktops.priceDesktopCar);
		
		getDesktops.getInCamera();			//ingreso a la seccion de camaras
		
		assertEquals("Leica T Mirrorless Digital Camera", getDesktops.leicaDisplayed()); //la camara a elegir existe
		
		getDesktops.getDataCamera();		//agregar los datos de la camara al comprar
		
		getDesktops.getInLeica();			//ingresa y agrega la camara si existe
		
		getDesktops.isMessageDisplayed(); 	//el mensaje de agregado al carrito existe
		
		getDesktops.getInShoppingCar();		//regreso al carrito
		
		getDesktops.isCameraInCar();		//verificar que la camara está añadida al carrito
		
		getDesktops.getDataCameraCar();		//guardar valores del carrito para camera
		
		//comparar descripcion camara mientras era comprada a lo que aparece en el carrito
		assertEquals(getDesktops.descripCamera, getDesktops.descripCameraCar);
		
		//comparar precio camara mientras era comprada a lo que aparece en el carrito
		assertEquals( getDesktops.priceCamera, getDesktops.priceCameraCar);
		
	}
}
