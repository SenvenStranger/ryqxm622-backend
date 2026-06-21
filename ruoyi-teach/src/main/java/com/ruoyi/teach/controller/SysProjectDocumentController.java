package com.ruoyi.teach.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.teach.domain.SysProjectDocument;
import com.ruoyi.teach.service.ISysProjectDocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目文档Controller
 * 
 * @author ruoyi
 */
@Api(tags = "项目文档管理")
@RestController
@RequestMapping("/teach/project/document")
public class SysProjectDocumentController extends BaseController {

    @Autowired
    private ISysProjectDocumentService documentService;

    /**
     * 获取文档列表
     */
    @ApiOperation("获取文档列表")
    @PreAuthorize("@ss.hasPermi('teach:document:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysProjectDocument document) {
        startPage();
        List<SysProjectDocument> list = documentService.selectDocumentList(document);
        return getDataTable(list);
    }

    /**
     * 获取文档详情
     */
    @ApiOperation("获取文档详情")
    @PreAuthorize("@ss.hasPermi('teach:document:query')")
    @GetMapping("/{docId}")
    public AjaxResult getInfo(@PathVariable Long docId) {
        return success(documentService.selectDocumentById(docId));
    }

    /**
     * 上传文档
     */
    @ApiOperation("上传文档")
    @PreAuthorize("@ss.hasPermi('teach:document:add')")
    @Log(title = "项目文档", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file,
                            @RequestParam("projectId") Long projectId,
                            @RequestParam("docType") String docType,
                            @RequestParam(value = "docName", required = false) String docName) {
        if (file.isEmpty()) {
            return error("上传文件不能为空");
        }
        
        String fileName = file.getOriginalFilename();
        String fileType = "";
        if (StringUtils.isNotNull(fileName) && fileName.contains(".")) {
            fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        if (StringUtils.isNull(docName)) {
            docName = fileName;
        }
        
        SysProjectDocument document = new SysProjectDocument();
        document.setProjectId(projectId);
        document.setDocName(docName);
        document.setDocType(docType);
        document.setFileType(fileType);
        document.setDocSize(file.getSize());
        document.setUserName(SecurityUtils.getUsername());
        
        // 这里需要实现文件上传到服务器的逻辑
        // 暂时使用模拟路径
        String filePath = "/uploads/project/" + System.currentTimeMillis() + "_" + fileName;
        document.setDocPath(filePath);
        
        return toAjax(documentService.insertDocument(document));
    }

    /**
     * 下载文档
     */
    @ApiOperation("下载文档")
    @GetMapping("/download/{docId}")
    public void download(@PathVariable Long docId, HttpServletResponse response) throws IOException {
        SysProjectDocument document = documentService.selectDocumentById(docId);
        if (document == null) {
            response.setStatus(404);
            return;
        }
        // 这里需要实现文件下载逻辑
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + document.getDocName());
    }

    /**
     * 删除文档
     */
    @ApiOperation("删除文档")
    @PreAuthorize("@ss.hasPermi('teach:document:remove')")
    @Log(title = "项目文档", businessType = BusinessType.DELETE)
    @DeleteMapping("/{docIds}")
    public AjaxResult remove(@PathVariable Long[] docIds) {
        return toAjax(documentService.deleteDocumentByIds(docIds));
    }
}
