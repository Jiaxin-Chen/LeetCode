/*
157. Read N Characters Given Read4

The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. 
For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
*/


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class LC157 extends Reader4{

	// Time Complexity: O(N)
	// Runtime: 1ms, beats 32.25%
	
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	char[] tmp = new char[4];
        boolean eof = false;
        int total = 0;

        while(!eof && total < n){
        	int count = read4(tmp);

        	// Check if it's the end of the file
        	eof = (count < 4);

        	// Get the actual count in case that we don't need to read to the end of file
        	count = Math.min(count, n - total);

        	for(int i = 0; i < count; i++)
        		buf[total++] = tmp[i];
        }

        return total;
    }
}