public class Queue{
	int array [];
	int front;
	int rear;
	int length;
	int first;
	
	//constructor
	public Queue(int e){
		front = -1;
		rear = -1;
		first = -1;
		length = 0;
		first = -1;
		array = new int[e];
	}

	 //isEmpty
	 public boolean isEmpty(){
	 	if (length==0)
	 	{
	 		return true;
	 	}
	 	return false;
	 }
	 //length
	 public int length(){
	 	return length;
	 }
	 //first
	 int first(){
	 	if (isEmpty()){
	 		return 0;
	 	}
	 	return array[front];
	 }
	 //enqueue
	  public void enqueue (int e){
	  	if (isEmpty()){
	  		array[0]=e;
	  		front = 0;
	  		rear = 0;
	  		first= array[0];
	  	}
	  	else{
		  	array[rear +1] = e;
		  	rear = rear+1;
		  }
		  length=length+1;
		}

	  //dequeue
	  public int dequeue(){
	  	if (isEmpty()){
	  		return 0;
	  	}
	 	 else{
				front = front+1;
		}
		length=length-1;
		return array[front-1];
	}

	public static void main(String args []){
		Queue obj = new Queue(10);

		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);

		System.out.println("isEmpty: "+obj.isEmpty());
		System.out.println("length: " +obj.length());
		System.out.println("first: " +obj.first());
		System.out.println("dequeue: " +obj.dequeue());

		assert(obj.isEmpty()==false);
		assert(obj.first()==1);
		assert(obj.dequeue()==1);
		assert(obj.length()==3);
		System.out.println("All the Function has passed.");

	}
}