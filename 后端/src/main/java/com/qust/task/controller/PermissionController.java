package com.qust.task.controller;

import com.qust.task.mapper.PermissionMapper;
import com.qust.task.service.PermissionService;
import com.qust.task.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "菜单控制器类")
@RestController
@CrossOrigin
@RequestMapping("/api/permissions")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @GetMapping(value = "")
    public Msg getAllPermission(String roleName) {
        return Msg.success().data("permissions", permissionService.getAllPermission(roleName));

    }
}
