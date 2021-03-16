import java.util.Scanner;

public class Main1338 {
    public static void main(String args[]) {
        //20210316 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2074&sca=2010

        /*
          x = 01234     y = 43210
          x = 1234      y = 4321
          x = 234       y = 432
          x = 34        y = 43
          x = 4         y = 4

          x = i 부터 height-1 까지 1씩 증가
          y = height-1 부터 i 까지 1씩 감소
         */

        Scanner sc = new Scanner(System.in);

        int i, j, height;
        char[][] arr = new char[100][100];
        char c = 'A';

        height = sc.nextInt();

        //공백으로 초기화
        for(i=0; i<arr.length; i++) {
            for(j=0; j<arr.length; j++) {
                arr[i][j] = ' ';
            }
        }

        //배열에 값 대입
        for(i=0; i<height; i++) {
            int x = 1;
            for(j=i; j<height; j++) {
                arr[j][height - x++] = c++;
                if(c > 'Z') c = 'A';
            }
        }

        //출력
        for(i=0; i<height; i++) {
            for(j=0; j<height; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
