import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D6q3 {

    static long sum;
    public static void main(String[] args) throws IOException{

        String[] content = Files.readString(Path.of("inputd6.txt")).split("\\R");
        
        solveProblem(content);
        System.out.println(sum);
    }

    static void solveProblem(String[] content){

        String OpString = content[content.length-1];
        int length = OpString.length();

        int startIdx = 0;
        int endIdx = OpString.length()-1;

        for(int i= length-1; i>=0; i-- ){
            char Operator = OpString.charAt(i);
            if(Operator == '+' || Operator == '*'){
                startIdx = i;
                calculateSum(content, startIdx, endIdx,Operator );
                endIdx = startIdx - 1;
            }
        }
    }

    static void calculateSum(String[] content, int startIdx, int endIdx, char Operator){

        Long result;
        if(Operator == '+'){
            result = (long)0;
        }else{
            result = (long)1;
        }

        for(int i=endIdx; i >= startIdx; i--){
            StringBuilder sb =  new StringBuilder();
            for(int j=0; j<content.length -1; j++){
                char c = content[j].charAt(i);
                if(c != ' '){
                    sb.append(c);
                }
            }
            String temp = sb.toString();
            if(temp.length() > 0){
                if(Operator == '+'){
                    result += Long.parseLong(temp);
                }else{
                    result *= Long.parseLong(temp);
                }
            }
        }
        System.out.println(result);
        sum += result;
    }
}
