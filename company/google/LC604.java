/*

Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '
*/

// Runtime: 120ms, beats 74.81%
class StringIterator {

    char[] chs;
    int cnt;
    int idx; 
    char c;
    
    public StringIterator(String compressedString) {
        chs = compressedString.toCharArray();

        cnt = 0;
        idx = 0;
        c = ' ';
    }
    
    public char next() {
        if(hasNext()){
            cnt--;
            return c;
        }
        return ' ';
    }
    
    public boolean hasNext() {
        if(cnt > 0){
            return true;
        }
        if(idx >= chs.length){
            return false;
        }
        c = chs[idx++];
        
        while(idx < chs.length && chs[idx] >= '0' && chs[idx] <= '9'){
            //cnt += cnt * 10 + Integer.valueOf(chs[idx++]);
            cnt = cnt * 10 + chs[idx++] - '0';
            //System.out.println("c = " + c + ", cnt = " + cnt);
        }
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */