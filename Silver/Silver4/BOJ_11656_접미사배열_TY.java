package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N11656_Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = in.readLine();
        
        List<String> list = new ArrayList<>();
        
        int size = str.length();
        for (int i = 0; i < size; i++) {
            list.add(str.substring(i, size));
        }
    
        Collections.sort(list);
        
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
        
    }
}