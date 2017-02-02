
public class Solution357 {
	/* 367. Valid Perfect Square:
	 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
	 * 
	 * 1 = 1
	 * 4 = 1 + 3
	 * 9 = 1 + 3 + 5
	 * 16 = 1 + 3 + 5 + 7
	 * 25 = 1 + 3 + 5 + 7 + 9
	 * 36 = 1 + 3 + 5 + 7 + 9 + 11
	 *....
	 *so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
	 */
	
	
	// Binary Search
	public boolean isPerfectSquare(int num){
		if(num < 1){
			return false;
		}
		
		long left = 1, right = num;
		
		while(left <= right){  //Corner case: num = 1
			long mid = (left + right) / 2;
			long res = mid * mid;
			if(res == num){
				return true;
			}else if(res < num){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return false;
	}
	
	
	// Newton Method
	public boolean isPerfectSquare2(int num){
		if(num == 1){
			return true;
		}
		
		long t = num / 2;
		while(t * t > num){
			t = (t + num / t) / 2;
		}
		return t * t == num;
	}
	
	
	public static void main(String[] args){
		int num = 1;
		Solution357 res = new Solution357();
		if(res.isPerfectSquare(num)){
			System.out.println("True");
		}
	}
}
