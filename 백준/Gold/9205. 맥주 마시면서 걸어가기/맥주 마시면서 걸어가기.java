import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        BFSHandler bfsHandler = new BFSHandler();

        int testCase = inputHandler.readTestCaseCount();
        for (int t = 0; t < testCase; t++) {
            TestCaseData data = inputHandler.readTestCaseData();
            boolean result = bfsHandler.canReachEnd(data);
            outputHandler.appendResult(result);
        }
        outputHandler.printResults();
    }
}

// Input 처리 클래스
class InputHandler {
    private final BufferedReader br;

    public InputHandler() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readTestCaseCount() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public TestCaseData readTestCaseData() throws IOException {
        int storeSize = Integer.parseInt(br.readLine());
        int[] startXY = readCoordinates();
        int[][] storeXY = new int[storeSize][2];
        for (int i = 0; i < storeSize; i++) {
            storeXY[i] = readCoordinates();
        }
        int[] endXY = readCoordinates();
        return new TestCaseData(startXY, endXY, storeXY);
    }

    private int[] readCoordinates() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }
}

// Output 처리 클래스
class OutputHandler {
    private final StringBuilder sb;

    public OutputHandler() {
        this.sb = new StringBuilder();
    }

    public void appendResult(boolean result) {
        sb.append(result ? "happy" : "sad").append('\n');
    }

    public void printResults() {
        System.out.print(sb);
    }
}

// BFS 탐색 로직 처리 클래스
class BFSHandler {
    public boolean canReachEnd(TestCaseData data) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[data.storeXY.length];

        queue.add(data.startXY);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            // 도착지와의 거리 계산
            if (manhattanDistance(current, data.endXY) <= 1000) {
                return true;
            }

            for (int i = 0; i < data.storeXY.length; i++) {
                if (visited[i]) continue;
                if (manhattanDistance(current, data.storeXY[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(data.storeXY[i]);
                }
            }
        }

        return false;
    }

    private int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}

// 테스트 케이스 데이터 클래스
class TestCaseData {
    public final int[] startXY;
    public final int[] endXY;
    public final int[][] storeXY;

    public TestCaseData(int[] startXY, int[] endXY, int[][] storeXY) {
        this.startXY = startXY;
        this.endXY = endXY;
        this.storeXY = storeXY;
    }
}
