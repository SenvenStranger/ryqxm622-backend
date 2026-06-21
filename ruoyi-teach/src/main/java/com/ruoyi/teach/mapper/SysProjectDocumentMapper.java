package com.ruoyi.teach.mapper;

import java.util.List;
import com.ruoyi.teach.domain.SysProjectDocument;

/**
 * 项目文档Mapper接口
 * 
 * @author ruoyi
 */
public interface SysProjectDocumentMapper {

    /**
     * 查询文档列表
     */
    List<SysProjectDocument> selectDocumentList(SysProjectDocument document);

    /**
     * 查询文档详情
     */
    SysProjectDocument selectDocumentById(Long docId);

    /**
     * 新增文档
     */
    int insertDocument(SysProjectDocument document);

    /**
     * 修改文档
     */
    int updateDocument(SysProjectDocument document);

    /**
     * 删除文档
     */
    int deleteDocumentById(Long docId);

    /**
     * 批量删除文档
     */
    int deleteDocumentByIds(Long[] docIds);

    /**
     * 根据项目ID查询文档
     */
    List<SysProjectDocument> selectDocumentsByProjectId(Long projectId);
}
