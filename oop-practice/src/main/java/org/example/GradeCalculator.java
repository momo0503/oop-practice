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
        double multiCreditAndGradeNumber = 0;

        //이 값을 일급컬렉션에 위임을 할 수있음.
        for(Course course : courses){
           // 만약에 학점 계산이 여러군대에서 사용이 된다면
            //이부분에대한 로직이 바꾸면 여러군대 다바꿔야함 Course 에서 가지고 오는게 맞음.
            // multiCreditAndGradeNumber += course.getCredit() * course.getGradeNumber();
            // 밑의 줄처럼 getter가 아니라 해당 객체에 작업을 위임.
            multiCreditAndGradeNumber += course.multiplyCreditAndGrade();
        }

        //수강신청 총 학점
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)  //레퍼런스 메서드로 변경 후 .mapToInt(course -> course.getCredit() 이었음
                .sum();

        return multiCreditAndGradeNumber/totalCompletedCredit;
    }


    //일급 컬렉션을 사용한다는게 어떤의미면 course에대한 로직처리가 gradeCalculator에 있음 .
    // 이부분을 일급 컬렉션을 사용하면 어떻게되는지 확인 해보자.


}
