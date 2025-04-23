package com.entity.model;

import com.entity.SusheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宿舍
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SusheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 唯一编号
     */
    private String susheNumberUuid;


    /**
     * 楼宇
     */
    private Integer louyuTypes;


    /**
     * 宿舍号
     */
    private String susheName;


    /**
     * 宿舍楼层
     */
    private String susheLouceng;


    /**
     * 宿舍位置
     */
    private String susheAddress;


    /**
     * 可住人数
     */
    private Integer kezhuNumber;


    /**
     * 已住人数
     */
    private Integer yizhuNumber;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：唯一编号
	 */
    public String getSusheNumberUuid() {
        return susheNumberUuid;
    }


    /**
	 * 设置：唯一编号
	 */
    public void setSusheNumberUuid(String susheNumberUuid) {
        this.susheNumberUuid = susheNumberUuid;
    }
    /**
	 * 获取：楼宇
	 */
    public Integer getLouyuTypes() {
        return louyuTypes;
    }


    /**
	 * 设置：楼宇
	 */
    public void setLouyuTypes(Integer louyuTypes) {
        this.louyuTypes = louyuTypes;
    }
    /**
	 * 获取：宿舍号
	 */
    public String getSusheName() {
        return susheName;
    }


    /**
	 * 设置：宿舍号
	 */
    public void setSusheName(String susheName) {
        this.susheName = susheName;
    }
    /**
	 * 获取：宿舍楼层
	 */
    public String getSusheLouceng() {
        return susheLouceng;
    }


    /**
	 * 设置：宿舍楼层
	 */
    public void setSusheLouceng(String susheLouceng) {
        this.susheLouceng = susheLouceng;
    }
    /**
	 * 获取：宿舍位置
	 */
    public String getSusheAddress() {
        return susheAddress;
    }


    /**
	 * 设置：宿舍位置
	 */
    public void setSusheAddress(String susheAddress) {
        this.susheAddress = susheAddress;
    }
    /**
	 * 获取：可住人数
	 */
    public Integer getKezhuNumber() {
        return kezhuNumber;
    }


    /**
	 * 设置：可住人数
	 */
    public void setKezhuNumber(Integer kezhuNumber) {
        this.kezhuNumber = kezhuNumber;
    }
    /**
	 * 获取：已住人数
	 */
    public Integer getYizhuNumber() {
        return yizhuNumber;
    }


    /**
	 * 设置：已住人数
	 */
    public void setYizhuNumber(Integer yizhuNumber) {
        this.yizhuNumber = yizhuNumber;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
