/*
149. Max Points on a Line

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;

class Point{
	int x; 
	int y;
	Point(){
		x = 0; 
		y = 0;
	}
	Point(int a, int b){
		x = a;
		y = b;
	}
}

public class LC149{
	public int maxPoints(Point[] points){
		int len = points.length;
		if(len <= 2)
			return len;

		int res = 1;
		for(int i = 0; i < len; i++){
			//Map<Double, Integer> map = new HashMap<Double, Integer>();
			Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
			int sameP = 0, sameX = 1;
			for(int j = 0;  j < len; j++){
				if(j != i){
					if(points[i].x == points[j].x && points[i].y == points[j].y)
						sameP++;
					if(points[i].x == points[j].x){
						sameX++;
						continue;
					}
					//double k = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
					BigDecimal dy = new BigDecimal(points[i].y - points[j].y);
					BigDecimal dx = new BigDecimal(points[i].x - points[j].x);
					BigDecimal k = dy.divide(dx, MathContext.DECIMAL128);


					if(map.containsKey(k)){
						map.put(k, map.get(k) + 1);
					}else{
						map.put(k, 2);
					}
					res = Math.max(res, map.get(k) + sameP);
				}
			}
			res = Math.max(res, sameX);
		}
		return res;
	}
}