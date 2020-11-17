import java.util.Scanner;
public class selection
{
	public static void main(String args [])
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter the length of array: ");
		int size = cin.nextInt();

		int a[] = new int[size];
		System.out.println("Enter the values: ");

		for(int i=0; i<size; i++){
			int values = cin.nextInt();
			a[i] = values;
			//a[i] = cin.nextInt();
		}
		System.out.print("The array elements before selection are: ");
		for (int j=0;j<size; j++){
			System.out.print(a[j] + " ");
		}
		//performing selection sort
		for(int i=0; i<size; i++){
			for(int k=i+1;k<size;k++){
				if(a[i] > a[k])
				{
					int temp = a[i];
					a[i]=a[k];
					a[k]= temp;
				}
			}
		}
		System.out.print("Elements after performing selection sort are: ");
		for(int i=0;i<size;i++){
			System.out.print(a[i] + " ");
		}
	}
}
