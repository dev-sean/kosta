

/*
이거는 강제로 에러를 발생시켜야 하기 때문에
현철이형 PPT에 있는 super/super() 예제 2개를 사용하기로 했음

추상, 인터페이스, 내부클래스도 현철이형 pt에 있는 예제 ㄱㄱㅆ!!
잘 설명이 되어있는 것 같아서 그냥 써도 되겠다.
*/

/*
class Parent {
    int x; 
    Parent ( int x) {  
       this.x = x;
   }
}

class Child extends Parent {
    int y;
    Child (int x, int y) {
//      super();  ? Parent () 호출  
        this.x = x;    ? super(x);  
        this.y = y;        Parent(int x) 호출
    }
} 

new Child(int x, int y);  // 에러발생
*/