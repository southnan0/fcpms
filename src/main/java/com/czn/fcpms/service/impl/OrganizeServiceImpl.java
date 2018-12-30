package com.czn.fcpms.service.impl;

import com.czn.fcpms.dao.OrganizeDao;
import com.czn.fcpms.entity.Organize;
import com.czn.fcpms.service.OrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizeServiceImpl implements OrganizeService {
    @Autowired
    private OrganizeDao organizeDao;

    @Override
    public List<Organize> organizeList(){
        return organizeDao.organizeList();
    }
}
