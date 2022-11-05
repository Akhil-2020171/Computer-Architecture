import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Reading file
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String[] data = sc.nextLine().split(" ");
            Run(data);
        }
        sc.close();
    }

    private static void Run(String[] Data){
        // Initialising NOC
        NOC noc = new NOC();

        // Create Header 
        Header header = new Header(Data[1], Data[2]);
        String[] head = header.getHeader();

        // Create Packets of size 8 bits each
        // Data would be of 96 bits , so there would be 12 packets each of size 8 bits
        
        int k = 0;
        for(int i = 0 ; i<12; i++){
            String data = Data[3].substring(k,k+8);
            int tail = -1;
            if(i==11) tail = 1;
            String[][] payload = {head,{data},{Integer.toString(tail)}};
            int response = noc.NOC_trasnfer(payload);
            System.out.println(response+""+k);
            k = k+8;
        }
    }
}

// class Data{
//     String cycle;
//     String src;
//     String dst;
//     String data;

//     Data(String[] data){
//         this.cycle = data[0];
//         this.src = data[1];
//         this.dst = data[2];
//         this.data = data[3];
//     }
// }