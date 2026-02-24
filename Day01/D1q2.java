import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D1q2{

    public static int count = 0 ;
    public static void main(String[] args) {
        int dial = 50;
        try(BufferedReader bf = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while( (line = bf.readLine()) != null){
                dial = spinDial(line, dial);
            }
        }    
        catch(IOException e){
            System.out.println("error : "+ e);
        }
        System.out.println(count);
    }

    public static int spinDial(String s, int dial){
        int number = Integer.parseInt(s.substring(1));
        count +=  number/100;
        int rotation = number % 100;
        if(rotation == 0){
            return dial;
        }

        if(s.charAt(0) == 'R'){
            rotation = dial + rotation;
            if(rotation > 100){
                count++;
            }
            if(rotation > 99){
                rotation = rotation - 100;  
            }
        }else{
            rotation =  dial - rotation;
            if(rotation < 0){ 
                rotation += 100; 
                if(dial != 0){
                    count++;
                }
            }
        }
    if (rotation == 0){
        count++;
    }
    return rotation;
    };

}


