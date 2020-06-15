package com.datastructure.chapter_03_LinkedList;

/**
 * @date : 2019-11-5
 */
public class Solution {

    public  boolean isValid(String s){
        LinkedListStack<Character> stack = new LinkedListStack<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if(c == ')' && pop != '(') return false;
                if(c == '}' && pop != '{') return false;
                if(c == ']' && pop != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("{{([])()}}"));
        System.out.println((new Solution()).isValid("([([(())]"));

    }
}
