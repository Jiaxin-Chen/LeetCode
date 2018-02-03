/*
657. Judge Route Circle

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/

class LC657 {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.equals("")){
            return true;
        }
        
        char[] chs = moves.toCharArray();
        int x = 0, y = 0;
        
        for(char ch : chs){
            switch(ch){
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'U':
                    y++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}