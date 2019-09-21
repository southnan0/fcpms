package com.czn.fcpms.dao;

import com.czn.fcpms.entity.Region;

import java.util.List;

public interface RegionDao {
    List<Region> provinceList();
    List<Region> regionListById(Integer parentId);
    Region region(Integer regionId);
}
