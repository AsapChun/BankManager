package BankPackage;

public class Data {
	String customer_name = "";
	int birth_day;
	int birth_month;
	int birth_year;
	int age; //not sure needed
	
	public Data(String name, int day, int month, int year, int age) {
		//age can be calculated, but for now we're lazy
		this.customer_name = name;
		this.birth_day = day;
		this.birth_month = month;
		this.birth_year = year;
		this.age = age;
	}
	
	public String toString() {
		String returner = "";
		returner = returner + customer_name + ", " + birth_month + "/" + birth_day + "/" + birth_year; 
		return returner;
		
	}
	
	
	//No setters because you shouldn't change values
	public String getCustomer_name() {
		return customer_name;
	}
	
	public int getBirth_day() {
		return birth_day;
	}
	
	public int getBirth_month() {
		return birth_month;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public int getAge() {
		return age;
	}
	
	
}
