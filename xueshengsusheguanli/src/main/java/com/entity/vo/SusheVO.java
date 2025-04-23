package com.entity.vo;

import com.entity.SusheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宿舍
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("sushe")
public class SusheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 唯一编号
     */

    @TableField(value = "sushe_number_uuid")
    private String susheNumberUuid;


    /**
     * 楼宇
     */

    @TableField(value = "louyu_types")
    private Integer louyuTypes;


    /**
     * 宿舍号
     */

    @TableField(value = "sushe_name")
    private String susheName;


    /**
     * 宿舍楼层
     */

    @TableField(value = "sushe_louceng")
    private String susheLouceng;


    /**
     * 宿舍位置
     */

    @TableField(value = "sushe_address")
    private String susheAddress;


    /**
     * 可住人数
     */

    @TableField(value = "kezhu_number")
    private Integer kezhuNumber;


    /**
     * 已住人数
     */

    @TableField(value = "yizhu_number")
    private Integer yizhuNumber;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：唯一编号
	 */
    public String getSusheNumberUuid() {
        return susheNumberUuid;
    }


    /**
	 * 获取：唯一编号
	 */

    public void setSusheNumberUuid(String susheNumberUuid) {
        this.susheNumberUuid = susheNumberUuid;
    }
    /**
	 * 设置：楼宇
	 */
    public Integer getLouyuTypes() {
        return louyuTypes;
    }


    /**
	 * 获取：楼宇
	 */

    public void setLouyuTypes(Integer louyuTypes) {
        this.louyuTypes = louyuTypes;
    }
    /**
	 * 设置：宿舍号
	 */
    public String getSusheName() {
        return susheName;
    }


    /**
	 * 获取：宿舍号
	 */

    public void setSusheName(String susheName) {
        this.susheName = susheName;
    }
    /**
	 * 设置：宿舍楼层
	 */
    public String getSusheLouceng() {
        return susheLouceng;
    }


    /**
	 * 获取：宿舍楼层
	 */

    public void setSusheLouceng(String susheLouceng) {
        this.susheLouceng = susheLouceng;
    }
    /**
	 * 设置：宿舍位置
	 */
    public String getSusheAddress() {
        return susheAddress;
    }


    /**
	 * 获取：宿舍位置
	 */

    public void setSusheAddress(String susheAddress) {
        this.susheAddress = susheAddress;
    }
    /**
	 * 设置：可住人数
	 */
    public Integer getKezhuNumber() {
        return kezhuNumber;
    }


    /**
	 * 获取：可住人数
	 */

    public void setKezhuNumber(Integer kezhuNumber) {
        this.kezhuNumber = kezhuNumber;
    }
    /**
	 * 设置：已住人数
	 */
    public Integer getYizhuNumber() {
        return yizhuNumber;
    }


    /**
	 * 获取：已住人数
	 */

    public void setYizhuNumber(Integer yizhuNumber) {
        this.yizhuNumber = yizhuNumber;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
