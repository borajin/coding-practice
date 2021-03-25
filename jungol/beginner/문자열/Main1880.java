import java.util.Scanner;

public class Main1880 {
    //20210325 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1153&sca=2050

    /*
        복호화 키를 0~24 배열에 담음.
        0~24는 a~z 의 자리와 동일.
        암호화한 문장도 배열로 만듦
        각 알파벳이 a~z(0~24) 이므로 유니코드 계산해서 복호화 키가 담긴 배열의 인덱스에 넣으면 됨.
        대문자는 소문자와 대문자 유니코드 차이만큼 빼주기.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String decryptionKey = sc.nextLine();
        String encryptionStr = sc.nextLine();

        char[] decryption = decryptionKey.toCharArray();
        char[] encryption = encryptionStr.toCharArray();

        for(int i=0; i<encryption.length; i++) {
            if(encryption[i] != ' ') {
                if(encryption[i] > 'Z') {
                    encryption[i] = decryption[encryption[i]-'a'];
                } else {
                    encryption[i] = (char)(decryption[encryption[i]-'A'] - ('a' - 'A'));
                }
            }
        }

        System.out.println(encryption);
    }
}