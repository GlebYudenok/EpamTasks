package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.LeafElement;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void printWord(){
        LeafElement word = new Word("word");
        word.print();
    }

    @Test
    public void printTwoWordsInOneConstructor(){
        LeafElement word = new Word("Simple word");
        word.print();
    }

    @Test
    public void printWithNullInConstructor(){
        LeafElement word = new Word(null);
        word.print();
    }
}