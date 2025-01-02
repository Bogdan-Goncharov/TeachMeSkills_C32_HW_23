import exception.ParserException;
import jakarta.xml.bind.JAXBException;
import model.Book;
import parser.Dom;
import parser.Jackson;
import parser.Jaxb;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        try {
            List<Book> books = Jackson.collectionFromJson();
            Jaxb.collectionToXml(books);
            Dom.parseToXmlAndFindMaxPageBook();
        }
        catch (ParserException e) {
            System.out.println(e.getMessage());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
