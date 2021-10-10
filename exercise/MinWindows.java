package exercise;

public class MinWindows {
	private boolean check(int[] map){
        for(int i = 0;i < map.length;i++){
            if(map[i] > 0)
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] map = new int[58];
        long mask = 0;
        int n = s.length(),minLen = n;
        String ans = s;
        for(int i = 0;i < t.length();i++){
            int j = t.charAt(i) - 'A';
            map[j]++;
            mask |= 1 << j;
        }
        
        int l = 0,r = 0;
        while(r < n){
            while(r < n && (1 << s.charAt(r) - 'A' & mask) == 0)
                r++;
            while(l < n && (1 << s.charAt(l) - 'A' & mask) == 0)
                l++;
            if(r >= n) break;
            map[s.charAt(r) - 'A']--;
            if(check(map)){
                if(s.charAt(r) == s.charAt(l)){
                    while(true){
                        while(l < n && (1 << s.charAt(l) - 'A' & mask) == 0)
                            l++;
                        if(map[s.charAt(l) - 'A'] == 0)
                            break;
                        map[s.charAt(l++) - 'A']++;
             
                    }
                }
                minLen = Math.min(minLen,r - l + 1);
                if(ans.length() > minLen)
                    ans = s.substring(l,r + 1);
           }
           r++;
        }
        return ans;
    }
    public static void main(String[] args) {
		String s = "ADOBECODEBANC",t = "ABC";
		System.out.println(new MinWindows().minWindow(s, t));
	}
}
