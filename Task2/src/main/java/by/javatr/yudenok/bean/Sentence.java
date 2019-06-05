package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.composite.LeafElement;

import java.util.List;

/**
 * Class which describe element of text called sentence.
 */
public class Sentence extends CompositeElement {

    /**
     * Constructor with arguments.
     * @param textElements the element of text
     */
    public Sentence(final List<LeafElement> textElements) {
        super(textElements);
    }

    /**
     * Print datas.
     */
    @Override
    public void print() {
        System.out.print(getElement());
    }

    /**
     * Get datas as string.
     * @return sentence as string
     */
    @Override
    public String getElement() {
        String sentence = new String();
        for (int i = 0; i < getTextElements().size(); i++) {
            sentence += getTextElements().get(i).getElement();
        }

        String newSentence = sentence.substring(0, sentence.length() - 1);
        sentence = newSentence + ". ";
        return sentence;
    }
}