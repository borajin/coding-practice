import java.util.Scanner;

public class Main2809 {
    public static void main(String args[]) {
        //20210317 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=450&sca=2030

        /*
           N의 약수 구하기.
           약수란 N을 나누었을 때 나머지가 0이 되게 하는 수.
           보통 1부터 N까지의 수를 N과 나누었을 때 0이되는 수를 구하는 알고리즘을 쓰는데, 그러면 시간이 N만큼 걸리게 됨.

           시간을 줄이는 방법 => 1부터 N의 제곱근까지의 수를 N과 나누었을 때 0이되는 수 두 쌍, 즉 나누는 수와 몫을 한꺼번에 저장.
           a*b = N 에서 a와 b를 가르는 기준이 N의 제곱근이기 때문.

           ex) 16의 약수 = 1 2 4 / 8 16
           ex) 21의 약수 = 1 2 / 7 21
         */

        Scanner sc = new Scanner(System.in);

        int i, n, sqrtN, x = 0;
        int[] divisors = new int[100000];

        n = sc.nextInt();
        sqrtN = (int)Math.ceil(Math.sqrt(n));

        //약수 구하기
        for(i=1; i<sqrtN; i++) {
            if(n%i == 0) {
                divisors[x++] = i;

                if(n/i != i) {
                    divisors[x++] = n/i;
                }
            }
        }

        //작은 수로 정렬
        int temp, j;
        for(i=0; i<x-1; i++) {
            for(j=0; j<x-1-i; j++) {
                if(divisors[j] >= divisors[j+1]) {
                    temp = divisors[j];
                    divisors[j] = divisors[j+1];
                    divisors[j+1] = temp;
                }
            }
        }

        for(i=0; i<x; i++) {
            System.out.print(divisors[i] + " ");
        }
    }
}
