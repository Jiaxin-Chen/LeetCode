/*
157. Read N Characters Given Read4
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
*/

class LC157 extends Reader4{
	 /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

     // Time Complexity: O(N)
     // Runtime: 1ms, beats 11.44%
    public int read(char[] buf, int n){ // buf的长度为n，我们需要把buf4的值四个四个地输入到buf中
     	char[] buf4 = new char[4]; // 是指读入的字符串，通过read4(char[] buf)赋值
		int idx = 0;

		while(true){
			int len = read4(buf4);  // read4 一次最多只能读4个character，返回值len <=4，是实际字符长度
			for(int i = 0; i < len && idx < n; i++){
				buf[idx++] = buf4[i];
			}
			if(len == 0 || idx == n){
				return idx;
			}
		}   
    }
}