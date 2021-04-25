import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RadixSort {
	public static Queue<Integer> q0 = new LinkedList<Integer>();
	public static Queue<Integer> q1 = new LinkedList<Integer>();
	public static Queue<Integer> q2 = new LinkedList<Integer>();
	public static Queue<Integer> q3 = new LinkedList<Integer>();
	public static Queue<Integer> q4 = new LinkedList<Integer>();
	public static Queue<Integer> q5 = new LinkedList<Integer>();
	public static Queue<Integer> q6 = new LinkedList<Integer>();
	public static Queue<Integer> q7 = new LinkedList<Integer>();
	public static Queue<Integer> q8 = new LinkedList<Integer>();
	public static Queue<Integer> q9 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1000);
		list.add(4);
		list.add(25);
		list.add(319);
		list.add(88);
		list.add(51);
		list.add(3430);
		list.add(8471);
		list.add(701);
		list.add(1);
		list.add(2989);
		list.add(657);
		list.add(713);
		
		System.out.println(rSort(list));
		sc.close();
		
	}
	
	public static ArrayList<Integer> rSort(ArrayList<Integer> list) {
		ArrayList<Integer> newList = stages(list, "stage1");
		newList = stages(newList, "stage2");
		newList = stages(newList, "stage3");
		newList = stages(newList, "stage4");
		return newList;
	}
	
	public static ArrayList<Integer> stages(ArrayList<Integer> list, String stage) {

		for(int i = 0; i < list.size(); i++) {
			int digitToCheck;
			int digits;
			
			switch(stage) {
			case "stage1":
				digitToCheck = list.get(i) %10;
				break;
			case "stage2":
				digits = list.get(i) %100;
				digitToCheck = digits / 10;
				break;
			case "stage3":
				digits = list.get(i) %1000;
				digitToCheck = digits / 100;
				break;
			case "stage4":
				digits = list.get(i) %10000;
				digitToCheck = digits / 1000;
				break;
			default:
				digitToCheck = 0;
				break;
			}
			
			switch(digitToCheck) {
			case 0:
				q0.offer(list.get(i));
				break;
			case 1:
				q1.offer(list.get(i));
				break;
			case 2:
				q2.offer(list.get(i));
				break;
			case 3:
				q3.offer(list.get(i));
				break;
			case 4:
				q4.offer(list.get(i));
				break;
			case 5:
				q5.offer(list.get(i));
				break;
			case 6:
				q6.offer(list.get(i));
				break;
			case 7:
				q7.offer(list.get(i));
				break;
			case 8:
				q8.offer(list.get(i));
				break;
			case 9:
				q9.offer(list.get(i));
				break;
			}
		}
		
		ArrayList<Integer> newList = new ArrayList<>();
		
		while(!q0.isEmpty()) {
			newList.add(q0.remove());
		}
		while(!q1.isEmpty()) {
			newList.add(q1.remove());
		}
		while(!q2.isEmpty()) {
			newList.add(q2.remove());
		}
		while(!q3.isEmpty()) {
			newList.add(q3.remove());
		}
		while(!q4.isEmpty()) {
			newList.add(q4.remove());
		}
		while(!q5.isEmpty()) {
			newList.add(q5.remove());
		}
		while(!q6.isEmpty()) {
			newList.add(q6.remove());
		}
		while(!q7.isEmpty()) {
			newList.add(q7.remove());
		}
		while(!q8.isEmpty()) {
			newList.add(q8.remove());
		}
		while(!q9.isEmpty()) {
			newList.add(q9.remove());
		}
		
		return newList;
	}
}
