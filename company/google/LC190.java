/*
190. Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
*/

import java.util.*;

class LC190{
	// Time Complexity: O(N)
	public int reverseBits(int n) {
        
        int res = 0;
        
        for(int i = 0; i < 32; i++){
            res += n & 1;
            
            // corner case: n = 1
            if(i < 31){   // for last digit, don't shift!
                res <<= 1;  
            }
            n >>>= 1;     // must do unsigned shift
        }
        return res;
    }


//--------------------------------------------------------------------------
    // Optimization: we can use HashMap to cache each bytes to improve the performance if called multiple times
    // Time Complexity:
    public int reverseBits2(int n){
    	Map<Byte, Integer> map = new HashMap<>();
    	byte[] bytes = new byte[4];

    	// Step 1: convert int into 4 bytes
    	for(int i = 0; i < 4; i++){
    		bytes[i] = (byte) (n & 0xFF);
    		n >>>= 8;    // CATCH: must do unsigned shift
    	}

    	int res = 0;

    	// Step 2: reverse per byte
    	for(int i = 0; i < 4; i++){
    		res += reverseByte(bytes[i], map);
    		if(i < 3){
    			res <<= 8;
    		}
    	}
    	return res;
    }

    private int reverseByte(byte b, Map<Byte, Integer> map){

    	// First to find reversed byte in the map
    	Integer reversed = map.get(b);
    	if(reversed != null){
    		return reversed;
    	}

    	// If not in the map, compute the reversed byte
    	reversed = 0;
    	for(int i = 0; i < 8; i++){
    		reversed += (b >>> i) & 1;
    		if(i < 7){
    			reversed <<= 1;
    		}
    	}
    	map.put(b, reversed);
    	return reversed;
    }

    public static void main(String[] args){
    	LC190 x = new LC190();
    	int n = 1;
    	System.out.println(x.reverseBits2(n));
    }
}