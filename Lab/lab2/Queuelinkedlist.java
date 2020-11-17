class Linkedlist {
	Node front;
	Node tail;
	int size;
	//constructor
	public Linkedlist() {
		front = null;
		tail = null;
		size = 0;
	}
	//isEmpty
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	//enqueue
	public void enqueue(int element) {
		Node newest = new Node(element, null);
		if(size == 0) {
			front = newest;
			tail = newest;
			System.out.println("The enqueue element is : " +element);
		}
		else {
			tail.setNext(newest);
			tail = newest;
			System.out.println("The enqueue element is : " +element);
		}
		size = size + 1;
	}
	//dequeue
	public int dequeue() {
		int removedelement = front.getElement();
		if(isEmpty()) {
			return 1;
		}
		else {
			front = front.getNext();
			size = size-1;
			System.out.println("The dequeued element is : " +removedelement);
		}
		return removedelement;
	}
	//first	
	public int first() {
		int firstelement = front.getElement();
		if(size == 0) {
			System.out.println("StackUnderFlowError");
		}
		else {
			return firstelement;
		}
		return first();
	}
	//length
	public int len() {
		if(isEmpty()) {
			return 1;
		}
		return size;
	}
}
class Node{
	//Variable declaration
	private int element;
	private Node next;
	public Node(int element, Node next) {
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement() {
		return element;
	}
	//getNext
	public Node getNext() {
		return next;
	}
	//setElement
	public void setElement(int e) {
		element = e;
	}
	//setNext
	public void setNext(Node e) {
		next = e;
	}
}
public class Queuelinkedlist{

	public static void main(String[] args) {
		Linkedlist obj = new Linkedlist();
		obj.enqueue(3);
		obj.enqueue(7);
		obj.enqueue(8);

		System.out.println("The deleted element is : "+obj.dequeue());
		System.out.println("The first element is : " +obj.first());
		System.out.println("isEmpty: " +obj.isEmpty());
		System.out.println("The length of a queue elements is : " + obj.len());

		assert(obj.isEmpty() == false);
		assert(obj.first() == 7);
		assert(obj.len() == 2);
		System.out.println("All the test are passed");
		
	}
}