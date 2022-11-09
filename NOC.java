// will use in second half of the project (after mid evaluation)

public class NOC{
    
    // n: North, s: South, e: East, w: West, 0: not connected, 1:PE
    // Index code: 0:A, 1:B, 2:C, 3:D, 4:PE(A), 5:PE(B), 6:PE(C), 7:PE(D)

    //  Router    A B C D PE(A) PE(B) PE(C) PE(D)
    //  A(0)         0 e 0 s 1      0      0     0
    //  B(1)         w 0 s 0 0      1      0     0
    //  C(2)         0 n 0 w 0      0      1     0
    //  D(3)         n 0 e 0 0      0      0     1
    // PE(A)(4)      1 0 0 0 0      0      0     0
    // PE(B)(5)      0 1 0 0 0      0      0     0
    // PE(C)(6)      0 0 1 0 0      0      0     0
    // PE(D)(7)      0 0 0 1 0      0      0     0

    final String[][] NOC = {{"0","e","0","s","1","0","0","0"},
                            {"w","0","s","0","0","1","0","0"},
                            {"0","n","0","w","0","0","1","0"},
                            {"n","0","e","0","0","0","0","1"},
                            {"1","0","0","0","0","0","0","0"},
                            {"0","1","0","0","0","0","0","0"},
                            {"0","0","1","0","0","0","0","0"},
                            {"0","0","0","1","0","0","0","0"}};


    public int NOC_trasnfer(String[][] payload){
        // Switch Switch = new Switch();
        // Switch.SwitchAllocater(payload[0]);

        return 1;
    }
}