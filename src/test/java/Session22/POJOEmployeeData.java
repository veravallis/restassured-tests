package Session22;

public class POJOEmployeeData {
	
	/* {“firstName” : “Suresh”,
          “lastName” : “kumar”
          “age” : 35,
           “gender” : “male”,
           “salary” : 300000.00,
          “Address” :
          {  “Streat” : “Park evanue”,
            “City” : “Vijayawada”,
             “State” : “Andhra pradesh”,
              “Pin Code” : 534102

}*/
       private String FirstName;
       private String LastName;
       private String Gender;
       private int  Age;
       private double Salary;
       private POJOAddress  Address; // For address, create another POJO class and call hear.
       
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
	public POJOAddress getAddress() {
		return Address;
	}
	public void setAddress(POJOAddress address) {
		Address = address;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
       
       
}
