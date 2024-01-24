import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arrInt = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stackInt = new Stack<>(); // 계산하는 수
        Stack<Integer> stackNum = new Stack<>(); // 위치
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (stackInt.isEmpty()) { // 스택이 비었을 때
                stackInt.push(arrInt[i]); // stack에 값을 더하고
                sb.append(0); // 0을 출력한 후
                stackNum.push(i+1);
            } else {
                while (true) {
                    if (!stackInt.isEmpty() && stackInt.peek() < arrInt[i]) { // 1. 스택 가장 위의 값 < 현재값
                        stackInt.pop();
                        stackNum.pop();

                    } else if (stackInt.isEmpty()) { // 2. 스택이 비어있을 때
                        stackInt.push(arrInt[i]);
                        sb.append(" " + 0);
                        stackNum.push(i+1);
                        break;

                    }else { // 스택 가장 위의 값 > 현재값
                        stackInt.push(arrInt[i]);
                        sb.append(" " + stackNum.peek()); // location을 더함
                        stackNum.push(i+1);
                        break;
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}