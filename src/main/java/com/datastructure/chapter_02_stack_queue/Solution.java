package com.datastructure.chapter_02_stack_queue;

import java.util.HashMap;
import java.util.Map;

/**
 * @date : 2019-10-30
 */
public class Solution {
    /**
     * 括号配对，解法1
     * @param s
     * @return
     */
    private boolean isValid(String s){
        ArrayStack<Character> as = new ArrayStack();
        Map<Character,Character> map = new HashMap() {
            {
                put('(',')');
                put('{','}');
                put('[',']');
            }
        };
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                as.push(c);
            }else{
                if(as.isEmpty())
                    return false;

                char pop = as.pop();
                if(map.get(pop) != c)
                    return false;
            }

        }
        return as.isEmpty();
    }

    /**
     * 括号配对，解法2
     * @param s
     * @return
     */
    private boolean isValid2(String s){
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }while(length != s.length());

        return s.length() == 0;
    }

    private static void test1(){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i< 10000; i++){
            sb1.append("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((" +
                    "))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
        }
        for(int i=0; i< 10000; i++){
            sb2.append("([(())]([(())]([(())]([(())]([(())]([(())]([(())]");
        }
        long start = System.currentTimeMillis();
        System.out.println((new Solution()).isValid(sb1.toString()));
        System.out.println((new Solution()).isValid(sb2.toString()));
        //System.out.println((new Solution()).isValid("{()[()]{()}{}()}{()[()]{()}{}()}{()[()]{()}{}()}"));
        //System.out.println((new Solution()).isValid("([(())]([(())]([(())]([(())]([(())]([(())]([(())]"));
        long end = System.currentTimeMillis();
        System.out.println("isValid:"+(end - start));
        System.out.println((new Solution()).isValid2(sb1.toString()));
        System.out.println((new Solution()).isValid2(sb2.toString()));
        //System.out.println((new Solution()).isValid2("{()[()]{()}{}()}{()[()]{()}{}()}{()[()]{()}{}()}"));
        //System.out.println((new Solution()).isValid2("([(())]([(())]([(())]([(())]([(())]([(())]([(())]"));
        long end2 = System.currentTimeMillis();
        System.out.println("isValid2:"+(end2 - end));
    }


    public static void main(String[] args) {
        test1();
    }
}
