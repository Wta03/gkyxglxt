package com.qust.task.service;

import com.qust.task.domain.Permission;
import com.qust.task.mapper.PermissionMapper;
import com.qust.task.model.PermissionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    public List<PermissionModel> getAllPermission(String roleName) {
        String finalRoleName = "ROLE_"+roleName;
        List<PermissionModel> allPermission = permissionMapper.getPermission(finalRoleName.trim());
        PermissionModel fatherPermisson = new PermissionModel();
        List<PermissionModel> finalPermisson = new ArrayList<>();
        for (PermissionModel per:allPermission) {
            if (per.getPid() == 0) {
                finalPermisson.add(selectChildren(per, allPermission,finalRoleName));
            }
        }
        return finalPermisson;
    }
    /**
     * 为父节点添加children
     * @param father
     * @param allPermission
     * @return
     */
    public PermissionModel selectChildren(PermissionModel father, List<PermissionModel> allPermission,String finalRoleName) {
        List<Permission> list = new ArrayList<>();
        allPermission.forEach(item -> {
            if (!finalRoleName.equals("ROLE_1")) {
                String title = item.getMeta().getTitle().replace("管理", "查询");
                item.getMeta().setTitle(title);
            }
            if (father.getId() == item.getPid()) {
                father.setChildren(list);
                father.getChildren().add(selectChildren(item, allPermission,finalRoleName));
            }
        });
        return father;

    }
}
