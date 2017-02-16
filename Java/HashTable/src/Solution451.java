
public class Solution451 {
	/*
	 * 451. Sort Characters By Frequency:
	 * Given a string, sort it in decreasing order based on the frequency of characters.
	 * 
	 * Input: "tree", Output: "eert"
	 * Input: "cccaaa", Output: "cccaaa"
	 * Input: "Aabb", Output: "bbAa"
	 */
	
	public String frequencySort(String s){
		if(s.length() < 3){
			return s;
		}
		
		int max = 0;
		int[] map = new int[128];
		
		for(char ch : s.toCharArray()){
			map[ch]++;
			max = Math.max(max, map[ch]);
		}
		
		String[] buckets = new String[max + 1];
		for(int i = 0; i < 128; i++){
			String str = buckets[map[i]];
			if(map[i] > 0){
				buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = max; i >= 0; i--){
			if(buckets[i] != null){
				for(char ch : buckets[i].toCharArray()){
					for(int j = 0; j < i; j++){
						sb.append(ch);
					}
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String s = "aaacccc";
		Solution451 res = new Solution451();
		System.out.println(res.frequencySort(s));
	}
}
