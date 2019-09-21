package com.czn.fcpms.web;

import com.czn.fcpms.common.ResultUtil;
import com.czn.fcpms.entity.Region;
import com.czn.fcpms.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping(value = "/provinceList")
    private Map<String, Object> provinceList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Region> list = regionService.provinceList();

        modelMap.put("result", ResultUtil.success(list));
        return modelMap;
    }

    @GetMapping(value = "/regionListById/{parentId}")
    private Map<String, Object> regionListById(@PathVariable("parentId") Integer parentId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Region> list = regionService.regionListById(parentId);

        System.out.print(parentId);

        modelMap.put("result", ResultUtil.success(list));
        return modelMap;
    }
}
