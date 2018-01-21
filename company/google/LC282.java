/*
282. Expression Add Operators

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

import java.util.*;

class LC282{
	// Time Complexity: O()
	public List<String> addOperators(String num, int target){
		List<String> res = new LinkedList<>();
		if(num == null || num.length() == 0){
			return res;
		}

		dfs(res, "", num, target, 0, 0, 0);
		return res;
	}

	private void dfs(List<String> res, String path, String num, int target, int start, long curRes, long lastF){
		if(start == num.length()){
			if(curRes == target){
				res.add(path);
			}
			return;
		}
		
		// Wrong way: we cannot append digit + operation together, because we cannot compute the lastF for the multiplication
		/*for(int i = start; i < num.length(); i++){		
			long digit = Long.parseLong(num.substring(start, i + 1));
			sb.append(digit);
			System.out.println("sb = " + sb);
			if(i + 1 < num.length()){
				dfs(res, sb.append('+'), num, target, i + 1, curRes + digit, digit);
				sb.setLength(sb.length() - 2);
				dfs(res, sb.append('-'), num, target, i + 1, curRes - digit, -digit);
				sb.setLength(sb.length() - 2);
				dfs(res, sb.append('*'), num, target, i + 1, curRes - lastF + lastF * digit, lastF * digit);
				sb.setLength(sb.length() - 2);
			}
			if(i != start && num.charAt(start) == '0'){
				break;
			}
		}*/
		
		// Right way: we need consider the the append the digit at num.charAt(0) first, so that we can compute the lastF
		// Besides, we CANNOT use StringBuilder, because we cannot just sb.setLength() due to we need skip some leading 0
		for(int i = start; i < num.length(); i++){
			long digit = Long.parseLong(num.substring(start, i + 1));
			//System.out.println("start = " + start + ", sb = " + sb);
			if(start == 0){
				dfs(res, "" + digit, num, target, i + 1, digit, digit);
			}else{
				dfs(res, path + "+" + digit, num, target, i + 1, curRes + digit, digit);
				
				dfs(res, path + "-" + digit, num, target, i + 1, curRes - digit, -digit);
				
				dfs(res, path + "*" + digit, num, target, i + 1, curRes - lastF + lastF * digit, lastF * digit);
				
			}
			// avoid leading 0 in the digit
			if(num.charAt(start) == '0'){
				break;
			}
		}
	}

	public static void main(String[] args){
		LC282 x = new LC282();
		String num = "105";
		int target = 5;
		System.out.println(x.addOperators(num, target));
	}
}