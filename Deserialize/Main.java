import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Deserialization is the reverse process of converting a byte stream into an object.
        //(Think of this as if you're loading a saved file)

        //Steps to Deserialize
        //---------------------------------------------------------------
        //1. Your class should implement Serializable interface
        //2. add import java.io.Serializable;
        //3. FileInputStream fileIn = new FileInputStream(file path);
        //4. ObjectInputStream in = new ObjectInputStream(fileIn);
        //5. objectNam = (Class) in.readObject();
        //6. in.close(); fileIn.close();
        //---------------------------------------------------------------
        User user = null;
        FileInputStream fileIn = new FileInputStream("/Users/onurelhakan/IdeaProjects/Serializer/UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        user = (User) in.readObject();
        in.close();
        fileIn.close();
        System.out.println(user.name);
        System.out.println(user.password);
        user.sayHello();
        long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
}
