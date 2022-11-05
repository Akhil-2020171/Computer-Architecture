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
        // Create Header 
        Header header = new Header(Data[1], Data[2]);
        String[] head = header.getHeader();

        for(String i : head){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}