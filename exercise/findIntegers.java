package exercise;

public class findIntegers {
	private int maxdepth;
    private int n2;

    private int dfs(int depth, int num, int numNow){
        numNow*=2;
        numNow+=num;
        
        if(numNow>n2) return 0;//判断当前数是否大于给定的数
        if(depth == maxdepth) return 1;//到达最大深度

        if(num == 0) return dfs(depth+1, 0,numNow)+dfs(depth+1,1,numNow);//当前节点为0
        return dfs(depth+1,0,numNow);//节点为1
    }
    
    public int findInteger(int n) {
        n2=n;
        maxdepth=0;
        while(n>0){
            maxdepth++;
            n/=2;
        }

        return dfs(1,0,0)+dfs(1,1,0);
    }
    public static void main(String[] args) {
    	long currentTimeMillis = System.currentTimeMillis();
    	for(int i = 0;i < 1000000000;i++) {
    		int[] arr = new int[1];
    	}
		//System.out.println(new findIntegers().findInteger(1000000000));
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}
}
