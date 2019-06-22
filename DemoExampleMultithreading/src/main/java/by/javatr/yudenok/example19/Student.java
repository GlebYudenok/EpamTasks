package by.javatr.yudenok.example19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Student extends Thread {
    private Integer idStudent;
    private List<Task> taskList;
    private CountDownLatch countDown;

    public Student(Integer idStudent, int numberTasks) {
        this.idStudent = idStudent;
        this.taskList = new ArrayList<Task>(numberTasks);
        this.countDown = new CountDownLatch(numberTasks);
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public CountDownLatch getCountDownLatch(){
        return countDown;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public void run(){
        int i = 0;
        for(Task inWork : taskList){
            try {
                Thread.sleep(new Random().nextInt(100));
            }catch (InterruptedException e){
                System.err.println(e);
            }
            inWork.setAnswer("Answer #"+ ++i);
            System.out.println("Answer #" + i + " from " + idStudent);
            try {
                countDown.await();
            }catch (InterruptedException e){
                System.err.println(e);
            }
        }
        float avgMark = 0;
        for(Task inWork : taskList){
            avgMark += inWork.getMark();
        }
        avgMark /= taskList.size();
        System.out.println("Student " + idStudent + " : Average mark = " + avgMark);
    }
}
