import java.io.*;
import java.util.*;
class MeatInfo implements Comparable<MeatInfo>{
    int weight = 0;
    int price = 0;
    public MeatInfo(int weight,int price){
        this.weight = weight;
        this.price = price;
    }
    @Override
    public int compareTo(MeatInfo o) { //오름차순
        if (this.price == o.price){
            return o.weight-this.weight;
        }
        return this.price - o.price;
    }
}
public class Main {
    static int loaf;
    static long needMeat;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        loaf = Integer.parseInt(st.nextToken());
        needMeat = Long.parseLong(st.nextToken());
        MeatInfo[] arr = new MeatInfo[loaf];
        int total = 0;
        for (int i = 0; i < loaf; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            arr[i] = new MeatInfo(weight, price);
            total += weight;
        }
        if (total < needMeat) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);

        int tmpPrice = 0;
        int weightSum = 0;
        int priceSum = 0;
        int min = Integer.MAX_VALUE;
        for (MeatInfo cur : arr) {
            weightSum += cur.weight;
            if (tmpPrice != cur.price) {
                priceSum = tmpPrice = cur.price;
            } else {
                priceSum += cur.price;
            }

            if (weightSum >= needMeat) {
                min = Math.min(min, priceSum);
            }
        }

        System.out.println(min);
    }

}