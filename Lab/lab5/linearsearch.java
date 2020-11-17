public class linearsearch
{
	public static void main(String args [])
	{

		int a [] ={1,3,2,6,7};
		int search =7;

		// Iteration to print the target values until it is found.
		for(int i=0; i<=a.length;i++)
		{
			if(a[i]==search)
			{
				System.out.println("Element found " +search);
				break;
			}
			else
			{
				System.out.println("Element not found" );
			}
		}
	}
}