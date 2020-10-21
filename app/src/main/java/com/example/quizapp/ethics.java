package com.example.quizapp;

public class ethics {
    public String mQuestions[]={
            "Main mechanism for protecting creative works in the US",
            "Publishing false statements about another person with the intent of harming their reputation",
            "It occurs when an infringement committed by another person would not have happened without your help",
            "It involves an infringement that occurs in an area under your supervision, and when you should have been policing and preventing such acts",
            "The theory of ____ promotes tolerance",
            "The quality that every person is treated equally and no one is given preferential treatment in the theory",
            "A decision reached by applying the theory should be correct for everyone that has a similar decision to make.",
            "The ______ radiation machine killed three people and injured several others in the mid-80s",
            "The reasoning that is used to make decisions",
            "Purpose is to establish the truth based on Euclidean geometry",
            "Ethics of _______ focuses on equality, universality, right, fairness",
            "A ____ is a way of defining morality"
    };
    private String mChoices [][]= {
            {"Copyright", "Trademark", "Patent", "Fair use"},
            {"Slander", "Hate comment", "Libel", "Discrimination"},
            {"Copyright Infringement", "Vicarious Infringement", "Contributory Infringement", "Plagiarism"},
            {"Copyright Infringement", "Vicarious Infringement", "Contributory Infringement", "Plagiarism"},
            {"Cutural Relativism", "Utilitarianism", "Religious Ethics", "Deontological ethics"},
            {"Universality", "Pure reason", "Impartiality", "Practical Reason"},
            {"Universality", "Pure reason", "Impartiality", "Practical Reason"},
            {"Therac-25", "Macintosh", "IEEE- Computer", "AECL"},
            {"Universality", "Pure reason", "Impartiality", "Practical Reason"},
            {"Universality", "Pure reason", "Impartiality", "Practical Reason"},
            {"Justice", "Caring", "Religion", "Culture"},
            {"Moral Theory", "Ethnicity", "Professionalism", "Moral Compass"}


    };
    private String mCorrectAnswers[]=
            {"Copyright","Libel","Contributory Infringement",
            "Vicarious Infringement","Cutural Relativism","Impartiality","Universality","Therac-25",
            "Practical Reason","Pure reason","Justice","Moral Theory"};

    public String title = "Ethics";




    public String getmQuestions(int a) {
        String questions = mQuestions[a];
        return questions;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }
    public String getCorrectAnswer (int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
