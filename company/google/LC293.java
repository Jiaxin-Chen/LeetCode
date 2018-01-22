/*
293. Flip Game

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
*/

import java.util.*;

class LC293{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 10.73%
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new LinkedList<>();
        if(s == null || s.length() < 2){
            return res;
        }
        for(int i = 0; i < s.length() - 1; i++){
        	if(s.indexOf("++", i) == i){
            //if(s.startsWith("++", i)){
            //if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                res.add(s.substring(0, i) + "--" + s.substring(i+2));
            }
        }
        return res;
    }

    public static void main(String[] args){
    	LC293 x = new LC293();
    	String s = "++++";
    	System.out.println(x.generatePossibleNextMoves(s));
    }
}