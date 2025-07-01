package Session24;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class POJOIncludu {
	
	private String FirstName;
	private String LastName;
	private String Gender;
	private int Age;
	private double Salary;
	private boolean IsMarried;
	private String[] Hobbies;
	private List<String> Degrees;
	private Map<String,String> FamilyMembers;
	
	
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public boolean isIsMarried() {
		return IsMarried;
	}
	public void setIsMarried(boolean isMarried) {
		IsMarried = isMarried;
	}
	public String[] getHobbies() {
		return Hobbies;
	}
	public void setHobbies(String[] hobbies) {
		Hobbies = hobbies;
	}
	public List<String> getDegrees() {
		return Degrees;
	}
	public void setDegrees(List<String> degrees) {
		Degrees = degrees;
	}
	public Map<String, String> getFamilyMembers() {
		return FamilyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		FamilyMembers = familyMembers;
	}
	
	

}
