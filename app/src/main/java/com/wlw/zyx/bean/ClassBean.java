package com.wlw.zyx.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ClassBean {

    private String status;
    private String msg;
    private result result;

    public result getResult() {
        return result;
    }

    public void setResult(result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



 public class result {

    private int totalRecord;
    private List<data> data;

    public List<result.data> getData() {
        return data;
    }

    public void setData(List<result.data> data) {
        this.data = data;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

  public  class data {

        private int id;
        private String codes;
        private String name;
        private String purposeName;
        private int type;
        private String floor;
        private String ip;
        private String port;
        private int parentId;
        private String createTime;
        private String createBy;
        private String updateTime;
        private String updateBy;
        private String parentName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCodes() {
            return codes;
        }

        public void setCodes(String codes) {
            this.codes = codes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPurposeName() {
            return purposeName;
        }

        public void setPurposeName(String purposeName) {
            this.purposeName = purposeName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }
    }

 }

}
