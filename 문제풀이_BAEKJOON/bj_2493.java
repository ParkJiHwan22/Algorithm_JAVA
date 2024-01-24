import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrInt = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stackInt = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stackInt.isEmpty()) {
                stackInt.push(arrInt[i]);
            } else {
                while (true) {
                    if (stackInt.peek() < arrInt[i]) {
                        stackInt.pop();
                    } else {
                        stackInt.push(arrInt[i]);
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arrInt));
    }
}