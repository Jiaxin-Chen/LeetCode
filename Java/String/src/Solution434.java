
public class Solution434 {
	/* 434. Number of Segments in a String
	 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
	 * Please note that the string does not contain any non-printable characters.
	 */
	
	public int countSegments(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		int count = 0;
		char[] ch = s.toCharArray();
		
		for(int i = 0; i < ch.length; i++){
			if(ch[i] != ' '){
				count++;
			}
			while(i < ch.length && ch[i] != ' '){
				i++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		String s = "Hello, my name   is Jiaxin Chen.";
		Solution434 res = new Solution434();
		System.out.println(res.countSegments(s));
	}
}
