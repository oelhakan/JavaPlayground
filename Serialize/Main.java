import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.name = "Onur";
        user.password = "P@ssword123";
//        user.sayHello();
        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();

        System.out.println("Object Info Saved.");

        long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
    //Serialization is the process of converting an object into a byte stream.
    //Saves the state of the object after program exits
    //This byte stream can be saved as a file or sent over a network
    //Byte stream can be saved as a file (.ser) which is platform independent
    //(Think of this as if you're saving a file with the object's information)

    //Steps to Serialize
    //---------------------------------------------------------------
    //1. Your class should implement Serializable interface
    //2. add import java.io.Serializable;
    //3. FileOutputStream fileOut = new FileOutputStream(file path)
    //4. ObjectOutputStream out = new ObjectOutputStream(fileOut);
    //5. out.writeObject(objectName)
    //6. out.close(); fileOut.close();
    //---------------------------------------------------------------

    // important notes
    // 1. child classes of a parent class that implements Serializable will do so as well
    //2. static fields are not serialized (they belong to the class, not an individual object)
    //3. Fields declared as "transient" aren't serialized, they're ignored
    //4. the class's definition ("class file") itself is not recorded, cast it as the object type
    //5. serialVersionUID is a unique version ID

    //serialVersionUID is a unique ID that functions like a version #
    //verifies that the sender and receiver of a serialized object,
    //have loaded classes for that object that are compatible
    //Ensures object will be compatible between machines
    //Number must match. otherwise, this will cause a InvalidClassException
    //A SerialVersionUID will be calculated based on class properties, members, etc.
    //A serializable class can declare its own serialVersionUID explicitly (recommended)
}

