class Solution {
    public String reverseParentheses(String s) {
        return reverseParenthesis(s);
    }
    public static String reverseParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != ')'){
                stack.push(ch);
                continue;
            }
            String popped = "";
            while (!stack.isEmpty() && stack.peek() != '('){
                popped += stack.pop();
            }
            if(!stack.isEmpty()){
                stack.pop();
            }
            if(popped.length() > 0){
        
                for (int j = 0; j < popped.length(); j++) {
                    stack.push(popped.charAt(j));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}