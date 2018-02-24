package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * @author Donqiuxote
 * @data 2018/2/3 16:20
 */
public class ResultVOUtils {
    public static ResultVO sucess(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO sucess(){
        return sucess(null);
    }

    public static ResultVO error(int code,String message){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
