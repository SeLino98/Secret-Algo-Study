import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] arrList = br.readLine().toCharArray();
        int arrSize = arrList.length - 1 ;
        int searchSize = arrList.length/2;
        boolean isFlag = true;

        for (int i = 0; i < searchSize; i++) {
            if (arrList[i] != arrList[arrSize-i]){
                isFlag = false;
                break;
            }
        }
        if (isFlag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
