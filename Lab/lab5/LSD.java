public class LSD
{
	public static void sort (String[] a, int w)
	{
		//sort a[] on leading w characters.
		int N = a.length;
		int R = 256;
		String [] aux = new String[N];
		for (int d = w-1; d>=0;d--)
		{
			//sort by key indexed counting on dth char.
			int [] count = new int[R+1];

			//compute frquency counts
			for(int i = 0; i < N;i++)
				count [a[i].charAt (d)+1]++;
			for (int r=0; r<R;r++)

				//Transform counts to indices
				count [r+1] +=count [r];
			for (int i=0; i < N; i++)

				//Distribute
				aux [count [a[i].charAt (d)]++] = a[i];
			for (int i = 0; i < N; i++)
				//copy back
				a[i] = aux[i];
		}
	}
	public static void main(String args [])
	{
		LSD obj = new LSD();
		String a[] = {"Sonam", "Tashi","Karma"};
		obj.sort(a,5);

		for(int i=0;i<a.length;i++)

			System.out.println(" " +a[i]);
	}
}