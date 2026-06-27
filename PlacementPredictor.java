public class PlacementPredictor {

       public static double calculateScore(Student s) {

            double score =
                    (s.cgpa * 4)
                  + (s.attendance * 0.15)
                  + (s.aptitude * 0.20)
                  + (s.technical * 0.20)
                  + (s.communication * 0.15)
                  + (s.projects * 2)
                  + (s.certifications * 1);
        
            if(score > 100)
                score = 100;
        
            return score;
       }

    public static String predict(Student s) {

        double score = calculateScore(s);

        if(score >= 85)
            return "Excellent";
        else if(score >= 70)
            return "Good";
        else if(score >= 50)
            return "Average";
        else
            return "Poor";
    }

    public static String suggestion(double score) {

        if(score >= 85)
            return "Excellent chance of placement.";
        else if(score >= 70)
            return "Good chance. Improve coding.";
        else if(score >= 50)
            return "Work on DSA, Aptitude and Projects.";
        else
            return "Improve all skills before placements.";
    }

    public static String getGrade(Student s) {

        double score = calculateScore(s);

        if(score >= 90)
            return "A+";
        else if(score >= 80)
            return "A";
        else if(score >= 70)
            return "B";
        else if(score >= 60)
            return "C";
        else
            return "D";
    }

    public static String recommendCompany(Student s) {

        double score = calculateScore(s);

        if(score >= 90)
            return "Google / Microsoft / Amazon";
        else if(score >= 80)
            return "Adobe / Oracle / Salesforce";
        else if(score >= 70)
            return "Infosys / TCS / Accenture";
        else if(score >= 60)
            return "Wipro / Capgemini";
        else
            return "Improve Skills Before Applying";
    }
}