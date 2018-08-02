package com.wlw.zyx.bean;

public class RoomBean {


    /**
     * status : 1
     * msg :
     * result : {"humidity":"51.8","illumination":"112","temperature":"27.8"}
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
         * humidity : 51.8
         * illumination : 112
         * temperature : 27.8
         */

        private String humidity;
        private String illumination;
        private String temperature;
        private String pm25;

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getIllumination() {
            return illumination;
        }

        public void setIllumination(String illumination) {
            this.illumination = illumination;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }
    }
}
