package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	private void dfs(String s,Set<String> set){
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0;i < sb.length();i++){
            char c = sb.charAt(i);
            if(c == '(') count++;
            if(c == ')') count--;
            if(count < 0){
                for(int j = 0;j <= i;j++){
                    System.out.println(j + "       " + i);
                    if(sb.charAt(j) == ')'){
                        dfs(sb.deleteCharAt(j).toString(),set);
                        sb.insert(j,')');
                        count++;
                    }
                }
                break;
            }
             if(i == sb.length() - 1 && count == 0){
                set.add(sb.toString());
                System.out.println(set);
                return;
            }
        }
        count = 0;
        for(int i = sb.length() - 1;i >= 0;i--){
            char c = sb.charAt(i);
            if(c == ')') count++;
            if(c == '(') count--;
            if(count < 0){
                for(int j = sb.length() - 1;j >= i;j--){
                    if(sb.charAt(j) == '('){
                        dfs(sb.deleteCharAt(j).toString(),set);
                        sb.insert(j,')');
                        count++;
                    }
                }
                break;
            }
            if(i == 0 && count == 0){
                set.add(sb.toString());
                return;
            }
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        dfs(s,set);
        return new ArrayList<String>(set);
    }
    public static void main(String[] args) {
		String s = "()())()";
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(s));
	}
//    
}
