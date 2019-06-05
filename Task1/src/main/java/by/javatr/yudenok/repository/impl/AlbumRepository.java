package by.javatr.yudenok.repository.impl;

import by.javatr.yudenok.bean.Album;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.RepositoryException;
import by.javatr.yudenok.parser.AlbumParser;
import by.javatr.yudenok.repository.Repository;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository implements Repository<Album> {

    private static final Logger logger = LogManager.getLogger(AlbumRepository.class);
    private static final File filePath = new File("src/main/resources/AlbumList.txt");


    public File getPath() {
        return filePath;
    }

    public void read() throws IOException, ParserException{
        AlbumParser.parse(getPath());
    }

    public void update() throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(getPath());
        }catch (IOException e){
            throw new IOException();
        }

        for(Album album : Library.getInstance().getAlbumList()){
            fileWriter.write(album.getProducerName() + " ");
            fileWriter.write(album.getPagesAmount() + "\n");
        }

        fileWriter.close();
    }

    @Override
    public void remove(Album entity) throws RepositoryException {

        checkNull(entity);
        Library.getInstance().getAlbumList().remove(entity);
    }

    public List<Album> find(Specification specification) throws RepositoryException {
        List<Album> result = new ArrayList<Album>();

        checkNull(specification);

        for (int i = 0; i < Library.getInstance().getAlbumList().size(); i++) {
            if (specification.match(Library.getInstance().getAlbumList().get(i))) {
                result.add(Library.getInstance().getAlbumList().get(i));
            }
        }
        return result;
    }

    @Override
    public void removeAll(Specification specification) throws RepositoryException {

        checkNull(specification);

        for(int i = 0; i < Library.getInstance().getAlbumList().size(); i++){
            if(specification.match(Library.getInstance().getAlbumList().get(i))){
                Library.getInstance().getAlbumList().remove(i);
                i--;
            }
        }
    }

    @Override
    public void add(Album entity) throws RepositoryException {

        checkNull(entity);

        Library.getInstance().getAlbumList().add(entity);
    }

    private static void checkNull (Object obj) throws RepositoryException {

        if (obj == null) {
            logger.error("Was get null as parameter");
            throw new RepositoryException();
        }
    }
}