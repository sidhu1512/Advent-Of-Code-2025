import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class D3q2 {
    public static long sum;
    public static int curridx;
    public static int ds = 2;
    public static void main(String[] args){
        try(BufferedReader bf = new BufferedReader(new FileReader("inputd3.txt"))){
            String line;
            while( (line = bf.readLine()) != null){
                MaxVoltage(line);
            }
        }    
        catch(IOException e){
            System.out.println("error : "+ e);
        }
        System.out.println("sum is : " + sum);
    }

    public static void MaxVoltage(String Bank){
        curridx = 0;
        StringBuffer ans = new StringBuffer();
        
        while(ans.length() != ds){
        int limit = Bank.length() - ds + ans.length();
        int max = Integer.MIN_VALUE;

        for(int i = 0 + curridx; i<=limit; i++){
            int num  = Bank.charAt(i) - '0';
            if(num > max){
                max = num;
                curridx = i + 1;
            }
        }
        ans.append(String.valueOf(max));
    }
        sum+= Long.parseLong(ans.toString());
    }
}
