package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class regx {
	class NFA {
		Map<Integer, Map<Character, Integer>> nfa = new HashMap<>();
		int start = 0;
		Set<Integer> end = new HashSet<>();

		NFA(String s) {
			int key = start;
			nfa.put(key, new HashMap<Character, Integer>());
			for (int i = 0; i < s.length() - 1; i++) {
				char c = s.charAt(i);
				if (c != '*') {
					nfa.get(key).put(c, key + 1);
					key++;
					nfa.put(key, new HashMap<Character, Integer>());
					int j = 0;
					while (i + j + 1 < s.length() && s.charAt(i + 1 + j) == '*') {
						if (i + j + 2 < s.length()) {
							nfa.get(key - 1).put(s.charAt(i + j + 2), key + 1 + j / 2);
						} else {
							end.add(key - 1);
						}
						nfa.get(key).put(s.charAt(i), key);
						j += 2;
					}
				}
			}
			char last = s.charAt(s.length() - 1);
			if( last != '*') {
				nfa.get(key).put(last, key + 1);
				key++;
			}
			end.add(key);
		}

	}

	public boolean isMatch(String s, String p) {
		NFA obj = new NFA(p);
		int state = obj.start;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Map<Character, Integer> map = obj.nfa.get(state);
			if ((map == null) || (!map.containsKey('.') && !map.containsKey(c)))
				return false;
			if (map.containsKey(c))
				state = map.get(c);
			else
				state = map.get('.');
		}
		return obj.end.contains(state);
	}

	public static void main(String[] args) {
		String s = "aaa", p = "ab*a*c*a";
		System.out.println(new regx().isMatch(s, p));
	}
}
