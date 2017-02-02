
public class Solution69 {
	/* 69. Sqrt(x):
	 * Implement int sqrt(int x).
	 * Compute and return the square root of x.
	 */
	
	public int mySqrt(int x){
		if(x == 0){
			return 0;
		}
		
		int left = 1, right = x, res = 0;
		while(left <= right){
			int mid = (left + right) >>> 1;
			if(mid <= x / mid){
				left = mid + 1;
				res = mid;
			}else{
				right = mid - 1;
			}
		}
		return res;
	}
	
	
	// More concise Binary Search version, but slower, Runtime 4ms
	public int mySqrt2(int x){
		if(x == 0){
			return 0;
		}
		
		int left = 1, right = x;
		while(left <= right){
			int mid = (left + right) >>> 1;
			if(mid == x / mid){
				return mid;
			}else if(mid < x / mid){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return right;
	}
	
	
	// Newton Method, still slow......
	public int mySqrt3(int x){
		if(x < 2) return x;
		
		long r = x / 2;
		while(r * r > x){
			r = (r + x / r) / 2;
		}
		return (int)r;
	}
	
	public static void main(String[] args){
		int x = 17;
		Solution69 res = new Solution69();
		System.out.println(res.mySqrt(x));
	}
}
