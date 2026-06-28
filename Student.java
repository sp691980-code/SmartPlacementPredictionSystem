 import java.time.LocalDate;
 import java.io.Serializable;

public class Student implements Serializable {

    int studentId;
    int rank;
    String registrationDate;

    String name;
    double cgpa;
    double attendance;
    double aptitude;
    double technical;
    double communication;
    int projects;
    int certifications;

    public Student(String name,
                   double cgpa,
                   double attendance,
                   double aptitude,
                   double technical,
                   double communication,
                   int projects,
                   int certifications) 
                {

      
                    
        this.studentId = (int)(Math.random() * 9000) + 1000;
        this.registrationDate = LocalDate.now().toString();

        this.name = name;
        this.cgpa = cgpa;
        this.attendance = attendance;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
        this.projects = projects;
        this.certifications = certifications;
    }

    @Override
    public String toString() {

        return "\n=============================="
                + "\nName : " + name
                + "\nCGPA : " + cgpa
                + "\nAttendance : " + attendance
                + "\nAptitude : " + aptitude
                + "\nTechnical : " + technical
                + "\nCommunication : " + communication
                + "\nProjects : " + projects
                + "\nCertifications : " + certifications
                + "\n==============================";
    }
}