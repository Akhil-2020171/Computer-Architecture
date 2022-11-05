public class Router{
    port Northinput;
    port Northoutput;
    port Southinput;
    port Southoutput;
    port Westinput;
    port Westoutput;
    port Eastinput;
    port Eastoutput;
    port localinput;
    port localoutput;

    int[] data;
    int[][] crossbar = new int[5][5];   // The row number will be the input, the column number will be the output.
    					                //index 0:N, index 1:S, index 2:E, index 3:W, index 4: PE
    int[] switchAllocator = new int[2]; // index 0: input, index 1: output

}