/*
271. Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. 
Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
*/

public class Codec {

	// Time Complexity: O(N)
	// Runtime: 12ms, beats 70.19%
	public String encode(List<String> strs){
		StringBuilder sb = new StringBuilder();
		for(String str : strs){
			sb.append(str.length()).append('/').append(str);
		}
		return sb.toString();
	}

	public List<String> decode(String s){
		List<String> res = new LinkedList<>();

		int idx = 0;
		while(idx < s.length()){
			int slashIdx = s.indexOf('/', idx);
			int size = Integer.valueOf(s.substring(idx, slashIdx));
			res.add(s.substring(slashIdx + 1, slashIdx + 1 + size));
			idx = slashIdx + 1 + size;
		}
		return res;
	}


	// My fault version.......
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int idx = 0;
            for(int i = 0; i < str.length() - 1; i++){
                if(str.charAt(i) == '\\'){
                    sb.append(str.substring(idx, i));
                    sb.append('\');
                    idx = i + 1;
                }
            }
            sb.append(str.substring(idx));
            sb.append('\n');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        if(s == null || s.length() == 0 ){
            return res;
        } 
        if(s.equals("\n")){
            res.add("");
            return res;
        }
        int idx = 0; 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++){
            if(s.substring(i, i + 2).equals('\n')){
                sb.append(s.substring(idx, i));
                res.add(sb.toString());
                sb.setLength(0);
                idx = i + 2;
            }else if(s.substring(i, i + 2).equals('\\')){
                sb.append(s.substring(idx, i + 1));
                idx = i + 2;
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));