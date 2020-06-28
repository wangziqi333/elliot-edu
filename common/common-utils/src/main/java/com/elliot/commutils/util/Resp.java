package com.elliot.commutils.util;

import java.util.HashMap;
import java.util.Map;

public class Resp extends HashMap {

    static final int SUCC_CODE = 1;
    static final int FAIL_CODE = 0;

    static final boolean SUCC = true;
    static final boolean FAIL = false;

    private Resp(){
        put("code",SUCC_CODE);
        put("success",SUCC);
    }


    public static Resp ok(){
        return new Resp();
    }

    public static Resp error(){
        Resp resp = new Resp();
        resp.put("code", FAIL_CODE);
        resp.put("success",FAIL);
        return resp;
    }

    public Resp data(Object data){
        put("data",data);
        return this;
    }

    public Map data(){
        Map item = new HashMap();
        this.data(item);
        return item;
    }



}
