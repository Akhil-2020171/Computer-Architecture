import java.io.IOException;
import java.util.Arrays;

public class RouterA {
    String[][] payload;
    String[] header;
    String packet;
    String[] tail;

    RouterA(String[][] data){
        this.header = data[0];
        this.packet = data[1][0];
        this.tail = data[2];
        this.payload = data;
    }
    
    public void switchallocator() throws IOException{
        String dst = header[1];

        if(dst.equals("1")){
            // System.out.println("Data transfer from A to 1"); // inceament cycle by 1
            process.pointer = "1";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +this.tail+" transfered from A"+" to "+process.pointer+'\n');
            Main.writer.write('\n');
        }

        if(dst.equals("2")){
            // System.out.println("Data transfer from A to B");
            RouterB routerB = new RouterB(payload); // increament cycle by 1
            process.pointer = "B";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from A"+" to "+process.pointer+'\n');
            routerB.switchallocator();
        }

        if(dst.equals("3")){
            
            if(Main.isXY){
                // System.out.println("Data transfer from A to B");
                RouterB routerB = new RouterB(payload); // increament cycle by 1
                process.pointer = "B";
                process.cycleNum++;
                Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from A"+" to "+process.pointer+'\n');
                routerB.switchallocator();
            }
            else{
                // System.out.println("Data transfer from A to D");
                RouterD routerD = new RouterD(payload); // increament cycle by 1
                process.pointer = "D";
                process.cycleNum++;
                Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from A"+" to "+process.pointer+'\n');
                routerD.switchallocator();
            }
        }
        
        if(dst.equals("4")){
            // System.out.println("Data transfer from A to D");
            RouterD routerD = new RouterD(payload); // increament cycle by 1
            process.pointer = "D";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from A"+" to "+process.pointer+'\n');
            routerD.switchallocator();
        }
    }
    
}
