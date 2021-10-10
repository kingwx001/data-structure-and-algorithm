package exercise;

import java.util.Arrays;


public class MergeSort {
	  class Data implements Comparable<Data>{
        public int value;
        public int count;
        public Data(){};
        public Data(int value,int count){
            this.value = value;
            this.count = count;
        }
//        public Data(Data data){
//            this.value = data.value;
//            this.count = data.count;
//        }
		@Override
		public int compareTo(Data d) {
			if(this.count == d.count) return this.value - d.value;
            return this.count - d.count;
		}
		
    }
    void mergeSort(Data[] arr,int l,int r){
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1,r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr,l,mid,r);
    }
    void merge(Data[] arr, int l, int mid, int r){
        Data[] aux =  Arrays.copyOfRange(arr,l,r + 1);
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){
                arr[k] = aux[i-l]; i ++;
            }
            else{
                arr[k] = aux[j-l]; j ++;
            }
        }
    }
    public int[] sortByBits(int[] arr) {
    	int n = arr.length;
        Data[] data = new Data[n];
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            int count = 0,num = arr[i];
            while(num != 0){
                count += num & 1;
                num = num >> 1;
            }
            data[i] = new Data(arr[i],count);
        }
        mergeSort(data,0,n - 1);
        for(int i = 0;i < n;i++){
            res[i] = data[i].value;
        }
        return res;
    }
    public static void main(String[] args) {
		int[] test = new int[] {0,1,2,3,4,5,6,7,8};
		test = new MergeSort().sortByBits(test);
		System.out.print(Arrays.toString(test));
		
	}
}
