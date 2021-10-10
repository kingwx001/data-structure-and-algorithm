package exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class getorder {

	    class Node{
	        int[] task;
	        int index;
	        Node(int[] task,int index){
	            this.task = task;
	            this.index = index;
	        }
			@Override
			public String toString() {
				return "Node [task=" + Arrays.toString(task) + ", index=" + index + "]";
			}
	        
	    }

	    public int[] getOrder(int[][] tasks) {
	        int m = tasks.length;
	        int[] res = new int[m];
	        Node[] sortTasks = new Node[m];
	        int resIndex = 0,curTime = 0,tasksIndex = 1;

	        for(int i = 0;i < m;i++){
	           sortTasks[i] = new Node(tasks[i],i);
	        }

	        Arrays.sort(sortTasks,(a,b) -> {
	            if(a.task[0] == b.task[0]){
	                return a.task[1] - b.task[1];
	            }
	            return a.task[0] - b.task[0];
	        });
	        @SuppressWarnings({ "unchecked", "rawtypes" })
			PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {
		        public int compare(Node o1, Node o2) {
		            if(o1.task[1] == o2.task[1]){
	                    return o1.index - o2.index;
	                }
		            return o1.task[1] - o2.task[1];
		        }
		        
		    });
	        pq.offer(sortTasks[0]);
	        curTime = sortTasks[0].task[0];
	        while(pq.size() != 0){
	            Node task = pq.poll();
	            curTime += task.task[1];
	            res[resIndex++] = task.index;
	            while(tasksIndex < m && sortTasks[tasksIndex].task[0] <= curTime){
	            	pq.offer(sortTasks[tasksIndex++]);
	            }
	            if(pq.size() == 0 && tasksIndex < m) {
	            	curTime = sortTasks[tasksIndex].task[0];
	            	pq.offer(sortTasks[tasksIndex++]);
	            }
	        }
	        return res;
	    }
	    public static void main(String[] args) {
			int[][] task = {{1,2},{2,4},{3,2},{4,1}};
			System.out.println(Arrays.toString(new getorder().getOrder(task)));
		}
}
