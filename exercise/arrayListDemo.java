package exercise;

import java.util.ArrayList;

public class arrayListDemo {
	public static void main2(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		//���ü��Ϸ���add�洢Ԫ��
		array.add("abc");
		array.add("itcast");
	    array.add("love");
		array.add("java");
		//������ϵĳ���,���ü��Ϸ���size, size�����ķ���ֵ���� int
		int size = array.size();
		System.out.println(size);
		
		//��ȡ�������е�һ��Ԫ��,��ȡ1������Ԫ��
		//���ϵķ���get, ��ȡԪ�غ�����������
		String s = array.get(1);
		System.out.println(s);
		
		
		System.out.println(array.get(0));
		System.out.println(array.get(1));
		System.out.println(array.get(2));
		System.out.println(array.get(3));
	
	}
}
