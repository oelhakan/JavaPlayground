package JavaGenerics;

public class Main {
    public static void main(String[] args) {
        /*
         * generics = enable types to be parameters when defining classes,interfaces and methods
         * a benefit is that it eliminates the need to create multiple versions of methods or classes for various types
         * Use 1 version for all reference data types */

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {5.5, 4.4, 3.3, 2.2, 1.1};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"B", "Y", "E"};

        displayArray(intArray);
        displayArray(doubleArray);
        displayArray(charArray);
        displayArray(stringArray);

        System.out.println(getFirstElement(intArray));
        System.out.println(getFirstElement(doubleArray));
        System.out.println(getFirstElement(charArray));
        System.out.println(getFirstElement(stringArray));

    }

    public static <T> void displayArray(T[] array) {
        for(T x : array){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static <T> T getFirstElement(T[] array) {
        return array[0];
    }
}
