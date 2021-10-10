package exercise;

public class matrixrotate {
	public int orchestraLayout(int num, int xPos, int yPos) {
        int min = Math.min(xPos,yPos);
        min = Math.min(min,num - xPos - 1);
        min = Math.min(min,num - yPos - 1);
        long count = (long)num * num - (long)(num -  2 * min) * (num - 2 * min);
        if(min == xPos){
            count += yPos - min + 1;
        }
        else if(min == num - 1 - yPos){
            count += num - 2 * min + xPos - min;
        }
        else if(min == num - 1 - xPos){
            count += (num - 2 * min) * 3 - 2 - (yPos - 1 - min);
        }
        else if(min == yPos){
            count += (num - 2 * min) * 4 - 4 - (xPos - 1 - min);
        }
        return (int)((count - 1) % 9) + 1;
    }
	public static void main(String[] args) {
		System.out.println(new matrixrotate().orchestraLayout(5,2,2));
	}
}
