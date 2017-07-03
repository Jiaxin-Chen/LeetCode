/*
158. Read N Characters Given Read4 II - Call multiple times

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. 
For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*
I used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls. 
In the while loop, if buffPtr reaches current buffCnt, it will be set as zero to be ready to read new data.
*/
public class LC158 extends Reader4 {

	// Time Complexity: O(N)
	// Runtime: 2ms, beats 31.92%
	private int bufPtr = 0;
	private int bufCnt = 0;
	private char[] tmp = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n){
        	if(bufPtr == 0)
        		bufCnt = read4(tmp);

        	if(bufCnt == 0)
        		break;

        	while(ptr < n && bufPtr < bufCnt)
        		buf[ptr++] = tmp[bufPtr++];

        	if(bufPtr >= bufCnt)
        		bufPtr = 0;
        }
        return ptr;
    }
}
