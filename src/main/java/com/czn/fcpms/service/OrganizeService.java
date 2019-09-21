package com.czn.fcpms.service;

import com.czn.fcpms.entity.Organize;

import java.util.List;

public interface OrganizeService {
    /**
     * 组织列表
     * @return
     */
    List<Organize> organizeList();
    /**
     * 新增组织
     * @param organize
     * @return
     */
    Integer addOrganize(Organize organize);

    /**
     * 修改组织
     * @param organize
     * @return
     */
    Integer editOrganize(Organize organize);
    /**
     * 禁用组织
     * @param orgId
     * @return
     */
    Integer disableOrganize(Integer orgId);

    /**
     * 启用组织
     * @param orgId
     * @return
     */
    Integer enableOrganize(Integer orgId);

    /**
     * 根据id查询组织
     * @param orgId
     * @return
     */
    Organize organize(Integer orgId);
}
