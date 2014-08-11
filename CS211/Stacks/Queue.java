package Queue;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue myqueue = new Queue(5);
		Scanner input = new Scanner(System.in);
		String command = "";
		while (!command.equals("quit")) {
			System.out.println();
			System.out
					.println("Do you want to insert, remove, getsize or quit?");
			command = input.next();
			if (command.equals("insert")) {
				System.out.println("Enter name to insert");
				String name = input.next();
				myqueue.insert(name);
				System.out.println(name + " has been inserted into the queue");
				myqueue.printout();
			} else if (command.equals("remove")) {
				System.out.println(myqueue.remove()
						+ " has been removed from the queue");
				myqueue.printout();
			} else if (command.equals("getsize")) {
				System.out.println("The size of the queue is "
						+ myqueue.getSize());
			}
		}
	}
}






package Queue;

public class Queue {

	private String[] array;
	private int size;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int s) {
		size = s;
		array = new String[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public boolean insert(String name) {
		if (isFull())
			return false;
		if (rear == size - 1)
			rear = -1;
		rear++;
		array[rear] = name;
		nItems++;
		return true;
	}

	public String remove() {
		if (isEmpty())
			return null;
		String temp = array[front];
		front++;
		if (front == size)
			front = 0;
		return temp;
	}

	public boolean isFull() {
		return (nItems == size);
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public int getSize() {
		return nItems;
	}

	public void printout() {
		for(int i=front;i<nItems;i++){
			System.out.print(array[i] + " ");
		}
	}
}
