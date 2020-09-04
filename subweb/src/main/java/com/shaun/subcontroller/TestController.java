package com.shaun.subcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/subweb")
public class TestController {

    @GetMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        response.getOutputStream().write("sub module controller test".getBytes());
        response.flushBuffer();
    }

}
