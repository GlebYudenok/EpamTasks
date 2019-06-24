package by.javatr.yudenok.service;

import by.javatr.yudenok.dao.DAO;

import java.util.concurrent.TimeUnit;

public class FillerDiagonalThread extends Thread {

    /**
     * value, which should be set by thread.
     */
    private int value;

    /**
     * constructor with initialize value by thread.
     * @param value which should be set by thread
     */
    public FillerDiagonalThread(final int value) {
        this.value = value;
    }

    /**
     * Overriding method by Runnable interface for thread work.
     */
    @Override
    public void run() {
        for (int i = 0; i < DAO.getINSTANCE().matrix.getMatrix().length; i++) {
            DAO.getINSTANCE().matrix.changeValue(value, getName());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
