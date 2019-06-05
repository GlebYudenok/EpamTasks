package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.composite.LeafElement;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParagraphTest {

    public CompositeElement paragraph = null;

    public void init(List<LeafElement> lf){
        paragraph = new Paragraph(lf);
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

        CompositeElement sentence1 = new Sentence(words);

        word4 = new Word("second");
        CompositeElement sentence2 = new Sentence(words);

        List<LeafElement> sentences = new ArrayList<>();
        sentences.add(sentence1);
        sentences.add(sentence2);

        init(sentences);

        paragraph.print();
    }

    @Test(expected = NullPointerException.class)
    public void printWithNullInConstructor(){
        paragraph = null;
        paragraph.print();
    }
}