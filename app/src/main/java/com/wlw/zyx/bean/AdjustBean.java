package com.wlw.zyx.bean;

/**
 * 温湿度对象
 */
public class AdjustBean {

    /**
     * status : 1
     * msg : 成功
     * result : {"id":1,"siteCodes":"011","temperatureMax":29,"temperatureMaxStatus":false,"temperatureMaxOperation":"[]","temperatureMin":10,"temperatureMinStatus":false,"temperatureMinOperation":"[]","illuminationMax":100,"illuminationMaxStatus":false,"illuminationMaxOpreation":"[]","illuminationMin":50,"illuminationMinStatus":false,"illuminationMinOpreation":"[]","status":true}
     */

    private String status;
    private String msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * siteCodes : 011
         * temperatureMax : 29.0
         * temperatureMaxStatus : false
         * temperatureMaxOperation : []
         * temperatureMin : 10.0
         * temperatureMinStatus : false
         * temperatureMinOperation : []
         * illuminationMax : 100.0
         * illuminationMaxStatus : false
         * illuminationMaxOpreation : []
         * illuminationMin : 50.0
         * illuminationMinStatus : false
         * illuminationMinOpreation : []
         * status : true
         */

        private int id;
        private String siteCodes;
        private double temperatureMax;
        private boolean temperatureMaxStatus;
        private String temperatureMaxOperation;
        private double temperatureMin;
        private boolean temperatureMinStatus;
        private String temperatureMinOperation;
        private double illuminationMax;
        private boolean illuminationMaxStatus;
        private String illuminationMaxOpreation;
        private double illuminationMin;
        private boolean illuminationMinStatus;
        private String illuminationMinOpreation;
        private boolean status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSiteCodes() {
            return siteCodes;
        }

        public void setSiteCodes(String siteCodes) {
            this.siteCodes = siteCodes;
        }

        public double getTemperatureMax() {
            return temperatureMax;
        }

        public void setTemperatureMax(double temperatureMax) {
            this.temperatureMax = temperatureMax;
        }

        public boolean isTemperatureMaxStatus() {
            return temperatureMaxStatus;
        }

        public void setTemperatureMaxStatus(boolean temperatureMaxStatus) {
            this.temperatureMaxStatus = temperatureMaxStatus;
        }

        public String getTemperatureMaxOperation() {
            return temperatureMaxOperation;
        }

        public void setTemperatureMaxOperation(String temperatureMaxOperation) {
            this.temperatureMaxOperation = temperatureMaxOperation;
        }

        public double getTemperatureMin() {
            return temperatureMin;
        }

        public void setTemperatureMin(double temperatureMin) {
            this.temperatureMin = temperatureMin;
        }

        public boolean isTemperatureMinStatus() {
            return temperatureMinStatus;
        }

        public void setTemperatureMinStatus(boolean temperatureMinStatus) {
            this.temperatureMinStatus = temperatureMinStatus;
        }

        public String getTemperatureMinOperation() {
            return temperatureMinOperation;
        }

        public void setTemperatureMinOperation(String temperatureMinOperation) {
            this.temperatureMinOperation = temperatureMinOperation;
        }

        public double getIlluminationMax() {
            return illuminationMax;
        }

        public void setIlluminationMax(double illuminationMax) {
            this.illuminationMax = illuminationMax;
        }

        public boolean isIlluminationMaxStatus() {
            return illuminationMaxStatus;
        }

        public void setIlluminationMaxStatus(boolean illuminationMaxStatus) {
            this.illuminationMaxStatus = illuminationMaxStatus;
        }

        public String getIlluminationMaxOpreation() {
            return illuminationMaxOpreation;
        }

        public void setIlluminationMaxOpreation(String illuminationMaxOpreation) {
            this.illuminationMaxOpreation = illuminationMaxOpreation;
        }

        public double getIlluminationMin() {
            return illuminationMin;
        }

        public void setIlluminationMin(double illuminationMin) {
            this.illuminationMin = illuminationMin;
        }

        public boolean isIlluminationMinStatus() {
            return illuminationMinStatus;
        }

        public void setIlluminationMinStatus(boolean illuminationMinStatus) {
            this.illuminationMinStatus = illuminationMinStatus;
        }

        public String getIlluminationMinOpreation() {
            return illuminationMinOpreation;
        }

        public void setIlluminationMinOpreation(String illuminationMinOpreation) {
            this.illuminationMinOpreation = illuminationMinOpreation;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
}
