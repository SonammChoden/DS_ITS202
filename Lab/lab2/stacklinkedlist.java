class Node{
	int element;
	Node next;

	public Node(int element){
		this.element = element;
		this.next = null;
	}
}
public class stacklinkedlist{
	
	Node head; 
	int size;
	public stacklinkedlist(){
		Node head = null; 
		int size = 0;;	
	}
	//push
	public void push(int element){
		Node newest= new Node(element);
		newest.next = head;
		head = newest;
		System.out.println(element);

		size = size+1;
	}
	//isEmpty
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		else{
			return false;
			
		}
		
	}
	//size
	public int size(){
		return size;
	}
	//top
	public int top(){
		if (head == null) {
			System.out.println("The stack is empty");
		}
		return head.element;
	}
	//pop
	public void pop(){
		Node tem = head;
		this.head = this.head.next;
		System.out.println("The pop element is : "+tem. element);

		size = size - 1;
	}
	
}