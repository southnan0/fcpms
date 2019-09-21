package com.czn.fcpms.service.impl;

import com.czn.fcpms.dao.RegionDao;
import com.czn.fcpms.entity.Region;
import com.czn.fcpms.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionDao regionDao;

    @Override
    public List<Region> provinceList(){
        return regionDao.provinceList();
    }

    @Override
    public List<Region> regionListById(Integer parentId){return regionDao.regionListById(parentId);}

    @Override
    public Region region(Integer regionId){return  regionDao.region(regionId);}
}
