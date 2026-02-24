import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D8q2 {
    public static void main(String[] args) throws IOException{
        String[] content = Files.readString(Path.of("inputd8.txt")).split("\\R");

        helper(content);
    }

    static void helper(String[] cordinates){

        Map<String, Double> map = new HashMap<>();

        
        for(int i=0; i<cordinates.length; i++){
            for(int j = i+1; j<cordinates.length; j++){
                double dis = getDistance(cordinates[i], cordinates[j]);
                map.put(cordinates[i].toString() + "#" + cordinates[j], dis);
            }
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());        
        list.sort((entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));

        Map<String , String> parent = new HashMap<>();
        Map<String , Integer> size = new HashMap<>();

        for(String point : cordinates){
            parent.put(point, point);
            size.put(point,1);
        }

        int circuitsRemaining = cordinates.length;

        for(Map.Entry<String, Double> entry : list){
            String[] part = entry.getKey().split("#");
            String point1 = part[0];
            String point2 = part[1];
            String leader1 = point1;
            String leader2 = point2;

            while (!parent.get(leader1).equals(leader1)) {
                parent.put(leader1, parent.get(leader1));
                leader1 = parent.get(leader1);
            }
            while (!parent.get(leader2).equals(leader2)) {
                parent.put(leader2, parent.get(leader2));
                leader2 = parent.get(leader2);
            }
            
            if (!leader1.equals(leader2)) {
                parent.put(leader1, leader2);
                size.put(leader2, size.get(leader1) + size.get(leader2));
                circuitsRemaining--;

                if (circuitsRemaining == 1) {
                System.out.println("The final connection is between:");
                System.out.println(point1 + " and " + point2);
                getans(point1,point2);
                break; 
            }
            }
        }
    }

    static double getDistance(String point1, String point2){
        String[] a= point1.split(",");
        String[] b= point2.split(",");

        return  Math.hypot(Math.hypot(Long.parseLong(a[0]) - 
        Long.parseLong(b[0]), Long.parseLong(a[1]) - 
        Long.parseLong(b[1])), Long.parseLong(a[2]) - 
        Long.parseLong(b[2]));
    }

    static void getans(String point1, String point2){
        String[] a= point1.split(",");
        String[] b= point2.split(",");

        System.out.println("ans is " + Long.parseLong(a[0]) * Long.parseLong(b[0])); 
    }
}
