public class PetTest {
    public static void main(String[] args) {
        DateT bday = new DateT(6, 23, 1998);
        Pet fifi = new Pet("Fifi", "cat", bday);
    
        System.out.println(fifi.getName());
        System.out.println(fifi.getType());
        System.out.println(fifi.getBirthday());
    
        fifi.setName("Fififi");
    
        System.out.println(fifi.getName());
    
        System.out.println(fifi.isBirthday());
        System.out.println(fifi.getAge());
    }
}
