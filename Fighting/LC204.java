/*
204. Count Primes

Count the number of prime numbers less than a non-negative number, n.
 */

public class LC204{
	// Time Complexity: O(NlogN)
	// Runtime: 12ms, beats 98.09%
	public int countPrimes(int n){
		if(n < 3)
			return 0;

		boolean[] isPrime = new boolean[n];
		int count = n / 2;

		for(int i = 3; i * i < n; i += 2){
			if(isPrime[i])
				continue;
			for(int j = i * i; j < n; j += 2 * i){
				if(!isPrime[j]){
					--count;
					isPrime[j] = true;
				}
			}
		}
		return count;
	}


	// Time Complexity: O(NlogN)
	// Runtime: 33ms, beats 46.42%
	public int countPrimes2(int n){
		if(n < 3)
			return 0;

		boolean[] isNotPrime = new boolean[n];
		int count = 0;

		for(int i = 2; i < n; i++){
			if(isNotPrime[i] == false){
				for(int j = 2; i * j < n; j++)
					isNotPrime[i * j] = true;
				count++;   // isNotPrime[i] == false means is a Prime
			}
		}
		return count;
	}


	public static void main(String[] args){
		int n = 99;
		LC204 x = new LC204();
		System.out.println(x.countPrimes(n));
	}
}