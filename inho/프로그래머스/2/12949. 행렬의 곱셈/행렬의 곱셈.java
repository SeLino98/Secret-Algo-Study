import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
class Solution {
   public static int[][] solution(int[][] arr1, int[][] arr2) {
        //arr1이 행
        //arr2가 열
        // System.out.println(arr1.length+"::"+ arr2.length);
//        System.out.println(arr1[0].length+"::"+ arr2[0].length);

        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[1].length; j++) {
                for (int k = 0; k < arr1[1].length; k++) {
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
                // System.out.print(answer[i][j]+" ");
            }
            // System.out.println();
        }
        return answer;
    }
}