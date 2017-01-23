package HomeTask;

public class Author 
{
	private String name;
	private String surname;
	private String birthdate;
	
	public Author(String name, String surname, String birthdate) {
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public boolean equals(Author other)
	{
		if (name.equals(other.name) && 
		    surname.equals(other.surname) &&
			birthdate.equals(other.birthdate))
		{
			return true;
		}
		return false;
	}
}
