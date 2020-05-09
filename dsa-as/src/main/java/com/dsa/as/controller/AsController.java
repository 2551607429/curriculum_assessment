package com.dsa.as.controller;

import com.dsa.as.service.UserService;
import com.dsa.common.aop.NoRepeatSubmit;
import com.dsa.common.config.Jedis.JedisCache;
import com.dsa.common.utils.Page;
import com.dsa.common.utils.ResultInfo;
import com.dsa.common.version.ApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/as")
public class AsController {

    private static Logger logger = LoggerFactory.getLogger(AsController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JedisCache jedisCache;

    @ApiVersion
    @GetMapping("{version}/test")
    public String oldTest(){
        return "old test ";
    }

    @ApiVersion(2)
    @GetMapping("{version}/test")
    public String test(){
        return "test";
    }

    @ApiVersion(3)
    @GetMapping("{version}/test")
    public String newTest(){
        return "new test";
    }

    /**
     * @return
     */
    @GetMapping("hello")
    public String hello() {
        logger.info("run this");
        jedisCache.set("name", "test");
        String s = (String) jedisCache.get("name");
        System.out.println(s);
        return "hello:as";
    }

    /**
     *
     * @param currentPage 页码
     * @param pageSize 每页展示的数据
     * @return
     */
    @GetMapping("findall")
    public ResultInfo<?> findByPage(HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        ResultInfo resultInfo = new ResultInfo();
        Map<String, Object> param_map = new HashMap<>();
        Page page = new Page();
        if(!StringUtils.isEmpty(currentPage)){
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        if(!StringUtils.isEmpty(pageSize)){
            page.setPageSize(Integer.valueOf(pageSize));
        }
        param_map.put("page",page);
        Map<String, Object> listMap =  userService.findAll(param_map);
        resultInfo.setCode(0);
        resultInfo.setData(listMap.get("list"));
        resultInfo.setPage((Page) listMap.get("page"));
        return resultInfo;
    }

    @PostMapping("submit")
    @NoRepeatSubmit(lockTime = 30)
    public Object submit() {
        try {
            // 模拟业务场景
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResultInfo<>(200, "成功", null);
    }
}
