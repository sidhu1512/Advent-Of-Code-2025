import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class D5q1 {

    static int count;
    public static void main(String[] args){
        List<String> lines = new ArrayList<>();
        
        //ArrayList<Long> arr =  new ArrayList<>();
        List<Long[]> fullList = new ArrayList<>();
        boolean flag =  false;

        try(BufferedReader bf = new BufferedReader(new FileReader("inputd5.txt"))){
            String line;
            while( (line = bf.readLine()) != null){
                if (!line.isEmpty() && !flag) {
                    flag = false;
                    lines.add(line);
                }else {
                    flag = true;
                    if (!line.isEmpty()) {
                        countFresh(fullList,Long.parseLong(line));
                    }else{
                        computeList(lines, fullList);
                    }
                }
            }
        }    
        catch(IOException e){
            System.out.println("error : "+ e);
        }        
        System.out.println(count);
    }

    static void computeList(List<String> lines,List<Long[]> fullList ){
        int rows = lines.size();
        Long[][] ranges = new Long[rows][2];

        for(int i=0; i<rows; i++){
            ranges[i][0] = Long.parseLong(lines.get(i).split("-")[0]);
            ranges[i][1] = Long.parseLong(lines.get(i).split("-")[1]);
        }
        Arrays.sort(ranges, (a, b) -> Long.compare(a[0], b[0]));
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
    }


    static void countFresh(List<Long[]> fullList, Long l){
            for(Long[] range: fullList){
                if(l < range[0]){
                    break;
                }
                if(l >= range[0] && l <= range[1]){
                    count++;
                    break;
                }
            }
    }
}
