package maps;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class JavaSet {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(20);
        hashSet.add(1);
        hashSet.add(50);
        hashSet.add(4);


        for(Integer element : hashSet) {
            System.out.println(element);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(20);
        treeSet.add(1);
        treeSet.add(50);
        treeSet.add(4);


        for(Integer element : treeSet) {
            System.out.println(element);
        }


        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(20);
        linkedHashSet.add(1);
        linkedHashSet.add(50);
        linkedHashSet.add(4);


        for(Integer element : linkedHashSet) {
            System.out.println(element);
        }
    }
}
