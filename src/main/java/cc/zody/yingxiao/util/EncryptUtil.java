package cc.zody.yingxiao.util;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author liumin
 * @since 2019-02-28
 */
public class EncryptUtil {

    /**
     * md5字符串(35小写)
     */
    public static String md5(String data) {
        return md5(data, null, false);
    }

    private static String md5(String data, String salt, boolean upper) {
        byte[] bytes;
        Charset cs = Charset.forName("utf-8");
        if (salt == null)
            bytes = data.getBytes(cs);
        else
            bytes = (data + salt).getBytes(cs);
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(bytes);
        bytes = md.digest();
        return upper ? bytes2Hex(bytes).toUpperCase() : bytes2Hex(bytes);
    }

    private static String bytes2Hex(byte[] data) {
        StringBuilder builder = new StringBuilder();
        for (byte b : data) {
            if ((b & 0xff) < 0x10) {
                builder.append("0");
            }
            builder.append(Long.toString(b & 0xff, 16));
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(md5("123456"));
        System.out.printf("");
    }

    /**
     *
     * rsa 加密
     */


    /**
     * des 加密
     */



}
