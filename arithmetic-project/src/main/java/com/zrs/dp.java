package com.zrs;

import java.util.ArrayList;

public class dp {

    public static void main(String[] args) {
        dp(16,3);

    }

    //价值
    public static int[] V = new int[100];
    //重量
    public static int[] G = new int[100];
    public static int[][] result = new int[1000][100];

    /**
     * m重量的背包 装n件东西
     * @param m
     * @param n
     */
    public static void dp(int m, int n){

        {
                V[1] = 2;G[1] = 4;
                V[2] = 8;G[2] = 4;
                V[3] = 5;G[3] = 7;
                V[4] = 3;G[4] = 5;
                V[5] = 2;G[5] = 8;
                V[6] = 67;G[6] = 22;
                V[7] = 4;G[7] = 33;
        }

        for (int i = 0; i < m; i++) {
            result[i][0] = 0;
            result[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int y1=0,y2=0;
                if(i >=G[j]){
                    y1 = V[j] + result[i - G[j]][j-1];
                }
                y2 = result[i][j-1];

                if(y1>y2){
                    result[i][j] = y1;
                }else{
                    result[i][j] = y2;
                }
                System.out.println("i="+i+",j="+j+",result="+result[i][j]);
            }

        }

    }
}
