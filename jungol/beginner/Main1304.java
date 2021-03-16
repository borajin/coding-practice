import java.util.Scanner;

public class Main1304 {
    public static void main(String args[]) {

        //풀이1
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

        //풀이2
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
