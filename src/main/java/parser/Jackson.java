package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exception.ParserException;
import model.Book;


import java.io.File;
import java.io.IOException;

import java.util.List;

public class Jackson {
    public static List<Book> collectionFromJson() throws ParserException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Book> books ;
        try {
            books = mapper.readValue(new File("books.json"), mapper.getTypeFactory()
                    .constructCollectionType(List.class, Book.class));
        } catch (IOException e) {
            throw new ParserException("Error:" + e.getMessage());
        }

        return books;
    }
}
