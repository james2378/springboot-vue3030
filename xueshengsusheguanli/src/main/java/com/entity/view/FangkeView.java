package com.entity.view;

import com.entity.FangkeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 访客
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangke")
public class FangkeView extends FangkeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;



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

		//级联表 suguan
			/**
			* 宿管姓名
			*/
			private String suguanName;
			/**
			* 宿管手机号
			*/
			private String suguanPhone;
			/**
			* 宿管头像
			*/
			private String suguanPhoto;
			/**
			* 电子邮箱
			*/
			private String suguanEmail;

	public FangkeView() {

	}

	public FangkeView(FangkeEntity fangkeEntity) {
		try {
			BeanUtils.copyProperties(this, fangkeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
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










				//级联表的get和set suguan

					/**
					* 获取： 宿管姓名
					*/
					public String getSuguanName() {
						return suguanName;
					}
					/**
					* 设置： 宿管姓名
					*/
					public void setSuguanName(String suguanName) {
						this.suguanName = suguanName;
					}

					/**
					* 获取： 宿管手机号
					*/
					public String getSuguanPhone() {
						return suguanPhone;
					}
					/**
					* 设置： 宿管手机号
					*/
					public void setSuguanPhone(String suguanPhone) {
						this.suguanPhone = suguanPhone;
					}

					/**
					* 获取： 宿管头像
					*/
					public String getSuguanPhoto() {
						return suguanPhoto;
					}
					/**
					* 设置： 宿管头像
					*/
					public void setSuguanPhoto(String suguanPhoto) {
						this.suguanPhoto = suguanPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getSuguanEmail() {
						return suguanEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setSuguanEmail(String suguanEmail) {
						this.suguanEmail = suguanEmail;
					}



}
