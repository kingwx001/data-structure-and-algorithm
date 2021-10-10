package exercise;

import java.util.ArrayList;
import java.util.List;

public class findNumOfValidWords {
	    public static List<Integer> findNumOfValidWord(String[] words, String[] puzzles) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < puzzles.length;i++){
            int[] hash = new int[26];
            for(int j = 0;j < puzzles[i].length();j++){
                hash[puzzles[i].charAt(j) - 'a']++;
            }
            
            int count = 0;//���յ׵��ʼ���
            for(int j = 0;j < words.length;j++){
            	boolean flag = false;//�ж��Ƿ����յ�
                for(int k = 0;k < words[j].length();k++){
                    char c = words[j].charAt(k);
                    System.out.println(c);
                    if(hash[c - 'a'] == 0){
                        flag = false;
                        break;
                    }
                    if(puzzles[i].charAt(0) == c){
                    	System.out.println(puzzles[i].charAt(0));
                        flag = true;
                    }
                }
                
                if(flag) count++;  
                System.out.println(count);
            }
            res.add(count);
        }
        return res;
    }
	public static void main(String[] args) {
		String[] words = new String[] {"kkaz","kaaz","aazk","aaaz","abcdefghijklmnopqrstuvwxyz","kkka","kkkz","aaaa","kkkk","zzzz"
	};
		String[] puzzles = new String[] {"kazxyuv"};
		System.out.println(findNumOfValidWord(words,puzzles));
		
	}	
}
