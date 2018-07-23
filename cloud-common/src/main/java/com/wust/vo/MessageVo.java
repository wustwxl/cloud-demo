package com.wust.vo;
import com.wust.utils.StringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by IntelliJ IDEA.
 * @author : F7687967
 * Date: 2017/10/16
 * Time: 上午 08:51
 * Description: 统一返回类型
 */

// 无参构造函数
@NoArgsConstructor
// 全参构造函数
// @AllArgsConstructor
@Data
// set链式写法
@Accessors(chain = true)
public class MessageVo {

    public static final Integer OK = 0;
    public static final Integer ERROR = 1;
    public static final Integer HYSTRIX = -1;
    public static final Integer ZUUL = -2;

    private Integer code;
    private String info;
    private String logCode = StringUtil.getStringRandom(12);
    private Object data;

}
