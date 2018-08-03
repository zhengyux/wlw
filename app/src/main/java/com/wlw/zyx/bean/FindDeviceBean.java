package com.wlw.zyx.bean;

import java.util.List;

public class FindDeviceBean {


    /**
     * data : [{"id":3,"type":"3","name":"多媒体","commonds":[{"id":9,"commondName":"开","status":"01","deviceId":3},{"id":14,"commondName":"关","status":"00","deviceId":3}]}]
     * totalRecord : 1
     */

    private int totalRecord;
    private List<DataBean> data;

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * type : 3
         * name : 多媒体
         * commonds : [{"id":9,"commondName":"开","status":"01","deviceId":3},{"id":14,"commondName":"关","status":"00","deviceId":3}]
         */

        private int id;
        private String type;
        private String name;
        private List<CommondsBean> commonds;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<CommondsBean> getCommonds() {
            return commonds;
        }

        public void setCommonds(List<CommondsBean> commonds) {
            this.commonds = commonds;
        }

        public static class CommondsBean {
            /**
             * id : 9
             * commondName : 开
             * status : 01
             * deviceId : 3
             */

            private int id;
            private String commondName;
            private String status;
            private int deviceId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCommondName() {
                return commondName;
            }

            public void setCommondName(String commondName) {
                this.commondName = commondName;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(int deviceId) {
                this.deviceId = deviceId;
            }
        }
    }
}
