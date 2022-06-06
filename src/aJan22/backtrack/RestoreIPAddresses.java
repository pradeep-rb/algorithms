package aJan22.backtrack;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.List;


//93. Restore IP Addresses
/*

 */

public class RestoreIPAddresses {

    List<String> ans = new ArrayList<>();

    List<String> backtrack(char[] ip, int start, String path, int comp) {

        if( comp == 4 && start >= ip.length)  ans.add(path);
        else if(!path.isEmpty())  path = path + ".";

        char one, two, three;
        if(start < ip.length ) {
            one = ip[start];
            backtrack(ip, start + 1, path + "" + one , comp + 1);
            if(start + 1 < ip.length ) {
                two = ip[start + 1];
                if(one != '0') {
                    backtrack(ip, start + 2, path + "" + one + "" + two , comp + 1);
                    if (start + 2 < ip.length) {
                        three = ip[start + 2];
                        String triplet = one + "" + two + "" + three;
                        if (Integer.parseInt(triplet) <= 255) {
                            backtrack(ip, start + 3, path + triplet , comp + 1);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<String> restoreIpAddresses(String s) {
        return backtrack(s.toCharArray(), 0, "", 0);
    }


    public static void main(String[] args) {
        RestoreIPAddresses rip = new RestoreIPAddresses();
        //System.out.println(rip.restoreIpAddresses("0000"));
        System.out.println(rip.restoreIpAddresses("101023"));
        //System.out.println(rip.restoreIpAddresses("25525511135"));
    }

}
