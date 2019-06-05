package by.javatr.yudenok.bean;

public class Album {
    private String producerName;
    private int pagesAmount;

    public Album(String producerName, int pageAmount) {
        this.producerName = producerName;
        this.pagesAmount = pageAmount;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public String getProducerName() {
        return producerName;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (pagesAmount != album.pagesAmount) return false;
        return producerName != null ? producerName.equals(album.producerName) : album.producerName == null;

    }

    @Override
    public int hashCode() {
        int result = producerName != null ? producerName.hashCode() : 0;
        result = 31 * result + pagesAmount;
        return result;
    }

    @Override
    public String toString() {
        return "Album:\n" +
                "producerName : " + producerName + '\n' +
                "pagesAmount : " + pagesAmount + '\n';
    }
}
