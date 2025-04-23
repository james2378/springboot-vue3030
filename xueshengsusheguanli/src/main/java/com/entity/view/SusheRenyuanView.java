package com.entity.view;

import com.entity.SusheRenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宿舍人员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("sushe_renyuan")
public class SusheRenyuanView extends SusheRenyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 sushe
			/**
			* 唯一编号
			*/
			private String susheNumberUuid;
			/**
			* 楼宇
			*/
			private Integer louyuTypes;
				/**
				* 楼宇的值
				*/
				private String louyuValue;
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

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

	public SusheRenyuanView() {

	}

	public SusheRenyuanView(SusheRenyuanEntity susheRenyuanEntity) {
		try {
			BeanUtils.copyProperties(this, susheRenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















				//级联表的get和set sushe

					/**
					* 获取： 唯一编号
					*/
					public String getSusheNumberUuid() {
						return susheNumberUuid;
					}
					/**
					* 设置： 唯一编号
					*/
					public void setSusheNumberUuid(String susheNumberUuid) {
						this.susheNumberUuid = susheNumberUuid;
					}

					/**
					* 获取： 楼宇
					*/
					public Integer getLouyuTypes() {
						return louyuTypes;
					}
					/**
					* 设置： 楼宇
					*/
					public void setLouyuTypes(Integer louyuTypes) {
						this.louyuTypes = louyuTypes;
					}


						/**
						* 获取： 楼宇的值
						*/
						public String getLouyuValue() {
							return louyuValue;
						}
						/**
						* 设置： 楼宇的值
						*/
						public void setLouyuValue(String louyuValue) {
							this.louyuValue = louyuValue;
						}

					/**
					* 获取： 宿舍号
					*/
					public String getSusheName() {
						return susheName;
					}
					/**
					* 设置： 宿舍号
					*/
					public void setSusheName(String susheName) {
						this.susheName = susheName;
					}

					/**
					* 获取： 宿舍楼层
					*/
					public String getSusheLouceng() {
						return susheLouceng;
					}
					/**
					* 设置： 宿舍楼层
					*/
					public void setSusheLouceng(String susheLouceng) {
						this.susheLouceng = susheLouceng;
					}

					/**
					* 获取： 宿舍位置
					*/
					public String getSusheAddress() {
						return susheAddress;
					}
					/**
					* 设置： 宿舍位置
					*/
					public void setSusheAddress(String susheAddress) {
						this.susheAddress = susheAddress;
					}

					/**
					* 获取： 可住人数
					*/
					public Integer getKezhuNumber() {
						return kezhuNumber;
					}
					/**
					* 设置： 可住人数
					*/
					public void setKezhuNumber(Integer kezhuNumber) {
						this.kezhuNumber = kezhuNumber;
					}

					/**
					* 获取： 已住人数
					*/
					public Integer getYizhuNumber() {
						return yizhuNumber;
					}
					/**
					* 设置： 已住人数
					*/
					public void setYizhuNumber(Integer yizhuNumber) {
						this.yizhuNumber = yizhuNumber;
					}







				//级联表的get和set xuesheng

					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}






}
