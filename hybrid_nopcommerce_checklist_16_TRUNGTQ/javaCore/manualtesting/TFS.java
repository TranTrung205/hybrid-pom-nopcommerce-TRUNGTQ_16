
package manualtesting;

import automationtesting.Selenium;

public class TFS {
	public static void main(String[] argr) {
		//Khai bao va khoi tao mot doi tuong moi cua class Selenium
		Selenium selenium = new Selenium();
		System.out.println("Public: " + selenium.version);
		System.out.println(selenium.getVersion());
		selenium.setVersion("4.0.0");
		System.out.println("Public: " + selenium.getVersion());
	}
}
