package com.noway.wechatorder.utils;

import com.noway.wechatorder.VO.ResultVO;

public class ResultUtils {


    public static ResultVO success(Object o){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(o);
        return resultVO;
    }

    public static ResultVO success(){
      return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
