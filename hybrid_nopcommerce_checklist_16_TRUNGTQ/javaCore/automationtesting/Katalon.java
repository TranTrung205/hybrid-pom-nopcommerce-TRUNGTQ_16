package automationtesting;

public class Katalon {
	public static void main(String[] argr) {
		Selenium selenium = new Selenium();
		System.out.println("Default: " + selenium.organization);
		selenium.organization = "VIB";
		System.out.println("Default: " + selenium.getOrganization());
		//Protected
		System.out.println("Protected: " + selenium.getSponsor());
		selenium.setSponsor("Github");
		System.out.println("Protected: " + selenium.getSponsor());
		//Public
		System.out.println("Public: " + selenium.getVersion());
		selenium.setVersion("4.0.0");
		System.out.println("Public: " + selenium.getVersion());
	}
}
