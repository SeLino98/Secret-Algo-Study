import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 굴다리의 길이
        int sizeN = Integer.parseInt(br.readLine());

        // 가로등의 개수
        int countLight = Integer.parseInt(br.readLine());

        // 가로등 위치를 저장할 배열
        int[] list = new int[countLight];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < countLight; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 높이값을 구하기 위해 첫 구간과 마지막 구간 거리 확인
        int maxDistance = list[0]; // 시작점 ~ 첫 번째 가로등
        maxDistance = Math.max(maxDistance, sizeN - list[countLight - 1]); // 마지막 가로등 ~ 끝점

        // 가로등 사이의 최대 거리 계산
        for (int i = 1; i < countLight; i++) {
            int distance = (list[i] - list[i - 1] + 1) / 2; // 가로등 사이의 거리의 절반 (홀수일 경우 올림)
            maxDistance = Math.max(maxDistance, distance); // 최대 거리 갱신
        }

        // 최종적으로 모든 구간을 커버할 수 있는 최소 높이 출력
        System.out.println(maxDistance);
    }
}
