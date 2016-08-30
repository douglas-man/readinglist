package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dman on 8/26/16.
 */
@Controller
@RequestMapping("/readingList")
//@ConfigurationProperties(prefix="amazon")
public class ReadingListController {

    private static final String reader = "craig";
//    private String associateId;

    private ReadingListRepository readingListRepository;
//    private AmazonProperties amazonProperties;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }
//    public ReadingListController(
//            ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
//        this.readingListRepository = readingListRepository;
//        this.amazonProperties = amazonProperties;
//    }

//    public void setAssociateId(String associateId) {
//        this.associateId = associateId;
//    }

    //    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }
//    public String readersBooks(
//            @PathVariable("reader") String reader,
//            Model model) {
//        List<Book> readingList =
//                readingListRepository.findByReader(reader);
//        if (readingList != null) {
//            model.addAttribute("books", readingList);
//            model.addAttribute("reader", reader);
//            model.addAttribute("amazonID", amazonProperties.getAssociateId());
//        }
//        return "readingList";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList";
    }
//    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
//    public String addToReadingList(
//            @PathVariable("reader") String reader, Book book) {
//        book.setReader(reader);
//        readingListRepository.save(book);
//        return "redirect:/{reader}";
//    }
}
