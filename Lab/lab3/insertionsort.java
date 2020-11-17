import java.util.Scanner;
public class insertionsort
{
	public static void insertionsort(int [] temp)
	{
		int k=temp.length;
		for( int x=1;x<k;x++)
		{
			int l=temp[x];
			int i=x-1;

			while((i> -1) && temp[i] > l)
			{
				temp[i+1]=temp[i];
				i--;
			}
			temp[i+1] = l;
		}
	}
	public static void main(String args [])
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Enter the length: ");
		int size= cin.nextInt();

		int a[] = new int[size];
		System.out.println("Enter the values: " );
		for (int i=0; i<size; i++)
		{
			a[i] = cin.nextInt();
			//int values = cin.nextInt();
			//a[i] =values;
		}
		//Array before performing insertion sort.
		System.out.print("The unsorted array values are: \n");
		for (int j=0;j<size; j++){
			System.out.print(a[j] +" ");
			
		}
		//After performing insertionsort in array.
		System.out.print("Array after sorted are: \n");
		insertionsort(a);
		for(int i:a)
		{
			System.out.print(i);
		}
	}
}






	


