package com.dxctraining.consoleapp.ui;


import com.dxctraining.consoleapp.entities.Author;
import com.dxctraining.consoleapp.entities.Book;
import com.dxctraining.consoleapp.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BookUi {
    @Autowired
    private IBookService service;


    @PostConstruct
    public void runUi() {
        try {
        	Author author1=new Author("prathyusha");
        	Author author2=new Author("priya");
            Book book1 = new Book("java", 543.21,author1);
            Book book2 = new Book("c", 533.21,author2);
    
           service.add(book1);
            service.add(book2);

            int id1 = book1.getId();
            Book fetched1 = service.findById(id1);
            System.out.println("fetcehd book =" + fetched1.getName() + " " + fetched1.getCost() + " " + fetched1.getAuthor());

         
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
