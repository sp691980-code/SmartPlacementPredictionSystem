import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportGenerator {

    public static void exportReport(ArrayList<Student> students) {

        try {

            FileWriter writer =
                    new FileWriter("report.txt");

            writer.write("SMART PLACEMENT PREDICTION SYSTEM\n");
            writer.write("=====================================\n\n");

            for(Student st : students)
            {

                double score =
                        PlacementPredictor.calculateScore(st);

                writer.write("Name : " + st.name + "\n");
                writer.write("CGPA : " + st.cgpa + "\n");
                writer.write("Placement Score : "
                        + String.format("%.2f", score) + "\n");

                writer.write("Placement Chance : "
                        + PlacementPredictor.predict(st) + "\n");

                writer.write("Suggestion : "
                        + PlacementPredictor.suggestion(score) + "\n");

                writer.write("---------------------------------------\n");
            }

            writer.close();

        }
        catch(IOException e)
        {
            System.out.println("Error Exporting Report!");
        }

    }

}