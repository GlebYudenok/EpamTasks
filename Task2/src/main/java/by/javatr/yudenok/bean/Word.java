package by.javatr.yudenok.bean;

import by.javatr.yudenok.composite.LeafElement;

 /**
  * Class which describe element of text called word.
  */
public class Word implements LeafElement {

    private String word;

     /**
      * Constructor with param.
      * @param word is arg which by assigned to field
      */
    public Word(final String word) {
        this.word = word;
    }

     /**
      * print field.
      */
    @Override
    public void print() {
        System.out.print(getElement());
    }

     /**
      * Getting field as string.
      * @return part of text as string
      */
    @Override
    public String getElement() {
        return word + " ";
    }

     /**
      * Getting field string length.
      * @return length of field
      */
    public int getWord() {
        return word.length();
    }

     /**
      * Simple toString function.
      * @return fields of class
      */
    @Override
    public String toString() {
        return word;
    }
}
