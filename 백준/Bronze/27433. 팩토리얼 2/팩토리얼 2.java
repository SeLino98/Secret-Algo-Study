import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long value = Long.parseLong(br.readLine());
        System.out.println(combination(value));
    }
    static public Long combination(Long value){
        if (value==0) return Long.parseLong("1");
        else{
            return value*combination(value-1);
        }
    }
}
