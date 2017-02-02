
public class Solution274 {
	/* 274. H-Index:
	 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
	 * 
	 * Input: [3, 0, 6, 1, 5]
	 * Output: 3
	 */
	
	public int hIndex(int[] citations){
		int len = citations.length;
		if(len == 0){
			return 0;
		}
		int total = 0;
		int[] res = new int[len + 1];
		for(int i = 0; i < len; i++){
			if(citations[i] > len){
				res[len]++;
			}else{
				res[citations[i]]++;
			}
		}
		
		for(int i = len; i >=0; i--){
			total += res[i];
			if(total >= i){
				return i;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args){
		Solution274 res = new Solution274();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(res.hIndex(citations));
	}
}
