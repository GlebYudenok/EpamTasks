package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.composite.LeafElement;

import java.util.List;

/**
 * Class which describe element of text called text.
 */
public class Text extends CompositeElement {

    /**
     * default empty constructor.
     */
    public Text() {
        super();
    }

    /**
     * Constructor with arguments.
     * @param textElems the element of text
     */
    public Text(final List<LeafElement> textElems) {
        super(textElems);
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
     * @return text as string
     */
    @Override
    public String getElement() {
        String text = new String();

        for (int i = 0; i < getTextElements().size(); i++) {
            text += getTextElements().get(i).getElement();
        }

        text = text.replaceAll("(.{77})", "$1\n");
        return text;
    }
}
