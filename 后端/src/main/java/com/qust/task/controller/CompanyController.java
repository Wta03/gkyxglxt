package com.qust.task.controller;

import com.github.pagehelper.PageInfo;
import com.qust.task.domain.DrugCompany;
import com.qust.task.service.CompanyService;
import com.qust.task.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "医药公司信息控制器")
@RestController

@RequestMapping("/api/companys")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 医药公司信息的分页查询,name不为空则模糊查询
     *
     * @param pn
     * @param size
     * @param name
     * @return
     */
    @GetMapping(value = {"/{pn}/{size}", ""})
    public Msg getCompanyWithPage(@PathVariable(value = "pn", required = false) Integer pn,
                                  @PathVariable(value = "size", required = false) Integer size,
                                  @RequestParam(required = false) String name) {
        PageInfo<DrugCompany> info = companyService.getCompanyWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("pageInfo", info);
        }
        return Msg.fail();
    }

    /**
     * 根据id查询一个医药公司信息
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Msg getCompanyById(@PathVariable("id") Integer id) {
        Msg msg = companyService.getCompanyById(id);
        return msg;
    }

    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveCompany(@RequestBody DrugCompany company) {
        String name = company.getCompanyName();
        String phone = company.getCompanyPhone();

        if (name == null || phone == null || name == "" || phone == "") {
            return Msg.fail().mess("填写信息不完整");
        }
        return companyService.saveCompany(company);
    }

    /**
     * 根据id更新医药公司信息
     *
     * @param company
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateCompanyById(@PathVariable("id") Long id, @RequestBody DrugCompany company) {
        String name = company.getCompanyName();
        String phone = company.getCompanyPhone();
        if (name == null || name == "") {
            return Msg.fail().mess("公司名称不能为空");
        }
        if (phone == null || phone == "") {
            return Msg.fail().mess("公司电话不能为空");
        }
        Msg msg = companyService.updateCompanyById(id, company);
        return msg;
    }

    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteCompanyById(@PathVariable("id") Integer id) {
        Msg msg = companyService.deleteCompanyById(id);
        return msg;
    }
}
