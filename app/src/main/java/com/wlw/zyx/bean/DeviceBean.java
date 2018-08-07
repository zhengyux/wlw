package com.wlw.zyx.bean;

import java.util.List;

public class DeviceBean {

    /**
     * status : 1
     * msg : 成功
     * result : {"sitepurposeName":"一年1班","houseNumber":"101","circuitryList":null,"switchPatternList":[{"id":10,"name":"阅读模式","status":"00","siteCodes":"011","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"中央灯\",\"status\":\"01\"}]","patternType":"0","siteName":"101"},{"id":11,"name":"板书模式","status":"01","siteCodes":"011","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"01\"},{\"codes\":\"CL02\",\"name\":\"黑板灯\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"二排灯\",\"status\":\"01\"},{\"codes\":\"CD01\",\"name\":\"xx\",\"status\":\"01\"}]","patternType":"0","siteName":"101"},{"id":12,"name":"ppt模式","status":"01","siteCodes":"011","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"03\"},{\"codes\":\"CL02\",\"name\":\"黑板灯\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"灯\",\"status\":\"01\"}]","patternType":"0","siteName":"101"}],"sortList":[{"name":"灯控","circuitryList":[{"id":17,"codes":"CL01","name":"中央灯","deviceType":"1","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-28 15:08:25","deviceName":"灯光","siteName":"101","sitePurposeName":"一年1班"},{"id":19,"codes":"CL02","name":"黑板灯","deviceType":"1","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-28 15:08:30","deviceName":"灯光","siteName":"101","sitePurposeName":"一年1班"}]},{"name":"空调","circuitryList":[{"id":16,"codes":"061","name":"空调（前）","deviceType":"4","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"空调","siteName":"101","sitePurposeName":"一年1班"},{"id":20,"codes":"008","name":"空调（后）","deviceType":"4","status":"02","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"空调","siteName":"101","sitePurposeName":"一年1班"}]},{"name":"窗帘","circuitryList":[{"id":15,"codes":"CC01","name":"窗户","deviceType":"2","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-27 15:15:48","deviceName":"窗帘","siteName":"101","sitePurposeName":"一年1班"}]},{"name":"其他","circuitryList":[{"id":14,"codes":"011","name":"多媒体","deviceType":"3","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"多媒体","siteName":"101","sitePurposeName":"一年1班"},{"id":18,"codes":"006","name":"前排风扇","deviceType":"5","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"风扇","siteName":"101","sitePurposeName":"一年1班"},{"id":29,"codes":"CD01","name":"班牌","deviceType":"7","status":"00","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-20 17:04:06","deviceName":"班牌","siteName":"101","sitePurposeName":"一年1班"}]}],"globalPatternList":[{"id":1,"name":"上课","status":"00","siteCodes":"000","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"灯\",\"status\":\"01\"}]","patternType":"1","siteName":null},{"id":2,"name":"下课","status":"00","siteCodes":"000","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"03\"},{\"codes\":\"CL01\",\"name\":\"灯\",\"status\":\"00\"}]","patternType":"2","siteName":null}]}
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
         * sitepurposeName : 一年1班
         * houseNumber : 101
         * circuitryList : null
         * switchPatternList : [{"id":10,"name":"阅读模式","status":"00","siteCodes":"011","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"中央灯\",\"status\":\"01\"}]","patternType":"0","siteName":"101"},{"id":11,"name":"板书模式","status":"01","siteCodes":"011","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"01\"},{\"codes\":\"CL02\",\"name\":\"黑板灯\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"二排灯\",\"status\":\"01\"},{\"codes\":\"CD01\",\"name\":\"xx\",\"status\":\"01\"}]","patternType":"0","siteName":"101"},{"id":12,"name":"ppt模式","status":"01","siteCodes":"011","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"03\"},{\"codes\":\"CL02\",\"name\":\"黑板灯\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"灯\",\"status\":\"01\"}]","patternType":"0","siteName":"101"}]
         * sortList : [{"name":"灯控","circuitryList":[{"id":17,"codes":"CL01","name":"中央灯","deviceType":"1","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-28 15:08:25","deviceName":"灯光","siteName":"101","sitePurposeName":"一年1班"},{"id":19,"codes":"CL02","name":"黑板灯","deviceType":"1","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-28 15:08:30","deviceName":"灯光","siteName":"101","sitePurposeName":"一年1班"}]},{"name":"空调","circuitryList":[{"id":16,"codes":"061","name":"空调（前）","deviceType":"4","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"空调","siteName":"101","sitePurposeName":"一年1班"},{"id":20,"codes":"008","name":"空调（后）","deviceType":"4","status":"02","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"空调","siteName":"101","sitePurposeName":"一年1班"}]},{"name":"窗帘","circuitryList":[{"id":15,"codes":"CC01","name":"窗户","deviceType":"2","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-27 15:15:48","deviceName":"窗帘","siteName":"101","sitePurposeName":"一年1班"}]},{"name":"其他","circuitryList":[{"id":14,"codes":"011","name":"多媒体","deviceType":"3","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"多媒体","siteName":"101","sitePurposeName":"一年1班"},{"id":18,"codes":"006","name":"前排风扇","deviceType":"5","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"deviceName":"风扇","siteName":"101","sitePurposeName":"一年1班"},{"id":29,"codes":"CD01","name":"班牌","deviceType":"7","status":"00","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-20 17:04:06","deviceName":"班牌","siteName":"101","sitePurposeName":"一年1班"}]}]
         * globalPatternList : [{"id":1,"name":"上课","status":"00","siteCodes":"000","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"01\"},{\"codes\":\"CL01\",\"name\":\"灯\",\"status\":\"01\"}]","patternType":"1","siteName":null},{"id":2,"name":"下课","status":"00","siteCodes":"000","circuitryCodes":"[{\"codes\":\"CC01\",\"name\":\"窗户\",\"status\":\"03\"},{\"codes\":\"CL01\",\"name\":\"灯\",\"status\":\"00\"}]","patternType":"2","siteName":null}]
         */

