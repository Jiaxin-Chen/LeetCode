import java.util.*;

public class Solution71 {
	/* 71. Simplify Path:
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * Input: "/home/", Output: "/home"
	 * Input: "/a/./b/../../c/", Output: "/c"
	 * Corner Case:
	 * Input: "/../", Output: "/"
	 * Input: "/home//foo/", Output: "/home/foo"
	 */
	
	public String simplifyPath(String path){
		Stack<String> stack = new Stack<String>();
		for(String p : path.split("/")){
			if(p.isEmpty() || p.equals(".")){
				continue;
			}
			if(p.equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else{
				stack.push(p);
			}
		}
		
		/*
		 * Runtime: 14ms
		 * return "/" + String.join("/", stack);
		 */
		
		// Runtime 12ms
		StringBuilder res = new StringBuilder("/");
        for(String s : stack){
            res.append(s + "/");
        }
        if(!stack.isEmpty()){
        	res.setLength(res.length() - 1);
        }
        return res.toString();
	}
	
	public static void main(String[] main){
		
		Solution71 res = new Solution71();
		
		String path = "/../home/jiaxin/";
		System.out.println(res.simplifyPath(path));
	}
}
