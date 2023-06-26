package maps;

/**
 * @author amgarg
 */
public class CustomMapUse {

    public static void main(String[] args) {
        CustomMap map = new CustomMap();

        map.put("Aman", 124);
        map.put("Manas", 356);
        map.put("Satya", 12010872);


        System.out.println(map.size());

        System.out.println(map.get("Manas"));

        System.out.println(map.get("Satya"));
        map.put("Satya", 124);

        System.out.println(map.get("Satya"));
    }
}
