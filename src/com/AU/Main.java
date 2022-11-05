package com.AU;

public class Main {

    public static void main(String[] args) {
	NOC NOC = new NOC();
        NOC.A.North = null;
        NOC.A.South = NOC.D;
        NOC.A.West = null;
        NOC.A.East = NOC.B;
        NOC.A.local = NOC.PEA;
        NOC.B.North = null;
        NOC.B.South = NOC.C;
        NOC.B.West = NOC.A;
        NOC.B.East = null;
        NOC.B.local = NOC.PEB;
        NOC.C.North = null;
        NOC.C.South = NOC.D;
        NOC.C.West = null;
        NOC.C.East = NOC.B;
        NOC.C.local = NOC.PEA;
    }
}
class Router{
    Router North;
    Router South;
    Router East;
    Router West;
    PE local;
    int[] data;
	
    int[][] crossbar = new int[5][5]; // The row number will be the input, the column number will be the output.
                                      //index 0:N, index 1:S, index 2:E, index 3:W, index 4: PE
    int[] switchAllocator = new int[2]; // index 0: input, index 1: output


}
class PE{
    int[] data;
    Router local;
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
