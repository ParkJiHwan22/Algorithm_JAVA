import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push": {
                    int X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                }
                case "pop": sb.append(stack.pop()).append("\n"); break;
                case "size": sb.append(stack.size()).append("\n"); break;
                case "empty": sb.append(stack.empty()).append("\n"); break;
                case "top": sb.append(stack.top()).append("\n"); break;
            }
        }
        System.out.print(sb);
    }

    private static class Stack {
        int[] data;
        int top;

        public Stack(int N) {
            data = new int[N];
            top = -1;
        }

        public void push(int X) {
            data[++top] = X;
        }

        public int pop() {
            return empty() == 1 ? top : this.data[this.top--];
        }

        public int size() {
            return top + 1;
        }

        public int empty() {
            return top == -1 ? 1 : 0; // 맞으면 1, 틀리면 0을 반환
        }

        public int top() {
            return empty() == 1 ? top : data[top];
        }

    }
}
