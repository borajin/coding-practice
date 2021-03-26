import java.util.*;

public class Main1516 {

    public static void main(String[] args) {
        //20210327 - http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=788&sca=2050

        /*
        문장 입력받아 단어 세기.
        화이트 스페이스를 기준으로 split 하여 string 배열에 담기
        단어 - 단어빈도수 꼴이고 정렬해야 하므로 key-value 쌍의 정렬된 sortedmap 자료구조 이용.
        자바는 sortedmap 을 treemap으로 구현함.

        문제는... 얘가 메모리를 다른 풀이에 비해 2배를 잡아먹으므로
        메모리 줄일 수 있는 코드를 나중에 다시 작성해봐야함!
         */
        
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        while(!str.equals("END")) {
            SortedMap<String, Integer> words = new TreeMap<String, Integer>();
            String[] strs = str.split(" ");

            for(String s : strs) {
                if(words.containsKey(s)) {
                    words.put(s, words.get(s)+1);
                } else {
                    words.put(s, 1);
                }
            }

            //반복자를 이용하기 위해 map 을 set으로 변환
            Set s = words.entrySet();   //key만 필요한 경우 keySet() , 둘 다 필요한 경우 entrySet(). entry 뜻은 하위개념이라고 생각하면 됨
            Iterator i = s.iterator();

            while(i.hasNext()) {
                Map.Entry m = (Map.Entry) i.next();

                String key = (String) m.getKey();
                int value = (Integer) m.getValue();

                System.out.println(key + " : " + value);
            }

            str = sc.nextLine();
        }
    }
}