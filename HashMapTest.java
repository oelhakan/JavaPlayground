import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        /*
        * HashMap implements the Map interface
        * it is similar to ArrayList, but with key-value pairs
        * stores objects, so you need to use Wrapper class
        * ex : (name,email)(userID,password)...*/

        HashMap<String,String> countryCapitals = new HashMap();

        //adding key-value pairs to our hashMap
        countryCapitals.put("Turkey","Ankara");
        countryCapitals.put("Poland","Warsaw");
        countryCapitals.put("Germany","Berlin");
        countryCapitals.put("France","Paris");
        countryCapitals.put("Russia","Moscow");

        System.out.println(countryCapitals);

        //removing a key-value pair from our hashMap
        countryCapitals.remove("France");

        System.out.println(countryCapitals);

        //get value of a key
        System.out.println(countryCapitals.get("Turkey"));

        //display size of hashMap
        System.out.println(countryCapitals.size());

        //replace the value for a key
        countryCapitals.replace("Russia","Kiev");
        System.out.println(countryCapitals);

        //check if a certain key is within our hashMap
        System.out.println(countryCapitals.containsKey("Turkey"));
        System.out.println(countryCapitals.containsKey("England"));

        //check if a certain value is within our hashMap
        System.out.println(countryCapitals.containsValue("Berlin"));
        System.out.println(countryCapitals.containsValue("London"));

        //iterate once for each key within our hashMap to print the keys and values appropriately
        for(String i : countryCapitals.keySet()){
            System.out.print(i + "\t= ");
            System.out.println(countryCapitals.get(i));
        }

        //clear the hashMap
        countryCapitals.clear();
        System.out.println(countryCapitals);
    }
}
