import java.io.File;
import java.util.*;
import java.text.*;
import java.time.*;

class Java_LinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function of Intersection is not necessary for set difference

	/*
	 * void Intersection(Node first_head, Node second_head) { Node t1 = first_head;
	 * 
	 * while (t1 != null) { if (isPresent(second_head, t1.data)) { push(t1.data); }
	 * t1 = t1.next; } }
	 */

	void getDifference(Node first_head, Node second_head) {
		Node t1 = first_head;

		while (t1 != null) {
			if (notPresent(second_head, t1.data)) {
				push(t1.data);
			}
			t1 = t1.next;
		}
	}

	void printList() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}

	void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	boolean notPresent(Node head, int data) {
		Node t = head;

		while (t != null) {
			if (t.data == data)
				return false;
			t = t.next;
		}
		return true;
	}

	public static void main(String args[]) throws Exception, ParseException {

		Instant start = Instant.now();
		
		String filename = args[0];
		String filename2 = args[1];

		Java_LinkedList first_list = new Java_LinkedList();
		Java_LinkedList second_list = new Java_LinkedList();
		Java_LinkedList first_minus_second = new Java_LinkedList();
		Java_LinkedList second_minus_first = new Java_LinkedList();

		Scanner first = new Scanner(new File(filename));

		while (first.hasNext()) {
			int i = first.nextInt();
			first_list.push(i);
		}

		Scanner second = new Scanner(new File(filename2));

		while (second.hasNext()) {
			int i = second.nextInt();
			second_list.push(i);
		}

		first_minus_second.getDifference(first_list.head, second_list.head);
		System.out.println("For first file, The difference from second file is: ");
		first_minus_second.printList();

		System.out.println();

		second_minus_first.getDifference(second_list.head, first_list.head);
		System.out.println("For second file, The difference from first file is: ");
		second_minus_first.printList();

		Instant finish = Instant.now();

		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println();
		System.out.println("The time cost of this program is " + timeElapsed + " milliseconds");
	}
}
