import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class D11q2 {

    static int sum;
        static Map<String, List<String>> map = new HashMap<>();
        static Map<String, Long> times = new HashMap<>();

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

        helper( "svr", "fft");
        long fftcounts1 = times.getOrDefault("svr", 0L);
        times.clear();

        helper( "fft", "dac");
        long fftcounts2 = times.getOrDefault("fft", 0L);
        times.clear();

        helper( "dac", "out");
        long fftcounts3 = times.getOrDefault("dac", 0L);
        times.clear();

        helper( "svr", "dac");
        long daccounts1 = times.getOrDefault("svr", 0L);
        times.clear();

        helper( "dac", "fft");
        long daccounts2 = times.getOrDefault("dac", 0L);
        times.clear();

        helper( "fft", "out");
        long daccounts3 = times.getOrDefault("fft", 0L);
        times.clear();

        System.out.println((fftcounts1 * fftcounts2 * fftcounts3) + (daccounts1 * daccounts2 * daccounts3));
    }

    static void helper(String key, String end){

        if(key.equals(end)){
            times.put(key, 1L);
            return;
        }
        if(key.equals("out")){
            times.put(key, 0L);
            return;
        }

        if(times.containsKey(key)){
            return; 
        }

        List<String> start = map.get(key);
        if (start == null) {
            times.put(key, 0L);
            return;
        }

        for (String s : start) {
            if(times.containsKey(s)){
                times.put(key, times.getOrDefault(key, 0L) + times.get(s));
                continue;
            }
            helper(s, end);
            times.put(key, times.getOrDefault(key, 0L) + times.get(s));
        }
    }
}