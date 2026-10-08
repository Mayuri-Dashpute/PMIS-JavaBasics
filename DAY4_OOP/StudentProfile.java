package DAY4_OOP;
import java.util.Scanner;
class Admission{
    String name;
    int student_id;
    double exam_score;

    Admission(String name, int student_id, double exam_score){
     this.name = name;
     this.student_id = student_id;
     this.exam_score = exam_score;
}

Admission(String name, int student_id){
     this.name = name;
     this.student_id = student_id;
     this.exam_score = 0.0;
}

char gradeSystem(){
    if(exam_score >= 90){
      return 'A';
    }else if(exam_score >=75){
        return 'B';
    }else if(exam_score >=50){
        return 'C';
    }else{
        return 'F';
    }

}

void reportCard(){
    System.out.println("name: "+ name);
    System.out.println("student_id: "+ student_id);
    System.out.println("exam_score: "+ exam_score);
    System.out.println("Grade: "+ gradeSystem());
    
}
public class StudentProfile{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
     Admission ad = new Admission("mayu", 1,82.5);
     ad.reportCard();  
     Admission ad1 = new Admission("mahi", 2);
     ad1.reportCard(); 

    }
}
}