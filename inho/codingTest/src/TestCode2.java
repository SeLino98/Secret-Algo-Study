public class TestCode2 {


    public static void main(String[] args) {
        P p1 = new C();
        p1.f1(); // C
        p1.f2(); // B

        C p2 = new C();
        p2.f1(); //C
        p2.f2(); //B
        p2.f3(); //D

        P p3 = new P();
        p3.f1();//A
        p3.f2();//B
    }
}
class P{
    public void f1(){
        System.out.println("A");
    }
    public void f2(){
        System.out.println("B");
    }
}

class C extends P{
    public void f1(){
        System.out.println("C");
    }

    public void f3(){
        System.out.println("D");
    }
}
