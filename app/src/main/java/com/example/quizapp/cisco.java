package com.example.quizapp;

public class cisco {
    public String mQuestions[]={
            "Saving that state of the old process and loading the saved state of the new process is called:",
            "Information about a process is maintained in a:",
            "A thread is a ____ process.",
            "It provides the file system, CPU scheduling, memory management, amd other operating-system funstions",
            "It is interrupt driven by hardware which allows OS to protect itself and other system components",
            "It executes information stored in memory",
            "The CPU is connected to memory and I/O through strips of wire called_____.",
            "It is use to provides basic computing resources.",
            "It contains programs and information essential to the operation of the computer.",
            "It is a defense of a system against internal and external attacks.",
            "It allows direct command entry.",
            "Inter process communication can be done through:"
    };
    private String mChoices [][]= {
            {"state", "context switching", "multi programming", "multi-threading"},
            {"translation lookaside bufferblock", "stack", "process control block", "program control block"},
            {"heavy weight", "inter thread", "multiprocess", "light weight"},
            {"BIOS","system programs","kernel","MS-DOS"},
            {"privilege mode","scanning", "mode bit","dual mode"},
            {"CPU", "system bus", "ROM", "I/O devices"},
            {"system bus", "jumpers", "connectors", "peripherals"},
            {"hardware", "users", "application programs", "OS"},
            {"HDD", "CPU", "RAM", "ROM"},
            {"authentication", "protection", "authorization", "security"},
            {"input devices", "output devices", "GUI", "CLI"},
            {"system calls", "messages", "mails", "traps"}


    };
    private String mCorrectAnswers[]={"context switching","process control block","light weight","kernel","dual mode","CPU","system bus","hardware","ROM","security","CLI","messages"};
    public String title = "Operating System";




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
