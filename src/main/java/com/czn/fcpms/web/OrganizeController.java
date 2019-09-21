package com.czn.fcpms.web;

import com.czn.fcpms.annotation.Authorization;
import com.czn.fcpms.common.ResultUtil;
import com.czn.fcpms.entity.Organize;
import com.czn.fcpms.entity.Region;
import com.czn.fcpms.service.OrganizeService;
import com.czn.fcpms.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/organize")
public class OrganizeController {
    @Autowired
    private OrganizeService organizeService;
    @Autowired
    private RegionService regionService;

    @GetMapping(value="/organizeList")
    @Authorization
    private Map<String,Object> organizeList() {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Organize> list = organizeService.organizeList();

        modelMap.put("result",ResultUtil.success(list));
        System.out.print(list);
        return modelMap;
    }

    @PostMapping(value="/addOrganize")
    private Map<String,Object> addOranize(@RequestBody Organize organize){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        organize.setCreatedTime(new Date().getTime());
        organize.setCreatedBy(0);  //todo:获取当前登录用户id
        Integer result = organizeService.addOrganize(organize);

        modelMap.put("result",ResultUtil.success());
        return modelMap;
    }

    @PostMapping(value="/editOrganize/{orgId}")
    private Map<String,Object> editOranize(@PathVariable("orgId") Integer orgId, @RequestBody Organize organize, @RequestHeader("Authorization") String Authorization){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        organize.setUpdatedBy(0);  //todo:获取当前登录用户id
        organize.setUpdatedTime(new Date().getTime());
        organize.setOrgId(orgId);
        Integer result = organizeService.editOrganize(organize);

        if(result.equals(0)){
            modelMap.put("result",ResultUtil.error(1,"编辑失败"));
        }else {
            modelMap.put("result",ResultUtil.success());
        }
        return modelMap;
    }

    @PutMapping(value="/disableOrganize/{orgId}")
    private Map<String,Object> disableOrganize(@PathVariable("orgId") Integer orgId){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        Integer result = organizeService.disableOrganize(orgId);

        modelMap.put("result",ResultUtil.success());
        return modelMap;
    }

    @PutMapping(value="/enableOrganize/{orgId}")
    private Map<String,Object> enableOrganize(@PathVariable("orgId") Integer orgId){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        Integer result = organizeService.enableOrganize(orgId);

        modelMap.put("result",ResultUtil.success());
        return modelMap;
    }

    @GetMapping(value="/organize/{orgId}")
    private Map<String,Object> organize(@PathVariable("orgId") Integer orgId){
        Map<String,Object> modelMap = new HashMap<String,Object>();

        Organize result = organizeService.organize(orgId);

        Integer regionId = result.getRegionId();

        Region region = regionService.region(regionId);

        String path = region.getPath();

        Integer[] arrPathId;
        String[] arrPathName;
        Integer len;

        if(path.isEmpty()){
            len = 1;
            arrPathId = new Integer[len];
            arrPathName = new String[len];

            arrPathId[0] = regionId;
            arrPathName[0] = region.getRegionName();

            result.setRegionPathName(arrPathName);
            result.setRegionPathId(arrPathId);
        }else {
            String[] arrPath = path.split("_");
            len = arrPath.length+1;
            arrPathId = new Integer[len];
            arrPathName = new String[len];

            for (int i = 0;i<arrPath.length;i++){
                Integer rId = Integer.parseInt(arrPath[i]);
                arrPathName[i] = regionService.region(rId).getRegionName();

                arrPathId[i] = Integer.parseInt(arrPath[i]);
            }

            arrPathId[len-1] = regionId;
            arrPathName[len-1] = region.getRegionName();

            result.setRegionPathId(arrPathId);
            result.setRegionPathName(arrPathName);
        }

        modelMap.put("result",ResultUtil.success(result));
        return modelMap;
    }
}
