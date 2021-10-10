package exercise;

import java.util.HashMap;
import java.util.Map;

public class nowcoder {
	public int numKLenSubstrRepeats (String s, int k) {
        // write code here
        int n = s.length(),ans = 0;
        if(n < k) return 0;
        for(int i = 0;i < n - k + 1;i++){
            boolean flag = false;
            for(int j = 0;j < k;j++){
                char c = s.charAt(i + j);
                Map<Character,Integer> map = new HashMap<>();
                int freq = map.getOrDefault(c,0);
                if(freq > 0){
                    flag = true;
                    break;
                }
                map.put(c,freq + 1);
            }
            if(flag) ans++;
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(new nowcoder().numKLenSubstrRepeats("createfunonyoka", 4));
	}
}
