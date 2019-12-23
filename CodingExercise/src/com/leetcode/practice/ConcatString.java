package com.leetcode.practice;

public class ConcatString {
    public static void main(String[] args) {

        int n = 100;
          ConcatString concatString = new ConcatString();
       /* StringBuilder res   =   concatString.getString(n, new StringBuilder());
        System.out.println(res.toString());*/
        System.out.println(ConcatString.printIndexVal(n, "0"));

    }

    public StringBuilder getString(int num, StringBuilder s){
        if(num == 0){
            return new StringBuilder("0");
        }else{
            s = getString(num-1, s);
            Long sLong    =   Long.parseLong(s.toString(),2);
            String complimant   =   Long.toBinaryString(Long.valueOf(~sLong));
            String s1   =   complimant.substring(complimant.length()-s.length());
            s.append("0");
            s.append(s1);
        }

        return s;
    }

    static String printIndexVal(int k, String s)
    {
        while (s.length() <= Math.pow(2,k))
        {

            // Building the complement of s
            String t = "";
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == '0')
                    t += '1';
                else
                    t += '0';
            }

            // Appending the complement to form
            // the new string
            s += "0";
            s += t;
        }

        // To match return type
        return s;
    }
}
