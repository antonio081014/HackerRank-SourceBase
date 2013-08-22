/**
 * Using Binary Search to Insert and Remove. So generally, the time complexity for this problem is O(nlogn)
 * 
 */

import java.util.*;
import java.text.DecimalFormat;
class Solution{
   
    public static void main( String args[] ){
       Solution main = new Solution();
       main.run();
       System.exit(0);
    }
    
    private void run(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Long> list = new ArrayList<Long>();
        while(N-->0){
            String c = in.next();
            long n = in.nextLong();
            if(c.charAt(0) == 'a'){
                // insert it.
                int left = 0;
                int right = list.size();
                while(left < right){
                    int mid = (left + right)/2;
                    if(list.get(mid) <= n){
                        left = mid + 1;
                    } else
                        right = mid;
                }
                list.add(left, n);
                median(list);
            } else {
                int index = -1;
                int left = 0;
                int right = list.size()-1;
                while(left <= right){
                    int mid = (left + right)/2;
                    long tmp = list.get(mid);
                    if( tmp == n){
                        index = mid;
                        break;
                    } else if( tmp < n) {
                        left = mid + 1;
                    } else
                        right = mid - 1;
                }
                if(index == -1){
                    System.out.println("Wrong!");
                } else {
                    list.remove(index);
                    median(list);
                }
            }
            //print(list);
        }
    }
    
    private void median(ArrayList<Long> list){
        int N = list.size();
        if(N == 0){
            System.out.println("Wrong!");
            return;
        }
        DecimalFormat format = new DecimalFormat("0.#");
        if(N % 2 == 0){
            System.out.println(format.format(1.0*(list.get(N/2)+list.get(N/2-1))/2.0));
        } else {
            System.out.println(format.format(list.get(N/2)));
        }
    }
    private void print(ArrayList<Long> list){
        System.out.println(list);
    }
}
