class ArrayList{
	//Declaration
	int [] array;
	int size;
	//initialization
	int top = 0;
	double full1_over4=0.25;
	double full3_over4=0.75;

	//constructor
	public ArrayList(int length){
		size = length;
		array = new int[size];
	}

	//adding element
	public void add (int element)
	{
		array[top] = element;
		top++;
	} 
	//pop without returning the value.
	public void pop()
	{
		if(top > 0){
			array[top-1] = 0;
			top--;
		}
	}

	//size 
	public int size()
	{
		return size;
	}

	//resizing the array size to double if the array is 75% full or half if it is 50%.
	public void resize()
	{
		if (top == full1_over4){

			int[] newArray = new int[size/2];

			for (int i=0; i<top;i++){
				newArray[i]=array[i];
			}

			size = size/2;
			array = newArray;
		}
		if (top == full3_over4){

			int[] newArray = new int [size*2];

			for (int i=0; i<top; i++){
				newArray[i] =array[i];
			}

			size = size*2;
			array = newArray;
		}
	}
	public int check()
	{	

		return top;
	}
	public String toString()
	{
		String c = Integer.toString(size);
		return c;
	}
}

public class ArrayLinkedList{
	public static void main (String args []){
		int start = 4;
		ArrayList obj = new ArrayList(start);

		System.out.println("The Array space are  full");
		//adding element to the array.
		obj.add(1);
		obj.add(2);
		obj.add(3);

		//Element in the array adding the element.
		System.out.println("Element in an array before are:");

		for (int i = 0; i <obj.size; i++){
			System.out.print(obj.array[i] + " ");
		}

		//size of the array before inserting the element.
		System.out.println("\nSize of the array before is: " +obj.size);
		System.out.println("Number of the element in array before is:" +obj.top);

		obj.pop(); //removing the last element from the array.

		System.out.println("\nElement in array after pop: ");

		for (int i = 0; i < obj.size; i++){
			System.out.print(obj.array[i] + " ");
		}

		// Size and number of element in the arary before inserting element 
		System.out.println("\nsize of the array after is: "+obj.size);
		System.out.println("\nElements in an array after pop: "+obj.top);
		//obj.pop();

		obj.check();
		obj.resize();

		//Updated size of an array after removing last element.
		System.out.println("\nElement in an array after: ");

		if(obj.size!=start){
			for (int i = 0; i < obj.size; i++){
				System.out.print(obj.array[i] + " ");
			}
			System.out.println("\nSize of the array has changed as an array is full by 1/4 or 3/4 is: " +obj.size);

		}else{
			for (int i = 0; i < obj.size; i++){
				System.out.print(obj.array[i] + " ");
			}
			System.out.println("\nSize of an array remains same that is: " +obj.size);
		}
		System.out.println("Number of an element in array after: " +obj.top);
		System.out.println("toString " +obj.toString());

		assert(obj.size()==4);
		//assert(obj.pop()==3);

		System.out.println("All the Test has passed");
		}

	}
