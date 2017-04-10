package cn.edu.nju.controller;

import cn.edu.nju.service.PersistService;
import cn.edu.nju.utility.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    @PostMapping(value = "/persist")
    public String persist(@RequestBody GoodJson goodInfos) {


//        System.out.println(goodInfos);

        persistService.persist(goodInfos.getGoodInfoList());

        return "Success";
    }


}
