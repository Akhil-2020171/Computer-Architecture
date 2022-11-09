//class to handle working of the clock and obtaining positive and negative edges given as input

public class clock{

    // counters for the Positive Edge and Negative Edge 
    private static int posEdge, negEdge;

    // Variable for setting Current Time as the first Positive edge
    private static long currTime;

    //Variables that store the first Positive Edge Negative Edge time
    private static long posEdgeTime, negEdgeTime;

    // Constructor to initialize all variables
    clock(){
        currTime = System.currentTimeMillis();
        posEdgeTime = currTime;
        negEdgeTime = currTime+100;
        posEdge = 0; negEdge = 0;
    }

    // Function to check if the clock has reached a positive edge
    static boolean atPosEdge(){
        int currEdge = (int)((System.currentTimeMillis() - posEdgeTime)/100);
        if((System.currentTimeMillis() - posEdgeTime)%100 == 0 && currEdge%2!=0)
            return true;
        return false;
    }

    // Function to check if the clock has reaches a negative edge
    static boolean atNegEdge(){
        int currEdge = (int)((System.currentTimeMillis() - negEdgeTime)/100);
        if((System.currentTimeMillis() - negEdgeTime)%100 == 0 && currEdge%2==0)
            return true;
        return false;
    }

    // Maintaining the Positive Edge counter
    static int posEdgeCheck(){
        if(atPosEdge())
            posEdge+=1;
        return posEdge;
    }
    
    // Maintains the Negative Edge counter
    static int negEdgeCheck(){
        if(atNegEdge())
            negEdge+=1;
        return negEdge;
    }
    
    // For a given amount of time runs a loop to check status of the clock 
    // also checks and returns values of any and all Edges that were encountered
    static void status(int time){
        long last = System.currentTimeMillis() + time;
        while(System.currentTimeMillis() < last){
            if(atPosEdge()){
                System.out.println("Current time: " + System.currentTimeMillis());
                int curEdge = posEdgeCheck();
                System.out.println("At positive edge: " + curEdge + " of the clock\n");
            }
            if(atNegEdge()){
                System.out.println(System.currentTimeMillis());
                System.out.println("At negative edge of the clock\n");   
            }
            System.out.println(System.currentTimeMillis() + "\n");
        }
    }
}