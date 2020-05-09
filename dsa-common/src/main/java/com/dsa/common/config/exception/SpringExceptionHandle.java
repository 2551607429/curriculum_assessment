package com.dsa.common.config.exception;

import com.dsa.common.enums.ResponseBean;
import com.dsa.common.enums.UnicomResponseEnums;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.List;


/**
 * @description:全局的异常处理类
 * @author:
 * @create: 2019年2月28日16:14:22
 **/
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class SpringExceptionHandle {


    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);

    /**
     * 请求参数类型错误异常的捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {BindException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseBean badRequest(BindException e) {
        e.printStackTrace();
        logger.error("occurs error when execute method ,message {}", e);
        return new ResponseBean<>(false, UnicomResponseEnums.BAD_REQUEST);
    }

    /**
     * 404错误异常的捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseBean<String> badRequestNotFound(BindException e) {
        logger.error("occurs error when execute method ,message {}", e);
        return new ResponseBean<>(false, UnicomResponseEnums.NOT_FOUND);
    }

    /**
     * mybatis未绑定异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindingException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<String> mybatis(Exception e) {
        logger.error("occurs error when execute method ,message {}", e);
        return new ResponseBean<>(false, UnicomResponseEnums.BOUND_STATEMENT_NOT_FOUNT);
    }

    /**
     * 自定义异常的捕获
     * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = {UnicomRuntimeException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> ResponseBean<T> sendError(UnicomRuntimeException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        logger.error("occurs error when execute url ={} ,message {}", requestURI, exception);
        return new ResponseBean<>(false, exception.getCode(), exception.getMsg());
    }

    /**
     * 数据库操作出现异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<String> systemError(Exception e) {
        logger.error("occurs error when execute method ,message {}", e);
        return new ResponseBean<>(false, UnicomResponseEnums.DATABASE_ERROR.getCode(), UnicomResponseEnums.DATABASE_ERROR.getMsg());
    }

    /**
     * 网络连接失败！
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ConnectException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<String> connect(Exception e) {
        logger.error("occurs error when execute method ,message {}", e);
        return new ResponseBean<>(false, UnicomResponseEnums.CONNECTION_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseBean<String> notAllowed(Exception e) {
        e.printStackTrace();
        logger.error("occurs error when execute method ,message {}", e);
        return new ResponseBean<>(false, UnicomResponseEnums.SYSTEM_ERROR);
    }

    /**
     * @Author xwk
     * @Description: token 不匹配
     * @Param: [e]
     * @Return: com.qif.com.qif.ommup.dto.ResponseBean
     * @Create: 2019/3/1 10:09
     */
    @ExceptionHandler(value = {UnauthenticatedException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean unAuthorized(Exception e) {
        logger.error("token 不匹配！", e);
        return new ResponseBean(false, UnicomResponseEnums.UNAUTHORIZED);
    }

    /**
     * @Description: 账号或密码错误
     * @Author xwk
     * @Param: [e]
     * @Return: com.qif.com.qif.ommup.dto.ResponseBean
     * @Create: 2019/3/8 11:00
     */
    @ExceptionHandler(value = {IncorrectCredentialsException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean authorizationFailed(Exception e) {
        logger.error("用户名密码错误：{}", e);
        return new ResponseBean(false, UnicomResponseEnums.INVALID_PASSWORD.getCode(), UnicomResponseEnums.INVALID_PASSWORD.getMsg());
    }

    /**
     * 删除失败异常
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author xu wen kai
     * @Create: 2019/3/20 20:11
     */
    @ExceptionHandler(value = {DeleteDataException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean deleteDataException(Exception e) {
        logger.error("删除数据失败，有可能重复删除！{}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), "删除失败，有可能重复删除！");
    }

    /**
     * 插入数据异常
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author xu wen kai
     * @Create: 2019/3/20 20:11
     */
    @ExceptionHandler(value = {InsertDataException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean insertDataException(Exception e) {
        logger.error("执行 insert语句报错！{}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.DATABASE_ERROR.getCode(), UnicomResponseEnums.DATABASE_ERROR.getMsg());
    }

    /**
     * 请求参数为空
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author xu wen kai
     * @Create: 2019/3/20 20:11
     */
    @ExceptionHandler(value = {ParamIsEmptyException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean paramIsEmptyException(Exception e) {
        logger.error("请求参数是空{}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 用户名不存在
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author xu wen kai
     * @Create: 2019/3/20 20:11
     */
    @ExceptionHandler(value = {UnknownAccountException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean unknownAccountException(Exception e) {
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.NO_USER_EXIST.getCode(), UnicomResponseEnums.NO_USER_EXIST.getMsg());
    }


    /**
     * 请求参数为空
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author zhangzheng
     * @Create: 2019/4/8 20:11
     */
    @ExceptionHandler(value = {RuntimeSqlException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean runtimeSqlException(Exception e) {
        logger.error("数据库连接异常 {}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.UPDATE_DATA.getCode(), UnicomResponseEnums.UPDATE_DATA.getMsg());
    }


    /**
     * 请求参数为空
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author xu wen kai
     * @Create: 2019/3/20 20:11
     */
    @ExceptionHandler(value = {SQLNonTransientConnectionException.class, SQLNonTransientConnectionException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean DBConnectionException(Exception e) {
        logger.error("数据库连接异常 {}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.DATABASE_ERROR.getCode(), UnicomResponseEnums.DATABASE_ERROR.getMsg());
    }


    /**
     * 请求参数和预期不一致
     *
     * @param e
     * @return com.qif.com.qif.ommup.dto.ResponseBean
     * @Author xu wen kai
     * @Create: 2019/3/20 20:11
     */
    @ExceptionHandler(value = {ParamsIsFailedException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseBean paramsIsFailedException(Exception e) {
        logger.error("错误的请求参数 {}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.BAD_REQUEST.getCode(), UnicomResponseEnums.BAD_REQUEST.getMsg());
    }


    /**
     * 参数为空异常
     *
     * @param e
     * @return ResponseBean
     * @Author GuoJiKang
     * @Create: 2019/5/27 9:24
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public static ResponseBean NotEmptyException(MethodArgumentNotValidException e) {
        logger.error("空字符串异常 {}", e);
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuffer str = new StringBuffer();
        for(ObjectError error:allErrors){
            str.append(error.getDefaultMessage()+" ");
        }
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": " + str);
    }

    /**
     * 自定义参数不能为空异常
     *
     * @param e
     * @return ResponseBean
     * @Author GuoJiKang
     * @Create: 2019/5/27 9:24
     */
    @ExceptionHandler(value = {NotEmptyException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public static ResponseBean NotEmptyException(NotEmptyException e) {
        String message = e.getMessage();
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.ILLEGAL_ARGUMENT.getCode(), UnicomResponseEnums.ILLEGAL_ARGUMENT.getMsg() + ": " + message);
    }


    /**
     * 请求头不正确
     *
     * @param e
     * @return ResponseBean
     * @Author GuoJiKang
     * @Create: 2019/5/27 9:24
     */
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public static ResponseBean HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("错误的HTTP请求 {}", e);
        e.printStackTrace();
        return new ResponseBean(false, UnicomResponseEnums.HEADER_ERROR.getCode(), UnicomResponseEnums.HEADER_ERROR.getMsg()+": 系统只支持application/json格式的请求");
    }

}