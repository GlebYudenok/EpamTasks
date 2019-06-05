package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.composite.LeafElement;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {

    public CompositeElement sentence = null;

    public void init(List<LeafElement> lf){
         sentence = new Sentence(lf);
    }

    @Test
    public void printSentence(){
        LeafElement word1 = new Word("This");
        LeafElement word2 = new Word("is");
        LeafElement word3 = new Word("a");
        LeafElement word4 = new Word("simple");
        LeafElement word5 = new Word("sentence");

        List<LeafElement> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);

        init(words);

        sentence.print();
    }

    @Test(expected = NullPointerException.class)
    public void printWithNullInConstructor(){
        sentence = null;
        sentence.print();
    }

}