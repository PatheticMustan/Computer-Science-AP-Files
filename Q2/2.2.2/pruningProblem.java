import java.util.*;

public class pruningProblem {
    public static void main(String[] args) {
        StringArrayList list3 = new StringArrayList();
        StringArrayList list2 = new StringArrayList();
        
        String sentence = "To be or not to be that is the question";
        String[] words = sentence.split(" ");
        
        for (String s : words) {
            list3.add(s);
            list2.add(s);
        }
        
        
        removeWithLength(list3, 3);
        removeWithLength(list2, 2);
        
        System.out.println(list3);
        System.out.println(list2);
        
    }
    
    public static void removeWithLength(StringArrayList list, int length) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).length() == length) {
                // since we're removing a word, the size is decreasing by 1.
                // We don't want to increment, so we'll decrement here.
                list.remove(i--);
            }
        }
    }
}