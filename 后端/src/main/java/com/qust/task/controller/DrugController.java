package com.qust.task.controller;

import com.github.pagehelper.PageInfo;
import com.qust.task.model.DrugModel;
import com.qust.task.param.DrugParam;
import com.qust.task.service.DrugService;
import com.qust.task.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Date;

@Api(tags = "药品控制器类")
@RestController
@CrossOrigin
@RequestMapping("/api/drugs")
public class DrugController {
    @Autowired
    DrugService drugService;
    /**
     * 药品信息的分页查询,name不为空则模糊查询
     * @param pn
     * @param size
     * @param name
     * @return
     */
    @GetMapping("/{pn}/{size}")
    public Msg getDrugWithPage(@PathVariable("pn") int pn, @PathVariable("size") int size, @RequestParam(required = false) String name) {
        PageInfo<DrugModel> info = drugService.getDrugWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("drugPageInfo",info);
        }
        return Msg.fail();

    }
    /**
     * 新增药品信息
     * @param drugParam
     * @return
     */
    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg saveDrug(@RequestBody DrugParam drugParam) {
        drugParam.setCreatetime(new Date());
        drugParam.setUpdatetime(new Date());
        Msg msg = drugService.saveDrug(drugParam);
        return msg;

    }
    /**
     * 更新药品信息
     * @param drugParam
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateDrug(@PathVariable("id") Long id, @RequestBody DrugParam drugParam) {
        return drugService.updateDrug(id,drugParam);

    }

    /**
     * 根据id删除药品信息以及药品-药店关联表的信息
     * @param drugId
     * @return
     */
    @RolesAllowed({"1"})
    @DeleteMapping(value = "/{drugId}")
    public Msg deleteDrug(@PathVariable("drugId") Long drugId) {
        return drugService.deleteDrug(drugId);

    }
}
