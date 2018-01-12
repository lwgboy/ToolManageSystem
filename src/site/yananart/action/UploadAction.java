package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.entity.User;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class UploadAction {
    private String name;
    private String version1;
    private String version2;
    private String version3;
    private int type;
    private String tag;
    private String describe;
    private File file;
    private String fileFileName;
    private String fileContentType;

    public String upload() throws IOException, SQLException {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String realpath = ServletActionContext.getServletContext().getRealPath("/tool");
        System.out.println("realpath: "+realpath);
        session.put("upname",name);
        session.put("ver1",version1);
        session.put("ver2",version2);
        session.put("ver3",version3);
        session.put("uptag",tag);
        session.put("tudes",describe);
        if(name.equals("")){
            session.put("uploadStatus","请填入工具名");
            return "error";
        }
        if(version1.equals("")||version2.equals("")||version3.equals("")){
            session.put("uploadStatus","请填入版本号");
            return "error";
        }
        String version = 'v'+version1+'.'+version2+'.'+version3;
        try{
            Integer.valueOf(version1);
            Integer.valueOf(version2);
            Integer.valueOf(version3);
        }catch (Exception e){
            session.put("uploadStatus","版本号请填入正确的数字格式");
            return "error";
        }
        if(tag.equals("")){
            session.put("uploadStatus","请填入标签");
            return "error";
        }
        if(describe.equals("")){
            session.put("uploadStatus","请填入工具描述");
            return "error";
        }
        if(file==null){
            session.put("uploadStatus","请选择文件");
            return "error";
        }
        //System.out.println(fileFileName);
        //String[] names=fileFileName.split(".");
        String[] des={"系统工具","通讯社交","影音播放","新闻阅读","摄影图像","网上购物","金融理财","办公商务"};
        realpath+='/'+des[type];
        fileFileName=name+' '+version+fileFileName.substring(fileFileName.lastIndexOf('.'));
        File savefile = new File(new File(realpath), fileFileName);
        FileUtils.copyFile(file,savefile);
        session.remove("upname");
        session.remove("ver1");
        session.remove("ver2");
        session.remove("ver3");
        session.remove("uptag");
        session.remove("tudes");
        session.put("searchStatus","已将文件"+fileFileName+"上传保存至\"\\"+des[type]+"\\\"目录");
        ToolDAO toolDAO= GetDAO.getToolDAO();
        User user= (User) session.get("user");
        toolDAO.insertNewTool(name,version,type,user.getUserId(),describe,tag,"/"+des[type]+"/"+fileFileName);
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion1() {
        return version1;
    }

    public void setVersion1(String version1) {
        this.version1 = version1;
    }

    public String getVersion2() {
        return version2;
    }

    public void setVersion2(String version2) {
        this.version2 = version2;
    }

    public String getVersion3() {
        return version3;
    }

    public void setVersion3(String version3) {
        this.version3 = version3;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}
