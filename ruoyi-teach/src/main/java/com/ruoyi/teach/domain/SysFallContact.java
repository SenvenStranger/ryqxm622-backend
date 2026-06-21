package com.ruoyi.teach.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 报警联系人对象 sys_fall_contact
 *
 * @author ruoyi
 */
@Data
public class SysFallContact implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 联系人ID */
    private Long contactId;

    /** 用户ID(被监护人) */
    private Long userId;

    /** 用户姓名 */
    private String userName;

    /** 联系人姓名 */
    private String contactName;

    /** 关系: family-家属, friend-朋友, doctor-医生, caregiver-护工 */
    private String contactRelation;

    /** 联系电话 */
    private String contactPhone;

    /** 联系邮箱 */
    private String contactEmail;

    /** 是否紧急联系人: 0-否, 1-是 */
    private String isEmergency;

    /** 通知顺序 */
    private Integer notifyOrder;

    /** 是否启用: 0-禁用, 1-启用 */
    private String isEnabled;

    /** 备注 */
    private String remark;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 关系字典文本 */
    private String contactRelationText;
}
