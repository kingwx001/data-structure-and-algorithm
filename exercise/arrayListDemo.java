package exercise;

import java.util.ArrayList;

public class arrayListDemo {
	public static void main2(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		//调用集合方法add存储元素
		array.add("abc");
		array.add("itcast");
	    array.add("love");
		array.add("java");
		//输出集合的长度,调用集合方法size, size方法的返回值类型 int
		int size = array.size();
		System.out.println(size);
		
		//获取出集合中的一个元素,获取1索引的元素
		//集合的方法get, 获取元素后结果数据类型
		String s = array.get(1);
		System.out.println(s);
		
		
		System.out.println(array.get(0));
		System.out.println(array.get(1));
		System.out.println(array.get(2));
		System.out.println(array.get(3));
	
	}
}
