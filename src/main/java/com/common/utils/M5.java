package com.common.utils;

import org.springframework.util.DigestUtils;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
public class M5 {
    public static void main(String[] args) {
        System.out.println(new M5().m5("lianghao"));
    }
    private String m5(String str){
        return
            DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
