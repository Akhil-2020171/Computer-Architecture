import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static FileWriter writer;
    public static void main(String[] args) throws IOException {
        // Reading file
        File file = new File("input.txt");
        Scanner sc1 = new Scanner(file);
        Scanner sc2 = new Scanner(file);
        int numberOfLines = 0;

        // Reading number of lines ;
        while(sc1.hasNextLine()){
            numberOfLines++;
            sc1.nextLine();
        }

        PayLoad[] inputPayload = new PayLoad[numberOfLines];
        int i = 0;
        while(sc2.hasNextLine()){
            String[] data = sc2.nextLine().split(" ");
            inputPayload[i] = new PayLoad(data[0], data[1], data[2], data[3]);
            i++;
        }

        Arrays.sort(inputPayload, new Comparator<PayLoad>() {
            @Override
            public int compare(PayLoad o1, PayLoad o2) {
                return Integer.parseInt(o1.cycle) - Integer.parseInt(o2.cycle);
            }
            
        });

        writer = new FileWriter("Log.txt"); // Writting Log File
        writer.write("Data has been divided in 12 packets , each of 8 bits\n");
        writer.write('\n');
        for(int j = 0; j<numberOfLines ; j++){
            String[] data = {inputPayload[j].cycle, inputPayload[j].Src, inputPayload[j].Dst, inputPayload[j].data};
            process process = new process(data);
            process.run();
        }

        writer.close();
        sc1.close();
        sc2.close();
    }
}

class process{
    public static String pointer;
    public static int cycleNum;
    String[] Data;

    process(String[] data){
        this.Data = data;
        cycleNum = Integer.parseInt(data[0]);
    }

    public void run() throws IOException{
        // Create Header 
        String[] head = {Data[1],Data[2]};

        // Create Packets of size 8 bits each
        // Data would be of 96 bits , so there would be 12 packets each of size 8 bits
        Main.writer.write("Data has been entered in the NOC. The source of the data is PE "+head[0]+" and the destination is PE "+head[1]+'\n');
        Main.writer.write("Cycle starts for this data transaction at "+cycleNum+'\n');
        Main.writer.write('\n');
        
        int k = 0;
        for(int i = 0 ; i<12; i++){
            String data = Data[3].substring(k,k+8);
            k = k+8;            
            int tail = -1;
            if(i==11) tail = 1;
            String[][] payload = {head,{data},{Integer.toString(tail)}};
            
            if(head[0].equals("1")){
                RouterA routerA = new RouterA(payload);
                pointer = "A";
                cycleNum++;
                Main.writer.write("     *     "+"At cycle : "+cycleNum+"  --  "+"Data packet : "+data+" transfered from "+head[0]+" to "+pointer+'\n');
                routerA.switchallocator();
            }
            if(head[0].equals("2")){
                RouterB routerB = new RouterB(payload);
                pointer = "B";
                cycleNum++;
                Main.writer.write("     *     "+"At cycle : "+cycleNum+"  --  "+"Data packet : "+data+" transfered from "+head[0]+" to "+pointer+'\n');
                routerB.switchallocator();
            }
            if(head[0].equals("3")){
                RouterC routerC = new RouterC(payload);
                pointer = "C";
                cycleNum++;
                Main.writer.write("     *     "+"At cycle : "+cycleNum+"  --  "+"Data packet : "+data+" transfered from "+head[0]+" to "+pointer+'\n');
                routerC.switchallocator();
            }
            if(head[0].equals("4")){
                RouterD routerD = new RouterD(payload);
                pointer = "D";
                cycleNum++;
                Main.writer.write("     *     "+"At cycle : "+cycleNum+"  --  "+"Data packet : "+data+" transfered from "+head[0]+" to "+pointer+'\n');
                routerD.switchallocator();
            }

            if(tail==1){
                Main.writer.write("Data : "+Data[3]+" has been completed transfered from PE "+head[0]+" to PE "+head[1]+'\n');
                Main.writer.write('\n');
            }
        }
    }
}

class PayLoad{
    String cycle;
    String Src;
    String Dst;
    String data;

    PayLoad(String a, String b, String c, String d){
        this.cycle = a;
        this.Src = b;
        this.Dst = c;
        this.data = d;
    }
}