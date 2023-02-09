package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 요구사항
• 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
• MVC패턴(Model-View-Controller) 기반으로 구현한다.
• 일급 컬렉션 사용
* */
public class GrandCalculatorTest {
    // 어떤 도메인이 필요할까 : 이수과목 , 학점 계산기
    // 동적인 객체를 정적인 객체로 추상화해서 도메인 모델링
    // 이수 과목에는 객체 지향 프로그래밍, 자료구조, 중국어 등 있을수 있는데 - > 과목이라는 클래스로 표현한다는게 동적객체 - >정적 객체 추상화해서
    //도메인 모델링 한다는 의미.

    //객체를 포괄하는 타입에 ( 쉽게말해 클래스에 ) 적절한 책임을 할당
    //평균학점을 계산하기 위해서 이수한 과목을 전달하여 평균학점 계산을 요청. --- > 학점계산기에게 ((학점수×교과목 평점)의 합계/수강신청 총학점 수)


    //적절한 책임을 할당의 의미 테스트코드로  , 작은 객체부터 만드는 편 Course 관련 클래스만든후, Course 를 통해 학점계산 테스트를한다.
    @DisplayName("평균학점 계산")
    @Test
    void calculateGradeTest() {
        List<Course> courses =  new ArrayList<>();
        courses.add(new Course("oop",3,"A+"));
        courses.add(new Course("자료구조",3,"A+"));

        // 학점계산기가 생성될때 이수한 과목들을 전달 하고,
        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        //이수한과목들을 가지고 성적을 계산해보겠다.
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }

    //일급 컬렉션을 사용한다는게 어떤의미면 course에대한 로직처리가 gradeCalculator에 있음 .
    // 이부분을 일급 컬렉션을 사용하면 어떻게되는지 확인 해보자.

}
