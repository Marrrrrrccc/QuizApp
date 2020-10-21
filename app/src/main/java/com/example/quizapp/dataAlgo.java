package com.example.quizapp;

public class dataAlgo {
    public String mQuestions[] = {
            "Study of techniques of art and science in programming",
            "Second stage of ADT",
            "What is a well-defined procedure that processes input values to generate desired output values to solve a problem",
            "What is the execution of a loops body",
            "What is the simplest sorting algorithm?",
            "Which ADT uses LIFO?",
            "Which ADT uses FIFO?",
            "A finite set of nodes and a set of edges or arcs, where each edge is related to a pair of nodes.",
            "An ADT for a collection  of key-value pairs",
            "What is a unique number that can be mapped into a table?",
            "A Tree where every parent has a pair of children",
            "What is a collection of disjoint trees?"
    };
    private String mChoices[][] = {
            {"Information Technology", "Computer Sciences", "Software Engineering", "Programming Sciences"},
            {"Implementation", "Specification", "Representation", "Formulation"},
            {"Solution", "Formula", "Method", "Algorithm"},
            {"Recursion", "Iteration", "Relations", "Operation"},
            {"Insertion sort", "Selection sort", "Bubble sort", "Merge Sort"},
            {"Stacks", "Queues", "Trees", "Graphs"},
            {"Stacks", "Queues", "Trees", "Graphs"},
            {"Graphs", "Trees", "Stacks", "Queues"},
            {"Map", "Key", "Heap", "Nodes"},
            {"Hash", "Map", "Tag", "Load"},
            {"Binary tree", "Forest", "Complete Binary Tree", "Graph"},
            {"Graphs", "Complete trees", "Forest", "Parent trees"}


    };
    private String mCorrectAnswers[] =
            {"Software Engineering", "Representation", "Algorithm",
                    "Iteration", "Bubble sort", "Stacks", "Queues", "Graphs",
                    "Map", "Map", "Complete Binary Tree", "Forest"};
    public String title = "Data Algorithm";

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

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}