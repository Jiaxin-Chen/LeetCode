/*
6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class LC006{
	// Time Complexity: O(N)
	// Runtime: 50ms, beats 88.17%
	public String convert(String s, int numRows){
		if(numRows <= 1)
			return s;

		StringBuilder[] sb = new StringBuilder[numRows];
		// Cannot miss the initialization! Otherwise it throws NullPointerException!
		for(int i = 0; i < numRows; i++)
			sb[i] = new StringBuilder();

		char[] ch = s.toCharArray();
		int idx = 0, step = 1, len = ch.length;
		for(int i = 0; i < len; i++){
			sb[idx].append(ch[i]);
			if(idx == 0)
				step = 1;
			if(idx == numRows - 1)
				step = -1;
			idx += step;
		}

		StringBuilder res = new StringBuilder();
		for(int i = 0; i < numRows; i++)
			res.append(sb[i]);
		return res.toString();
	}

	public static void main(String[] args){
		String s = "PAYPALISHIRING";
		int numRows = 3;

		LC006 x = new LC006();
		System.out.println(x.convert(s, numRows));
	}






}