        private String sitepurposeName;
        private String houseNumber;
        private Object circuitryList;
        private List<SwitchPatternListBean> switchPatternList;
        private List<SortListBean> sortList;
        private List<GlobalPatternListBean> globalPatternList;

        public String getSitepurposeName() {
            return sitepurposeName;
        }

        public void setSitepurposeName(String sitepurposeName) {
            this.sitepurposeName = sitepurposeName;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public Object getCircuitryList() {
            return circuitryList;
        }

        public void setCircuitryList(Object circuitryList) {
            this.circuitryList = circuitryList;
        }

        public List<SwitchPatternListBean> getSwitchPatternList() {
            return switchPatternList;
        }

        public void setSwitchPatternList(List<SwitchPatternListBean> switchPatternList) {
            this.switchPatternList = switchPatternList;
        }

        public List<SortListBean> getSortList() {
            return sortList;
        }

        public void setSortList(List<SortListBean> sortList) {
            this.sortList = sortList;
        }

        public List<GlobalPatternListBean> getGlobalPatternList() {
            return globalPatternList;
        }

        public void setGlobalPatternList(List<GlobalPatternListBean> globalPatternList) {
            this.globalPatternList = globalPatternList;
        }

        public static class SwitchPatternListBean {
            /**
             * id : 10
             * name : 阅读模式
             * status : 00
             * siteCodes : 011
             * circuitryCodes : [{"codes":"CC01","name":"窗户","status":"01"},{"codes":"CL01","name":"中央灯","status":"01"}]
             * patternType : 0
             * siteName : 101
             */

            private int id;
            private String name;
            private String status;
            private String siteCodes;
            private String circuitryCodes;
            private String patternType;
            private String siteName;
            private String flag;

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSiteCodes() {
                return siteCodes;
            }

            public void setSiteCodes(String siteCodes) {
                this.siteCodes = siteCodes;
            }

            public String getCircuitryCodes() {
                return circuitryCodes;
            }

            public void setCircuitryCodes(String circuitryCodes) {
                this.circuitryCodes = circuitryCodes;
            }

            public String getPatternType() {
                return patternType;
            }

            public void setPatternType(String patternType) {
                this.patternType = patternType;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }
        }

        public static class SortListBean {
            /**
             * name : 灯控
             * circuitryList : [{"id":17,"codes":"CL01","name":"中央灯","deviceType":"1","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-28 15:08:25","deviceName":"灯光","siteName":"101","sitePurposeName":"一年1班"},{"id":19,"codes":"CL02","name":"黑板灯","deviceType":"1","status":"01","siteCodes":"011","createBy":null,"createTime":null,"updateBy":null,"updateTime":"2018-06-28 15:08:30","deviceName":"灯光","siteName":"101","sitePurposeName":"一年1班"}]
             */


            private String name;
            private String deviceType;
            private Boolean isChecked;
            private List<CircuitryListBean> circuitryList;

            public Boolean getChecked() {
                return isChecked;
            }

            public void setChecked(Boolean checked) {
                isChecked = checked;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDeviceType() {
                return deviceType;
            }

            public void setDeviceType(String deviceType) {
                this.deviceType = deviceType;
            }

            public List<CircuitryListBean> getCircuitryList() {
                return circuitryList;
            }

            public void setCircuitryList(List<CircuitryListBean> circuitryList) {
                this.circuitryList = circuitryList;
            }

            public static class CircuitryListBean {
                /**
                 * id : 17
                 * codes : CL01
                 * name : 中央灯
                 * deviceType : 1
                 * status : 01
                 * siteCodes : 011
                 * createBy : null
                 * createTime : null
                 * updateBy : null
                 * updateTime : 2018-06-28 15:08:25
                 * deviceName : 灯光
                 * siteName : 101
                 * sitePurposeName : 一年1班
                 */

                private int id;
                private String codes;
                private String name;
                private String deviceType;
                private String status;
                private String siteCodes;
                private Object createBy;
                private Object createTime;
                private Object updateBy;
                private String updateTime;
                private String deviceName;
                private String siteName;
                private String sitePurposeName;
                private int brightness;

                public int getBrightness() {
                    return brightness;
                }

                public void setBrightness(int brightness) {
                    this.brightness = brightness;
                }

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

                public String getDeviceType() {
                    return deviceType;
                }

                public void setDeviceType(String deviceType) {
                    this.deviceType = deviceType;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getSiteCodes() {
                    return siteCodes;
                }

                public void setSiteCodes(String siteCodes) {
                    this.siteCodes = siteCodes;
                }

                public Object getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(Object createBy) {
                    this.createBy = createBy;
                }

                public Object getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(Object createTime) {
                    this.createTime = createTime;
                }

                public Object getUpdateBy() {
                    return updateBy;
                }

                public void setUpdateBy(Object updateBy) {
                    this.updateBy = updateBy;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getDeviceName() {
                    return deviceName;
                }

                public void setDeviceName(String deviceName) {
                    this.deviceName = deviceName;
                }

                public String getSiteName() {
                    return siteName;
                }

                public void setSiteName(String siteName) {
                    this.siteName = siteName;
                }

                public String getSitePurposeName() {
                    return sitePurposeName;
                }

                public void setSitePurposeName(String sitePurposeName) {
                    this.sitePurposeName = sitePurposeName;
                }
            }
        }

        public static class GlobalPatternListBean {
            /**
             * id : 1
             * name : 上课
             * status : 00
             * siteCodes : 000
             * circuitryCodes : [{"codes":"CC01","name":"窗户","status":"01"},{"codes":"CL01","name":"灯","status":"01"}]
             * patternType : 1
             * siteName : null
             */

            private int id;
            private String name;
            private String status;
            private String siteCodes;
            private String circuitryCodes;
            private String patternType;
            private Object siteName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSiteCodes() {
                return siteCodes;
            }

            public void setSiteCodes(String siteCodes) {
                this.siteCodes = siteCodes;
            }

            public String getCircuitryCodes() {
                return circuitryCodes;
            }

            public void setCircuitryCodes(String circuitryCodes) {
                this.circuitryCodes = circuitryCodes;
            }

            public String getPatternType() {
                return patternType;
            }

            public void setPatternType(String patternType) {
                this.patternType = patternType;
            }

            public Object getSiteName() {
                return siteName;
            }

            public void setSiteName(Object siteName) {
                this.siteName = siteName;
            }
        }
    }
}
