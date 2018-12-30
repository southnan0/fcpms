package com.czn.fcpms.web;

import com.czn.fcpms.entity.Organize;
import com.czn.fcpms.service.OrganizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/organize")
public class OrganizeController {
    @Autowired
    private OrganizeService organizeService;

    private Logger logger = LoggerFactory.getLogger(Main.class);

    @GetMapping(value="/organizeList")
    @CrossOrigin("http://localhost:4200")
    private Map<String,Object> organizeList(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Organize> list = organizeService.organizeList();

        logger.info("list===>",list);
//        modelMap.put("organizeList",list);
//        return modelMap;
        return null;
    }
}
