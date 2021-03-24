import java.util.Scanner;

public class Main2809 {
    public static void main(String args[]) {
        //20210317 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=450&sca=2030

        /*
           약수란 N을 나누었을 때 나머지가 0이 되게 하는 수.
           보통 1부터 N까지의 수를 N과 나누는 알고리즘을 쓰는데, 그러면 시간이 N만큼 걸리게 됨.

           <시간을 줄이는 방법>
           1부터 N의 제곱근까지의 수를 N과 나누고 나누는 수와 몫을 한꺼번에 저장.
           a*b = N 에서 a와 b를 가르는 기준이 N의 제곱근이기 때문.

           ex) 16의 약수 = 1 2 4 / 8 16
           ex) 12의 약수 = 1 2 3 / 4 6 12
         */

        Scanner sc = new Scanner(System.in);

        int i, n, sqrtN, x = 0;
        int[] divisors = new int[100000];

        n = sc.nextInt();
        sqrtN = (int)Math.sqrt(n); //소수점 버림(내림) > 12의 제곱근 3.xxx... 의 경우 3으로 저장.

        //약수 구하기
        for(i=1; i<=sqrtN; i++) {
            if(n%i == 0) {
                divisors[x++] = i;

                //이부분이 살짝 헷갈렸는데.. 12의 제곱근은 3. 3까지 돌고 3*4의 경우 몫인 4와 3이 같지 않으니 두 쌍 모두 저장하고 종료.
                //16의 제곱근은 4고 4까지 돎. 4*4의 경우 몫인 4와 4가 같으니 한쌍만 저장하고 종료함.
                if(n/i != i) {
                    divisors[x++] = n/i;
                }
            }
        }

        ArraySortPrint(divisors, x);
    }

    /*
    <버블정렬>
    이웃한 두 수를 비교하여 자리를 바꿈으로써 큰/작은 쪽을 왼쪽/오른쪽으로 밀어냄.
    그러면 가장 큰/가장 작은 수가 맨 왼쪽/맨 오른쪽 으로 정렬됨.
    맨 왼쪽/맨 오른쪽은 정렬 완료된 상태이므로 이 다음 반복 때는 비교군에서 제외.

    즉, 0 ~ length-1-i 만큼 두 수 비교하여 작은수/큰수를 가장자리로 밀어내는 과정을 0 ~ (length-1) 만큼 반복.
     */
    public static void ArraySortPrint(int[] arr, int length) {
        int temp, i, j;
        for(i=0; i<length-1; i++) {
            for(j=0; j<length-1-i; j++) {
                if(arr[j] >=  arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(i=0; i<length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
