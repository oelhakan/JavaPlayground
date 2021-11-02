import java.io.*;

public class User implements Serializable {
    String name;
    transient String password;
    public void sayHello(){
        System.out.println("Hello " + name);
    }
}
