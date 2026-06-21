package com.ruoyi.teach.service;

import com.ruoyi.teach.domain.SysProjectDocument;
import java.util.List;

/**
 * 项目文档Service接口
 *
 * @author ruoyi
 */
public interface ISysProjectDocumentService {

    /**
     * 查询文档
     */
    SysProjectDocument selectDocumentById(Long docId);

    /**
     * 查询文档列表
     */
    List<SysProjectDocument> selectDocumentList(SysProjectDocument document);

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
}
