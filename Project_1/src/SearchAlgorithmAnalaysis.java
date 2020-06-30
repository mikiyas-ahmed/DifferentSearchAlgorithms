import java.util.*;

public class SearchAlgorithmAnalaysis {
 
	public static int x;

	// Driver code  
	
	public static void main (String[] args) 
	{  
		Scanner in= new Scanner(System.in);
		System.out.println("enter the size of the array");
		int size = in.nextInt();
		int [] best=GenerateRandomArray(size,"best");
		int [] average=GenerateRandomArray(size,"average");
		int [] worest=GenerateRandomArray(size,"worest");

       
		System.out.println(".....................Best case in millisecond.........................");
		
		        double sb_S = System.currentTimeMillis();
		        
				SimpleLinearSearch (best,best[0]);
				double sb_S1 = System.currentTimeMillis();
				System.out.println( "\t\t\tsimple  "+(sb_S1-sb_S)+ " ms");
				
				double sb_I = System.currentTimeMillis();
				ImprovedLinearSearch(best,best[0]);
				
				double sb_I1 = System.currentTimeMillis();
				System.out.println("\t\t\timproved "+ (sb_I1-sb_I) + " ms");
		        
				double sb_L = System.currentTimeMillis();
				ImprovedLinearSearchWithSentinel(best, best[0]);  
				double sb_L1 = System.currentTimeMillis();
				System.out.println("\t\t\tsentinel "+ (sb_L1-sb_L) + " ms");
		

		System.out.println("\n.....................average case in millisecond.....................\n");
		
		        long sa_S = System.currentTimeMillis();
				SimpleLinearSearch (average,average[x]);
				long sa_S1 = System.currentTimeMillis();
				System.out.println( "\t\t\tsimple  "+ (sa_S1-sa_S) + " ms");
				
				long sa_I = System.currentTimeMillis();
				ImprovedLinearSearch(average,average[x]);
				long sa_I1 = System.currentTimeMillis();
				System.out.println("\t\t\timproved "+ (sa_I1-sa_I) + " ms");
		
		
				long sa_L = System.currentTimeMillis();
				ImprovedLinearSearchWithSentinel(average, average[x]);  
				long sa_L1 = System.currentTimeMillis();
				System.out.println("\t\t\tsentinel "+ (sa_L1-sa_L) + " ms");
		       

		System.out.println("\n\n.....................worest case in millisecond.....................\n");

		        double sw_S = System.currentTimeMillis();
				SimpleLinearSearch (worest,worest[worest.length-1]);
				double sw_S1 = System.currentTimeMillis();
				System.out.println( "\t\t\tsimple  "+ (sw_S1-sw_S) + " ms");
				
				double sw_I = System.currentTimeMillis();
				ImprovedLinearSearch(worest,worest[worest.length-1]);
				double sw_I1 = System.currentTimeMillis();
				System.out.println("\t\t\timproved "+ (sw_I1-sw_I) + " ms");
		

				double sw_L = System.currentTimeMillis();
				ImprovedLinearSearchWithSentinel(worest,worest[worest.length-1]);  
				double sw_L1 = System.currentTimeMillis();
				System.out.println("\t\t\tsentinel "+ (sw_L1-sw_L) + " ms");
		        
	   System.out.println("\n\n.....................Binary Search in nano second.....................\n");
				Arrays.sort(worest); 		
				long sw_B = System.nanoTime();
				binarySearch(worest,worest[worest.length-1]);; 
				long sw_B1 = System.nanoTime();
				System.out.println( "\t\t\tbinary  "+ (sw_B1-sw_B) + " ns");
		
		in.close();
	}  

	public static int [] sort(int [] arr) {
		int temp;
		for(int x=0; x<arr.length;x++) {
			for(int j=1; j<arr.length;j++) {
				temp=0;
				if(arr[j]<arr[j-1])
				{
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
		return arr;	
	}

	static boolean SimpleLinearSearch(int[] arr,int x) 

	{
		int n= arr.length;
		boolean found = false;
		for(int i=0; i<n-1;i++) 
		{
			if(arr[i]==x)
				found= true;
		}

		return found;

	}


	static boolean ImprovedLinearSearch(int arr[], int x)
	{
		int n= arr.length;
		for(int i=0; i<n-1;i++) 
		{
			if(arr[i]==x)
				return true;
		}
		return false;
	}


	// Function to search x in the given array  
	static boolean ImprovedLinearSearchWithSentinel(int arr[], int x)  
	{  
		int n= arr.length-1;
		int last = arr[n ];   
		arr[n] = x;  
		int i = 0;  
		while (arr[i] != x)  
			i++;   
		arr[n] = last;  

		if ((i < n) || (x == arr[n]))  
			return true;
		else
			return true;

	}  
	public static int[] GenerateRandomArray(int size,String cases) 
	{
		Random rd = new Random(); // creating Random object
		int[] arr = new int[size];
		if("best".equals(cases)) {
			for (int i = 0; i < arr.length; i++)
			{
				arr[i]=0;

			}
			arr[0]=rd.nextInt(arr.length);
			return arr;
		}
		else if("average".equals(cases)) {
			for (int i = 0; i < arr.length; i++)
			{
				arr[i]=0;

			}
			 x=rd.nextInt(arr.length);;
			arr[x]=rd.nextInt(arr.length);
			return arr;
		}
        else if("worest".equals(cases)) {
        	for (int i = 0; i < arr.length; i++)
			{
				arr[i]=0;

			}
			arr[arr.length-1]=rd.nextInt(arr.length);
		}
		return arr;
	}

	static boolean binarySearch(int arr[], int search)
	{
		int mid, low=0, high=arr.length-1;
		while(low<=high)
		{
			mid=low+((high-low)/2);
			if(arr[mid]==search)
				return true;
			else if(arr[mid]!=search &&arr[mid]>search)
				high= mid-1;
			else if(arr[mid]<search)
				low=mid+1;
		}
		return false;

	}

}

