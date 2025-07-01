package Session20;

public class POJOEmployee {
	
	/*firstName - String
       lastName – String
      age – Int
      gender – String
      salary – Boolean 
 */
       private String FirstName;
       private String LastName;
       private int Age;
       private String Gender;
       private double Salary;
       
       public String getLastName()
       {
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

	/*public String getFirstName()
      {
    	  return FirstName;
      }
      
      public void setFirstname(String FirstName)
      {
    	  this.FirstName  = FirstName;
      } */
      
      public String getFirstName()
      {
    	  return FirstName;
      }
      public void setFirstName(String FirstName)
      {
    	  this.FirstName = FirstName;
      }
}
