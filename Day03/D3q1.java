import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;


public class D3q1 {
    public static int sum;
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
        System.out.println(sum);
    }

    public static void MaxVoltage(String Bank){
        
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<Bank.length() - 1; i++){
            queue1.add((Bank.charAt(i) - '0'));
        }
        String firstDigit = String.valueOf(queue1.poll());
        queue1.clear();

        for(int i = Bank.indexOf(firstDigit) + 1; i<Bank.length(); i++){
            queue1.add((Bank.charAt(i) - '0'));
        }

        sum+= Integer.parseInt(firstDigit + String.valueOf(queue1.poll()));
    }
}
