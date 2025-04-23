package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 访客
 *
 * @author 
 * @email
 */
@TableName("fangke")
public class FangkeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangkeEntity() {

	}

	public FangkeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 宿舍
     */
    @TableField(value = "sushe_id")

    private Integer susheId;


    /**
     * 宿管
     */
    @TableField(value = "suguan_id")

    private Integer suguanId;


    /**
     * 访客姓名
     */
    @TableField(value = "fangke_name")

    private String fangkeName;


    /**
     * 访客手机号
     */
    @TableField(value = "fangke_phone")

    private String fangkePhone;


    /**
     * 访客身份证号
     */
    @TableField(value = "fangke_id_number")

    private String fangkeIdNumber;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 健康码
     */
    @TableField(value = "fangke_photo")

    private String fangkePhoto;


    /**
     * 来访事由
     */
    @TableField(value = "fangke_content")

    private String fangkeContent;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：宿舍
	 */
    public Integer getSusheId() {
        return susheId;
    }
    /**
	 * 获取：宿舍
	 */

    public void setSusheId(Integer susheId) {
        this.susheId = susheId;
    }
    /**
	 * 设置：宿管
	 */
    public Integer getSuguanId() {
        return suguanId;
    }
    /**
	 * 获取：宿管
	 */

    public void setSuguanId(Integer suguanId) {
        this.suguanId = suguanId;
    }
    /**
	 * 设置：访客姓名
	 */
    public String getFangkeName() {
        return fangkeName;
    }
    /**
	 * 获取：访客姓名
	 */

    public void setFangkeName(String fangkeName) {
        this.fangkeName = fangkeName;
    }
    /**
	 * 设置：访客手机号
	 */
    public String getFangkePhone() {
        return fangkePhone;
    }
    /**
	 * 获取：访客手机号
	 */

    public void setFangkePhone(String fangkePhone) {
        this.fangkePhone = fangkePhone;
    }
    /**
	 * 设置：访客身份证号
	 */
    public String getFangkeIdNumber() {
        return fangkeIdNumber;
    }
    /**
	 * 获取：访客身份证号
	 */

    public void setFangkeIdNumber(String fangkeIdNumber) {
        this.fangkeIdNumber = fangkeIdNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：健康码
	 */
    public String getFangkePhoto() {
        return fangkePhoto;
    }
    /**
	 * 获取：健康码
	 */

    public void setFangkePhoto(String fangkePhoto) {
        this.fangkePhoto = fangkePhoto;
    }
    /**
	 * 设置：来访事由
	 */
    public String getFangkeContent() {
        return fangkeContent;
    }
    /**
	 * 获取：来访事由
	 */

    public void setFangkeContent(String fangkeContent) {
        this.fangkeContent = fangkeContent;
    }
    /**
	 * 设置：来访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：来访时间
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

    @Override
    public String toString() {
        return "Fangke{" +
            "id=" + id +
            ", susheId=" + susheId +
            ", suguanId=" + suguanId +
            ", fangkeName=" + fangkeName +
            ", fangkePhone=" + fangkePhone +
            ", fangkeIdNumber=" + fangkeIdNumber +
            ", sexTypes=" + sexTypes +
            ", fangkePhoto=" + fangkePhoto +
            ", fangkeContent=" + fangkeContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
