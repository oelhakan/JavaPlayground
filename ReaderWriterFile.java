import java.io.*;

public class ReaderWriterFile {
    public static void main(String[] args) {
        //file = an abstract representation of file and directory pathname
        //if file is in the project folder, you only need the name
        //else you need the absolute pathway
        File file = new File("typeTest.txt");
        if(file.exists()){
            System.out.println("That File Exists");
            file.getPath();
            file.getAbsolutePath();
            file.isFile();
        }else{
            System.out.println("That File Does Not Exist");
        }

//        try {
//            FileWriter writer = new FileWriter("typeTest.txt");
//            writer.write("Roses Are Red\nViloets Are Blue");
//            writer.append("\nA Poem");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //FileReader = read the contents of a file as a stream of characters one by one
        //read() returns an int value which contains the byte value
        //when read returns -1, there's no more data to be read
        try {
            FileReader reader = new FileReader("typeTest.txt");
            int data = reader.read();
            while(data != -1){
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
