import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int listSize = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());

        long[] list = new long[listSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < listSize; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            switch (code) {
                case 1: // list에서 value 이상인 첫 번째 위치 찾기
                    sb.append(listSize - lowerBound(list, value));
                    break;

                case 2: // list에서 value 초과인 첫 번째 위치 찾기
                    sb.append(listSize - upperBound(list, value));
                    break;

                case 3: // value 이상, value2 초과 범위 개수 찾기
                    long value2 = Long.parseLong(st.nextToken());
                    int left = lowerBound(list, value);
                    int right = upperBound(list, value2);
                    sb.append(right - left);
                    break;
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    // lowerBound: value 이상의 첫 번째 위치 반환
    static int lowerBound(long[] list, long value) {
        int left = 0, right = list.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // upperBound: value 초과의 첫 번째 위치 반환
    static int upperBound(long[] list, long value) {
        int left = 0, right = list.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] > value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
