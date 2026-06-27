import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void saveStudents(ArrayList<Student> students) {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("students.dat"));

            out.writeObject(students);

            out.close();

            System.out.println("Students Saved Successfully!");

        }
        catch(Exception e)
        {
            System.out.println("Error Saving File!");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("students.dat"));

            ArrayList<Student> students =
                    (ArrayList<Student>) in.readObject();

            in.close();

            return students;

        }
        catch(Exception e)
        {
            return new ArrayList<>();
        }
    }
}