package com.ruoyi.teach.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目文档对象 sys_project_document
 * 
 * @author ruoyi
 */
public class SysProjectDocument extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 文档ID */
    private Long docId;

    /** 项目ID */
    private Long projectId;

    /** 文档类型 */
    private String docType;

    /** 文档名称 */
    private String docName;

    /** 文档路径 */
    private String docPath;

    /** 文件大小 */
    private Long docSize;

    /** 文件类型 */
    private String fileType;

    /** 上传人 */
    private String uploadBy;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uploadTime;

    /** 版本号 */
    private String version;

    /** 是否公开 */
    private String isPublic;

    /** 文档描述 */
    private String description;

    /** 删除标志 */
    private String delFlag;

    // ========== 关联查询字段 ==========
    /** 项目名称 */
    private String projectName;

    /** 用户名称 */
    private String userName;

    // ========== Getter/Setter ==========

    public Long getDocId() { return docId; }
    public void setDocId(Long docId) { this.docId = docId; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public String getDocType() { return docType; }
    public void setDocType(String docType) { this.docType = docType; }
    public String getDocName() { return docName; }
    public void setDocName(String docName) { this.docName = docName; }
    public String getDocPath() { return docPath; }
    public void setDocPath(String docPath) { this.docPath = docPath; }
    public Long getDocSize() { return docSize; }
    public void setDocSize(Long docSize) { this.docSize = docSize; }
    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }
    public String getUploadBy() { return uploadBy; }
    public void setUploadBy(String uploadBy) { this.uploadBy = uploadBy; }
    public Date getUploadTime() { return uploadTime; }
    public void setUploadTime(Date uploadTime) { this.uploadTime = uploadTime; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getIsPublic() { return isPublic; }
    public void setIsPublic(String isPublic) { this.isPublic = isPublic; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDelFlag() { return delFlag; }
    public void setDelFlag(String delFlag) { this.delFlag = delFlag; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
