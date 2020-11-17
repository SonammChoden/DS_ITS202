public class stack
{
	int array [];
	int top;
	int size;
	
	
	//constructor
	public stack (int n)
	{
		array = new int[n];
		size = 0;
		top = -1;
		
	}
	//size
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		if(size==0)
		{
			return true;
		}
		return false;
	}
	//push
	public void push (int n)
	{
		if (size==0)
		{
			array[0]=n;
			top = 0;
		}
		else
		{
			array[top+1]= n;
		}
		top++;
		size= size+1;

	}	
	//top
	public int top()
	{
		if(isEmpty())
		{
			return 0;
		}
		else{
			return array[top];

		}
		
	}
	public int pop()
	{
		if (isEmpty())
		{
			return 0;
		}
		else
		{
			top = top-1;
			size= size-1;
			return array[top+1];
		}
		
	}
	public static void main(String args [])
	{
		stack obj = new stack(6);

		obj.push(1);
		obj.push(3);
		obj.push(6);
		obj.push(9);

		System.out.println("The element in the stack is: " +obj.size());
		System.out.println("The top eleemnt is: " +obj.top());
		System.out.println("The element remove from the stack is: " +obj.pop());
		System.out.println("isEmpty:" +obj.isEmpty());	

		assert(obj.isEmpty()==false);
		assert(obj.top()==9);
		assert(obj.size()==4);
		assert(obj.pop()==9);
		System.out.println("All the function has passed");

	}

}