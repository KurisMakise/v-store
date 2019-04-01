package store.os.common.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.common.base.BaseController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;

/**
 * author  violet
 * createTime 2019/3/29 8:38
 * description
 * version 1.0
 */
@Controller
@RequestMapping("/pass")
@Api("验证码")
public class CaptchaController extends BaseController {

    private final Producer captchaProducer;

    public CaptchaController(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @ApiOperation("验证码")
    @GetMapping("/kaptcha")
    public void defaultKaptcha() throws Exception {
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        //request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //将验证码存到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        logger.info(capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
