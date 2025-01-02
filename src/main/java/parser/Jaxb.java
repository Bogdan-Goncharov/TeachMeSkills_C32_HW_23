package parser;

import exception.ParserException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Book;
import model.Root;

import java.io.File;
import java.util.List;

public class Jaxb {
    public static void collectionToXml(List<Book> books) throws ParserException, JAXBException {
        try {

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);

                Root rootToXml = new Root();
                rootToXml.setBooks(books);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                jaxbMarshaller.marshal(rootToXml, new File("books.xml"));
            } catch (JAXBException e) {
                throw new ParserException("Error: " + e.getMessage());
            }
        } catch (ParserException e) {
            throw new RuntimeException(e);
        }
    }
}
