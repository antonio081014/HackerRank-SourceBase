import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */

/**
 * @author antonio081014
 * @since Jan 7, 2012, 10:24:38 AM
 */
public class Solution {

    public static List<Orders>  list;
    public static HashSet<Long> set;

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(
        // new DataInputStream(new FileInputStream("input.txt"))));
        // BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
        // "output.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<Orders>();
        set = new HashSet<Long>();
        long T = Long.parseLong(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] strs = br.readLine().split(",");
            Orders order = new Orders(Long.parseLong(strs[0]), Long
                    .parseLong(strs[1]), processEmail(strs[2]),
                    processAddr(strs[3]), strs[4], getState(strs[5]), strs[6],
                    strs[7]);
            // int index = -1;
            // if ((index = list.indexOf(order)) != -1) {
            // set.add(list.get(index).orderID);
            // set.add(order.orderID);
            // }
            // else
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).fraudCaseOne(order)
                        || list.get(j).fraudCaseTwo(order)) {
                    set.add(list.get(j).orderID);
                    set.add(order.orderID);
                }
            }
            list.add(order);
        }
        // System.out.println(set.size());
        Iterator it = set.iterator();
        String ret = "";
        while (it.hasNext())
            ret += Long.toString((Long) it.next()) + ",";
        System.out.println(ret.substring(0, ret.length() - 1));

        // for (int i = 0; i < list.size(); i++)
        // // System.out.println(list.get(i));
        // bw.write(list.get(i) + "\n");

        br.close();
        // bw.close();
    }

    public static String processEmail(String email) {
        String ret = email.toLowerCase();
        int index = ret.lastIndexOf('@');
        String portion = ret.substring(0, index);
        String extension = ret.substring(index);
        ret = removePlus(removeDot(portion)) + extension;
        return ret;
    }

    public static String removeDot(String portion) {
        return portion.replaceAll("\\.", "");
    }

    public static String removePlus(String portion) {
        int index = portion.indexOf('+');
        if (index == -1)
            return portion;
        return portion.substring(0, index);
    }

    public static String processAddr(String address) {
        int index = address.lastIndexOf(" ");
        String front = address.substring(0, index);
        String end = getAbb(address.substring(index + 1));
        return front + " " + end;
    }

    public static String getAbb(String name) {
        if (name.compareToIgnoreCase("street") == 0)
            return "st.";
        if (name.compareToIgnoreCase("road") == 0)
            return "rd.";
        return name;
    }

    public static String getState(String state) {
        if (state.compareToIgnoreCase("Illinois") == 0)
            return "IL";
        if (state.compareToIgnoreCase("New York") == 0)
            return "NY";
        if (state.compareToIgnoreCase("California") == 0)
            return "CA";
        return state;
    }
}

class Orders implements Comparable<Orders> {
    public long   orderID;
    public long   dealID;
    public String email;
    public String street;
    public String city;
    public String state;
    public String zipcode;
    public String creditCard;

    public Orders(long order, long deal, String email_, String street_,
            String city_, String state_, String zipcode_, String creditCard_) {
        this.orderID = order;
        this.dealID = deal;
        this.email = email_;
        this.street = street_;
        this.city = city_;
        this.state = state_;
        this.zipcode = zipcode_;
        this.creditCard = creditCard_;
    }

    public boolean fraudCaseOne(Orders obj2) {
        if (this.dealID != obj2.dealID)
            return false;
        if (this.email.compareToIgnoreCase(obj2.email) == 0
                && this.creditCard.compareToIgnoreCase(obj2.creditCard) != 0)
            return true;
        return false;
    }

    public boolean fraudCaseTwo(Orders obj2) {
        if (this.dealID != obj2.dealID)
            return false;
        if (this.street.compareToIgnoreCase(obj2.street) == 0
                && this.city.compareToIgnoreCase(obj2.city) == 0
                && this.state.compareToIgnoreCase(obj2.state) == 0
                && this.creditCard.compareToIgnoreCase(obj2.creditCard) != 0)
            return true;
        return false;
    }

    public String toString() {
        return String.format("%d,%d,%s,%s,%s,%s,%s,%s", orderID, dealID, email,
                street, city, state, zipcode, creditCard);
    }

    public boolean equals(Orders o) {
        if (this.fraudCaseOne(o) || this.fraudCaseTwo(o))
            return true;
        return false;
    }

    public int compareTo(Orders o) {
        if (this.fraudCaseOne(o) || this.fraudCaseTwo(o))
            return 0;
        else
            return 1;
    }
}
