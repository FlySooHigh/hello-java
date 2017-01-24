package HomeTask1;

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
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null){throw new NullPointerException("null reference");}
		Author otherOne = (Author)other;
		return (name.equals(otherOne.name) && 
		    surname.equals(otherOne.surname) &&
			birthdate.equals(otherOne.birthdate));
	}
}
