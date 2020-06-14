import java.util.*;

public class SearchAlgorithmAnalaysis {
 
	public static int x;

	// Driver code  
	
	public static void main (String[] args) 
	{  
		int [] best=GenerateRandomArray(10000000,"best");
		int [] average=GenerateRandomArray(10000000,"average");
		int [] worest=GenerateRandomArray(10000000,"worest");

       
		System.out.println("Best case");
		
		        long sb_S = System.currentTimeMillis();
				SimpleLinearSearch (best,best[0]);
				long sb_S1 = System.currentTimeMillis();
				System.out.println( "simple "+(sb_S1-sb_S)+ " ns");
				
				long sb_I = System.currentTimeMillis();
				ImprovedLinearSearch(best,best[0]);
				
				long sb_I1 = System.currentTimeMillis();
				System.out.println("improved "+ (sb_I1-sb_I) + " ns");
		        
				long sb_L = System.currentTimeMillis();
				ImprovedLinearSearchWithSentinel(best, best[0]);  
				long sb_L1 = System.currentTimeMillis();
				System.out.println("sentinel "+ (sb_L1-sb_L) + " ns");
		

		System.out.println("average case");
		
		        long sa_S = System.currentTimeMillis();
				SimpleLinearSearch (average,average[x]);
				long sa_S1 = System.currentTimeMillis();
				System.out.println( "simple "+ (sa_S1-sa_S) + " ns");
				
				long sa_I = System.currentTimeMillis();
				ImprovedLinearSearch(average,average[x]);
				long sa_I1 = System.currentTimeMillis();
				System.out.println("improved "+ (sa_I1-sa_I) + " ns");
		
		
				long sa_L = System.currentTimeMillis();
				ImprovedLinearSearchWithSentinel(average, average[x]);  
				long sa_L1 = System.currentTimeMillis();
				System.out.println("sentinel "+ (sa_L1-sa_L) + " ns");
		       

		System.out.println("worest case");

		        double sw_S = System.currentTimeMillis();
				SimpleLinearSearch (worest,worest[worest.length-1]);
				double sw_S1 = System.currentTimeMillis();
				System.out.println( "simple "+ (sw_S1-sw_S) + " ns");
				
				long sw_I = System.currentTimeMillis();
				ImprovedLinearSearch(worest,worest[worest.length-1]);
				long sw_I1 = System.currentTimeMillis();
				System.out.println("improved "+ (sw_I1-sw_I) + " ns");
		
		
				long sw_L = System.currentTimeMillis();
				ImprovedLinearSearchWithSentinel(worest,worest[worest.length-1]);  
				long sw_L1 = System.currentTimeMillis();
				System.out.println("sentinel "+ (sw_L1-sw_L) + " ns");
		        
				System.out.println(".......................Binary Search.......................................");
				Arrays.sort(worest); 		
				long sw_B = System.currentTimeMillis();
				binarySearch(worest,worest[worest.length-1]);; 
				long sw_B1 = System.currentTimeMillis();
				System.out.println( "binary "+ (sw_B1-sw_B) + " ns");
		

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
		if(cases=="best") {
			for (int i = 0; i < arr.length; i++)
			{
				arr[i]=0;

			}
			arr[0]=rd.nextInt(arr.length);
			return arr;
		}
		else if(cases=="average") {
			for (int i = 0; i < arr.length; i++)
			{
				arr[i]=0;

			}
			 x=size/2;
			arr[x]=rd.nextInt(arr.length);
			return arr;
		}
        else if(cases=="worest") {
        	for (int i = 0; i < arr.length; i++)
			{
				arr[i]=0;

			}
			arr[arr.length-1]=rd.nextInt(arr.length);
		}
		
		//System.out.println(Arrays.toString(array));
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

