package com.qust.task.controller;

import com.qust.task.service.FileUploadService;
import com.qust.task.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;

@Api(tags = "文件上传控制器")
@RestController
@CrossOrigin
@RequestMapping("/api/base/upload")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;
    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg fileUpload(MultipartFile file) {
        Msg msg = fileUploadService.upload(file);
        return msg;
    }
}
