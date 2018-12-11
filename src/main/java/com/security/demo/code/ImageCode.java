package com.security.demo.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {

    /** 验证码 */
    private String code;

    /** 判断过期时间 */
    private LocalDateTime expireTime;

    /** 生成的图片验证码 */
    private BufferedImage image;


    public ImageCode(String code, int expireIn, BufferedImage image) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
        this.image = image;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }




}
