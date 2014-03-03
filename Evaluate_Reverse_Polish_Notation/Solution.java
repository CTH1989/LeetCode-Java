public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String Ele : tokens) {
            if (Ele.equals("+") || Ele.equals("-") || Ele.equals("*") || Ele.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                int z = 0;
                if (Ele.equals("+"))
                    z = x + y;
                else if (Ele.equals("-"))
                    z = x - y;
                else if (Ele.equals("*"))
                    z = x * y;
                else if (Ele.equals("/"))
                    z = x / y;
                stack.push(z);
            } else {
                int tmp = Integer.parseInt(Ele);
                stack.push(tmp);
            }
        }
        return stack.pop();
    }
}
