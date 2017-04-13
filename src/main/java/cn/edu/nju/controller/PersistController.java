package cn.edu.nju.controller;

import cn.edu.nju.controller.json.GoodJson;
import cn.edu.nju.service.PersistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Qiang
 * @since 10/04/2017
 */
@Controller
public class PersistController {

    private final
    PersistService persistService;

    @Autowired
    public PersistController(PersistService persistService) {
        this.persistService = persistService;
    }


    @ResponseBody
    @PostMapping(value = "/persist", consumes = "application/json")
    public String persist(@RequestBody GoodJson goodInfos) {

//        persistService.persist(goodInfos.getGoodInfoList());
        System.out.println(goodInfos);
        return "Success";
    }



}
