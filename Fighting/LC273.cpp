/*
273. Integer to English Words

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

#include<iostream>

using namespace std;

class LC273{
public:
	string numberToWords(int num){
		if(num == 0)
			return "Zero";
		return helper(num).substr(1);
	}

private:
	const string below20[19] = {"One", "Two", "Three", "Four","Five","Six","Seven","Eight","Nine","Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	const string below100[8] = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

	string helper(int num){
		if(num >= 1000000000)
			return helper(num / 1000000000) + " Billion" + helper(num % 1000000000);
		else if(num >= 1000000)
			return helper(num / 1000000) + " Million" + helper(num % 1000000);
		else if(num >= 1000)
			return helper(num / 1000) + " Thousand" + helper(num % 1000);
		else if(num >= 100)
			return helper(num / 100) + " Hundred" + helper(num % 100);
		else if(num >=20)
			return string(" ") + below100[num / 10 -2] + helper(num % 10);
		else if(num >= 1)
			return string(" ") + below20[num - 1];
		else 
			return "";
	}
};


int main(){
	LC273 x;
	int num = 1234567;
	cout << x.numberToWords(num) << endl;
	return 0;
}