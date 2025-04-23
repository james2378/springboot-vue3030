
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
 * 宿管
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/suguan")
public class SuguanController {
    private static final Logger logger = LoggerFactory.getLogger(SuguanController.class);

    @Autowired
    private SuguanService suguanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private XueshengService xueshengService;


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
        else if("宿管".equals(role))
            params.put("suguanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = suguanService.queryPage(params);

        //字典表数据转换
        List<SuguanView> list =(List<SuguanView>)page.getList();
        for(SuguanView c:list){
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
        SuguanEntity suguan = suguanService.selectById(id);
        if(suguan !=null){
            //entity转view
            SuguanView view = new SuguanView();
            BeanUtils.copyProperties( suguan , view );//把实体数据重构到view中

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
    public R save(@RequestBody SuguanEntity suguan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,suguan:{}",this.getClass().getName(),suguan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SuguanEntity> queryWrapper = new EntityWrapper<SuguanEntity>()
            .eq("username", suguan.getUsername())
            .or()
            .eq("suguan_phone", suguan.getSuguanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SuguanEntity suguanEntity = suguanService.selectOne(queryWrapper);
        if(suguanEntity==null){
            suguan.setCreateTime(new Date());
            suguan.setPassword("123456");
            suguanService.insert(suguan);
            return R.ok();
        }else {
            return R.error(511,"账户或者宿管手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SuguanEntity suguan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,suguan:{}",this.getClass().getName(),suguan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<SuguanEntity> queryWrapper = new EntityWrapper<SuguanEntity>()
            .notIn("id",suguan.getId())
            .andNew()
            .eq("username", suguan.getUsername())
            .or()
            .eq("suguan_phone", suguan.getSuguanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SuguanEntity suguanEntity = suguanService.selectOne(queryWrapper);
        if("".equals(suguan.getSuguanPhoto()) || "null".equals(suguan.getSuguanPhoto())){
                suguan.setSuguanPhoto(null);
        }
        if(suguanEntity==null){
            suguanService.updateById(suguan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者宿管手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        suguanService.deleteBatchIds(Arrays.asList(ids));
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
            List<SuguanEntity> suguanList = new ArrayList<>();//上传的东西
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
                            SuguanEntity suguanEntity = new SuguanEntity();
//                            suguanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //suguanEntity.setPassword("123456");//密码
//                            suguanEntity.setSuguanName(data.get(0));                    //宿管姓名 要改的
//                            suguanEntity.setSuguanPhone(data.get(0));                    //宿管手机号 要改的
//                            suguanEntity.setSuguanPhoto("");//详情和图片
//                            suguanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            suguanEntity.setLouyuTypes(Integer.valueOf(data.get(0)));   //楼宇 要改的
//                            suguanEntity.setSuguanEmail(data.get(0));                    //电子邮箱 要改的
//                            suguanEntity.setCreateTime(date);//时间
                            suguanList.add(suguanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //宿管手机号
                                if(seachFields.containsKey("suguanPhone")){
                                    List<String> suguanPhone = seachFields.get("suguanPhone");
                                    suguanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> suguanPhone = new ArrayList<>();
                                    suguanPhone.add(data.get(0));//要改的
                                    seachFields.put("suguanPhone",suguanPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<SuguanEntity> suguanEntities_username = suguanService.selectList(new EntityWrapper<SuguanEntity>().in("username", seachFields.get("username")));
                        if(suguanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SuguanEntity s:suguanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //宿管手机号
                        List<SuguanEntity> suguanEntities_suguanPhone = suguanService.selectList(new EntityWrapper<SuguanEntity>().in("suguan_phone", seachFields.get("suguanPhone")));
                        if(suguanEntities_suguanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SuguanEntity s:suguanEntities_suguanPhone){
                                repeatFields.add(s.getSuguanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [宿管手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        suguanService.insertBatch(suguanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        SuguanEntity suguan = suguanService.selectOne(new EntityWrapper<SuguanEntity>().eq("username", username));
        if(suguan==null || !suguan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(suguan.getId(),username, "suguan", "宿管");
        R r = R.ok();
        r.put("token", token);
        r.put("role","宿管");
        r.put("username",suguan.getSuguanName());
        r.put("tableName","suguan");
        r.put("userId",suguan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SuguanEntity suguan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<SuguanEntity> queryWrapper = new EntityWrapper<SuguanEntity>()
            .eq("username", suguan.getUsername())
            .or()
            .eq("suguan_phone", suguan.getSuguanPhone())
            ;
        SuguanEntity suguanEntity = suguanService.selectOne(queryWrapper);
        if(suguanEntity != null)
            return R.error("账户或者宿管手机号已经被使用");
        suguan.setCreateTime(new Date());
        suguanService.insert(suguan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        SuguanEntity suguan = new SuguanEntity();
        suguan.setPassword("123456");
        suguan.setId(id);
        suguanService.updateById(suguan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        SuguanEntity suguan = suguanService.selectOne(new EntityWrapper<SuguanEntity>().eq("username", username));
        if(suguan!=null){
            suguan.setPassword("123456");
            boolean b = suguanService.updateById(suguan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrSuguan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        SuguanEntity suguan = suguanService.selectById(id);
        if(suguan !=null){
            //entity转view
            SuguanView view = new SuguanView();
            BeanUtils.copyProperties( suguan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
