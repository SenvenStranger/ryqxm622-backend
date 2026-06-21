package com.ruoyi.teach.domain;

import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目团队成员对象 sys_project_member
 * 
 * @author ruoyi
 */
public class SysProjectMember extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 成员ID */
    private Long memberId;

    /** 项目ID */
    private Long projectId;

    /** 用户ID */
    private Long userId;

    /** 成员姓名 */
    private String memberName;

    /** 成员角色(负责人/骨干/参与) */
    private String memberRole;

    /** 职称 */
    private String title;

    /** 学历 */
    private String degree;

    /** 专业 */
    private String specialty;

    /** 工作量(小时) */
    private BigDecimal workloadHours;

    /** 主要贡献 */
    private String contribution;

    /** 联系电话 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 加入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;

    /** 离开日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaveDate;

    /** 是否在研(0否/1是) */
    private String isActive;

    /** 删除标志 */
    private String delFlag;

    // ========== 关联查询字段 ==========
    /** 项目名称 */
    private String projectName;

    // ========== Getter/Setter ==========

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public String getMemberRole() { return memberRole; }
    public void setMemberRole(String memberRole) { this.memberRole = memberRole; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public BigDecimal getWorkloadHours() { return workloadHours; }
    public void setWorkloadHours(BigDecimal workloadHours) { this.workloadHours = workloadHours; }
    public String getContribution() { return contribution; }
    public void setContribution(String contribution) { this.contribution = contribution; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
    public Date getLeaveDate() { return leaveDate; }
    public void setLeaveDate(Date leaveDate) { this.leaveDate = leaveDate; }
    public String getIsActive() { return isActive; }
    public void setIsActive(String isActive) { this.isActive = isActive; }
    public String getDelFlag() { return delFlag; }
    public void setDelFlag(String delFlag) { this.delFlag = delFlag; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
}
