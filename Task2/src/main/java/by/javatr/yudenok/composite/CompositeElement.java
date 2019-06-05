package by.javatr.yudenok.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class which connected with beans.
 */
public abstract class CompositeElement implements LeafElement {

    /**
     * This field contains elements from all beans.
     */
    private List<LeafElement> textElements = new ArrayList<>();

    /**
     * Simple empty constructor.
     */
    public CompositeElement() {

    }

    /**
     * Constructor with parameter.
     * @param textElements can contains all types
     *                     of elements implements LeafElement.
     **/
    public CompositeElement(final List<LeafElement> textElements) {
        this.textElements = textElements;
    }


    /**
     * Simple getter.
     * @return all elements of text.
     */
    public List<LeafElement> getTextElements() {
        return textElements;
    }

}
