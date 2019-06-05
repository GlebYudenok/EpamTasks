package by.javatr.yudenok.repository.impl;

import by.javatr.yudenok.bean.Author;
import by.javatr.yudenok.bean.Library;
import by.javatr.yudenok.bean.Magazine;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.RepositoryException;
import by.javatr.yudenok.parser.MagazineParser;
import by.javatr.yudenok.repository.Repository;
import by.javatr.yudenok.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MagazineRepository implements Repository<Magazine> {

    private static final Logger logger = LogManager.getLogger(MagazineRepository.class);

    private static final File filePath = new File("src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "MagazineList.txt");


    public File getPath() {
        return filePath;
    }

    public void read() throws IOException, ParserException{
        MagazineParser.parse(getPath());
    }

    public void update() throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(getPath());
        }catch (IOException e){
            throw new IOException();
        }

        for (Magazine magazine :
                Library.getInstance().getMagazineList()) {
            Author author = magazine.getAuthor();
            fileWriter.write(author.getName() + " ");
            fileWriter.write(author.getSurname() + " ");
            fileWriter.write(magazine.getTitle() + " ");
            fileWriter.write(magazine.getPublishingHouseName() + " ");
            fileWriter.write(magazine.getPagesAmount() + "\n");
        }

        fileWriter.close();
    }

    @Override
    public void remove(Magazine entity) throws RepositoryException {
        checkNull(entity);

        Library.getInstance().getMagazineList().remove(entity);
    }

    public List<Magazine> find(Specification specification) throws RepositoryException {

        checkNull(specification);

        List<Magazine> result = new ArrayList<Magazine>();

        for (int i = 0; i < Library.getInstance().getMagazineList().size(); i++) {
            if (specification.match(Library.getInstance().getMagazineList().get(i))) {
                result.add(Library.getInstance().getMagazineList().get(i));
            }
        }
        return result;
    }

    @Override
    public void removeAll(Specification specification) throws RepositoryException {

        checkNull(specification);

        for(int i = 0; i < Library.getInstance().getMagazineList().size(); i++){
            if(specification.match(Library.getInstance().getMagazineList().get(i))){
                Library.getInstance().getMagazineList().remove(i);
                i--;
            }
        }
    }

    @Override
    public void add(Magazine entity) throws RepositoryException {

        checkNull(entity);

        Library.getInstance().getMagazineList().add(entity);
    }

    private static void checkNull (Object obj) throws RepositoryException {

        if (obj == null) {
            logger.error("Was get null as parameter");
            throw new RepositoryException();
        }
    }
}
