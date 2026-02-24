import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class D9q2 {
    public static void main(String[] args) throws IOException{
        String[] content = Files.readString(Path.of("inputd9.txt")).split("\\R");
        helper(content);
    }

    static void helper(String[] content) {
        Long maxarea = Long.MIN_VALUE;
        for(int i=0; i<content.length; i++){

            String[] pointA = content[i].split(",");
            for(int j = i +1; j< content.length; j++){
                String[] pointB = content[j].split(",");
                if(checkValid(pointA, pointB)){
                    long result = calculateArea(pointA, pointB);
                    if( maxarea < result){
                        maxarea = result;
                        }
                    }
            }
        }
        System.out.println(maxarea);
    }

    static long calculateArea(String[] a, String[] b){
        return  (Math.abs(Long.parseLong(a[0]) - Long.parseLong(b[0])) +1) * (Math.abs(Long.parseLong(a[1]) - Long.parseLong(b[1])) + 1) ;
    }

    static boolean checkValid(String[] a, String[] b){
        String[] pointC = {b[0], a[1]};
        String[] pointD = {a[0], b[1]};
        
        return true;
    }
}