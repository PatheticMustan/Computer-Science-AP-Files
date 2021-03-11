public class Dog extends Pet {
    // inherited from pet
    // private String name;
	// private String type;
	// private Date birthday;
    private String breed;

    public Dog(String name, Date birthday, String breed) {
        super(name, "Dog", birthday);
        this.breed = breed;
    }

    public Dog(String name, Date birthday) {
        super(name, "Dog", birthday);
        this.breed = "unknown";
    }

    // just bred different
    public String getBreed() {
        return this.breed;
    }
    // a totally different breed, a class ahead of the others
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String toString() {
        return this.getName() + ", a " + this.getBreed()+ " " + this.getType()+ " (" + this.getBirthday()+ ")";
    }

    public static void main(String[] args) {
        // one *very* old dog
        // testing Dog(String, Date)
        Dog abby = new Dog("Abby", new Date(1, 5, 1920));

        System.out.println(abby.getBreed());
        abby.setBreed("different"); // truly a different breed
        System.out.println(abby.getBreed());

        System.out.println(abby.getName());
        System.out.println(abby.getBirthday());
        System.out.println(abby.getType());
        System.out.println(abby); // test toString

        System.out.println("\n\n\n"); // AHHHHHHHHHHHHH

        // Elktarot, born in the future
        // testing Dog(String, Date, String)
        Dog elktarot = new Dog("Elk", new Date(2, 29, 2060), "Unicorn");
        System.out.println(elktarot.getBreed());
        elktarot.setBreed("shiba inu");
        System.out.println(elktarot.getBreed());

        System.out.println(elktarot.getName());
        System.out.println(elktarot.getBirthday());
        System.out.println(elktarot.getType());

        System.out.println(elktarot);
    }
}
