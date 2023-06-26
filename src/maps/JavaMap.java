package maps;


import java.util.HashMap;

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
    }
}
