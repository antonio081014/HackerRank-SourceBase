/*
<a href="https://www.hackerrank.com/contests/july13/challenges/game-of-thrones"> Problem Link</a>
Game Of Thrones - I
King Robert has 7 kingdoms under his rule. He gets to know from Raven that the Dothraki are to wage a war against him soon. But, he knows the Dothraki need to cross the narrow river to enter his dynasty. There is only one bridge that connects both sides of the river which is sealed by a huge door.

door

The king wants to lock the door so that the Dothraki can’t enter. But, to lock the door you need a key that is a palindrome of an anagram of a certain string.

The king has a list of words. For each given word, can you help the king in figuring out if any anagram of it can be a palindrome or not?.

Input Format
A single line which will contain the input string

Constraints
1<=length of string <= 10^5 Each character of the string is a lowercase english alphabet.

Output Format
A single line containing YES/NO in capital letter of english alphabet.

Sample Input : 01

aaabbbb
Sample Output : 01

YES
Explanation
One of the permutations of the given string which is a palindrome is bbaaabb. 

Sample Input : 02

cdefghmnopqrstuvw
Sample Output : 02

NO
Explanation
You can verify that no permutation of the given string can be a palindrome. 

Sample Input : 03

cdcdcdcdeeeef
Sample Output : 03

YES
Explanation
One of the permutations of the given string which is a palindrome is ddcceefeeccdd .
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String src = in.readLine();
        int[] count = new int[26];
        //Arrays.fill(count, 0);
        for(int i=0; i<src.length(); i++){
            count[src.charAt(i)-'a']++;
        }
        
        int even = 0;
        int odd = 0;
        for(int i=0; i<26; i++)
            if(count[i]%2==0)even++;
            else odd++;
        
        if (odd <=1) System.out.println("YES");
        else System.out.println("NO");
    }
}
