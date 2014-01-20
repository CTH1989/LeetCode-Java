public class Solution {
    public boolean isValid(String s) {
        char arr[] = s.toCharArray(), tmp;
        Stack<Character> stack = new Stack<Character>();
        for (char Ele : arr) {
            if (Ele == ')') {
                if (stack.isEmpty()) return false;
                tmp = stack.pop();
                if (tmp != '(') return false;
            } else if (Ele == ']') {
                if (stack.isEmpty()) return false;
                tmp = stack.pop();
                if (tmp != '[') return false;
            } else if (Ele == '}') {
                if (stack.isEmpty()) return false;
                tmp = stack.pop();
                if (tmp != '{') return false;
            } else {
                stack.push(Ele);
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
