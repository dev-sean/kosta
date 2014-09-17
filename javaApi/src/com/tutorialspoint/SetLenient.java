package com.tutorialspoint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetLenient {

    public static void main(String[] args) {

        //날짜 출력 포맷 지정
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        //System.out.println(dateFormat.format(cal.getTime())); //오늘 날짜 출력

        cal.set(2014, 5, 31);//2014-06-31설정.참고로 월 설정시 0부터 시작하므로 1을 더한값이 실제 월.
        //6월은 마지막 일자가 30일 이므로 내부적으로 자동조정되어 7월 1일이 세팅됨.
        System.out.println("lenient true :"+dateFormat.format(cal.getTime())); //2014-07-01

        cal.setLenient(false); //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
        cal.set(2014, 5, 31);     //2014-06-31 설정
        System.out.println("비정상 :"+dateFormat.format(cal.getTime()));
        //기존 처럼 2014-07-01이 출력되지 않고 오류 발생

    }
}
