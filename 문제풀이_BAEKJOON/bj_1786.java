import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        int[] arr = new int[pattern.length()];
        piArrays(arr, pattern); // 파이배열 생성
        kmpMethods(arr, text, pattern);
    }


    public static void piArrays(int[] arr, String pattern) {
        int i = 0;
        int j = 1;

        while (j < pattern.length()) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                i++;
                arr[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = arr[i - 1];
                } else {
                    arr[j] = i;
                    j++;
                }
            }
        }
    }

    public static void kmpMethods(int[] arr,String text, String pattern) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while (j < text.length()) {
            if (pattern.charAt(i) == text.charAt(j)) {
                i++;
                j++;
            }
            if (i == pattern.length()) {
                cnt++;
                sb.append((j - i + 1)).append(" ");
                i = arr[i - 1];
            } else if (j < text.length() && pattern.charAt(i) != text.charAt(j)) { // pattern의 첫 문자열과 매칭되지 않을 때
                if (i != 0) {
                    i = arr[i - 1];
                } else {
                    j = j + 1;
                }
            }
        }
        System.out.println(cnt);
        if (cnt > 0) {
            System.out.println(sb.toString().trim());
        }
    }
}