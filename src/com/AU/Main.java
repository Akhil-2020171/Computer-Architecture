package com.AU;

public class Main {

    public static void main(String[] args) {
        NOC NOC = new NOC();
        NOC.A.Northoutput = null;
        NOC.A.Northinput = null;
        NOC.A.Southoutput = NOC.D.Northinput;
        NOC.A.Southinput = NOC.D.Northoutput;
        NOC.A.Eastoutput = NOC.B.Westinput;
        NOC.A.Eastinput = NOC.B.Westoutput;
        NOC.A.Westoutput = null;
        NOC.A.Westinput = null;
        NOC.A.localinput = NOC.PEA.localoutput;
        NOC.A.localoutput = NOC.PEA.localinput;
        NOC.B.Northoutput = null;
        NOC.B.Northinput = null;
        NOC.B.Southoutput = NOC.C.Northinput;
        NOC.B.Southinput = NOC.C.Northoutput;
        NOC.B.Eastoutput = null;
        NOC.B.Eastinput = null;
        NOC.B.Westoutput = NOC.A.Eastinput;
        NOC.B.Westinput = NOC.A.Eastoutput;
        NOC.B.localinput = NOC.PEB.localoutput;
        NOC.B.localoutput = NOC.PEB.localinput;
        NOC.C.Northoutput = NOC.B.Southinput;
        NOC.C.Northinput = NOC.B.Southoutput;
        NOC.C.Southoutput = null;
        NOC.C.Southinput = null;
        NOC.C.Eastoutput = null;
        NOC.C.Eastinput = null;
        NOC.C.Westoutput = NOC.D.Eastinput;
        NOC.C.Westinput = NOC.D.Eastoutput;
        NOC.C.localinput = NOC.PEC.localoutput;
        NOC.C.localoutput = NOC.PEC.localinput;
        NOC.D.Northoutput = null;
        NOC.D.Northinput = null;
        NOC.D.Southoutput = NOC.A.Southoutput;
        NOC.D.Southinput = NOC.A.Southinput;
        NOC.D.Eastoutput = NOC.C.Westinput;
        NOC.D.Eastinput = NOC.C.Westoutput;
        NOC.D.Westoutput = null;
        NOC.D.Westinput = null;
        NOC.D.localinput = NOC.PED.localoutput;
        NOC.D.localoutput = NOC.PED.localinput;



    }
}
class Router{
    port Northinput;
    port Northoutput;
    port Southinput;
    port Southoutput;
    port Westinput;
    port Westoutput;
    port Eastinput;
    port Eastoutput;
    int[] data;
    port localinput;
    port localoutput;
    int[][] crossbar = new int[5][5]; // The row number will be the input, the column number will be the output.
    					//index 0:N, index 1:S, index 2:E, index 3:W, index 4: PE
    int[] switchAllocator = new int[2]; // index 0: input, index 1: output



}


class port{
    int[] data;
}
class PE{
    int[] data;
    port localinput;
    port localoutput;

}
class NOC{
    Router A;
    Router B;
    Router C;
    Router D;
    PE PEA;
    PE PEB;
    PE PEC;
    PE PED;




}
