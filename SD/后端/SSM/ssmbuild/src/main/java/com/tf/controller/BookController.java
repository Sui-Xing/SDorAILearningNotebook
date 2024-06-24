package com.tf.controller;

import com.tf.pojo.Books;
import com.tf.service.BookService;
import com.tf.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/sab")
    public String selectAllBooks(Model model){


        List<Books> books = bookService.queryAllBook();
        model.addAttribute("books",books);
        return "sab";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model){
        System.out.println();
        return "addbook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/sab";
    }

    @GetMapping("/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable int id,Model model){
        Books books = bookService.queryBookById(id);


        model.addAttribute("book",books);
        return "updatebook";
    }


    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("/updateBook  books="+books);
        int i = bookService.updateBook(books);
        System.out.println("/updateBook  i="+i);

        return "redirect:/book/sab";
    }


    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        int i = bookService.deleteBookById(id);

        return "redirect:/book/sab";

    }

    @RequestMapping("/queryBookByName")
    public String queryBookByName(String bookname,Model model){

        List<Books> books = bookService.queryBookByName(bookname);
        System.out.println(books);
        if(books.isEmpty()){
            model.addAttribute("error","未找到");
        }
        model.addAttribute("books",books);
        return "sab";
    }
}
