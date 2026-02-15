
import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args){
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        hashMap.put(1,"Apple");
        hashMap.put(2,"Orange");
        hashMap.put(3,"Tree");
        hashMap.put(4,"Soil");

        System.out.println("Get method : "+hashMap.get(1));
        hashMap.put(3, "new Value for 3");
        System.out.println("The Get method after change : "+hashMap);
        System.out.println("contains the key : "+hashMap.containsKey(3));
        System.out.println("Get method : "+hashMap.size());
        System.out.println("Get method : "+hashMap.keySet());
    }
    
}
