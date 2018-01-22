/*
294. Flip Game II

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
*/
import java.util.*;

class LC294{
	// some logic faults about my thoughts...
	public boolean canWin(String s){
		if(s == null || s.length() <= 1){
			return false;
		}

		dfs(s, 1);
		return res;
	}

	private boolean res;

	private void dfs(String s, int count){
		if(!canMakeMove(s) && count % 2 == 0){
			System.out.println("s = " + s + ", count = " + count);
			res = true;
			return;
		}

		for(int i = 0; i < s.length() - 1; i++){
			if(s.startsWith("++", i)){
				String cur = s.substring(0, i) + "--" + s.substring(i+2);
				dfs(cur, count + 1);
			}
		}
		
	}

	private boolean canMakeMove(String s){
		for(int i = 0; i < s.length() - 1; i++){
			if(s.indexOf("++", i) == i){
				return true;
			}
		}
		return false;
	}
//------------------------------------------------------------------------
	/* Time Complexity: O(n!!)
	 * length of the input string s is n, there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."), 
	 * once we replace one "++", there are at most (n - 2) - 1 ways to do the replacement, 
	 * it's a little bit like solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., 
	 * so it's O(n!!), double factorial.
	 */
	// Runtime: 226ms, beats 17.43%
	public boolean canWin2(String s){
		if(s == null || s.length() <= 1){
			return false;
		}

		for(int i = 0; i < s.length() - 1; i++){
			if(s.startsWith("++", i)){
				String opponent = s.substring(0, i) + "--" + s.substring(i+2);

				// 后手玩家输, 意味着前手赢啦！！！
				if(!canWin2(opponent)){
					return true;
				}
			}
		}
		return false;
	}

//-------------------------------------------------------------------------

	/*canWin()==true是“先手玩家一定能赢（只要先手玩家先做出正确的move）”，而canWin()==false则表示“后手玩家一定能赢（无论先手玩家选择什么策略）”。
	  canWin()==true的充要条件是：先手玩家至少有一种策略，使得后手玩家在这种策略下canWin()==false(意思是后手玩家的再后手玩家，即原来的先手玩家，一定能赢)。
	  相应地，canWin()失败的充要条件是：无论先手玩家怎么走，后手玩家都能保证canWin()。
	 */
	// Optimization: dfs pruning
	// Time Complexity: O(...)
	// Runtime: 70ms, beats 45.05%
	public boolean canWin3(String s){
		if(s == null || s.length() <= 1){
			return false;
		}

		// Use a HashMap to avoid duplicate computation, like pruning
		Map<String, Boolean> map = new HashMap<>();
		return canWin(s, map);
	}

	private boolean canWin(String s, Map<String, Boolean> map){
		if(map.containsKey(s)){
			return map.get(s);
		}
		for(int i = 0; i < s.length() - 1; i++){
			if(s.startsWith("++", i)){
				String opponent = s.substring(0, i) + "--" + s.substring(i+2);
				// 后手玩家输, 意味着前手赢啦！！！
				if(!canWin(opponent, map)){
					System.out.println("opponent = " + opponent);
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}

	public static void main(String[] args){
		LC294 x = new LC294();
		//String s = "+++++++++";
		String s = "++++";
		System.out.println(x.canWin2(s));
	}
}