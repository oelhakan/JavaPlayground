import java.io.*;

public class User implements Serializable {
    static final long serialVersionUID = 1;
    String name;
    transient String password;
    public void sayHello(){
        System.out.println("Hello " + name);
    }
}
