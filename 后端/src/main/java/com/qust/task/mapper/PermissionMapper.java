package com.qust.task.mapper;

import com.qust.task.model.PermissionModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionMapper {
    List<PermissionModel> getPermission(String roleName);
}
