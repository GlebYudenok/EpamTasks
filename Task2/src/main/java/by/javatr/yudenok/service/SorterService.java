package by.javatr.yudenok.service;

import by.javatr.yudenok.bean.Paragraph;
import by.javatr.yudenok.bean.Sentence;
import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.bean.Word;
import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.composite.LeafElement;
import by.javatr.yudenok.controller.parser.impl.ParagraphParser;
import by.javatr.yudenok.controller.parser.impl.SentenceParser;
import by.javatr.yudenok.controller.parser.impl.TextParser;
import by.javatr.yudenok.controller.parser.impl.WordParser;
import by.javatr.yudenok.dao.TextDAOimpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sort element of text by criteria.
 */
public class SorterService {

    /**
     * Sorting sentences in paragraph by amount of words.
     * @param text source text object
     * @return
     */
    public static Paragraph sortParagraphsBySentences(final Paragraph text) {
        List<LeafElement> sortedSentence = text.getTextElements().stream()
                .map(sentence -> (Sentence) sentence)
                .sorted(Comparator.comparingInt(sentence -> sentence.getTextElements().size() ))
                .collect(Collectors.toList());
        Collections.reverse(sortedSentence);
        return new Paragraph(sortedSentence);
    }
}
























   /* private static Paragraph sortSentencesByAmountOfWordsInParagraph(Paragraph paragraph){
        List<LeafElement> sortedLeaf = paragraph.getTextElements().stream()
                .map(sentence -> (Sentence) sentence)
                .sorted(Comparator.comparingInt(sentence -> sentence.getTextElements().size() ))
                .collect(Collectors.toList());
        Collections.reverse(sortedLeaf);
        return new Paragraph(sortedLeaf);
    }*/