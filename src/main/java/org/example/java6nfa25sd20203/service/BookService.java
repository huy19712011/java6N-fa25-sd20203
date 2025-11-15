package org.example.java6nfa25sd20203.service;

import org.example.java6nfa25sd20203.dto.BookRequest;
import org.example.java6nfa25sd20203.dto.BookResponse;

import java.util.List;

public interface BookService {

    List<BookResponse> findAll();

    BookResponse findById(long id);

    BookResponse add(BookRequest bookRequest);

    BookResponse update(BookRequest bookRequest, long id);

    //BookResponse delete(long id);
    void delete(long id);
}
