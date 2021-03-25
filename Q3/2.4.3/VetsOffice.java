import java.util.ArrayList;

public class VetsOffice {
    private ArrayList<Pet> pets;

    public VetsOffice() {
        this.pets = new ArrayList<Pet>();
    }

    public void addPet(Pet p) {
        pets.add(p);
    }
    
    private int findPet(String name) {
        for (int i=0; i<pets.size(); i++) {
            if (name.equals(pets.get(i).getName())) return i;
        }

        return -1;
    }

    public Pet getPet(String name) {
        for (int i=0; i<pets.size(); i++) {
            if (name.equals(pets.get(i).getName())) return pets.get(i);
        }

        // lol, no pet found
        return null;
    }

    public Pet removePet(String name) {
        for (int i=0; i<pets.size(); i++) {
            if (name.equals(pets.get(i).getName())) {
                Pet removedPet = pets.get(i);
                pets.remove(i);
                return removedPet;
            }
        }

        return null;
    }

    public void listAll() {
        for (int i=0; i<pets.size(); i++) {
            System.out.println(pets.get(i));
        }
    }

    public void listAll(String type) {
        for (int i=0; i<pets.size(); i++) {
            if (pets.get(i).getType().equals(type)) {
                System.out.println(pets.get(i));
            }
        }
    }

    // java feels so easy to write suddenly...?
    public void listCatOwnersToRemind() {
        Date today = new Date();

        for (int i=0; i<pets.size(); i++) {
            if (pets.get(i) instanceof Cat) {
                Cat catte = (Cat)pets.get(i);
                if (catte.dueForVaccination(today)) {
                    System.out.println(catte);
                }
            }
        }
    }

    public static void main(String[] args) {
        VetsOffice vo = new VetsOffice();
        
        vo.addPet(new Pet("Jerry", "Mouse", new Date(2, 10, 1940)));
        vo.addPet(new Cat("Tom", new Date(2, 10, 1940), new Date(2, 10, 1940)));
        // I couldn't find Spike's real birthday
        vo.addPet(new Dog("Spike", new Date(4, 20, 1940)));
        vo.addPet(new Pet("goldy", "goldfish", new Date()));
        vo.addPet(new Cat("vaxx", new Date(), new Date()));

        System.out.println("Testing getPet");
        System.out.println(vo.getPet("Tom"));
        System.out.println(vo.getPet("Jerry"));
        System.out.println(vo.getPet("Spike"));
        System.out.println(vo.getPet("oooooooooo"));
        System.out.println(vo.getPet("goldy"));

        System.out.println("Testing removePet");
        System.out.println(vo.removePet("goldy"));
        System.out.println(vo.getPet("goldy"));

        System.out.println("Testing listAll");
        vo.listAll();
        System.out.println("Testing listAll Dogs");
        vo.listAll("Dog");

        System.out.println("Testing listCatOwnersToRemind");
        vo.listCatOwnersToRemind();
    }
}
