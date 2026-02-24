import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class D5q2 {

    static Long count = (long) 0;
    public static void main(String[] args){
        List<String> lines = new ArrayList<>();
        boolean flag =  false;
        try(BufferedReader bf = new BufferedReader(new FileReader("inputd5.txt"))){
            String line;
            while( (line = bf.readLine()) != null && !flag){
                if (!line.isEmpty() && !flag) {
                    flag = false;                    
                    lines.add(line);
                }else {
                    flag = true;
                }
            }
        }    
        catch(IOException e){
            System.out.println("error : "+ e);
        }
        int rows = lines.size();
        Long[][] ranges = new Long[rows][2];

        for(int i=0; i<rows; i++){
            ranges[i][0] = Long.parseLong(lines.get(i).split("-")[0]);
            ranges[i][1] = Long.parseLong(lines.get(i).split("-")[1]);
        }

        Arrays.sort(ranges, (a, b) -> Long.compare(a[0], b[0]));
        List<Long[]> fullList = new ArrayList<>();
        Long [] current = ranges[0];

        for(int i=1; i< rows; i++){
            if(ranges[i][0] <= current[1]){
                current[1]  = Math.max(current[1], ranges[i][1]);
            } else {
                fullList.add(current);
                current = ranges[i];
            }
        }
        fullList.add(current);

        countFresh(fullList);
        System.out.println(count);

    }


    static void countFresh(List<Long[]> fullList){
        
        for(Long[] l : fullList){
            Long num = l[1] - l[0] + 1;
            count += num;
        }
    }

}
