package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.composite.LeafElement;

import java.util.List;

/**
 * Class which describe element of text called paragraph.
 */
public class Paragraph extends CompositeElement {

    /**
     * Constructor with arguments.
     * @param textElements the element of text
     */
    public Paragraph(final List<LeafElement> textElements) {
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
     * @return paragraph as string
     */
    @Override
    public String getElement() {
        String paragraph = new String();

        paragraph += "\t";
        for (int i = 0; i < getTextElements().size(); i++) {
            paragraph += getTextElements().get(i).getElement();
        }
        paragraph += "\r\n";
        return paragraph;
    }
}
