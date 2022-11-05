import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String[] data = sc.nextLine().split(" ");
            Initialise(data);
        }
        sc.close();

    }

    private static void Initialise(String[] data){
        // initialisaing the NOC 
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
