package com.yapi.rentku;

public class ServerConfig {

    // URL SAMBUNG DB
    public static final String URL_BASE = "http://192.168.12.241:8000/";
    public static final String IMAGES_BASE = "http://192.168.0.140:8000/upload/";

    public static final String API_ENDPOINT = URL_BASE;

    // CRUD
    public static final int REQUEST_PICK_PHOTO = 2;
    public static final int REQUEST_WRITE_PERMISSION = 786;
    public static final int ALERT_DIALOG_CLOSE = 10;
    public static final int ALERT_DIALOG_DELETE = 20;
    public static final String INSERT_FLAG = "INSERT";
    public static final String UPDATE_FLAG = "UPDATE";

}
