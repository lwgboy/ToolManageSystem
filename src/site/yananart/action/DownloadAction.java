package site.yananart.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import site.yananart.controller.GetDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.entity.Tool;

public class DownloadAction {
    private String fileName;
    // 读取下载文件的输入流
    private InputStream is;
    // 读取下载文件的目录
    private String url;
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String url= (String) session.get("path");
        Tool tool= (Tool) session.get("tool");
        String path = ServletActionContext.getServletContext().getRealPath("tool");
        System.out.println(path+"\\"+url);
        try {
            is= new BufferedInputStream(new FileInputStream(path+"\\"+url));
            fileName=url.substring(url.lastIndexOf('/')+1);
            System.out.println(fileName);
            ToolDAO toolDAO= GetDAO.getToolDAO();
            toolDAO.addDownload(tool.getToolId());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        return "success";
    }
    // 创建InputStream的输入流
    public InputStream getInputStream() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String url= (String) session.get("path");
        String path = ServletActionContext.getServletContext().getRealPath("tool");
        System.out.println(path+"\\"+url);
        try {
            return new BufferedInputStream(new FileInputStream(path+"\\"+url));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public InputStream getIs() {
        return is;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }
}
