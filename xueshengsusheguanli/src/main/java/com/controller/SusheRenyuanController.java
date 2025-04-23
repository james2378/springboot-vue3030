
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 宿舍人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/susheRenyuan")
public class SusheRenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(SusheRenyuanController.class);

    @Autowired
    private SusheRenyuanService susheRenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private SusheService susheService;
    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private SuguanService suguanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("宿管".equals(role)){
            SuguanEntity suguanEntity = suguanService.selectById(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            params.put("louyuTypes",suguanEntity.getLouyuTypes());
            params.put("suguanId",request.getSession().getAttribute("userId"));
        }
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = susheRenyuanService.queryPage(params);

        //字典表数据转换
        List<SusheRenyuanView> list =(List<SusheRenyuanView>)page.getList();
        for(SusheRenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SusheRenyuanEntity susheRenyuan = susheRenyuanService.selectById(id);
        if(susheRenyuan !=null){
            //entity转view
            SusheRenyuanView view = new SusheRenyuanView();
            BeanUtils.copyProperties( susheRenyuan , view );//把实体数据重构到view中

                //级联表
                SusheEntity sushe = susheService.selectById(susheRenyuan.getSusheId());
                if(sushe != null){
                    BeanUtils.copyProperties( sushe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSusheId(sushe.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(susheRenyuan.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SusheRenyuanEntity susheRenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,susheRenyuan:{}",this.getClass().getName(),susheRenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            susheRenyuan.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SusheRenyuanEntity> queryWrapper = new EntityWrapper<SusheRenyuanEntity>()
            .eq("xuesheng_id", susheRenyuan.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SusheRenyuanEntity susheRenyuanEntity = susheRenyuanService.selectOne(queryWrapper);
        if(susheRenyuanEntity==null){

            SusheEntity susheEntity = susheService.selectById(susheRenyuan.getSusheId());
            if(susheEntity == null){
                return R.error("查不到宿舍");
            }
            List<SusheRenyuanEntity> susheRenyuanEntities = susheRenyuanService.selectList(new EntityWrapper<SusheRenyuanEntity>().eq("sushe_id", susheRenyuan.getSusheId()));
            if(susheRenyuanEntities.size()>=susheEntity.getKezhuNumber()){
                return R.error("当前宿舍已经住满了");
            }
            susheEntity.setYizhuNumber(susheRenyuanEntities.size()+1);
            susheService.updateById(susheEntity);

            susheRenyuan.setInsertTime(new Date());
            susheRenyuan.setCreateTime(new Date());
            susheRenyuanService.insert(susheRenyuan);
            return R.ok();
        }else {
            return R.error(511,"该学生已经绑定过宿舍了");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SusheRenyuanEntity susheRenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,susheRenyuan:{}",this.getClass().getName(),susheRenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            susheRenyuan.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<SusheRenyuanEntity> queryWrapper = new EntityWrapper<SusheRenyuanEntity>()
            .notIn("id",susheRenyuan.getId())
            .andNew()
            .eq("xuesheng_id", susheRenyuan.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SusheRenyuanEntity susheRenyuanEntity = susheRenyuanService.selectOne(queryWrapper);
        if(susheRenyuanEntity==null){
            susheRenyuanService.updateById(susheRenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该学生已经绑定过宿舍了");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());

        SusheRenyuanEntity susheRenyuan = susheRenyuanService.selectById(Arrays.asList(ids).get(0));

        SusheEntity susheEntity = susheService.selectById(susheRenyuan.getSusheId());
        if(susheEntity == null){
            return R.error("查不到宿舍");
        }
        List<SusheRenyuanEntity> susheRenyuanEntities = susheRenyuanService.selectList(new EntityWrapper<SusheRenyuanEntity>().eq("sushe_id", susheRenyuan.getSusheId()));

        susheEntity.setYizhuNumber(susheRenyuanEntities.size()-1);
        susheService.updateById(susheEntity);
        susheRenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<SusheRenyuanEntity> susheRenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SusheRenyuanEntity susheRenyuanEntity = new SusheRenyuanEntity();
//                            susheRenyuanEntity.setSusheId(Integer.valueOf(data.get(0)));   //宿舍 要改的
//                            susheRenyuanEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            susheRenyuanEntity.setRuzhuTime(sdf.parse(data.get(0)));          //入住时间 要改的
//                            susheRenyuanEntity.setInsertTime(date);//时间
//                            susheRenyuanEntity.setCreateTime(date);//时间
                            susheRenyuanList.add(susheRenyuanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        susheRenyuanService.insertBatch(susheRenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
