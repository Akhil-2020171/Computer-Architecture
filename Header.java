public class Header {
    String[] Data = new String[3];

    Header(String src, String dst){
        Data[0] = src;

        if(src.equals("A")){
            if(dst.equals("B")){
                Data[1] = "B";
            }
            if(dst.equals("C")){
                Data[1] = "B";
                Data[2] = "C";
            }
            if(dst.equals("D")){
                Data[1] = "D";
            }
        }
        if(src.equals("B")){
            if(dst.equals("A")){
                Data[1] = "A";
            }
            if(dst.equals("C")){
                Data[1] = "C";
            }
            if(dst.equals("D")){
                Data[1] = "A";
                Data[2] = "D";
            }
        }
        if(src.equals("C")){
            if(dst.equals("A")){
                Data[1] = "D";
                Data[2] = "A";
            }
            if(dst.equals("B")){
                Data[1] = "B";
            }
            if(dst.equals("D")){
                Data[1] = "D";
            } 
        }
        if(src.equals("D")){
            if(dst.equals("A")){
                Data[1] = "A";
            }
            if(dst.equals("C")){
                Data[1] = "C";
            }
            if(dst.equals("B")){
                Data[1] = "C";
                Data[2] = "B";
            }
        }
    }

    public String[] getHeader(){
        return Data;
    }
}
