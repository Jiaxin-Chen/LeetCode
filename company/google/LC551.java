/*
551. Student Attendance Record I

You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/

class LC551 {
	// One pass!!! OMG
	// Time Complexity: O(N)
    public boolean checkRecord(String s) {
        if(s == null || s.equals("") || s.length() <= 1){
            return true;
        }
        
        int absentNum = 0;        
        char[] chs = s.toCharArray();
        
        for(int i = 0; i < chs.length; i++){
            if(chs[i] == 'A'){
                absentNum++;
            }
            if(i > 1 && chs[i] == 'L' && chs[i-1] == 'L' && chs[i-2] == 'L'){
                return false;
            }
        }
        return absentNum <= 1;
    }

    //------------------------------------------------------------
    // Optimization:
    // Time Complexity: O(1)
    // Runtime: 8ms, beats 85.62%
    public boolean checkRecord2(String s){
    	if(s.indexOf('A') != s.lastIndexOf('A') || s.contains('LLL')){
    		return false;
    	}
    	return true;
    }
}