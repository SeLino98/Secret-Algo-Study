import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int myLanCable = Integer.parseInt(st.nextToken());
        int needLanCable = Integer.parseInt(st.nextToken());
        int [] cableList = new int[myLanCable];
        long maxValue = 0;
        for (int i = 0; i < myLanCable; i++) {
            cableList[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(cableList[i],maxValue);
        }
        long minValue = 0;
        long midValue = 0;
        maxValue++;
        while (maxValue>minValue){
            midValue = (maxValue+minValue)/2;
            long count = 0;
            for (int j : cableList) {
                count += j / midValue;
            }
            if (count<needLanCable){
                maxValue = midValue;
            }else{
                minValue = midValue+1;
            }
        }
        System.out.println(minValue-1);
    }
}
