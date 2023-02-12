package org.example;

import java.util.List;

//책임들이 해당 일급컬렉션 밑으로 이동선다.
//어떤것의 수정이 발생했을때 해당 course 에대한 총학점수를 수정해달라하면
//해당 메서드만 수정을 하면되겠다라는 판단이
public class Courses {
    //이동
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multiCreditAndGradeNumber = 0;
        //이 값을 일급컬렉션에 위임을 할 수있음.
        for(Course course : courses){
            // 만약에 학점 계산이 여러군대에서 사용이 된다면
            //이부분에대한 로직이 바꾸면 여러군대 다바꿔야함 Course 에서 가지고 오는게 맞음.
            // multiCreditAndGradeNumber += course.getCredit() * course.getGradeNumber();
            // 밑의 줄처럼 getter가 아니라 해당 객체에 작업을 위임.
            multiCreditAndGradeNumber += course.multiplyCreditAndGrade();
        }

        return multiCreditAndGradeNumber;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)  //레퍼런스 메서드로 변경 후 .mapToInt(course -> course.getCredit() 이었음
                .sum();

    }
}
