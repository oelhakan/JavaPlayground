package JavaGenerics;

public class MyGenericClass<T> {

    T x;

    MyGenericClass(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }
}
