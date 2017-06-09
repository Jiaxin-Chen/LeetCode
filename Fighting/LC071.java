/*
71. Simplify Path
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

import java.util.*;

public class LC071{
	// Time Complexity: O(N)
	// Runtime: 13ms, beats 48.38%
	public String simplifyPath(String path){
		if(path.length() == 0)
			return path;

		Stack<String> stack = new Stack<>();
		String[] folders = path.split("/");
		for(String f : folders){
			if(f.equals(".") || f.isEmpty())
				continue;
			else if(f.equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}else{
				stack.push(f);
			}
		}

		if(stack.isEmpty())
			return "/";

		StringBuilder res = new StringBuilder();
		for(String s : stack)
			res.append("/" + s);

		return res.toString();
	}

	public static void main(String[] args){
		LC071 x = new LC071();
		String path = "/abc/...";
		System.out.println(x.simplifyPath(path));
	}
}