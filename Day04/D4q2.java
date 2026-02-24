import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class D4q2 {

    static int count;
    static int rb;
    static int cb;
    static int curr = 64;
    public static void main(String[] args){
        List<String> lines = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("inputd4.txt"))){
            String line;
            while( (line = bf.readLine()) != null){
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        }    
        catch(IOException e){
            System.out.println("error : "+ e);
        }
        int rows = lines.size();
        int cols= lines.get(0).length();
        rb = rows;
        cb = cols;
        int[][] input = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String currentLine = lines.get(i);
            for (int j = 0; j < cols; j++) {
                input[i][j] = currentLine.charAt(j);
            }
        }

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };
        Matrixsol(input, dirs, rows, cols);
        System.out.println(count);
    }

    public static void Matrixsol(int[][] input, int[][] dirs, int rows, int cols){
        int rolls = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(input[i][j] == curr){
                    if(validRoll(i, j, input, dirs, curr)){
                        rolls++;
                        // System.out.println(i + ","+ j);
                    }else input[i][j] +=1;
                }
            }
        }
        count += rolls;
        if(rolls > 0) {
            System.out.println("current round done total replaced : " + rolls);
            curr++;
            Matrixsol(input, dirs, rows, cols);
        }
    }

    public static boolean validRoll(int i, int j, int[][] input, int[][] dirs,int curr){
        int vc = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (isValidPos(x, y) == 1){
                if(input[x][y] == curr || input[x][y] == curr +1) vc++;
            }
            if(vc > 3) return false;
        }
        return true;
    }

    static int isValidPos(int x, int y) {
        if (x < 0 || y < 0 || x >= rb || y >= cb ) return 0;
        return 1;
    }
}
