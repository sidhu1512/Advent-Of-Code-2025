import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class D11q1 {

    static int sum;
        static Map<String, List<String>> map = new HashMap<>();
        static Map<String, Integer> times = new HashMap<>();

    public static void main(String[] args) throws IOException{
        String[] content = Files.readString(Path.of("inputd11.txt")).split("\\R");

        for(String s: content){
            String[] raw = s.split(" ");
            String key = raw[0].replace(":", "");
            List<String> value = new ArrayList<>();

            for(int i=1; i<raw.length; i++ ){
                value.add(raw[i]);
            }
            map.put(key, value);
        }

        helper( "you", "out");
        System.out.println(times.get("you"));
    }

    static void helper(String key, String end){

        List<String> start = map.get(key);
        for (String s : start) {
            if(times.containsKey(s)){
                times.put(key, times.getOrDefault(key, 0) + times.get(s));
                continue;
            }
            if(s.equals(end)){
                times.put(key, 1);
                return;
            }
            helper(s, end);
            times.put(key, times.getOrDefault(key, 0) + times.get(s));
        }
    }
}