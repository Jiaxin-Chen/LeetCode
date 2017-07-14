/*
241. Different Ways to Add Parentheses

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]

Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

import java.util.*;

public class LC241{
	public List<Integer> diffWaysToCompute(String input){
		List<Integer> res = new LinkedList<>();
		char[] ch = input.toCharArray();

		for(int i = 0; i < input.length(); i++){
			if(ch[i] == '-' || ch[i] == '*' || ch[i] == '+'){
				String part1 = input.substring(0, i);
				String part2 = input.substring(i+1);
				List<Integer> res1 = diffWaysToCompute(part1);
				List<Integer> res2 = diffWaysToCompute(part2);

				/*
				for(int j = 0; j < res1.size(); j++)
					System.out.print(res1.get(j) + " ");
				System.out.println("\n");
				for(int j = 0; j < res2.size(); j++)
					System.out.print(res2.get(j) + " ");
				System.out.println("\n");
				*/

				for(Integer num1 : res1){
					for(Integer num2 : res2){
						int c = 0; 
						switch(ch[i]){
							case '+': c = num1 + num2;
								break;
							case '-': c = num1 - num2;
								break;
							case '*': c = num1 * num2;
								break;
						}
						res.add(c);
					}
				}
			}
		}
		if(res.size() == 0)
			res.add(Integer.valueOf(input));

		return res;
	}

	public static void main(String[] args){
		LC241 x = new LC241();
		String input = "2*3-4*5";
		List<Integer> res = x.diffWaysToCompute(input);
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
}