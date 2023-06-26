package maps;


import java.util.ArrayList;


class MapNode {
    String key;
    int value;
    MapNode next;

    public MapNode(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class CustomMap {

    private ArrayList<MapNode> bucketList;
   //represents the size of map
    private int size;

    //Number of buckets we have
    private int bucketListSize;

    public CustomMap() {
        bucketListSize  = 11;
        bucketList = new ArrayList<>();

        for(int i = 0; i < bucketListSize; i++) {
            bucketList.add(null);
        }
    }

    public int size() {
       return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void put(String key, int value) {

        int bucketIndex = getBucketIndex(key);
        MapNode head = bucketList.get(bucketIndex);

        MapNode temp = head;
        while(temp != null) {
            if(temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        MapNode newNode = new MapNode(key, value);
        newNode.next = head;
        bucketList.set(bucketIndex, newNode);
        size++;

        //load factor
        if((1.0) * size / bucketListSize > 0.75) {
            rehash();
        }
    }

    private void rehash() {
        ArrayList<MapNode> oldBucketList = bucketList;
        bucketList = new ArrayList<>();

        bucketListSize = bucketListSize * 2;
        for(int i = 0; i < bucketListSize; i++) {
            bucketList.add(null);
        }


        for(int index = 0; index < oldBucketList.size(); index++) {
            MapNode head = oldBucketList.get(index);
            while(head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public int get(String key) {
        int bucketIndex = getBucketIndex(key);

        MapNode head = bucketList.get(bucketIndex);
        MapNode temp = head;
        while(temp != null) {
            if(temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return Integer.MAX_VALUE;
    }

    public void remove(String key) {

    }


    private int getBucketIndex(String key) {
        int hashCode = Math.abs(key.hashCode());
        int compressed = hashCode % bucketListSize;
        return compressed;
    }
 }
