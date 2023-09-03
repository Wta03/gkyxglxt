package com.qust.task.mapper;

import com.qust.task.entity.MaterialEntity;
import com.qust.task.model.MaterialModel;
import com.qust.task.param.MaterialParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {
    /*查询所有的材料*/
    List<MaterialModel> getAllMaterial(MaterialParam param);

    /*新增材料*/
    int saveMaterial(MaterialEntity entity);

    /*更新材料*/
    int updateMaterial(MaterialEntity entity);

    /*删除材料*/
    int deleteMaterial(Long id);
}
