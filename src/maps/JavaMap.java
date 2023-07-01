package maps;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaMap {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Aman", 124);  //a[1] = item //O(1)
        map.put("Aman", 987);
        map.put("Manas", 567);
        map.put("Jayanth", 901);


        Integer value = map.get("Aman"); //a[1]

        System.out.println(map.size());

        String str = "Aman";

        System.out.println(str.hashCode());


        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(50, "xyz");
        hashMap.put(10, "abc");
        hashMap.put(4, "def");
        hashMap.put(9, "xyz");



        for(Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
        }


        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(50, "xyz");
        treeMap.put(10, "abc");
        treeMap.put(4, "def");
        treeMap.put(9, "xyz");



        for(Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(50, "xyz");
        linkedHashMap.put(4, "def");
        linkedHashMap.put(10, "abc");
        linkedHashMap.put(9, "xyz");



        for(Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey());
        }



    }
}
