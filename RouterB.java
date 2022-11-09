import java.io.IOException;

public class RouterB {
    String[][] payload;
    String[] header;
    String packet;
    String[] tail;

    RouterB(String[][] data){
        this.header = data[0];
        this.packet = data[1][0];
        this.tail = data[2];
        this.payload = data;
    }
    public void switchallocator() throws IOException{
        String dst = header[1];

        if(dst.equals("1")){
            // System.out.println("Data transfer from B to A"); // inceament cycle by 1
            RouterA routerA = new RouterA(payload);
            process.pointer = "A";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from B"+" to "+process.pointer+'\n');
            routerA.switchallocator();
        }

        if(dst.equals("2")){
            // System.out.println("Data transfer from B to 2"); // increament cycle by 1
            process.pointer = "2";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from B"+" to "+process.pointer+'\n');
            Main.writer.write('\n');
        }
        if(dst.equals("3")){
            // System.out.println("Data transfer from B to C");
            RouterC routerC = new RouterC(payload); // increament cycle by 1
            process.pointer = "C";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from B"+" to "+process.pointer+'\n');
            routerC.switchallocator();
            
        }
        if(dst.equals("4")){
            // System.out.println("Data transfer from B to A");
            RouterA routerA = new RouterA(payload); // increament cycle by 1
            process.pointer = "A";
            process.cycleNum++;
            Main.writer.write("     *     "+"At cycle : "+process.cycleNum+"  --  "+"Data packet : "+this.packet+" transfered from B"+" to "+process.pointer+'\n');
            routerA.switchallocator();
        }
    }
}
