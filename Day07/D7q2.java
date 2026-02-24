import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D7q2 {

    static long sum;
    public static void main(String[] args) throws IOException{
        String[] content = Files.readString(Path.of("inputd7.txt")).split("\\R");
        helper(content, 2, content[0].indexOf('S'));
        System.out.println(sum);
    }
    static void helper(String[] content, int start, int idx){
        for(int i=start; i<content.length -1; i = i +2){            
            char c = content[i].charAt(idx);
            if (c == '^') {
                helper(content, i+2, idx-1);
                helper(content, i+2, idx+1);
                return;
            }   } sum += 1;         
        }
}