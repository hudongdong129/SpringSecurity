package com.security.demo.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode extends ValidateCode {



    /** 生成的图片验证码 */
    private BufferedImage image;


    public ImageCode(String code, int expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(String code, LocalDateTime expireTime, BufferedImage image) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }




}
