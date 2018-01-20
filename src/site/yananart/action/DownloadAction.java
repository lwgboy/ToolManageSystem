package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.entity.Tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

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
            int fi,se,tr;
            fi=url.indexOf('/',2);
            se=url.indexOf('/',fi+1);
            tr=url.lastIndexOf('.');
            fileName=url.substring(fi+1,se)+' '+url.substring(se+1,tr)+url.substring(tr);
            System.out.println(fileName);
            ToolDAO toolDAO= GetDAO.getToolDAO();
            toolDAO.addDownload(tool.getToolId());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        tool.setDownloadNumber(tool.getDownloadNumber()+1);
        session.put("tool",tool);
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
