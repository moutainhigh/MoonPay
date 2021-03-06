package com.martin.service.tenpay;

import com.martin.utils.PayUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;

/**
 * @author ZXY
 * @ClassName: TenPayCore
 * @Description: 微信支付工具类
 * @date 2016/5/27 16:54
 */
class TenPayAppUtils {

    //编码格式
    private static String charset = "UTF-8";

    /**
     * 获取签名
     */
    public static String createSdkSign(String privateKey, LinkedHashMap<String, String> paraMap) {
        String param = PayUtils.buildConcatStr(paraMap);
        param += "key=" + privateKey;// 这里必须要用商户的KEY代码,我靠..
        String appSign = MD5(param);
        return appSign;
    }

    public static String MD5(String str) {

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(charset));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString().toUpperCase();
    }
}
