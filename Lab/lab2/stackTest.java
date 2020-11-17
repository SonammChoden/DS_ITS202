public class stackTest
{
	public static void main(String[] args) 
  {
		stacklinkedlist obj =new stacklinkedlist();
  		obj.push(1);
  		obj.push(2);
  		obj.push(4);
      
  		System.out.println("The stack is empty ="+obj.isEmpty());
  		System.out.println("The size is = "+obj.size());
  		System.out.println("The top is = "+obj.top());
  		obj.pop();
  		System.out.println("The size is = "+obj.size());

  		assert(obj.isEmpty() == false);
    	assert(obj.size() == 2);
    	assert(obj.top() == 2);
    	System.out.println("All the functions are working");
  }
}