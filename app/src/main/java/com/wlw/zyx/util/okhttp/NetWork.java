package com.wlw.zyx.util.okhttp;

public class NetWork {

    public static String code;//班级码
  public static String URL = "http://192.168.1.29:8085/iot-app/"; //服务器
  //  public static String URL = "http://10.110.48.55:8085/iot-app/"; //服务器
    public static String ClassUrl = URL+"general/pad/querySites"; //post 获取所有班级信息
    public static String DeviceUrl = URL + "general/pad/findCircuitryBySiteCodes?siteCodes=";//利用codes获取班级内的情景模式与设备信息
    public static String FindDeviceUrl = URL+"general/pad/findDevice?type="; //post 查找设备开关停
    public static String operateCircuitryUrl = URL+"general/pad/operateCircuitry";//操控设备
    public static String OperateSwitchPatternUrl = URL+"general/pad/operateSwitchPattern";//操作情景模式
    public static String GetRoomInfoURL = URL+"general/env/getRoomInfo?siteCodes=";//温湿度亮度
    public static String adjustSetURL=URL+"/general/pad/getAutoControlParam";//调节温度 参数：String siteCodes
    public static String operroomcomplexURl=URL+"/general/pad/operroomcomplex";//设备全开关

}
