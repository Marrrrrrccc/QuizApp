package com.example.quizapp;

public class frontEnd {
    public String mQuestions[]={
            "CSS stands for ______ ",
            " __________ is a free front end framework for faster and easier web development",
            "When was Bootstrap developed?",
            "Protocol and platform-independent server side components, written in Java, which extend the standard wed servers",
            "A _______ provides a general framework for services built on the request-response paradigm",
            " _______ are text files containing HTML",
            "Makes possible a Web page to react and change in response to the user’s actions",
            "___________ is a front end scripting language developed by Netscape for dynamic content",
            "Image tag in HTML",
            "Which is an invalid heading tag?",
            "Table row tag",
            "Block element in HTML"
    };
    private String mChoices [][]= {
            {"Cascading Style Server", "Computer Style Service", "Cascading Style Sheets", "Computer Super Sheets"},
            {"HTML", "CSS", "JavaScript", "Bootstrap"},
            {"2005", "2010", "2011", "2012"},
            {"JavaServlet", "Servlet", "Java Development Kit", "Java EE"},
            {"JavaServlet", "Servlet", "Java Development Kit", "Java EE"},
            {"Web pages", "Code", "Web app", ".html file"},
            {"DHTML", "XML", "CSS", "JS"},
            {"HTML", "CSS", "SQL", "JavaScript"},
            {"<img src>", "<img>", "<image>", "<imgs>"},
            {"<h1>", "<h7>", "<h6>", "<h3>"},
            {"<tr>", "<td>", "<row>", "<trow>"},
            {"<span>", "<br>", "<div>", "<bl>"}


    };
    private String mCorrectAnswers[]=
            {"Cascading Style Sheets","Bootstrap","2011","JavaServlet","Servlet","Web pages","DHTML","JavaScript","<img src>","<h7>","<tr>","<div>"};
    public String title = "FRONT-END";




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
