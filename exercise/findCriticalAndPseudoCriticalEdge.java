package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findCriticalAndPseudoCriticalEdge {
	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		Set<Integer> set = new HashSet<>();
		Set<Integer> set1 = new HashSet<>();
		List<List<Integer>> res = new ArrayList<>();
	    List<Integer> criticalEdges = new ArrayList<>();
//		List<Integer> pseudoCriticalEdges = new ArrayList<>();
	    res.add(criticalEdges);
//		res.add(pseudoCriticalEdges);
		while (true) {
			for (int i = 0; i < edges.length; i++) {
				if (!visited[i]) {
					if (set.isEmpty() || set.contains(edges[i][0]) && !set.contains(edges[i][1])
							|| set.contains(edges[i][1]) && !set.contains(edges[i][0])) {
						visited[i] = true;
						set.add(edges[i][0]);
						set.add(edges[i][1]);
						break;
					}
					if (set.contains(edges[i][0]) && set.contains(edges[i][1])) {
						int j = i;
						while(set.contains(edges[i][0]) && set.contains(edges[i][1]) && edges[i][2] == edges[j][2]) {
							visited[j] = true;
							set1.add(j++);	
						}
						j = i;
						while(j >= 0 && set.contains(edges[i][0]) && set.contains(edges[i][1]) && edges[i][2] == edges[j][2]) {
							visited[j] = true;
							set1.add(j--);	
						}
					}
				}
			}
			if (set.size() == n) {
				for (int i = 0; i < edges.length; i++) {
					if (!visited[i]) {
						if (set.contains(edges[i][0]) && set.contains(edges[i][1])) {	
							int j = i + 1;
							while(j < edges.length && set.contains(edges[i][0]) && set.contains(edges[i][1]) && edges[i][2] == edges[j][2]) {
								visited[j] = true;
								set1.add(i);
								set1.add(j++);	
									
							}
							j = i - 1;
							while(j >= 0 && set.contains(edges[i][0]) && set.contains(edges[i][1]) && edges[i][2] == edges[j][2]) {
								visited[j] = true;
								set1.add(i);
								set1.add(j--);
								
							}
						}
					}
				}
				for (int i = 0; i < n; i++) {
					if (!set1.contains(i)) {
						criticalEdges.add(i);
					}
				}
				break;
			}
		}
		res.add(new ArrayList<>(set1));
		return res;
	}
	public static void main(String[] args) {
		int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
		int n = 5;
		System.out.println(new findCriticalAndPseudoCriticalEdge().findCriticalAndPseudoCriticalEdges(n, edges));
	}
}
