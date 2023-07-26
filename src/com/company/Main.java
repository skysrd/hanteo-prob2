package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer sum = Integer.valueOf(bufferedReader.readLine());

        //","로 구분되는 String을 Integer List로 변환
        List<Integer> coins = Arrays.stream(bufferedReader.readLine().split(","))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();

        dfs(0, sum, coins, 0);

        //결과 출력
        System.out.println(result);
    }

    public static void dfs(int currentSum, int sum, List<Integer> coins, int level) {
        //currentSum보다 큰 경우 실패
        if (currentSum > sum) {
            return;
        }

        //currentSum과 동일한 경우 result 추가
        if (currentSum == sum) {
            result++;
            return;
        }

        //dfs
        for (int i = level; i < coins.size(); i++) {
            int tmp = currentSum + coins.get(i);
            if (tmp <= sum) {
                dfs(tmp, sum, coins, i);
            }
        }
    }
}