package com.czn.fcpms.service;

import com.czn.fcpms.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> provinceList();

    List<Region> regionListById(Integer parentId);

    Region region(Integer regionId);
}
