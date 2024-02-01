import java.util.*;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int res = 0;
        int maxInt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if (maxInt < arr[i][1]) {
                maxInt = arr[i][1];
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0])); // a[0] 기준으로 정렬

        int tmp_x = arr[0][0];
        int tmp_y = arr[0][1];
        int k = 0;
        for (int i = 1; i < n; i++) { // 앞에서부터
            if (tmp_y <= arr[i][1]) {
                res += (arr[i][0] - tmp_x) * tmp_y;
                tmp_x = arr[i][0];
                tmp_y = arr[i][1];
                if (tmp_y == maxInt) {
                    k = i;
                    break;
                }
            }
        }

        tmp_x = arr[n-1][0];
        tmp_y = arr[n-1][1];
        for (int i = n - 2; i >= k; i--) { // 뒤에서부터
            if (tmp_y <= arr[i][1]) {
                res += (tmp_x - arr[i][0]) * tmp_y;
                tmp_x = arr[i][0];
                tmp_y = arr[i][1];
            }
        }

        System.out.println(res + maxInt); // 가장 높은 기둥을 더함
    }
}