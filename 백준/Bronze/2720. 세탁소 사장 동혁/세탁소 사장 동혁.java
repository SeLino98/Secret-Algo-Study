import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            int amount = Integer.parseInt(br.readLine());
            int[] coins = calculateCoins(amount);
            sb.append(coins[0]).append(" ").append(coins[1]).append(" ")
              .append(coins[2]).append(" ").append(coins[3]).append('\n');
        }

        System.out.print(sb);
    }

    private static int[] calculateCoins(int amount) {
        int[] coins = new int[4];
        coins[0] = amount / 25; // quarters
        amount %= 25;
        coins[1] = amount / 10; // dimes
        amount %= 10;
        coins[2] = amount / 5;  // nickels
        coins[3] = amount % 5;  // pennies
        return coins;
    }
}
