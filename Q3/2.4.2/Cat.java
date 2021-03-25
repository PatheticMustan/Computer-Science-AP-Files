public class Cat extends Pet {
    // inherited from pet
    // private String name;
	// private String type;
	// private Date birthday;
    private Date nextVaccineDate;

    public Cat(String name, Date birthday, Date nextVaccineDate) {
        super(name, "Cat", birthday);
        this.nextVaccineDate = nextVaccineDate;
    }


    public Date getNextVaccineDate() {
        return this.nextVaccineDate;
    }

    public boolean dueForVaccination(Date date) {
        return this.nextVaccineDate.equals(date);
    }

    public void vaccinate() {
        this.nextVaccineDate = new Date();
        this.nextVaccineDate.setYear(this.nextVaccineDate.getYear() + 1);
    }

    public String toString() {
        return this.getName() + ", a " + this.getType() + ", born on " + this.getBirthday() + ". They're due for vaccinations on " + this.getNextVaccineDate();
    }

    public static void main(String[] args) {}
}
