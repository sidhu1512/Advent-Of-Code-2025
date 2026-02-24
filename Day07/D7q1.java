import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class D7q1 {

    static long sum;
    public static void main(String[] args) throws IOException{

        String[] content = Files.readString(Path.of("inputd7.txt")).split("\\R");
        
        helper(content);
        System.out.println(sum);
    }

    static void helper(String[] content){

        Set<Integer> beam = new HashSet<>();
        beam.add(content[0].indexOf('S'));

        for(int i=2; i<content.length -1; i = i +2){
            boolean flag = false;
            int bgidx = 0;
            System.out.println("current level : "+ i);

            while(!flag){                
                String s = content[i].substring(bgidx);
                int splitidx = s.indexOf('^');
                if(splitidx != -1){
                    splitidx += bgidx;
                    if(beam.contains(splitidx)){
                        bgidx = splitidx + 1;
                        sum +=1;
                        beam.remove(splitidx);
                        beam.add(splitidx - 1);
                        beam.add(splitidx + 1);
                        System.out.println("removed : "+ splitidx );
                    }
                    bgidx = splitidx + 1;
                }else{
                    flag = true;
                }
            }

        }
    }

}