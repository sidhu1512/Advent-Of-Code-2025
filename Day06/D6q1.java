import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;



public class D6q1 {

    static long sum;
    public static void main(String[] args) throws IOException{

        String[] content = Files.readString(Path.of("inputd6.txt")).split("\n");
        
        List<String[]> values = new ArrayList<>();

        for(int i = 0; i< content.length; i++){
            String[] arr = content[i].trim().split("\\s+");
            values.add(arr);
        }

        solveProblem(values, values.size());
        System.out.println(sum);
    }

    static void solveProblem(List<String[]> values, int len){

        for(int i = 0; i< values.get(len-1).length; i++){

            Long result = (long) 0;
            if(values.get(len-1)[i].equals("+")){
                for(int j =0; j<len -1; j++){
                    result += Long.parseLong(values.get(j)[i]);
                }
            }else{
                result = (long) 1;
                for(int j =0; j<len -1; j++){
                    result *= Long.parseLong(values.get(j)[i]);
                }
            }            
            sum += result;
        }
    }

}
