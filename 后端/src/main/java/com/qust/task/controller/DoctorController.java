package com.qust.task.controller;

import com.qust.task.param.DoctorParam;
import com.qust.task.service.DoctorService;
import com.qust.task.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "医师控制器类")
@RestController
@RequestMapping("/api/doctors")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RolesAllowed({"1", "2"})
    @GetMapping(value = "")
    public Msg getDoctorWithPage(DoctorParam param) {
        return doctorService.getDoctorWithPage(param);
    }

    @RolesAllowed({"1", "2"})
    @GetMapping("/info")
    public Msg getLevelAndType() {
        return doctorService.getLevelAndType();
    }

    @RolesAllowed({"1", "2"})
    @PostMapping(value = "")
    public Msg saveDoctor(@RequestBody @Validated DoctorParam param) {
        return doctorService.saveDoctor(param);
    }

    @RolesAllowed({"1"})
    @PutMapping("/{id}")
    public Msg updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorParam param) {
        return doctorService.updateDoctor(id, param);
    }

    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteDoctor(@PathVariable("id") Long id) {

        return doctorService.deleteDoctorById(id);
    }

    @RolesAllowed({"1"})
    @PutMapping("/reset/{id}")
    public Msg resetPwd(@PathVariable Long id) {
        return doctorService.resetPwd(id);
    }
}