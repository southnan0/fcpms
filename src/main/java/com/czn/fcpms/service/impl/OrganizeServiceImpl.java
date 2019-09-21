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

    @Override
    public Integer addOrganize(Organize organize){return organizeDao.addOrganize(organize);}

    @Override
    public Integer editOrganize(Organize organize){return organizeDao.editOrganize(organize);}

    @Override
    public Integer disableOrganize(Integer orgId){return organizeDao.disableOrganize(orgId);}

    @Override
    public Integer enableOrganize(Integer orgId){return organizeDao.enableOrganize(orgId);}

    @Override
    public Organize organize(Integer orgId){return organizeDao.organize(orgId);}
}
