import java.util.*;
import java.io.*;

public class Main{
    static class Person implements Comparable<Person>{
        String name;
        int korean;
        int english;
        int math;
        public Person(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        @Override
        public int compareTo(Person o) {
            if (this.korean != o.korean) {
                return o.korean - this.korean; // 국어 점수 내림차순
            }
            if (this.english != o.english) {
                return this.english - o.english; // 영어 점수 오름차순
            }
            if (this.math != o.math) {
                return o.math - this.math; // 수학 점수 내림차순
            }
            return this.name.compareTo(o.name); // 이름 사전순 오름차순
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Person> pList = new ArrayList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            pList.add(new Person(name,kor,eng,math));
        }
        Collections.sort(pList);
        for (Person person : pList) {
            sb.append(person.name).append("\n");
        }
        System.out.println(sb);
    }
}