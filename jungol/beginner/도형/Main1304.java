import java.util.Scanner;

public class Main1304 {
    public static void main(String args[]) {
        //20210324 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2070&sca=2010

        //풀이1 : 바깥 반복문은 열, 안쪽 반복문은 행임. 문제는 행과 열이 뒤집혀있으니 배열에 저장할 때 인덱스를 반대로 바꿔주면 됨.
        int i, j, length, num=1;
        int[][] arr = new int[100][100];

        Scanner sc = new Scanner(System.in);

        length = sc.nextInt();

        for(i=0; i<length; i++) {
            for(j=0; j<length; j++) {
                arr[j][i] = num++;
            }
        }

        for(i=0; i<length; i++) {
            for(j=0; j<length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

        //풀이2 : 행 사이 수와 열이 바뀔 때의 규칙을 찾음.
        /*
        int i, j, num=1, length;

        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();

        for(i=0; i<length; i++) {
            for(j=0; j<length; j++) {
                System.out.print(num + " ");
                num+=length;
            }
            System.out.println("");
            num -= (length*length-1);
        }
        */
    }
}
