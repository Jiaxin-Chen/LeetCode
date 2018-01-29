/*
443. String Compression

Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
Note:
All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.
*/

class LC443{

	// Two pointers + one counter
	// Time Complexity: O(N)
	public int compress(char[] chars){
		if(chars == null || chars.length <= 1){
            return chars.length;
        }
        int start = 0;
        int count = 0;

        for(int end = 0; end < chars.length; end++){
        	count++;
        	System.out.println(count);
        	if(end == chars.length - 1|| chars[end] != chars[end + 1]){
        		
        		chars[start++] = chars[end];

        		if(count != 1){
        			System.out.println(count);
        			char[] cntArr = String.valueOf(count).toCharArray();
        			for(int i = 0; i < cntArr.length; i++){
        				chars[start++] = cntArr[i];
        			}
        		}
        		count = 0;
        	}
        }
        return start;
	}

	// My fault version:... just a messy....
	public int compress2(char[] chars) {
        if(chars == null || chars.length <= 2){
            return chars.length;
        }
        
        int count = 0;
        
        for(int i = 0; i < chars.length; i++){
            int j = i + 1;
            count++;
            while(j < chars.length){
                if(chars[i] == chars[j]){
                    j++;
                    if(j == chars.length){
                    	count++;
                    }
                }else{
                    if(j >= i + 1){
                        count++;
                    }
                    
                    break;
                }
            }
            System.out.println(chars[i] + ", count = " + count);
            i = j;
        }
        return count;
    }

    public static void main(String[] args){
    	LC443 x = new LC443();
    	char[] chars = new char[]{'a', 'a'};
    	System.out.println();
    	System.out.println(x.compress(chars));
    }
}