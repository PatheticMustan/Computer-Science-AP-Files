public class StringListTest {
    public static void main(String[] args) {
        System.out.println("\n\n\n");

        StringArrayList list = new StringArrayList(5);



        // 1. Testing isEmpty method
        System.out.println("isEmpty on empty list: " + list.isEmpty());



        // 2. Testing size method on empty list
        System.out.println("size on empty list: " + list.size());



        // 3. Testing toString method on empty list
        System.out.println("toString on empty list: " + list);



        // 4-6. Testing 1-argument add method
        list.add("apple");
        System.out.println("1-argument add (1): " + list);
        list.add("banana");
        System.out.println("1-argument add (2): " + list);
        list.add("carrot");
        System.out.println("1-argument add (3): " + list);



        // 7. Testing add method in middle of list
        list.add(1, "pig");
        System.out.println("Add to middle of list: " + list);



        // 8. Testing add method at beginning of list
        list.add(0, "cow");
        System.out.println("Add to beginning of list: " + list);



        // 9. Testing add method at end of list
        list.add(list.size(), "sheep");
        System.out.println("Add to end of list: " + list);



        // 10. Testing out-of-bounds for add method
        try {
            list.add(-1, "out of bounds lol");
            System.out.println("FAIL, expected error: " + list);
        } catch (Exception e) {
            System.out.println("Out of bounds add (negative)");
        }

        try {
            list.add(999, "out of bounds lol");
            System.out.println("FAIL, expected error: " + list);
        } catch (Exception e) {
            System.out.println("Out of bounds add (super high)");
        }



        // 11. Making sure list is intact after erroneous call
        System.out.println("Is the list still intact?: " + list);



        // 12. Testing get method
        for (int i=0; i<list.size(); i++) {
            System.out.println("Testing get (" + i + "): " + list.get(i));
        }



        // 13. Testing out-of-bounds for get method
        try {
            list.get(-1);
            System.out.println("FAIL, expected error: " + list);
        } catch (Exception e) {
            System.out.println("Out of bounds get (negative)");
        }

        try {
            list.get(999);
            System.out.println("FAIL, expected error: " + list);
        } catch (Exception e) {
            System.out.println("Out of bounds get (super high)");
        }



        // 14-15. Testing set method
        list.set(0, "blue");
        System.out.println("Testing set: " + list);
        list.set(3, "green");
        System.out.println("Testing set: " + list);



        // 16-17. Testing remove method in middle
        list.remove(3);
        System.out.println("Testing remove at middle (1): " + list);
        list.remove(2);
        System.out.println("Testing remove at middle (2): " + list);



        // 18-19. Testing remove method at end
        list.remove(list.size()-1);
        System.out.println("Testing remove at end (1): " + list);
        list.remove(list.size()-1);
        System.out.println("Testing remove at end (2): " + list);



        // 20-21. Testing remove method at beginning
        list.remove(0);
        System.out.println("Testing remove at beginning (1): " + list);
        list.remove(0);
        System.out.println("Testing remove at beginning (2): " + list);


        
        // 22. Testing list-emptying code
        while (list.size() > 0) {
            list.remove(0);
            System.out.println("Testing list emptying: " + list);
        }



        // 23. Testing ability to resize
        for (int i=0; i<100; i++) {
            list.add("ehhh #" + i);
            System.out.println("Testing resizing ability (" + i + "): " + list);
        }
    }
}
