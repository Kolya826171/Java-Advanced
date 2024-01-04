package service;

import java.util.Map;

import domain.Book;
import shared.AbstractCrud;

public interface BookService extends AbstractCrud<Book>{
	public Map<Integer, Book> readAllMap();
}
