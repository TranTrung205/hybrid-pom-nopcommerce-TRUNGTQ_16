
package automationtesting;

public class Selenium {
	// Thuoc tinh = Properties/ Field / Variable
	private String name = "Selenium Webdriver";
	//Default
	String organization = "Selenium HQ";

	// Method/ Function
	//PRIVATE
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	
	//DEFAULT
	String getOrganization() {
		return this.organization;
	}
	
	//PROTECTED
	protected String sponsor = "SauceLab";
	protected String getSponsor() {
		return this.sponsor;
	}
	protected void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	//PUBLIC
	public String version = "3.141.59";
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public static void main (String[] agrs) {
		//Private
		Selenium selenium = new Selenium();
		System.out.println("Private: "+ selenium.getName());
		selenium.setName("Selenium Grid");
		System.out.println("Private: "+ selenium.getName());
		//Default
		System.out.println("Default: " + selenium.organization);
		System.out.println("Default: " + selenium.getOrganization());
		//Protected
		System.out.println("Protected: " + selenium.getSponsor());
		selenium.setSponsor("Github");
		System.out.println("Protected: " + selenium.getSponsor());
		//Version
		System.out.println("Public: " + selenium.getVersion());
		selenium.setVersion("4.0.0");
		System.out.println("Public: " + selenium.getVersion());
	 
	}
	
}
