package cn.edu.nju.controller;

import cn.edu.nju.service.CommentService;
import cn.edu.nju.service.SearchService;
import cn.edu.nju.utility.Comment;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class SearchController {

    private final
    SearchService searchService;

    private final
    CommentService commentService;

    @Autowired
    public SearchController(SearchService searchService, CommentService commentService) {
        this.searchService = searchService;
        this.commentService = commentService;
    }

    @RequestMapping("/search")
    public List<GoodInfo> search(@RequestParam String key){
        System.out.println("key:"+key);
        if(StringUtils.isEmpty(key)){
            return new ArrayList<>();
        }

        return searchService.search(key);

    }

    @RequestMapping("/searchInTitle")
    public List<GoodInfo> searchInTitle(@RequestParam String key){

        if(StringUtils.isEmpty(key)){
            return new ArrayList<>();
        }

        return searchService.searchInTitle(key);

    }

    @RequestMapping("/searchInDescription")
    public List<GoodInfo> searchInDescription(@RequestParam String key){

        if(StringUtils.isEmpty(key)){
            return new ArrayList<>();
        }

        return searchService.searchInDescription(key);

    }





}
