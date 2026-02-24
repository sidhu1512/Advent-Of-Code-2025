import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D8q1 {

    static long sum;
    public static void main(String[] args) throws IOException{
        String[] content = Files.readString(Path.of("inputd8.txt")).split("\\R");

        helper(content);
        System.out.println(sum);
    }

    static void helper(String[] cordinates){

        Map<String, Double> map = new HashMap<>();

        
        for(int i=0; i<cordinates.length; i++){
            for(int j = i+1; j<cordinates.length; j++){
                double dis = getDistance(cordinates[i], cordinates[j]);
                map.put(cordinates[i].toString() + "#" + cordinates[j], dis);
                sum += 1;
                // System.out.println(dis);
            }
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());        
        list.sort((entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));

        
        // for(int i=0; i< 5; i++){
        // System.out.println("keys : " + list.get(i).getKey() + " , distance = : " + list.get(i).getValue());
        // }
        //System.out.println(map);

        Map<String , String> parent = new HashMap<>();
        Map<String , Integer> size = new HashMap<>();

        for(String point : cordinates){
            parent.put(point, point);
            size.put(point,1);
        }

        int totalConnection = 0;

        for(Map.Entry<String, Double> entry : list){
            String[] part = entry.getKey().split("#");
            String point1 = part[0];
            String point2 = part[1];
            String leader1 = point1;
            String leader2 = point2;

            while (!parent.get(leader1).equals(leader1)) {
                leader1 = parent.get(leader1);
            }
            while (!parent.get(leader2).equals(leader2)) {
                leader2 = parent.get(leader2);
            }
            
            if (!leader1.equals(leader2)) {
                parent.put(leader1, leader2);
                size.put(leader2, size.get(leader1) + size.get(leader2));
            }
            totalConnection++;  
            if(totalConnection == 10){
                break;
            }
            
        }

        List<Integer> finalSizes = new ArrayList<>();
        long result = 1;

        for (String p : parent.keySet()) {
            if (parent.get(p).equals(p)) {
                finalSizes.add(size.get(p));
            }    
        }

        finalSizes.sort(Collections.reverseOrder());
        for(int t =0 ; t<3 ; t++){
            result*= finalSizes.get(t);
        }
        sum = result;

    }

    static double getDistance(String point1, String point2){
        String[] a= point1.split(",");
        String[] b= point2.split(",");

        return  Math.hypot(Math.hypot(Long.parseLong(a[0]) - 
        Long.parseLong(b[0]), Long.parseLong(a[1]) - 
        Long.parseLong(b[1])), Long.parseLong(a[2]) - 
        Long.parseLong(b[2]));
    }
}
