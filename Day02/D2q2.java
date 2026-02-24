import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D2q2 {

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
        long start = Long.parseLong(s.split("-")[0]);
        long end = Long.parseLong(s.split("-")[1]);
        
        for(long i=start; i<= end; i++){
            String num = String.valueOf(i);
                helper(num);
        }
    }

    public static void helper(String num){
        int chunk = 1;
        int len = num.length();
        while(chunk <= len/2){
            if(len % chunk !=0){
                chunk++;
                continue;
            }
            
            String c = num.substring(0, chunk);
            boolean flag = false;
            for(int j =chunk; j<len; j+=chunk){
                int dpt = j + chunk;
                if(dpt > len){
                    break;
                }
                if(!c.equals(num.substring(j,dpt))){
                    break;
                }
                if(dpt == len){
                    flag = true;
                }
            }

            if(flag){
                sum += Long.parseLong(num);
                return;
            }
            chunk++;
        }
    }
}
