package by.javatr.yudenok.example19;

import java.util.ArrayList;

public class RunLearning {
    public static void main(String[] args) {
        final int NUMBER_TASKS_1 = 5;
        Student student1 = new Student(322801, NUMBER_TASKS_1);
        for(int i = 0; i < NUMBER_TASKS_1; i++){
            Task t = new Task("Task #" + i);
            student1.addTask(t);
        }
        final int NUMBER_TASK_2 = 4;
        Student student2 = new Student(322924, NUMBER_TASK_2);
        for(int i = 0; i < NUMBER_TASK_2; i++){
            Task t = new Task("Task ##" + i);
            student2.addTask(t);
        }
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        Tutor tutor = new Tutor(list);
        student1.start();
        student2.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        tutor.start();
    }
}