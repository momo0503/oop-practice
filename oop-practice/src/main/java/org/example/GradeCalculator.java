package org.example;

import java.util.List;

public class GradeCalculator {

    // 일급 컬렉션을 사용한다는 것은 구현을통해 보자.
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);

    }
//평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
    public double calculateGrade() {


        double multipliedCreditAndCoureseGrade = courses.multiplyCreditAndCourseGrade();

        //수강신청 총 학점
        int totalCompletedCredit  = courses.calculateTotalCompletedCredit();

        return multipliedCreditAndCoureseGrade/totalCompletedCredit;
    }


    //일급 컬렉션을 사용한다는게 어떤의미면 course에대한 로직처리가 gradeCalculator에 있음 .
    // 이부분을 일급 컬렉션을 사용하면 어떻게되는지 확인 해보자.


}
