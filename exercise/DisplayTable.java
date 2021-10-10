package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DisplayTable {
	public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer,Map<String,Integer>> displayTables = new TreeMap<>();
        Set<String> foods = new HashSet<>();
        for(int i = 0;i < orders.size();i++){
            List<String> order = orders.get(i);
            int tableNumber = Integer.parseInt(order.get(1));
            Map<String,Integer> rowMap = displayTables.getOrDefault(tableNumber,new TreeMap<String,Integer>());
            displayTables.put(tableNumber, rowMap);
            rowMap.put(order.get(2),rowMap.getOrDefault(order.get(2),0) + 1);
            foods.add(order.get(2));
        }
        
        List<List<String>> res = new ArrayList<>();
        boolean first = true;
        for(Map.Entry<Integer,Map<String,Integer>> entry : displayTables.entrySet()){
            Integer tableNumber = entry.getKey();
            Map<String,Integer> rowMap = entry.getValue();
            if(first){
                Set<String> foodItems = rowMap.keySet();
                List<String> tableHead = new ArrayList<>();
                tableHead.add("Table");
                tableHead.addAll(foodItems);
                res.add(tableHead);
                first = false;
            }
            List<String> body = new ArrayList<>();
            body.add(tableNumber.toString());
            for(String s : foods){
                body.add(rowMap.getOrDefault(s,0).toString());
            }
            res.add(body);
        }
        return res;
    }
	public static void main(String[] args) {
		List<List<String>> lists = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		List<String> list4 = new ArrayList<>();
		List<String> list5 = new ArrayList<>();
		list1.add("James");
		list1.add("12");
		list1.add("Fried Chicken");
		list2.add("Ratesh");
		list2.add("12");
		list2.add("Fried Chicken");
		list3.add("Amadeus");
		list3.add("12");
		list3.add("Fried Chicken");
		list4.add("Adam");
		list4.add("1");
		list4.add("Canadian Waffles");
		list5.add("Brianna");
		list5.add("1");
		list5.add("Canadian Waffles");
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		lists.add(list5);
		System.out.println(new DisplayTable().displayTable(lists));		
	}
}
