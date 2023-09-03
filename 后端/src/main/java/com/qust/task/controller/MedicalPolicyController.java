package com.qust.task.controller;

import com.qust.task.param.MedicalPolicyParam;
import com.qust.task.service.MedicalPolicyService;
import com.qust.task.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "医药政策控制器类")
@RestController
@CrossOrigin
@RequestMapping("/api/medical_policys")
public class MedicalPolicyController {
    @Autowired
    MedicalPolicyService medicalPolicyService;

    /**
     * 条件查询医保政策信息
     *
     * @param param
     * @return
     */
    @GetMapping(value = "")
    public Msg getMedicalPolicyWithPage(MedicalPolicyParam param) {
        Msg msg = medicalPolicyService.getMedicalPolicyWithPage(param);
        return msg;

    }

    /**
     * 添加医保信息
     *
     * @param param
     * @return
     */
    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveMedicalPolicy(@RequestBody MedicalPolicyParam param) {
        Msg msg = medicalPolicyService.saveMedicalPolicy(param);
        return msg;

    }

    /**
     * 更新医保信息
     *
     * @param param
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateMedicalPolicy(@PathVariable("id") Long id, @RequestBody MedicalPolicyParam param) {
        if (!StringUtils.hasLength(param.getTitle())) {
            return Msg.fail().mess("标题不能为空");
        }
        if (!StringUtils.hasLength(param.getMessage())) {
            return Msg.fail().mess("内容不能为空");
        }
        if (param.getCityId() == null) {
            return Msg.fail().mess("城市不能为空");
        }
        return medicalPolicyService.updateMedicalPolicy(id, param);

    }
    /**
     * 根据id删除医保政策
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @DeleteMapping("/{id}")
    public Msg deleteMedicalPolicy(@PathVariable("id") Long id) {
        Msg msg = medicalPolicyService.deleteMedicalPolicy(id);
        return msg;

    }
}
