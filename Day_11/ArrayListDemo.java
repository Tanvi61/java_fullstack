package Day_11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> ai = new ArrayList<Integer>();
        ai.add(101);
        ai.add(102);
        ai.add(103);
        ai.add(190);
        System.out.println(ai);
        ai.add(2,100);
        System.out.println(ai);
        // ai.addFirst(190);
        // ai.addLast(200);
        boolean f = ai.contains(102);  //true
        System.out.println(f);
        ai.remove(4);
        List<Integer> l = ai.subList(2, 3);
        System.out.println(l);
        
    }
}
