package com.bs.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.service.SearchHistorySvc;
import com.bs.vo.ProcRtnVO;

@Controller
public class BookSearchCtrl {
	@Autowired
	private SearchHistorySvc searchHistorySvc;
	
    @RequestMapping(value= {"/searchBookList", "/"})
    public String searchBookList(Model model){
        return "searchBookList";
    }
    @RequestMapping(value="/searchBookList.ajax", method=RequestMethod.POST)
    @ResponseBody
    public String getSearchBookList(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> reqMap){
    	return searchHistorySvc.getSearchBookList(reqMap);
    }
    @RequestMapping(value="/bookDetailInfo" , method = RequestMethod.POST)
    public String bookDetailInfo(Model model, HttpServletRequest request){
    	String title = request.getParameter("title");
    	String contents = request.getParameter("contents");
    	String isbn = request.getParameter("isbn");
    	String price = request.getParameter("price");
    	String authors = request.getParameter("authors");
    	String publisher = request.getParameter("publisher");
    	String sale_price = request.getParameter("sale_price");
    	String translators = request.getParameter("translators");
    	String thumbnail = request.getParameter("thumbnail");
    	String sale_yn = request.getParameter("sale_yn");
    	String status = request.getParameter("status");
    	String category = request.getParameter("category");
    	String url = request.getParameter("url");
    	String datetime = request.getParameter("datetime");
    	
    	model.addAttribute("title", title);
    	model.addAttribute("contents", contents);
    	model.addAttribute("isbn", isbn);
    	model.addAttribute("price", price);
    	model.addAttribute("authors", authors);
    	model.addAttribute("publisher", publisher);
    	model.addAttribute("sale_price", sale_price);
    	model.addAttribute("translators", translators);
    	model.addAttribute("thumbnail", thumbnail);
    	model.addAttribute("sale_yn", sale_yn);
    	model.addAttribute("status", status);
    	model.addAttribute("category", category);
    	model.addAttribute("url", url);
    	model.addAttribute("datetime", datetime);
    	
        return "bookDetailInfo";
    }
}
