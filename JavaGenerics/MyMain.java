package JavaGenerics;

public class MyMain {
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(1);
        MyDouble myDouble = new MyDouble(3.14);
        MyChar myChar = new MyChar('@');
        MyString myString = new MyString("Hello");

        System.out.println(myInteger.getX());
        System.out.println(myDouble.getX());
        System.out.println(myChar.getX());
        System.out.println(myString.getX());

        MyGenericClass<Integer> myInteger2 = new MyGenericClass(1);
        //MyGenericClass<Integer,Integer> myInteger2 = new MyGenericClass(1,2);
        MyGenericClass<Double> myDouble2 = new MyGenericClass(3.14);
        MyGenericClass<Character> myChar2 = new MyGenericClass('@');
        MyGenericClass<String> myString2 = new MyGenericClass("Hello");

        System.out.println(myInteger2.getX());
        System.out.println(myDouble2.getX());
        System.out.println(myChar2.getX());
        System.out.println(myString2.getX());

        //bounded types : you can create the objects of a generic class to have
        //data of specific derived types
        //public class MyGenericClass<T extends Number> create only types deriven from Number class
    }
}
