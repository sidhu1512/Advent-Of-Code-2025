import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D2q1 {

    public static long sum = 0;
    public static void main(String[] args){
        try(BufferedReader bf = new BufferedReader(new FileReader("inputd2.txt"))){
            String line;
            while( (line = bf.readLine()) != null){
                String[] idrange = line.split(",");
                for(String s: idrange){
                    getId(s);
                }
            }
        }    
        catch(IOException e){
            System.out.println("error : "+ e);
        }
        System.out.println(sum);
    }

    public static void getId(String s){
        String[] ids = s.split("-");

        long start = Long.parseLong(ids[0]);
        long end = Long.parseLong(ids[1]);

        for(long i=start; i<= end ;i++){
            String num = String.valueOf(i);
                int len = num.length();
                if(len % 2 ==0){
                    int half = len/2;
                    if(num.substring(0,half).equals(num.substring(half))){
                        sum += i;
                    }
                }
        }
    }
}
