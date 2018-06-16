package top.shop.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传工具类
 */
public class FileUtils {

    /**
     * 文件MIME类型
     */
    public static final String FILE_CONTENT_TYPE = "fileContentType";
    /**
     * 输出文件名
     */
    public static final String OUT_PUT_FILE_NAME = "outputFileName";
    /**
     * 构造工具类
     */
    private static final ServletFileUpload SERVLET_FILE_UPLOAD = new ServletFileUpload(new DiskFileItemFactory());
    /**
     * 单个上传文件的最大允许大小，
     */
    private long fileSizeMax = 30 * 1024 * 1024;
    /**
     * 完整请求的最大允许大小
     */
    private long sizeMax = 80 * 1024 * 1024;
    /**
     * 指定读取标题时要使用的字符编码
     */
    private String headerEncoding = "UTF-8";
    /**
     * 输出目录
     */
    private String outDir;
    /**
     * 自定义文件名
     */
    private String customFileName;
    /**
     * 文件名类型
     */
    private int fileNameType = 0;

    /**
     * 默认文件上传
     *
     * @param request HttpServletRequest
     */
    public Map<String, String> startUpload(HttpServletRequest request) {
        try {
            Map<String, String> formField = new HashMap<>(16);
            SERVLET_FILE_UPLOAD.setFileSizeMax(fileSizeMax);
            SERVLET_FILE_UPLOAD.setSizeMax(sizeMax);
            SERVLET_FILE_UPLOAD.setHeaderEncoding(headerEncoding);
            List<FileItem> list = SERVLET_FILE_UPLOAD.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {
                    formField.put(item.getFieldName(), item.getString());
                } else {
                    formField.put(item.getFieldName(), item.getName());
                    formField.put("fileContentType", item.getContentType());
                    String name = item.getName();
                    String outputFileName = getFileName(name);
                    File file = new File(outDir, outputFileName);
                    formField.put("outputFileName", outputFileName);
                    item.write(file);
                    item.delete();
                }
            }
            return formField;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据设置的命名类型来设置
     *
     * @param name 原始文件名
     * @return 新文件名
     */
    private String getFileName(String name) {
        if (fileNameType == 0) {
            return name;
        } else if (fileNameType == 1) {
            return UUID.randomUUID().toString() + "." + name.substring(name.lastIndexOf(".") + 1);
        } else {
            return customFileName + "." + name.substring(name.lastIndexOf(".") + 1);
        }
    }

    /**
     * 设置文件名为UUID
     *
     * @return XiaoShuLuFileUtils
     */
    public FileUtils setUUIDFileName() {
        this.fileNameType = 1;
        return this;
    }

    public FileUtils setFileName(String fileName) {
        this.customFileName = fileName;
        this.fileNameType = 2;
        return this;
    }


    /**
     * 设置输出文件夹路径
     *
     * @param dir 文件夹路径
     * @return XiaoShuLuFileUtils
     */
    public FileUtils setOutPutDir(String dir) {
        this.outDir = dir;
        return this;
    }

    /**
     * 指定读取标题时要使用的字符编码
     *
     * @param encoding 字符编码
     * @return XiaoShuLuFileUtils
     */
    public FileUtils setHeaderEncoding(String encoding) {
        this.headerEncoding = encoding;
        return this;
    }

    /**
     * 设置单个上传文件的最大允许大小，
     *
     * @return XiaoShuLuFileUtils
     */
    public FileUtils setFileSizeMax(long size) {
        this.fileSizeMax = sizeMax;
        return this;
    }

    /**
     * 设置完整请求的最大允许大小
     *
     * @return XiaoShuLuFileUtils
     */
    public FileUtils setFormSizeMax(long size) {
        this.sizeMax = size;
        return this;
    }
}
