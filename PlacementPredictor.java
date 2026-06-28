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

        if (score > 100)
            score = 100;

        return score;
    }

    public static String predict(Student s) {

        double score = calculateScore(s);

        if (score >= 85)
            return "Excellent";
        else if (score >= 70)
            return "Good";
        else if (score >= 50)
            return "Average";
        else
            return "Poor";
    }

    public static String suggestion(double score) {

        if (score >= 85)
            return "Excellent chance of placement.";
        else if (score >= 70)
            return "Good chance. Improve coding.";
        else if (score >= 50)
            return "Work on DSA, Aptitude and Projects.";
        else
            return "Improve all skills before placements.";
    }

    public static String getGrade(Student s) {

        double score = calculateScore(s);

        if (score >= 90)
            return "A+";
        else if (score >= 80)
            return "A";
        else if (score >= 70)
            return "B";
        else if (score >= 60)
            return "C";
        else
            return "D";
    }

    public static String recommendCompany(Student s) {

        double score = calculateScore(s);

        if (score >= 90)
            return "Google / Microsoft / Amazon";
        else if (score >= 80)
            return "Adobe / Oracle / Salesforce";
        else if (score >= 70)
            return "Infosys / TCS / Accenture";
        else if (score >= 60)
            return "Wipro / Capgemini";
        else
            return "Improve Skills Before Applying";
    }

    public static double getPlacementPercentage(Student s) {

        double score = calculateScore(s);

        if (score > 100)
            score = 100;

        if (score < 0)
            score = 0;

        return score;
    }

    public static boolean isEligible(Student s, String company) {

        switch (company.toLowerCase()) {

            case "tcs":
                return s.cgpa >= 6.5;

            case "infosys":
                return s.cgpa >= 7.0;

            case "accenture":
                return s.cgpa >= 7.5;

            case "capgemini":
                return s.cgpa >= 7.0;

            case "google":
                return s.cgpa >= 8.5
                        && s.projects >= 3
                        && s.certifications >= 2;

            case "microsoft":
                return s.cgpa >= 8.5
                        && s.technical >= 85;

            case "amazon":
                return s.cgpa >= 8.0
                        && s.technical >= 80;

            default:
                return false;
        }
    }

    // Progress Bar Method
    public static String getProgressBar(double score) {

        int percentage = (int) score;
        int totalBars = 20;
        int filledBars = percentage / 5;

        StringBuilder bar = new StringBuilder("[");

        for (int i = 0; i < totalBars; i++) {
            if (i < filledBars) {
                bar.append("█");
            } else {
                bar.append("░");
            }
        }

        bar.append("] ").append(percentage).append("%");

        return bar.toString();
    }
}