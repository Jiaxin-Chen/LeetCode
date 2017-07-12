/*
223. Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Assume that the total area is never beyond the maximum possible value of int.
 */

public class LC223{
	// Time Complexity: O(1)
	// Runtime: 4ms, beats 46.01%
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);

		int overlap = 0;
		if(left < right && bottom < top){
			overlap = (right - left) * (top - bottom);
		}

		return area1 + area2 - overlap;
	}

	public static void main(String[] args){
		LC223 x = new LC223();
		int res = x.computeArea(-3, 0, 0, -1, 3, 4, 9, 2);
		System.out.println(res);
	}
}