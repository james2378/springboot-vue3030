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
 * 宿管
 *
 * @author 
 * @email
 */
@TableName("suguan")
public class SuguanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SuguanEntity() {

	}

	public SuguanEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 宿管姓名
     */
    @TableField(value = "suguan_name")

    private String suguanName;


    /**
     * 宿管手机号
     */
    @TableField(value = "suguan_phone")

    private String suguanPhone;


    /**
     * 宿管头像
     */
    @TableField(value = "suguan_photo")

    private String suguanPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 楼宇
     */
    @TableField(value = "louyu_types")

    private Integer louyuTypes;


    /**
     * 电子邮箱
     */
    @TableField(value = "suguan_email")

    private String suguanEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：宿管姓名
	 */
    public String getSuguanName() {
        return suguanName;
    }
    /**
	 * 获取：宿管姓名
	 */

    public void setSuguanName(String suguanName) {
        this.suguanName = suguanName;
    }
    /**
	 * 设置：宿管手机号
	 */
    public String getSuguanPhone() {
        return suguanPhone;
    }
    /**
	 * 获取：宿管手机号
	 */

    public void setSuguanPhone(String suguanPhone) {
        this.suguanPhone = suguanPhone;
    }
    /**
	 * 设置：宿管头像
	 */
    public String getSuguanPhoto() {
        return suguanPhoto;
    }
    /**
	 * 获取：宿管头像
	 */

    public void setSuguanPhoto(String suguanPhoto) {
        this.suguanPhoto = suguanPhoto;
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
	 * 设置：电子邮箱
	 */
    public String getSuguanEmail() {
        return suguanEmail;
    }
    /**
	 * 获取：电子邮箱
	 */

    public void setSuguanEmail(String suguanEmail) {
        this.suguanEmail = suguanEmail;
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
        return "Suguan{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", suguanName=" + suguanName +
            ", suguanPhone=" + suguanPhone +
            ", suguanPhoto=" + suguanPhoto +
            ", sexTypes=" + sexTypes +
            ", louyuTypes=" + louyuTypes +
            ", suguanEmail=" + suguanEmail +
            ", createTime=" + createTime +
        "}";
    }
}
