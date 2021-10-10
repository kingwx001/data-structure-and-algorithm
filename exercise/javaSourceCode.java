package exercise;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class javaSourceCode {
	//第一篇 lang 包篇
	public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>>  -distance);
    }
	
	public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
	public static void pairInsertionSort(int[] a,int left,int right) {
		 do {
             if (left >= right) {
                 return;
             }
         } while (a[++left] >= a[left - 1]);

         for (int k = left; ++left <= right; k = ++left) {
             int a1 = a[k], a2 = a[left];

             if (a1 < a2) {
                 a2 = a1; a1 = a[left];
             }
             while (--k >= 0 && a1 < a[k]) {
                 a[k + 2] = a[k];
             }
             a[++k + 1] = a1;
             while (--k >= 0 && a2 < a[k]) {
                 a[k + 1] = a[k];
             }
             a[k + 1] = a2;
         }
         int last = a[right];

         while (last < a[--right]) {
             a[right + 1] = a[right];
         }
         a[right + 1] = last;
	}
	public static void main(String[] args) {
		//Integer篇
		System.out.println(Integer.toBinaryString(-1 >> 31));
		System.out.println(Integer.toBinaryString(-4 >> -1));
		System.out.println(Integer.toString(-222,16));
		//String篇
		String s1 = "\uffff\ud8ff\u0000\u0001\u0909\ud800\udbff\udc00\udfff";
		String s2 = "abcde";
		System.out.println(s2.codePointAt(0));
		//StringBuilder篇
		StringBuilder sb = new StringBuilder();
		//List篇
		List<Object> list = new ArrayList<>();
		list.add(list); 
		list.add(null);
		ListIterator<Object> iterator = list.listIterator(1);
		iterator.add(null);
		iterator.add(null);
		iterator = list.listIterator(0);
		System.out.println(iterator.next());
		Integer[] arr = (Integer[]) Array.newInstance(Integer.class, 2);
		System.out.println(2147483647*2);
		List<Object> list1 = list.subList(2, 3);
		System.out.println(list1.iterator().next());
		String[] ss = {"abc","abc","abc","abc","dcd"};
		List<String> list3 = new ArrayList<String>(); 
		System.out.println(Arrays.toString(list3.toArray(ss)));
		//Long篇
		Long l = new Long("125");
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put(0, null);
		map.put(2, 2);
		map.put(1, 1);
		map.put(3, 3);
		map.put(4, 4);
		map.computeIfPresent(0, new BiFunction<Object, Object, Object>() {
			@Override
			public Object apply(Object t, Object u) {
				return null;
			}
		});
		map.computeIfAbsent(2, a -> 3);
		map.merge(1,4,(a,b) -> (Integer)a + (Integer)b);
		System.out.println(new javaSourceCode().tableSizeFor(5));
		for(int i = 0;i < 5;i++) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getId());
				}
			});
			t.start();
		}
		
	}
		
}
	
	
