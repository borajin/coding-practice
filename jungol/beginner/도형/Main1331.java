import java.util.Scanner;

class Main1331 {

    //20210324 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2073&sca=2020

    /*
    마름모 배열 = 2*length-1 길이 가지는 2차원 배열

    시작점 : 0, length-1

    왼쪽아래방향 : i++, j--
    오른쪽아래방향 : i++, j++
    오른쪽위방향 : i--, j++
    왼쪽위방향 : i--, j--

    방향을 바꾸는 때 : i 인덱스가 범위 벗어났거나 j인덱스가 범위 벗어났을 때. 커서 정상범위로 돌려놔야함.
    행 바꿀 때 : 넣으려는 자리에 이미 공백 아닌 값이 있을 때. 행이 바뀌면서 i, j 인덱스 범위 -1, +1 해야됨(안쪽 마름모이기 때문)
    멈추는 때 : i=length-1, j=length-1일 때 (length일 때는 안됨!!)

    순서 : 커서 유효성검사(행바꿔야하는지, 방향바꿔야 하는지) => 값 넣고 멈출지 검사 => 커서이동
     */

    public static void main(String[] args) {
        int length;
        char c = 'A';
        char[][] rhombus;
        Scanner sc = new Scanner(System.in);

        length = sc.nextInt();
        rhombus = new char[2 * length - 1][2 * length - 1];  //자바 가변길이가 되다니..

        //공백으로 초기화
        ResetArray(rhombus, ' ');

        int i = 0, j = length - 1, flag = 0, x = 0;

        while (true) {
            //값이 벗어났나? (행이 바뀔 때마다 검사 범위가 1씩 줄어듦(안쪽 마름모이기 때문))
            if (i >= rhombus.length - x || i < 0 + x || j >= rhombus.length - x || j < 0 + x) {
                //커서 제자리에
                if (flag == 0) {
                    j += 2;
                } else if (flag == 1) {
                    i -= 2;
                } else if (flag == 2) {
                    j -= 2;
                }

                flag++;
            }
            //행 바꿔야 하나?
            else if (rhombus[i][j] != ' ') {
                flag = 0;
                i++;
                x++;
            }
            //유효성 검사 통과했으니
            else {
                //값 넣고
                rhombus[i][j] = c++;
                if (c > 'Z') c = 'A';

                //멈춰야하나?
                if (i == length - 1 && j == length - 1) {
                    break;
                } else {
                    //커서 이동
                    if (flag == 0) {
                        i++;
                        j--;
                    } else if (flag == 1) {
                        i++;
                        j++;
                    } else if (flag == 2) {
                        i--;
                        j++;
                    } else if (flag == 3) {
                        i--;
                        j--;
                    }
                }
            }
        }

        PrintArray(rhombus);
    }

    public static void ResetArray(char[][] array, char value) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = value;
            }
        }
    }

    public static void PrintArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
