package com.dao;

import com.entity.SusheRenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SusheRenyuanView;

/**
 * 宿舍人员 Dao 接口
 *
 * @author 
 */
public interface SusheRenyuanDao extends BaseMapper<SusheRenyuanEntity> {

   List<SusheRenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
