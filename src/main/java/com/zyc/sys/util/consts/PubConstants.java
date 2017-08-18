package com.zyc.sys.util.consts;

public class PubConstants {
	
	public static final String GLOBAL_ERROR_STATUS = "1002";
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final String MD5_ALGORITHM = "MD5";
	public static final int HASH_INTERATIONS = 1024;
	public static final String YES = "1";
	public static final String NO = "0";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
    public static final String EMPTY_STR = "";
    public static final String CHINESE_YEAR_STR = "年";
    public static final String CHINESE_MONTH_STR = "月";
    public static final String CHINESE_DAY_STR = "日";
    public static final String DELIMITER = "^";
    public static final String DIRECTMODE = "Direct Mode!" + DELIMITER + DELIMITER;
    public static final int LENGTH_OR = 2;
    public static final String CONTAIN = "*";
    public static final boolean CHANGECHARSET = false; // Unicode to GBK
    public static final String GBK_UNICODE = "ISO8859_1";
    public static final String AND = "AND ";
    public static final String OR = "OR ";
    public static final String BLANK = "";
    public static final String COLON_SIGNAL = ":";
    public static final String NULL = "null";
    public static final String VERTICAL_SIGNAL = "|";
    public static final String ZERO = "0";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH24:mi:ss";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_LONG_TIME= "yyyymmdd";
    public static final String HH_MM_SS_FORMAT = "HH:mm:ss";
    public static final String HH_MM_SS_LONG_TIME = "HHmmssS";
    public static final String ROOT_CONTEXT = "/";
    public static final String USER_LOCKED = "1";

    public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
    public static final String DEFAULT_MOBILE_PARAM = "mobileLogin";
    public static final String DEFAULT_MESSAGE_PARAM = "message";
    public static final String ERROR_CODE_KEY = "errorCode";
    
    public static final String UPDATE_SESSION = "updateSession";
    public static final String REQUEST_HEADER_TOKEN_PARAM = "token";
    public static final String REQUEST_METHOD_OPTIONS_PARAM = "options";
    public static final String REQUEST_GET_METHOD = "GET";
    public static final String REQUEST_POST_METHOD = "POST";
    public static final String REQUEST_PUT_METHOD = "PUT";
    public static final String REQUEST_DELETE_METHOD = "DELETE";
    
    public static final String START_TIME = "startTime";
    public static final String EXECUTE_TIME = "executeTime";
    public static int SERVER_HANDLE_SUCCESS_INT_VALUE = 200;
    
    public static final String ALLOW_ORIGIN = "allow.origin";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "access.control.allow.headers";
    public static final String ALLOW_DIFFERENT_AREA_LOGIN = "allow.different.area.login";


    
    /** days of a month */
    public static int DAYS_OF_MONTH = 31;
    /** batch deal number */
    public static int BATCH_DEAL_NUM = 50;
    public static final String WHIPPLETREE_SIGNAL  = "-";

    //附件上传常量
    public static final String BACK  = "back";
    public static final String PASS  = "pass";
    public static final String OVER_LOAD  = "over_load";
    public static final String NEW  = "0";
    public static final String DELETED  = "1";
    public static final String COMMA  = ",";
    public static final String UPLOAD  = "上传";
    public static final String SUCCESS  = "成功";
    public static final String FAILURE  = "失败";
    public static final String EXCEPTION  = "exception";
    public static final String MES  = "mes";
    public static final String URL  = "url";
    public static final String UPLOAD_DOWNLOAD_CONFIG_FILE_PATH  = "config/properties/attachment/attachment.properties";
    public static final String CORS_CONFIG_FILE_PATH  = "config/properties/cors/cors.properties";
    public static final String SYSTEM_CONFIG_FILE_PATH  = "config/properties/sys/sys.properties";


}
