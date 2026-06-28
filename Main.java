import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


         if(!Login.login())
        {
            return;

        }
              Scanner sc = new Scanner(System.in);

             ArrayList<Student> students = FileManager.loadStudents();
             
             System.out.println();
             System.out.println("=========================================================");
             System.out.println("        SMART PLACEMENT PREDICTION SYSTEM");
             System.out.println("=========================================================");
             System.out.println("  Developed By : Shubham Pandey");
             System.out.println("  Language     : Java");
             System.out.println("  Version      : 2.0");
             System.out.println("=========================================================");
             System.out.println("  Welcome! Predict Your Placement Success");
             System.out.println("=========================================================");
             
            int choice;

        

        do {

           System.out.println("\n╔════════════════════════════════════════════════════╗");
             System.out.println("║        SMART PLACEMENT PREDICTION SYSTEM           ║");
             System.out.println("╠════════════════════════════════════════════════════╣");
             System.out.println("║ 1.  Predict Placement                              ║");
             System.out.println("║ 2.  View All Students                              ║");
             System.out.println("║ 3.  Search Student                                 ║");
             System.out.println("║ 4.  Update Student                                 ║");
             System.out.println("║ 5.  Delete Student                                 ║");
             System.out.println("║ 6.  Top Performer                                  ║");
             System.out.println("║ 7.  Statistics Dashboard                           ║");
             System.out.println("║ 8.  Student Ranking                                ║");
             System.out.println("║ 9.  Save Students                                  ║");
             System.out.println("║10.  Load Students                                  ║");
             System.out.println("║11.  Export Report                                  ║");
             System.out.println("║12.  Company Eligibility Checker                    ║");
             System.out.println("║13.  Exit                                           ║");
             System.out.println("║14. About Project                                   ║");
             System.out.println("╚════════════════════════════════════════════════════╝");
             System.out.print("Enter Your Choice : ");
            
                choice = sc.nextInt();
                sc.nextLine();
    
                switch(choice) {
    
                    case 1:
    
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
    
                        System.out.print("Enter CGPA: ");
                        double cgpa = sc.nextDouble();
    
                        if(cgpa < 0 || cgpa > 10) {
                            System.out.println("Invalid CGPA!");
                            break;
                        }
    
                        System.out.print("Enter Attendance: ");
                        double attendance = sc.nextDouble();
    
                        System.out.print("Enter Aptitude Score: ");
                        double aptitude = sc.nextDouble();
    
                        System.out.print("Enter Technical Score: ");
                        double technical = sc.nextDouble();
    
                        System.out.print("Enter Communication Score: ");
                        double communication = sc.nextDouble();
    
                        System.out.print("Enter Number of Projects: ");
                        int projects = sc.nextInt();
    
                        System.out.print("Enter Certifications: ");
                        int certifications = sc.nextInt();
    
                        Student s = new Student(
                                name,
                                cgpa,
                                attendance,
                                aptitude,
                                technical,
                                communication,
                                projects,
                                certifications
                        );
                        students.add(s); 
                        FileManager.saveStudents(students);
                        System.out.print("\nAnalyzing Student Data");
                        
                        for (int i = 0; i < 5; i++) {
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.print(".");
                        }
                        
                        System.out.println("\nAnalysis Completed Successfully!\n");
                          double score = PlacementPredictor.calculateScore(s);
                            String result = PlacementPredictor.predict(s);
                            
                            System.out.println("\n==================================================");
                            System.out.println("              PLACEMENT REPORT");
                            System.out.println("==================================================");
                            System.out.println("Student Name        : " + name);
                            System.out.printf("CGPA                : %.2f%n", cgpa);
                            System.out.printf("Placement Score     : %.2f%n", score);
                            System.out.println("Progress            :");
                            System.out.println(PlacementPredictor.getProgressBar(score));

                            System.out.println("Placement Chance    : " + result);
                            System.out.println("Grade               : " + PlacementPredictor.getGrade(s));
                            System.out.println("Recommended Company : " + PlacementPredictor.recommendCompany(s));
                            System.out.println("Suggestion          : " + PlacementPredictor.suggestion(score));
                            System.out.println("==================================================");
    
                                try {
    
                     FileWriter writer = new FileWriter("report.txt");
                 
                     writer.write("SMART PLACEMENT PREDICTION SYSTEM\n");
                     writer.write("---------------------------------\n");
                     writer.write("Name : " + name + "\n");
                     writer.write("CGPA : " + cgpa + "\n");
                     writer.write("Placement Score : " + score + "\n");
                     writer.write("Placement Chance : " + result + "\n");
                     writer.write("Suggestion : "
                             + PlacementPredictor.suggestion(score) + "\n");
    
                    writer.close();
           
                       System.out.println("Report Saved Successfully!");
          
                       }       
                         catch(IOException e)
                        {
                         System.out.println("Error Saving File!");
                        }
                     
                         break;
                     
                            case 2:

                                if(students.isEmpty())
                                {
                                    System.out.println("No Student Found!");
                                    break;
                                }

                                 System.out.println("\n===== STUDENT LIST =====");
                             
                                 for(Student st : students)
                                 {
                                     System.out.println("--------------------------------");
                                     System.out.println("Student ID : " + st.studentId);
                                     System.out.println("Registration Date : " + st.registrationDate);

                             
                                     System.out.println("Name : " + st.name);
                                     System.out.println("CGPA : " + st.cgpa);
                             
                                     System.out.printf("Placement Score : %.2f%n",
                                             PlacementPredictor.calculateScore(st));
                             
                                     System.out.println("Placement Chance : "
                                             + PlacementPredictor.predict(st));
                             
                                     System.out.println("Grade : "
                                             + PlacementPredictor.getGrade(st));
                             
                                     System.out.println("Recommended Company : "
                                             + PlacementPredictor.recommendCompany(st));
                                 }
                             
                                 break; 

                                case 3:
                                
                                 System.out.print("Enter Student Name : ");
                                 String searchName = sc.nextLine();
                             
                                 boolean found = false;
                             
                                 for(Student st : students)
                               {
                                   if(st.name.equalsIgnoreCase(searchName))
                                   {
                                       System.out.println("\n===== STUDENT FOUND =====");
                                       System.out.println("Student ID : " + st.studentId);
                                       System.out.println("Registration Date : " + st.registrationDate);

                                       System.out.println("CGPA : " + st.cgpa);
                                       System.out.println("Attendance : " + st.attendance);
                                       System.out.println("Aptitude : " + st.aptitude);
                                       System.out.println("Technical : " + st.technical);
                                       System.out.println("Communication : " + st.communication);
                                       System.out.println("Projects : " + st.projects);
                                       System.out.println("Certifications : " + st.certifications);
                                       
                                        double searchScore =
                                         PlacementPredictor.calculateScore(st);
                                        
                                       System.out.printf("Placement Score : %.2f%n", searchScore);
                                        
                                        System.out.println(
                                                "Placement Chance : "
                                                + PlacementPredictor.predict(st)
                                        );

                                        System.out.println("Grade : "
                                           + PlacementPredictor.getGrade(st));

                                           System.out.println("Recommended Company : "
                                          + PlacementPredictor.recommendCompany(st));
                          
                                        found = true;
                                        break;
                                   }  
                               }  
                            
                               if(!found)
                               {  
                                   System.out.println("Student Not Found");
                               }
                           
                               break;

                            case 4:

                                System.out.print("Enter Student Name to Update: ");
                                String updateName = sc.nextLine();
                               
                                boolean updated = false;
                               
                                for(Student st : students)
                                              {
                               if(st.name.equalsIgnoreCase(updateName))
                               {
                               System.out.println("Student Found!");
                   
                               System.out.print("New CGPA: ");
                               st.cgpa = sc.nextDouble();
                   
                               System.out.print("New Attendance: ");
                               st.attendance = sc.nextDouble();
                   
                               System.out.print("New Aptitude: ");
                               st.aptitude = sc.nextDouble();
                   
                               System.out.print("New Technical: ");
                               st.technical = sc.nextDouble();
                   
                               System.out.print("New Communication: ");
                               st.communication = sc.nextDouble();
                   
                               System.out.print("New Projects: ");
                               st.projects = sc.nextInt();
                   
                               System.out.print("New Certifications: ");
                               st.certifications = sc.nextInt();
                   
                               System.out.println("Student Updated Successfully!");
                               FileManager.saveStudents(students);
                   
                               updated = true;
                            break;
                            }
                       }

                            if(!updated)
                            {
                                System.out.println("Student Not Found!");
                            }
                        
                         break;
                
                        case 5:

                         System.out.print("Enter Student Name to Delete: ");
                         String deleteName = sc.nextLine();
                     
                         boolean deleted = false;
                     
                         for(int i = 0; i < students.size(); i++)
                         {
                             if(students.get(i).name.equalsIgnoreCase(deleteName))
                             {
                                 students.remove(i);
                                 FileManager.saveStudents(students);
                     
                                 System.out.println("Student Deleted Successfully!");
                     
                                 deleted = true;
                                 break;
                                }
                            }
                     
                          if(!deleted)
                           {
                             System.out.println("Student Not Found!");
                            }

                        break; 

                        case 6:

                             if(students.isEmpty())
                             {
                                 System.out.println("No Student Data Available!");
                                 break;
                             }
                         
                             Student topStudent = students.get(0);
                             double highestScore =
                                     PlacementPredictor.calculateScore(topStudent);
                         
                             for(Student st : students)
                             {
                                 double currentScore = PlacementPredictor.calculateScore(st);

                            if(currentScore > highestScore)
                            {
                                highestScore = currentScore;
                                topStudent = st;
                            }
                                 
                             }
                         
                                     
                                     System.out.println("\n==================================================");
                                       System.out.println("                 TOP PERFORMER");
                                       System.out.println("==================================================");
                                       
                                       System.out.println("Student ID            : " + topStudent.studentId);
                                       System.out.println("Registration Date     : " + topStudent.registrationDate);
                                       System.out.println("Name                  : " + topStudent.name);
                                       System.out.printf("CGPA                  : %.2f%n", topStudent.cgpa);
                                       System.out.printf("Placement Score       : %.2f%n", highestScore);
                                       System.out.println("Placement Chance      : " + PlacementPredictor.predict(topStudent));
                                       System.out.println("Grade                 : " + PlacementPredictor.getGrade(topStudent));
                                       System.out.println("Recommended Company   : " + PlacementPredictor.recommendCompany(topStudent));
                                       
                                       
                                                                        
                                     System.out.printf("Placement Score : %.2f%n", highestScore);
                                 
                                     System.out.println("Placement Chance : "
                                             + PlacementPredictor.predict(topStudent));

                                      System.out.println("==================================================");

                  
                        break;
                                       
                                    case 7:
                                        
                                            if(students.isEmpty())
                                            {
                                                System.out.println("No Student Data Available!");
                                                break;
                                            }
                                        
                                            double totalCgpa = 0;
                                            double totalScore = 0;
                                            int excellent = 0;
                                            int good = 0;
                                            int average = 0;
                                            int poor = 0;
                                        
                                            Student highestStudent = students.get(0);
                                            Student lowestStudent = students.get(0);
                                        
                                            double maxScore = PlacementPredictor.calculateScore(highestStudent);
                                            double lowestScore = PlacementPredictor.calculateScore(lowestStudent);
                                        
                                            for(Student st : students)
                                            {
                                                double  currentScore = PlacementPredictor.calculateScore(st);
                                                String placementResult = PlacementPredictor.predict(st);

                                                if(placementResult.equals("Excellent"))
                                                    excellent++;
                                                   
                                                  else if(placementResult.equals("Good"))
                                                    good++;
                                                else if(placementResult.equals("Average"))
                                                    average++;
                                                else
                                                    poor++;


                                                totalCgpa += st.cgpa;
                                                totalScore += currentScore;

                                                if(currentScore > maxScore)
                                                {
                                                    maxScore = currentScore;
                                                    highestStudent = st;
                                                }
                                                
                                                if(currentScore < lowestScore)
                                                {
                                                    lowestScore = currentScore;
                                                    lowestStudent = st;
                                                }
                                            }
                                        
                                            System.out.println("\n==================================================");
                                              System.out.println("           STATISTICS DASHBOARD");
                                              System.out.println("==================================================");
                                              
                                              System.out.println("Total Students            : " + students.size());
                                              
                                              System.out.printf("Average CGPA              : %.2f%n",
                                                      totalCgpa / students.size());
                                              
                                              System.out.printf("Average Placement Score   : %.2f%n",
                                                      totalScore / students.size());
                                              
                                              System.out.println("----------------------------------------------");
                                              
                                              System.out.println("Excellent Students        : " + excellent);
                                              System.out.println("Good Students             : " + good);
                                              System.out.println("Average Students          : " + average);
                                              System.out.println("Poor Students             : " + poor);
                                              
                                              System.out.println("----------------------------------------------");
                                              
                                              System.out.println("Highest Performer         : " + highestStudent.name);
                                              System.out.println("Lowest Performer          : " + lowestStudent.name);
                                              
                                              System.out.println("==================================================");
                                        
                                        break;

                                        case 8:

                                            if(students.isEmpty())
                                            {
                                                System.out.println("No Students Available!");
                                                break;
                                            }
                                        
                                            students.sort((a, b) ->
                                                    Double.compare(
                                                            PlacementPredictor.calculateScore(b),
                                                            PlacementPredictor.calculateScore(a)
                                                    ));
                                        
                                            System.out.println("\n========== STUDENT RANKING ==========");
                                        
                                            for(int i = 0; i < students.size(); i++)
                                            {
                                                Student st = students.get(i);
                                        
                                                st.rank = i + 1;
                                        
                                                System.out.println("-------------------------------------------");
                                                                                                     if (st.rank == 1)
                                                        System.out.println("*** Rank 1 (TOPPER) ***");
                                                    else if (st.rank == 2)
                                                        System.out.println("*** Rank 2 ***");
                                                    else if (st.rank == 3)
                                                        System.out.println("*** Rank 3 ***");
                                                    else
                                                        System.out.println("Rank : " + st.rank);
                                       
                                                  System.out.println("Student ID            : " + st.studentId);
                                                  System.out.println("Name                  : " + st.name);
                                                  System.out.printf("CGPA                  : %.2f%n", st.cgpa);
                                                  
                                                  System.out.printf("Placement Score       : %.2f%n",
                                                          PlacementPredictor.calculateScore(st));
                                                  
                                                  System.out.println("Placement Chance      : "
                                                          + PlacementPredictor.predict(st));
                                                  
                                                  System.out.println("Grade                 : "
                                                          + PlacementPredictor.getGrade(st));
                                                  
                                                  System.out.println("Recommended Company   : "
                                                          + PlacementPredictor.recommendCompany(st));
                                                  
                                                  System.out.printf("Placement Percentage  : %.2f%%%n",
                                                          PlacementPredictor.getPlacementPercentage(st));
                                                  
                                                  System.out.println("-------------------------------------------");
                                            }
                                        
                                         break;


                                    
                                    case 9:

                                     FileManager.saveStudents(students);
                                 
                                     System.out.println("Students Saved Successfully!");
                                 
                                     break;

                                case 10:

                                 students = FileManager.loadStudents();
                                 
                                 System.out.println("Students Loaded Successfully!");
                                 
                                break;

                                case 11:

                                  ReportGenerator.exportReport(students);
                                  
                                break;

                                case 12:

                                    if(students.isEmpty())
                                    {
                                        System.out.println("No Students Available!");
                                        break;
                                    }
                                
                                         System.out.print("Enter Student Name : ");
                                     
                                         String companyStudent = sc.nextLine();
                                     
                                         boolean companyFound = false;
                                     
                                         for(Student st : students)
                                    {
                                        if(st.name.equalsIgnoreCase(companyStudent))
                                        {
                                
                                            companyFound = true;
                                
                                            System.out.println("\n========== ELIGIBILITY ==========");
                                
                                            if(st.cgpa >= 6.5)
                                                System.out.println("✔ Eligible for TCS");
                                            else
                                                System.out.println("✘ Not Eligible for TCS");
                                
                                            if(st.cgpa >= 7.0)
                                                System.out.println("✔ Eligible for Infosys");
                                            else
                                                System.out.println("✘ Not Eligible for Infosys");
                                
                                            if(st.cgpa >= 7.5)
                                                System.out.println("✔ Eligible for Accenture");
                                            else
                                                System.out.println("✘ Not Eligible for Accenture");
                                
                                            if(st.cgpa >= 8.0)
                                                System.out.println("✔ Eligible for Capgemini");
                                            else
                                                System.out.println("✘ Not Eligible for Capgemini");
                                
                                            break;
                                        }
                                    }
                                
                                    if(!companyFound)
                                    {
                                        System.out.println("Student Not Found!");
                                    }
                                
                                    break;

                            

                                case 13:
                              
                                  FileManager.saveStudents(students);
                              
                                  System.out.println("\n==================================================");
                                  System.out.println("        THANK YOU FOR USING");
                                  System.out.println("   SMART PLACEMENT PREDICTION SYSTEM");
                                  System.out.println("--------------------------------------------------");
                                  System.out.println("Developed By : Shubham Pandey");
                                  System.out.println("Version      : 2.0");
                                  System.out.println("Data Saved Successfully");
                                  System.out.println("==================================================");
                              
                                  System.exit(0);
                                break;

                                case 14:
                            
                                System.out.println("\n==================================================");
                                System.out.println("           ABOUT THIS PROJECT");
                                System.out.println("==================================================");
                                System.out.println("Project Name : Smart Placement Prediction System");
                                System.out.println("Version      : 2.0");
                                System.out.println("Language     : Java");
                                System.out.println("Developer    : Shubham Pandey");
                                System.out.println("College      : Technocrats Institute of Technology");
                                System.out.println("Branch       : CSE - Data Science");
                                System.out.println("==================================================");
                                System.out.println("Features:");
                                System.out.println("✔ Student Management");
                                System.out.println("✔ Placement Prediction");
                                System.out.println("✔ Dashboard");
                                System.out.println("✔ Student Ranking");
                                System.out.println("✔ Top Performer");
                                System.out.println("✔ Report Generation");
                                System.out.println("✔ Company Eligibility Checker");
                                System.out.println("✔ File Handling");
                                System.out.println("==================================================");
                            
                                break;
                                
                                
 
                                 
                                        
                        default:
                                  
                                  
                            System.out.println("Invalid Choice!");
                        }
                     
                        } while(choice != 13);

                     
                     sc.close();

       }
   }
