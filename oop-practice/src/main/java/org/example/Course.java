package org.example;

public class Course {
    private final String grade;
    private final int credit;
    private final String subject;

    public Course(String subject, int credit, String grade) {

        this.subject = subject;
        this.credit =credit;
        this.grade =grade;
    }

    public int getCredit() {
        return this.credit;
    }

    public Double getGradeNumber() {

        double gradeNumber =0;

        switch(this.grade){
            case "A+" : gradeNumber = 4.5; break;
            case "A" :  gradeNumber = 4.0; break;
            case "B+" : gradeNumber = 3.5; break;
            case "B" : gradeNumber = 3.0; break;
            case "C+" : gradeNumber = 2.5; break;
            case "C" : gradeNumber = 2; break;
        }

        return gradeNumber;
    }

    public double multiplyCreditAndGrade() {
        return credit * getGradeNumber();  // 만약 여기서 +1 이 증가하도록 로직을 바꾸면 여기서만 +1 해주면됨. 응집도가 높기때문에 변화발생시
        // 한군데만 수정
    }
}
