package com.example.quizapp;

public class hCI {
    public String mQuestions[]={
            "__________ looks at how people interact with computers.",
            "Could be any technology ranging fromthe general desktop computer to a large scale computer system.",
            "When was Apple's iPad developed?",
            "An original model, form or an instance that serves as a basis for other processes.",
            "2nd stage of prototyping",
            "Stage where you put together the information you have created and gathered during the Empathise stage.",
            "________ is a graphic representation of how your story will unfold, shot by shot.",
            "________ provides a medium-fidelity representation and could be considered a high profile visual design draft.",
            "Skeleton or simple structure of your website/app.",
            "It’s basically just a raw freehand drawing on a piece of paper, that gives you a low-fidelity representation of your app.",
            "A high-fidelity representation of your app.",
            "One of the world’s first Turing complete computers"
    };
    private String mChoices [][]= {
            {"Human-Computer Interaction", "Programming", "Web Development", "Software Engineering"},
            {"Gadget", "Appliance", "Computer", "System"},
            {"2005", "2004", "2009", "2010"},
            {"Inspiration", "Prototype", "Sketch", "Storyboard"},
            {"Define", "Ideate", "Emphathize", "Test"},
            {"Ideate", "Prototype", "Define", "Test"},
            {"Prototype", "Sketch", "Mockup", "Storyboard"},
            {"Mockup", "Sketch", "Prototype", "Wireframe"},
            {"Sketch", "Mockup", "Prototype", "Wireframe"},
            {"Mockup", "Prototype", "Sketch", "Wireframe"},
            {"Mockup", "Sketch", "Wireframe", "Prototype"},
            {"Macintosh", "Microsoft", "ENIAC", "IBM"}


    };
    private String mCorrectAnswers[]=
            {"Human-Computer Interaction","Computer","2010",
            "Prototype","Define","Define","Storyboard","Mockup",
            "Wireframe","Sketch","Prototype","ENIAC"};
    public String title = "Human-Computer Interaction";

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