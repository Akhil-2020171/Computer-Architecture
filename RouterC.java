import java.io.IOException;

public class RouterC {
    String[][] payload;
    String[] header;
    String packet;
    String[] tail;

    RouterC(String[][] data){
        this.header = data[0];
        this.packet = data[1][0];
        this.tail = data[2];
        this.payload = data;
    }

    public void switchallocator() throws IOException{
        String dst = header[1];

        if(dst.equals("1")){
            // System.out.println("Data transfer from C to B"); // inceament cycle by 1
            RouterB routerB = new RouterB(payload);
            process.pointer = "B";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from C"+" to "+process.pointer+'\n');
            routerB.switchallocator();
        }

        if(dst.equals("2")){
            // System.out.println("Data transfer from C to B");
            RouterB routerB = new RouterB(payload); // increament cycle by 1
            process.pointer = "B";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from C"+" to "+process.pointer+'\n');
            routerB.switchallocator();
        }
        if(dst.equals("3")){
            // System.out.println("Data transfer from C to 3"); // increament cycle by 1
            process.pointer = "3";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from C"+" to "+process.pointer+'\n');            
            Main.writer.write('\n');
        }
        if(dst.equals("4")){
            // System.out.println("Data transfer from C to D");
            RouterD routerD = new RouterD(payload); // increament cycle by 1
            process.pointer = "D";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from C"+" to "+process.pointer+'\n');
            routerD.switchallocator();
        }
    }
    
}
