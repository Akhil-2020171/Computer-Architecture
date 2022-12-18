import java.io.IOException;
import java.util.Arrays;

public class RouterD {
    String[] header;
    String packet;
    String[] tail;
    String[][] payload;

    RouterD(String[][] data){
        this.header = data[0];
        this.packet = data[1][0];
        this.tail = data[2];
        this.payload = data;
    }
    public void switchallocator() throws IOException{
        String dst = header[1];

        if(dst.equals("1")){
            // System.out.println("Data transfer from D to A"); // inceament cycle by 1
            RouterA routerA = new RouterA(payload);
            process.pointer = "A";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from D"+" to "+process.pointer+'\n');
            routerA.switchallocator();
        }

        if(dst.equals("2")){
            if(Main.isXY){
                // System.out.println("Data transfer from D to C"); // increament cycle by 1
                process.pointer = "C";
                process.cycleNum++;
                RouterC routerC= new RouterC(payload);
                Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from D"+" to "+process.pointer+'\n');
                routerC.switchallocator();
            }
            else{
                // System.out.println("Data transfer from D to A"); // increament cycle by 1
                process.pointer = "A";
                process.cycleNum++;
                RouterA routerA= new RouterA(payload);
                Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from D"+" to "+process.pointer+'\n');
                routerA.switchallocator();
            }
            
        }
        if(dst.equals("3")){
            // System.out.println("Data transfer from D to C");
            RouterC routerC = new RouterC(payload); // increament cycle by 1
            process.pointer = "C";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from D"+" to "+process.pointer+'\n');
            routerC.switchallocator();
        }
        if(dst.equals("4")){
            // System.out.println("Data transfer from D to 4"); // increament cycle by 1
            process.pointer = "4";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data flit : "+Arrays.toString(this.header)+" "+this.packet+" " +Arrays.toString(this.tail)+" transfered from D"+" to "+process.pointer+'\n');
            Main.writer.write('\n');
        }
    }
}
