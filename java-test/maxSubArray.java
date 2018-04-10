package javaOne;

final class triplet {
	public int low;
	public int high;
	public int sum;
	
	triplet(int l, int h, int s) {
		low = l;
		high = h;
		sum = s;
	}
	
}


class maxSubArray {
	
	private triplet findMaxCrossingArray (int []values, int low, int mid, int high) {
		
		int left_max = 0;
		int left_sum = 0;
		int left_index=0, right_index=0, sum_index=0;
		
		for(int i = mid; i >= low; --i) {
			left_sum = left_sum + values[i];
			System.out.println("i:" + i + "\t\tSum:" + left_sum);
			if (left_sum > left_max) {
				left_max = left_sum;
				left_index = i;
			}
		}

		
		int right_max = 0;
		int right_sum = 0;
		
		for(int j = mid + 1; j <= high; ++j) {
			right_sum = right_sum + values[j];
			System.out.println("j:" + j + "\t\tSum:" + right_sum);
			if (right_sum > right_max) {
				right_max = right_sum;
				right_index = j;
			}
		}
		
		sum_index = left_max + right_max;
		triplet res = new triplet(left_index, right_index, sum_index);
		return res;
	}
	
	private triplet findMaxSubArray(int[] a, int low, int high) {
				
		if(low==high) {
			triplet res = new triplet(low, high, a[low]);
			
			return res;
		}
		else {
			int mid = low + high / 2;
			
			triplet left_side = findMaxCrossingArray(a, 0, 0 + mid /2, mid);

			triplet right_side = findMaxCrossingArray(a, mid + 1, mid + high / 2, high);
			
			triplet cross = findMaxCrossingArray (a, low, mid, high);
			
			triplet test = findMaxCrossingArray (a, 0, 7, 15);
		
			if(left_side.sum >= right_side.sum && left_side.sum >= cross.sum)
				return left_side;

			if(right_side.sum >= left_side.sum && right_side.sum >= cross.sum)
				return left_side;
			
			return cross;
		}
	}
	
	public static void main(String[] args) {
		
		int[] values = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		
		maxSubArray myApp = new maxSubArray();
		
		triplet res = myApp.findMaxSubArray(values, 0, values.length - 1);

		System.out.println("Done");
	}	
	
}