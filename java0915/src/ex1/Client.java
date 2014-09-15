package ex1;
/**
 * @author 오세현
 * Document : Client 
 * Created on : 2014. 9. 15, 오전 9:23:22
 */
public class Client {
    public static void main(String[] args) {
        Animal animal;
        animal = new Bird();
        animal.cry();
        
        animal = new Cat();
        animal.cry();
        
        animal = new Dogs();
        animal.cry();
        //배열을 사용한 다형성 처리
        //배열은 객체
        // - 일반자료형 배열, 참조 자료형 배열
        // - 일차원 배열과 다차원 배열
        // - 배열은 생성시 반드시 크기가 결정되어야 한다.
        Animal[] ar = new Animal[3];
        ar[0] = new Bird();
        ar[1] = new Cat();
        ar[2] = new Dogs();
        int size = ar.length;
        System.out.println("배열의 크기 : "+ size);
        //효율적인 코드를 사용하는 방법
        for (int i = 0; i < size; i++) {
            ar[i].cry();            
        }
        //jdk5부터 향상된 for문 제공
        //(배열/컬렉션의 객체 지역변수 :(in의 의미) 변수명){
        //실행
        //}
        for(Animal e : ar){
            e.cry();
        }
    }
}
