package value;

public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = a;

        a = 20;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        //기본타입은 항상 값을 복사해가기때문에 공유(사이드 이펙트)가 안됨

        Integer c = 10;
        Integer d = c;

        c = 20;
        System.out.println("c : " + c);
        System.out.println("d : " + d);
        //래퍼타입은 공유가능한 객체이지만 사이드이펙트가 나타나지않도록 막아놨음


    }
}
