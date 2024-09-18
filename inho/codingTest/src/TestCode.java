public class TestCode {

    public static void main(String[] args) {
        //하이딩과 클래스 상속 개념
        Parent p = new Child();
        p.greet();
        p.hiding();
        Parent p1 = new Parent();
        p1.greet();
        p1.hiding();
        Child p2 = new Child();
        p2.greet();
        p2.hiding();

        //추상 클래스
        Animal dog = new Dog();  // Dog 클래스는 인스턴스화 가능
        dog.sound();             // 출력: Bark
        // Animal animal = new Animal();  // 오류: 추상 클래스는 인스턴스화할 수 없음
        // 추상 클래스는 단일 상속만 가능합니다. 즉, 한 클래스는 오직 하나의 추상 클래스만 상속받을 수 있습니다.
        //공통적인 기본 기능을 제공하면서도 일부 메서드는 하위 클래스에서 반드시 구체적인 구현이 필요할 때 사용합니다.
        //클래스 간에 상속을 통한 계층 구조를 만들어야 하며, 클래스 간의 강한 관계(즉, 'is-a' 관계)가 있을 때 적합합니다.


        //인터페이스
//        인터페이스는 다중 구현이 가능합니다. 한 클래스는 여러 개의 인터페이스를 구현할 수 있습니다.
//        클래스 간의 약한 관계(즉, 'can-do' 관계)가 있을 때 사용합니다.
//        사용 상황:
//        특정 클래스가 여러 행동을 수행해야 할 때 (즉, 다중 기능을 구현할 때) 인터페이스를 사용합니다.
//        다양한 클래스들이 공통적으로 특정 기능을 가져야 할 때 (예: 데이터베이스 연결, 네트워크 통신 등) 사용합니다.
//                클래스 간 구현에 의존하지 않는 유연한 구조를 만들고자 할 때 적합합니다.
        // 추상 클래스는 상속 계층을 만들 때, 인터페이스는 다형성을 극대화하고 유연한 설계를 할 때 사용됩니다.


    }

}

class Parent {
    public void greet() {
        System.out.println("Hello from Parent");
    }
    public static void hiding(){
        System.out.println("Parent Hiding");
    }
}

class Child extends Parent {

    public void greet() {
        System.out.println("Hello from Child");
    }
    public static void hiding(){
        System.out.println("child Hiding");
    }
}



//추상 클래스는 인스턴스화 할 수 없다. !
abstract class Animal {
    public abstract void sound(); // 추상 메서드
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}