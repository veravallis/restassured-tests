package Session26;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)

public class POJOIgnoreUknown {
	
	private String FirstName;
    private String LastName;
    private int Age;
    private String Gender;
    private double Salary;
    private boolean Married;
    
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public boolean getMarried() {
		return Married;
	}
	public void setMarried(boolean married) {
		Married = married;
	}
	
    
    

}
