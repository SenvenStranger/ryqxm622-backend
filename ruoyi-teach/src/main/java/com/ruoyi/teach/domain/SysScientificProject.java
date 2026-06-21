package com.ruoyi.teach.domain;

import java.util.Date;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科研项目对象 sys_scientific_project
 * 
 * @author ruoyi
 */
public class SysScientificProject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectCode;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目类型(国家级/省部级/厅局级/校级) */
    @Excel(name = "项目类型")
    private String projectType;

    /** 项目级别(重点/一般) */
    @Excel(name = "项目级别")
    private String projectLevel;

    /** 学科分类 */
    @Excel(name = "学科分类")
    private String subjectCategory;

    /** 项目来源 */
    @Excel(name = "项目来源")
    private String sourceFrom;

    /** 资助金额(万元) */
    @Excel(name = "资助金额/万")
    private BigDecimal fundingAmount;

    /** 开始日期 */
    @Excel(name = "开始日期", dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @Excel(name = "结束日期", dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 项目状态(0筹备/1进行中/2已完成/3已终止) */
    @Excel(name = "状态")
    private String projectStatus;

    /** 负责人姓名 */
    @Excel(name = "负责人")
    private String principalName;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String principalPhone;

    /** 负责人邮箱 */
    @Excel(name = "负责人邮箱")
    private String principalEmail;

    /** 所属部门 */
    private Long deptId;

    /** 研究方向 */
    @Excel(name = "研究方向")
    private String researchDirection;

    /** 项目简介 */
    private String projectIntro;

    /** 研究目标 */
    private String objectives;

    /** 研究方法 */
    private String methods;

    /** 创新点 */
    private String innovations;

    /** 项目封面图 */
    private String imageUrl;

    /** 附件路径 */
    private String attachments;

    /** 删除标志 */
    private String delFlag;

    /** 部门名称 */
    @Excel(name = "所属部门")
    private String deptName;

    /** 搜索用：开始日期 */
    private String beginStartDate;

    /** 搜索用：结束日期 */
    private String endStartDate;

    // ========== 关联查询字段 ==========
    /** 团队成员数 */
    private Integer memberCount;

    /** 已完成里程碑数 */
    private Integer completedMilestones;

    /** 总体进度 */
    private Integer overallProgress;

    // ========== Getter/Setter ==========

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public BigDecimal getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(BigDecimal fundingAmount) {
        this.fundingAmount = fundingAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection;
    }

    public String getProjectIntro() {
        return projectIntro;
    }

    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getInnovations() {
        return innovations;
    }

    public void setInnovations(String innovations) {
        this.innovations = innovations;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBeginStartDate() {
        return beginStartDate;
    }

    public void setBeginStartDate(String beginStartDate) {
        this.beginStartDate = beginStartDate;
    }

    public String getEndStartDate() {
        return endStartDate;
    }

    public void setEndStartDate(String endStartDate) {
        this.endStartDate = endStartDate;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Integer getCompletedMilestones() {
        return completedMilestones;
    }

    public void setCompletedMilestones(Integer completedMilestones) {
        this.completedMilestones = completedMilestones;
    }

    public Integer getOverallProgress() {
        return overallProgress;
    }

    public void setOverallProgress(Integer overallProgress) {
        this.overallProgress = overallProgress;
    }

    @Override
    public String toString() {
        return "SysScientificProject{" +
                "projectId=" + projectId +
                ", projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }
}
