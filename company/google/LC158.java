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


// Time Complexity: O(N)
// Runtime: 2ms, beats 11.63%
class LC158 extends Reader4{

	/* The only thing is when you call read4() which reads 4 bytes into your buffer you might read more than you need, 
	 * so you want to store those bytes in the structure, and next time you call read will start from those stored bytes, 
	 * then read more from the file.
	 */

	// we need bufIdx, bufCnt, buf4 as global variables, because we may need them to store the previous data
	private int bufIdx = 0; //store the data bufIdx received in previous calls.
	private int bufCnt = 0; //store the data bufCnt received in previous calls.
	private char[] buf4 = new char[4];

	public int read(char[] buf, int n) {
        int idx = 0;

        while(idx < n){
        	// if idx = 0, we need read new 4 characters
        	if(idx == 0){
        		bufCnt = read4(buf4);
        	}

        	// no more new data, we can return idx now
        	if(bufCnt == 0){
        		break;
        	}

        	// assign buf4 to buf
        	while(idx < n && bufIdx < bufCnt){
        		buf[idx++] = buf4[bufIdx++];
        	}

        	// if buffPtr reaches current buffCnt, it already read up the previous data, 
        	// so it will be set as zero to be ready to read new data.
        	if(bufIdx == bufCnt){
        		bufIdx = 0;
        	}
        }

    	return idx;
    }


    //-------------------------------------------------------------------------------------------------
    private char[] buffer = new char[4];
    int head = 0, tail = 0;

    public int read(char[] buf, int n){
        int i = 0; 
        while(i < n){
            if(head == tail){
                head = 0;
                tail = read4(buf);  // max is 4, enqueue
                if(tail == 0){
                    break;
                }
            }

            while(i < n && head < tail){   // dequeue  
                buffer[i++] = buf[head++];
            }
        }
        return i;
    }
}