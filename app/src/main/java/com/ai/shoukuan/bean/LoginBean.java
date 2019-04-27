package com.ai.shoukuan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginBean {


    /**
     * successful : true
     * result : {"user":{"id":"admin","userName":"admin","passwd":"21232f297a57a5a743894a0e4a801fc3","failedLoginCount":null,"passwdExpireDays":null,"passwdExpireDatetime":null,"maxFailedLoginCount":null,"loginIp":null,"loginDatetime":null,"lastModifierId":null,"lastModifiedDatetime":null,"lastLoginIp":null,"lastLoginDatetime":null,"delFlag":"0","creatorId":null,"createDatetime":null,"accountExpireDatetime":null,"locked":null,"email":null},"admined":true,"roles":[{"id":"1","code":"admin","name":"管理员","orderNo":1,"remark":null,"inherent":"1"}],"defaultMenus":[{"id":"10","name":"组织管理","url":"$framework/view/unit/unit","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"unit","visible":"1","orderNo":1},{"id":"11","name":"菜单管理","url":"$framework/view/menu/menu","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"menu","visible":"1","orderNo":2},{"id":"12","name":"角色管理","url":"$framework/view/role/role","pid":"3","tip":null,"leafed":null,"remark":null,"chain":"0-3-","icon":null,"type":"0","code":"role","visible":"1","orderNo":3},{"id":"2","name":"首页","url":"main","pid":"0","tip":null,"leafed":"1","remark":null,"chain":"0-","icon":null,"type":"0","code":"main","visible":"1","orderNo":null},{"id":"3","name":"系统管理","url":null,"pid":"0","tip":null,"leafed":"0","remark":null,"chain":"0-","icon":null,"type":"0","code":null,"visible":"1","orderNo":null},{"id":"30","name":"日志管理","url":"$framework/view/query/queryEngine?id=2","pid":"3","tip":"","leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"sscResult","visible":"1","orderNo":4}],"menus":[{"id":"10","name":"组织管理","url":"$framework/view/unit/unit","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"unit","visible":"1","orderNo":1},{"id":"11","name":"菜单管理","url":"$framework/view/menu/menu","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"menu","visible":"1","orderNo":2},{"id":"12","name":"角色管理","url":"$framework/view/role/role","pid":"3","tip":null,"leafed":null,"remark":null,"chain":"0-3-","icon":null,"type":"0","code":"role","visible":"1","orderNo":3},{"id":"2","name":"首页","url":"main","pid":"0","tip":null,"leafed":"1","remark":null,"chain":"0-","icon":null,"type":"0","code":"main","visible":"1","orderNo":null},{"id":"3","name":"系统管理","url":null,"pid":"0","tip":null,"leafed":"0","remark":null,"chain":"0-","icon":null,"type":"0","code":null,"visible":"1","orderNo":null},{"id":"30","name":"日志管理","url":"$framework/view/query/queryEngine?id=2","pid":"3","tip":"","leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"sscResult","visible":"1","orderNo":4}],"globalConf":null,"authenticated":true,"userData":null}
     * errorCode : null
     * errMsg : null
     */

    private boolean successful;
    private ResultBean result;
    private Object errorCode;
    private Object errMsg;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(Object errMsg) {
        this.errMsg = errMsg;
    }

    public static class ResultBean {
        /**
         * user : {"id":"admin","userName":"admin","passwd":"21232f297a57a5a743894a0e4a801fc3","failedLoginCount":null,"passwdExpireDays":null,"passwdExpireDatetime":null,"maxFailedLoginCount":null,"loginIp":null,"loginDatetime":null,"lastModifierId":null,"lastModifiedDatetime":null,"lastLoginIp":null,"lastLoginDatetime":null,"delFlag":"0","creatorId":null,"createDatetime":null,"accountExpireDatetime":null,"locked":null,"email":null}
         * admined : true
         * roles : [{"id":"1","code":"admin","name":"管理员","orderNo":1,"remark":null,"inherent":"1"}]
         * defaultMenus : [{"id":"10","name":"组织管理","url":"$framework/view/unit/unit","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"unit","visible":"1","orderNo":1},{"id":"11","name":"菜单管理","url":"$framework/view/menu/menu","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"menu","visible":"1","orderNo":2},{"id":"12","name":"角色管理","url":"$framework/view/role/role","pid":"3","tip":null,"leafed":null,"remark":null,"chain":"0-3-","icon":null,"type":"0","code":"role","visible":"1","orderNo":3},{"id":"2","name":"首页","url":"main","pid":"0","tip":null,"leafed":"1","remark":null,"chain":"0-","icon":null,"type":"0","code":"main","visible":"1","orderNo":null},{"id":"3","name":"系统管理","url":null,"pid":"0","tip":null,"leafed":"0","remark":null,"chain":"0-","icon":null,"type":"0","code":null,"visible":"1","orderNo":null},{"id":"30","name":"日志管理","url":"$framework/view/query/queryEngine?id=2","pid":"3","tip":"","leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"sscResult","visible":"1","orderNo":4}]
         * menus : [{"id":"10","name":"组织管理","url":"$framework/view/unit/unit","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"unit","visible":"1","orderNo":1},{"id":"11","name":"菜单管理","url":"$framework/view/menu/menu","pid":"3","tip":null,"leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"menu","visible":"1","orderNo":2},{"id":"12","name":"角色管理","url":"$framework/view/role/role","pid":"3","tip":null,"leafed":null,"remark":null,"chain":"0-3-","icon":null,"type":"0","code":"role","visible":"1","orderNo":3},{"id":"2","name":"首页","url":"main","pid":"0","tip":null,"leafed":"1","remark":null,"chain":"0-","icon":null,"type":"0","code":"main","visible":"1","orderNo":null},{"id":"3","name":"系统管理","url":null,"pid":"0","tip":null,"leafed":"0","remark":null,"chain":"0-","icon":null,"type":"0","code":null,"visible":"1","orderNo":null},{"id":"30","name":"日志管理","url":"$framework/view/query/queryEngine?id=2","pid":"3","tip":"","leafed":"1","remark":null,"chain":"0-3-","icon":null,"type":"0","code":"sscResult","visible":"1","orderNo":4}]
         * globalConf : null
         * authenticated : true
         * userData : null
         */

        private UserBean user;
        private boolean admined;
        private Object globalConf;
        private boolean authenticated;
        private Object userData;
        private List<RolesBean> roles;
        private List<DefaultMenusBean> defaultMenus;
        private List<MenusBean> menus;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public boolean isAdmined() {
            return admined;
        }

        public void setAdmined(boolean admined) {
            this.admined = admined;
        }

        public Object getGlobalConf() {
            return globalConf;
        }

        public void setGlobalConf(Object globalConf) {
            this.globalConf = globalConf;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public Object getUserData() {
            return userData;
        }

        public void setUserData(Object userData) {
            this.userData = userData;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        public List<DefaultMenusBean> getDefaultMenus() {
            return defaultMenus;
        }

        public void setDefaultMenus(List<DefaultMenusBean> defaultMenus) {
            this.defaultMenus = defaultMenus;
        }

        public List<MenusBean> getMenus() {
            return menus;
        }

        public void setMenus(List<MenusBean> menus) {
            this.menus = menus;
        }

        public static class UserBean {
            /**
             * id : admin
             * userName : admin
             * passwd : 21232f297a57a5a743894a0e4a801fc3
             * failedLoginCount : null
             * passwdExpireDays : null
             * passwdExpireDatetime : null
             * maxFailedLoginCount : null
             * loginIp : null
             * loginDatetime : null
             * lastModifierId : null
             * lastModifiedDatetime : null
             * lastLoginIp : null
             * lastLoginDatetime : null
             * delFlag : 0
             * creatorId : null
             * createDatetime : null
             * accountExpireDatetime : null
             * locked : null
             * email : null
             */

            private String id;
            @SerializedName("userName")
            private String userNameX;
            private String passwd;
            private Object failedLoginCount;
            private Object passwdExpireDays;
            private Object passwdExpireDatetime;
            private Object maxFailedLoginCount;
            private Object loginIp;
            private Object loginDatetime;
            private Object lastModifierId;
            private Object lastModifiedDatetime;
            private Object lastLoginIp;
            private Object lastLoginDatetime;
            private String delFlag;
            private Object creatorId;
            private Object createDatetime;
            private Object accountExpireDatetime;
            private Object locked;
            private Object email;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserNameX() {
                return userNameX;
            }

            public void setUserNameX(String userNameX) {
                this.userNameX = userNameX;
            }

            public String getPasswd() {
                return passwd;
            }

            public void setPasswd(String passwd) {
                this.passwd = passwd;
            }

            public Object getFailedLoginCount() {
                return failedLoginCount;
            }

            public void setFailedLoginCount(Object failedLoginCount) {
                this.failedLoginCount = failedLoginCount;
            }

            public Object getPasswdExpireDays() {
                return passwdExpireDays;
            }

            public void setPasswdExpireDays(Object passwdExpireDays) {
                this.passwdExpireDays = passwdExpireDays;
            }

            public Object getPasswdExpireDatetime() {
                return passwdExpireDatetime;
            }

            public void setPasswdExpireDatetime(Object passwdExpireDatetime) {
                this.passwdExpireDatetime = passwdExpireDatetime;
            }

            public Object getMaxFailedLoginCount() {
                return maxFailedLoginCount;
            }

            public void setMaxFailedLoginCount(Object maxFailedLoginCount) {
                this.maxFailedLoginCount = maxFailedLoginCount;
            }

            public Object getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(Object loginIp) {
                this.loginIp = loginIp;
            }

            public Object getLoginDatetime() {
                return loginDatetime;
            }

            public void setLoginDatetime(Object loginDatetime) {
                this.loginDatetime = loginDatetime;
            }

            public Object getLastModifierId() {
                return lastModifierId;
            }

            public void setLastModifierId(Object lastModifierId) {
                this.lastModifierId = lastModifierId;
            }

            public Object getLastModifiedDatetime() {
                return lastModifiedDatetime;
            }

            public void setLastModifiedDatetime(Object lastModifiedDatetime) {
                this.lastModifiedDatetime = lastModifiedDatetime;
            }

            public Object getLastLoginIp() {
                return lastLoginIp;
            }

            public void setLastLoginIp(Object lastLoginIp) {
                this.lastLoginIp = lastLoginIp;
            }

            public Object getLastLoginDatetime() {
                return lastLoginDatetime;
            }

            public void setLastLoginDatetime(Object lastLoginDatetime) {
                this.lastLoginDatetime = lastLoginDatetime;
            }

            public String getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
            }

            public Object getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(Object creatorId) {
                this.creatorId = creatorId;
            }

            public Object getCreateDatetime() {
                return createDatetime;
            }

            public void setCreateDatetime(Object createDatetime) {
                this.createDatetime = createDatetime;
            }

            public Object getAccountExpireDatetime() {
                return accountExpireDatetime;
            }

            public void setAccountExpireDatetime(Object accountExpireDatetime) {
                this.accountExpireDatetime = accountExpireDatetime;
            }

            public Object getLocked() {
                return locked;
            }

            public void setLocked(Object locked) {
                this.locked = locked;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }
        }

        public static class RolesBean {
            /**
             * id : 1
             * code : admin
             * name : 管理员
             * orderNo : 1
             * remark : null
             * inherent : 1
             */

            private String id;
            private String code;
            private String name;
            private int orderNo;
            private Object remark;
            private String inherent;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(int orderNo) {
                this.orderNo = orderNo;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getInherent() {
                return inherent;
            }

            public void setInherent(String inherent) {
                this.inherent = inherent;
            }
        }

        public static class DefaultMenusBean {
            /**
             * id : 10
             * name : 组织管理
             * url : $framework/view/unit/unit
             * pid : 3
             * tip : null
             * leafed : 1
             * remark : null
             * chain : 0-3-
             * icon : null
             * type : 0
             * code : unit
             * visible : 1
             * orderNo : 1
             */

            private String id;
            private String name;
            private String url;
            private String pid;
            private Object tip;
            private String leafed;
            private Object remark;
            private String chain;
            private Object icon;
            private String type;
            private String code;
            private String visible;
            private int orderNo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public Object getTip() {
                return tip;
            }

            public void setTip(Object tip) {
                this.tip = tip;
            }

            public String getLeafed() {
                return leafed;
            }

            public void setLeafed(String leafed) {
                this.leafed = leafed;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getChain() {
                return chain;
            }

            public void setChain(String chain) {
                this.chain = chain;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getVisible() {
                return visible;
            }

            public void setVisible(String visible) {
                this.visible = visible;
            }

            public int getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(int orderNo) {
                this.orderNo = orderNo;
            }
        }

        public static class MenusBean {
            /**
             * id : 10
             * name : 组织管理
             * url : $framework/view/unit/unit
             * pid : 3
             * tip : null
             * leafed : 1
             * remark : null
             * chain : 0-3-
             * icon : null
             * type : 0
             * code : unit
             * visible : 1
             * orderNo : 1
             */

            private String id;
            private String name;
            private String url;
            private String pid;
            private Object tip;
            private String leafed;
            private Object remark;
            private String chain;
            private Object icon;
            private String type;
            private String code;
            private String visible;
            private int orderNo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public Object getTip() {
                return tip;
            }

            public void setTip(Object tip) {
                this.tip = tip;
            }

            public String getLeafed() {
                return leafed;
            }

            public void setLeafed(String leafed) {
                this.leafed = leafed;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getChain() {
                return chain;
            }

            public void setChain(String chain) {
                this.chain = chain;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getVisible() {
                return visible;
            }

            public void setVisible(String visible) {
                this.visible = visible;
            }

            public int getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(int orderNo) {
                this.orderNo = orderNo;
            }
        }
    }
}
