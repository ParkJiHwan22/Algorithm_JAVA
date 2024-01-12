import java.util.Scanner; // scanner를 사용하기 위해 import 함
import java.util.Arrays; // 정렬을 사용하기 위해 import 함

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in); // Scanner를 사용하여 입력을 받는 객체 생성
		int T = sc.nextInt(); // 정수 T를 입력 받음 (테스트 케이스의 개수)
        int[] numbers = new int[T]; // 숫자를 저장할 배열을 선언하고 크기를 T로 설정
        
        for (int i = 0; i < T; i++) {
            numbers[i] = sc.nextInt(); // T개의 숫자를 배열에 저장
        }
        
        Arrays.sort(numbers); // 숫자 배열을 오름차순으로 정렬
        System.out.println(numbers[T/2]); // 배열의 인덱스는 0부터 시작하므로 (T-1)/2 인덱스에 있는 값을 출력
        
        sc.close(); // Scanner 객체를 닫아서 자원을 해제

	}
}