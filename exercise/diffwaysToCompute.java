package exercise;

import java.util.ArrayList;
import java.util.List;

public class diffwaysToCompute {
	List<Integer> res = new ArrayList<>();
    private long calc(long n1,long n2,long opr){
        switch((int)opr){
            case '+':
            return n1 + n2;
            case '-':
            return n1 - n2;
            case '*':
            return n1 * n2;
        }
        return 0;
    }
    
    private void divide(long[] exp){
        if(exp[1] == 0){
            res.add((int)exp[0]);
            return;
        }
        for(int i = 0;i < exp.length;i++){
            if(exp[i] > Integer.MAX_VALUE){
                long n1 = exp[i - 1],n2 = exp[i + 1];
                long opr = exp[i];
                long result = calc(n1,n2,opr - Integer.MAX_VALUE);
                exp[i - 1] = result;
                for(int j = i;j < exp.length - 2;j++){
                    exp[j] = exp[j + 2];
                }
                exp[exp.length - 2] = 0;
                exp[exp.length - 1] = 0;
                divide(exp);
                for(int j = exp.length - 3;j >= i;j--){
                    exp[j + 2] = exp[j];
                }
                exp[i - 1] = n1;
                exp[i] = opr;
                exp[i + 1] = n2;
            }
        }
    }
    public List<Integer> diffWaysToCompute(String expression) {
        long[] exp = new long[expression.length()];
        int i = 0,num = 0,j = 0;
        while(i < expression.length()){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
                i++;
            }else{
                exp[j++] = num;
                exp[j++] = Integer.MAX_VALUE + (long)c;
                num = 0;
                i++;
            }
        }
        exp[j++] = num;
        divide(exp);
        return res;
    }
    public static void main(String[] args) {
		String s = "2-1-1";
		System.out.println(new diffwaysToCompute().diffWaysToCompute(s));
	
	}
}
