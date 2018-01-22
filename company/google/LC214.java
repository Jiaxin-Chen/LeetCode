/*
214. Shortest Palindrome

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

class LC214{
	// Brute force: 
	// Time Complexity: O(N^2)
	// Runtime: 412ms, beats 2.91%
	public String shortestPalindrome(String s){
		if(s == null || s.length() <= 1){
			return s;
		}

		int end = s.length() - 1;
		StringBuilder sb = new StringBuilder();

		while(end >= 0){
			if(isPanlindrome(s, 0, end)){
				sb.append(s.substring(end + 1)).reverse();
				System.out.println("sb = " + sb);
				break;
			}
			end--;
		} 
		if(sb.length() == 0){
			sb.append(s.substring(end + 1, s.length())).reverse();
		}
		
		sb.append(s);
		return sb.toString();
	}

	private boolean isPanlindrome(String s, int start, int end){
		while(start <= end){
			if(s.charAt(start++) != s.charAt(end--)){
				return false;
			}
		}
		return true;
	}

	//--------------------------------------------------------------------
	
	// Recursion:
	// Time Complexity: O(...)
	// Runtime: 4ms, beats 82.22%
	public String shortestPalindrome2(String s){
		if(s == null || s.length() <= 1){
			return s;
		}

		int end = 0; 
		for(int start = s.length() - 1; start >= 0; start--){ //找到第一个使他不回文的位置
			if(s.charAt(start) == s.charAt(end)){
				end += 1;
			}
		}
		if(end == s.length()){ //本身是回文
			return s;
		}

		String suffix = s.substring(end); // 后缀不能够匹配的字符串
		String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配

		// we have to compute mid, consider the case "adcba", prefix = "cba", we need find the palindrome of the "ad"
		String mid = shortestPalindrome2(s.substring(0, end)); //递归调用找 [0,j]要最少可以补充多少个字符让他回文

		return prefix + mid + suffix;
	}

	//------------------------------------------------------------------
	// Optimization:
	// KMP version: CANNOT understand at all.........
	// Reference: https://segmentfault.com/a/1190000003059361
	// Runtime: 12ms, beats 49.46%
	public String shortestPalindrome3(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        StringBuilder builder = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        builder.append("#").append(rev);
        int[] p = new int[builder.length()];
        for (int i = 1; i < p.length; i++) {
            int j = p[i - 1];
            while (j > 0 && builder.charAt(i) != builder.charAt(j)) j = p[j - 1];
            p[i] = j == 0 ? (builder.charAt(i) == builder.charAt(0) ? 1 : 0) : j + 1;
        }
        return p[p.length - 1];
    }

	public static void main(String[] args){
		LC214 x = new LC214();
		String s = "adcba";
		System.out.println(x.shortestPalindrome2(s));
	}
}