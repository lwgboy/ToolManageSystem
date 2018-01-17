package site.yananart.entity;

public class User {
    private String userId;
    private String userPwd;
    private String userName;
    private int userType;
    private String manageUrl;

    public User(String userId, String userPwd, String userName) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userType=0;
    }

    public User(String userId, String userPwd, String userName, int userType, String manageUrl) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userType = userType;
        this.manageUrl = manageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getManageUrl() {
        return manageUrl;
    }

    public void setManageUrl(String manageUrl) {
        this.manageUrl = manageUrl;
    }

    public String getAdminType(){
        if(this.userType==2) return "根管理员";
        else if(this.userType==0) return "非管理员";
        else return "\""+this.manageUrl+"\"目录管理员";
    }

    public int getManageType(){
        if (userType==2) return -1;
        String[] des={"系统工具","通讯社交","影音播放","新闻阅读","摄影图像","网上购物","金融理财","办公商务"};
        for (int i = 0; i <des.length ; i++) {
            if(manageUrl.contains(des[i])) return i;
        }
        return -1;
    }
}
