public class Pet {
	private String name;
	private String type;
	private DateT birthday;

	//constructors (part a)
	public Pet(String initName, String initType, DateT initBirthday) {
		this.name = initName;
		this.type = initType;
		this.birthday = initBirthday;
	}
	public Pet(String initName, String initType, int initMonth, int initDay, int initYear) {
		new Pet(initName, initType, new DateT(initMonth, initDay, initYear));
	}

	//getters and setters (part b)
	public String getName() { return this.name; }
	public String getType() { return this.type; }
	public DateT getBirthday() { return this.birthday; }
	public void setName(String newName) { this.name = newName; }

	//other methods (parts c and d)
	public boolean isBirthday() {
		return this.birthday.equals(new DateT());
	}
	public int getAge() {
		return this.birthday.ageAsOf(new DateT());
	}
}