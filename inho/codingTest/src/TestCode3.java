public class TestCode3 {


    public static void main(String[] args) {



    }


}
class Parent1 {

    protected int a = 10; // private 필드

    public int b = 20;  // public 필드

}

class Child2 extends Parent1 {
    public int c = 30;  // public 필드
    void display() {
         System.out.println(a); // 상속받은 private 필드 참조
        System.out.println(b);    // 상속받은 public 필드 참조
    }

}