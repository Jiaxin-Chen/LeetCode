import java.util.concurrent.*;

public class Solution374 {
	/*
	 * 374. Guess Number Higher or Lower:
	 * We are playing the Guess Game. The game is as follows:
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
	 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
	 * 
	 * Input: n = 10, I pick 6.
	 * Output: 6
	 */
	
	public int guessNumber(int n, int randomNum){
		
		int start = 1, end = n;		
		while(start <= end){
			// mid = (start + end) / 2 will lead to integer overflow!!!
			int mid = start + (end - start) / 2;
			if(guess(mid, randomNum) == 0){
				return mid;
			}else if(guess(mid, randomNum) == 1){
				start = mid + 1;
			}else{	
				end = mid - 1;
			}
		}
		return end;
	}
	
	private int guess(int num, int randomNum){	
		if(num < randomNum){
			return 1;
		}else if(num > randomNum){
			return -1;
		}
		return 0;
	}
	
	public static void main(String[] args){
		int n = 16;
		int randomNum = ThreadLocalRandom.current().nextInt(1, n + 1);
		System.out.println(randomNum);
		Solution374 res = new Solution374();
		System.out.println(res.guessNumber(n, randomNum));
	}
}
