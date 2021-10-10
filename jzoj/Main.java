package jzoj;

import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0;i < n;i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        for(int i = 0;i < n;i++){
            if(i <= n / 2) System.out.print(data[i * 2] + " ");
            else if(i == n - 1) System.out.println(data[(n - i) * 2 - 1]);
            else System.out.print(data[(n - i) * 2 - 1] + " ");
        }
    }
}
