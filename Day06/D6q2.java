import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;



public class D6q2 {

    static long sum;
    public static void main(String[] args) throws IOException{

        String[] content = Files.readString(Path.of("inputd6.txt")).split("\\R");
        
        List<String[]> values = new ArrayList<>();

        // for(int i = 0; i< content.length; i++){
        //     String[] arr = content[i].split("(?<=\\G.{" + 4 + "})");
        //     values.add(arr);
        // }
        for (int i = 0; i < content.length; i++) {
        String[] arr = content[i].split("(?<=\\G.{4})");
        for (int j = 0; j < arr.length; j++) {
            arr[j] = String.format("%-4s", arr[j]);
        }    
        values.add(arr);
        }

        int hight = values.size();
        int width = values.get(0).length;

        solveProblem(values, hight, width);
        System.out.println(sum);
    }

    static void solveProblem(List<String[]> values, int hight, int width){

        for(int i = width -1; i >= 0; i--){

            Long result ;
            if(values.get(hight-1)[i].trim().equals("+")){
                result = (long) 0;
            }else {
                result = (long) 1;
            }
            
                for(int j =4; j>0; j--){
                    StringBuilder sb = new StringBuilder();
                    for(int k =0; k<hight -1; k++){
                        char c = values.get(k)[i].charAt(j-1);
                        if( c != ' '){
                            sb.append(c);
                        }
                    }                
                    if(sb.toString().length() > 0){
                        System.out.println(sb.toString());
                        if(values.get(hight-1)[i].trim().equals("+")){
                            result += Long.parseLong(sb.toString());
                        }else {
                            result *= Long.parseLong(sb.toString());
                        }                        
                    }
                }
            sum += result;
        }
    }
}
