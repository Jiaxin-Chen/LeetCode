import java.util.*;

public class Solution500 {
	/*
	 * 500. Keyboard Row:
	 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
	 * You may use one character in the keyboard more than once.
	 * You may assume the input string will only contain letters of alphabet.
	 * 
	 * Input: ["Hello", "Alaska", "Dad", "Peace"]
	 * Output: ["Alaska", "Dad"]
	 */
	
	String[] rows = {"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};
	
	public String[] findWords(String[] words){
		List<String> res = new ArrayList<String>();
		
		int curRow = 0;
		boolean flag = true;
		for(String word : words){
			flag = true;
			curRow = getCurRow(word.charAt(0));
			for(char ch : word.toCharArray()){
				if(rows[curRow].indexOf(ch) == -1){
					flag = false;
					break;
				}
			}
			if(flag){
				res.add(word);
			}
		}
		return res.toArray(new String[res.size()]);
		
	}
	
	private int getCurRow(char ch){
		for(int i = 0; i < rows.length; i++){
			if(rows[i].indexOf(ch) != -1){
				return i;
			}
		}
		return -1;
	}
	
	// Count version: Runtime 5ms
	public String[] findWords2(String[] words){
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		Set<Character> set3 = new HashSet<Character>();
		
		set1.add('q'); set1.add('w'); set1.add('e'); set1.add('r'); set1.add('t'); set1.add('y'); set1.add('u'); set1.add('i'); set1.add('o'); set1.add('p');
		set2.add('a'); set2.add('s'); set2.add('d'); set2.add('f'); set2.add('g'); set2.add('h'); set2.add('j'); set2.add('k');set2.add('l');
		set3.add('z'); set3.add('x'); set3.add('c'); set3.add('v'); set3.add('b'); set3.add('n'); set3.add('m');
		
		List<String> res = new ArrayList<String>();
		
		for(String word : words){
			char[] wordArray = word.toLowerCase().toCharArray();
			int curSet = getCurRow(wordArray[0]) + 1;
			int count = 0;
			if(curSet == 1){
				for(char ch : wordArray){
					if(!set1.contains(ch)){
						break;
					}
					count++;
				}
			}else if(curSet == 2){
				for(char ch : wordArray){
					if(!set2.contains(ch)){
						break;
					}
					count++;
				}
			}else if(curSet == 3){
				for(char ch : wordArray){
					if(!set3.contains(ch)){
						break;
					}
					count++;
				}
			}
			
			if(count == wordArray.length){
				res.add(word);
			}
		}
		return res.toArray(new String[res.size()]);
		
	}
	
	// Flag Version: Runtime 5ms
	public String[] findWords3(String[] words){
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		Set<Character> set3 = new HashSet<Character>();
		
		set1.add('q'); set1.add('w'); set1.add('e'); set1.add('r'); set1.add('t'); set1.add('y'); set1.add('u'); set1.add('i'); set1.add('o'); set1.add('p');
		set2.add('a'); set2.add('s'); set2.add('d'); set2.add('f'); set2.add('g'); set2.add('h'); set2.add('j'); set2.add('k');set2.add('l');
		set3.add('z'); set3.add('x'); set3.add('c'); set3.add('v'); set3.add('b'); set3.add('n'); set3.add('m');
		
		List<String> res = new ArrayList<String>();
		
		for(String word : words){
			char[] wordArray = word.toLowerCase().toCharArray();
			int curSet = getCurRow(wordArray[0]) + 1;
			boolean flag = true;
			if(curSet == 1){
				for(char ch : wordArray){
					if(!set1.contains(ch)){
						flag = false;
						break;
					}
				}
			}else if(curSet == 2){
				for(char ch : wordArray){
					if(!set2.contains(ch)){
						flag = false;
						break;
					}
				}
			}else if(curSet == 3){
				for(char ch : wordArray){
					if(!set3.contains(ch)){
						flag = false;
						break;
					}
				}
			}
			
			if(flag){
				res.add(word);
			}
		}
		return res.toArray(new String[res.size()]);
		
	}
	
	
	public static void main(String[] args){
		String[] words = {"a", "b"}; //{"Hello", "Alaska", "Dad", "Peace"};
		Solution500 res = new Solution500();
		String[] outputs = res.findWords2(words);
		
		for(String output : outputs){
			System.out.println(output);
		}
	}
}
