package cn.edu.nju.controller;

import cn.edu.nju.service.CacheService;
import cn.edu.nju.service.CommentService;
import cn.edu.nju.service.SearchService;
import cn.edu.nju.utility.Comment;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    CacheService cacheService;

    private final
    SearchService searchService;

    private final
    CommentService commentService;

    @Autowired
    public SearchController(CacheService cacheService, SearchService searchService, CommentService commentService) {
        this.cacheService = cacheService;
        this.searchService = searchService;
        this.commentService = commentService;
    }

    @RequestMapping("/search")
    @ResponseBody
    @Cacheable(value = "searchCache", keyGenerator = "wiselyKeyGenerator")
    public List<GoodInfo> search(@RequestParam String key){
        System.out.println("key:"+key);
        List<GoodInfo> result = new ArrayList<>();
        if(StringUtils.isEmpty(key)){
            return result;
        }

        result = cacheService.search(key);
        if(!result.isEmpty()){
            return result;
        }

        if("".equals(key)){}


        return searchService.search(key);

    }

    @RequestMapping("/searchInTitle")
    @ResponseBody
    @Cacheable(value = "searchInTitleCache", keyGenerator = "wiselyKeyGenerator")
    public List<GoodInfo> searchInTitle(@RequestParam String key){

        List<GoodInfo> result = new ArrayList<>();
        if(StringUtils.isEmpty(key)){
            return result;
        }

        result = cacheService.search(key);
        if(!result.isEmpty()){
            return result;
        }

        return searchService.searchInTitle(key);
    }

    @RequestMapping("/searchInDescription")
    @ResponseBody
    @Cacheable(value = "searchInDescriptionCache", keyGenerator = "wiselyKeyGenerator")
    public List<GoodInfo> searchInDescription(@RequestParam String key){

        if(StringUtils.isEmpty(key)){
            return new ArrayList<>();
        }


        return searchService.searchInDescription(key);

    }





}
