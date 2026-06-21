package com.ruoyi.teach.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.teach.domain.SysProjectDocument;
import com.ruoyi.teach.mapper.SysProjectDocumentMapper;
import com.ruoyi.teach.service.ISysProjectDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 项目文档Service实现
 *
 * @author ruoyi
 */
@Service
public class SysProjectDocumentServiceImpl implements ISysProjectDocumentService {

    @Autowired
    private SysProjectDocumentMapper documentMapper;

    /**
     * 查询文档
     */
    @Override
    public SysProjectDocument selectDocumentById(Long docId) {
        return documentMapper.selectDocumentById(docId);
    }

    /**
     * 查询文档列表
     */
    @Override
    public List<SysProjectDocument> selectDocumentList(SysProjectDocument document) {
        return documentMapper.selectDocumentList(document);
    }

    /**
     * 新增文档
     */
    @Override
    public int insertDocument(SysProjectDocument document) {
        document.setCreateBy(StringUtils.isNotNull(SecurityUtils.getUserId()) ? SecurityUtils.getUsername() : "system");
        document.setCreateTime(DateUtils.getNowDate());
        return documentMapper.insertDocument(document);
    }

    /**
     * 修改文档
     */
    @Override
    public int updateDocument(SysProjectDocument document) {
        document.setUpdateBy(SecurityUtils.getUsername());
        document.setUpdateTime(DateUtils.getNowDate());
        return documentMapper.updateDocument(document);
    }

    /**
     * 删除文档
     */
    @Override
    public int deleteDocumentById(Long docId) {
        return documentMapper.deleteDocumentById(docId);
    }

    /**
     * 批量删除文档
     */
    @Override
    public int deleteDocumentByIds(Long[] docIds) {
        return documentMapper.deleteDocumentByIds(docIds);
    }
}
