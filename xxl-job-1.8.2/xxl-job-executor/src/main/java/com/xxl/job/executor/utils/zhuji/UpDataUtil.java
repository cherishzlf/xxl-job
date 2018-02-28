package com.xxl.job.executor.utils.zhuji;

import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.constants.UpUserNameConstant;
import com.xxl.job.executor.domain.zhuji.*;
import com.xxl.job.executor.utils.StringUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用于诸暨-绍兴接口的工具类
 */
public class UpDataUtil {
    /**
     * 人员创建接口
     * @param upUser
     * @param token
     * @return
     */
    public static String createuUserApi(UpUser upUser,String token){
        String url = "http://sx.ihezhang.com:8089/api.do?action=createuser";
//        String url = "http://www.zxmoa.com:9000/api.do?action=createuser";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        if(StringUtil.isNotEmptyStr(upUser.getSrcid())) {
            rlist.add(new BasicNameValuePair("userid", upUser.getSrcid()));
        }
        rlist.add(new BasicNameValuePair("objname",upUser.getObjectName()));
        rlist.add(new BasicNameValuePair("adcode",upUser.getAdCode()));
        rlist.add(new BasicNameValuePair("type",upUser.getType().toString()));
        rlist.add(new BasicNameValuePair("phone",upUser.getPhone()==null?"":upUser.getPhone()));
        rlist.add(new BasicNameValuePair("duty",upUser.getDuty()==null?"":upUser.getDuty()));
        rlist.add(new BasicNameValuePair("unit",upUser.getUnit()==null?"":upUser.getUnit()));
        String result = post(url,rlist);
        return result;
    }

    /**
     * post请求
     * @param url
     * @param params
     * @return
     */
        public static String post(String url, List<NameValuePair> params) {
            String body = null;
            HttpClient hc = new DefaultHttpClient();
            try {
                // Post请求
                HttpPost httppost = new HttpPost(url);
                // 设置参数
                httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
                // 发送请求
                HttpResponse httpresponse = hc.execute(httppost);
                // 获取返回数据
                HttpEntity entity = httpresponse.getEntity();
                body = EntityUtils.toString(entity,"UTF-8");
                if (entity != null) {
                    entity.consumeContent();
                }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
                XxlJobLogger.log(e.toString());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
                XxlJobLogger.log(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
                XxlJobLogger.log(e.toString());
        }
        return body;
    }

    /**
     * 创建河道
     * @param reach
     * @param token
     * @return
     */
    public static String createriver(UploadReach reach, String token) {
        String url = "http://sx.ihezhang.com:8089/api.do?action=createriver";
//        String url = "http://www.zxmoa.com:9000/api.do?action=createriver";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        if(StringUtil.isNotEmptyStr(reach.getSrcid())) {
            rlist.add(new BasicNameValuePair("riverid", reach.getSrcid()));
        }
        rlist.add(new BasicNameValuePair("rivername", reach.getRiverName()));
        rlist.add(new BasicNameValuePair("rivertype", reach.getRiverType()));
        if(StringUtil.isNotEmptyStr(reach.getRiveralias())) {
            rlist.add(new BasicNameValuePair("riveralias", reach.getRiveralias()));
        }
//        rlist.add(new BasicNameValuePair("riverno", reach.getRiverno()==null?"":reach.getRiverno().toString()));
        rlist.add(new BasicNameValuePair("adcode", reach.getAdCode()==null?reach.getRiverName():reach.getAdCode()));
        rlist.add(new BasicNameValuePair("basin", reach.getBasin()));
        rlist.add(new BasicNameValuePair("datatype", reach.getDataType()));
        rlist.add(new BasicNameValuePair("length", reach.getLength().toString()));
        if(StringUtil.isNotEmptyStr(reach.getOrigin())){
            rlist.add(new BasicNameValuePair("origin", reach.getOrigin()));
        }
        if(StringUtil.isNotEmptyStr(reach.getEndPoint())) {
            rlist.add(new BasicNameValuePair("endpoint", reach.getEndPoint()));
        }
        rlist.add(new BasicNameValuePair("userid", reach.getUserId()));
        String result = post(url,rlist);
        return result;
    }

    /**
     * 上报巡河记录
     * @param workLog
     * @param token
     * @return
     */
    public static String createpatrol(UpWorkLog workLog, String token) {
        String url = "http://sx.ihezhang.com:8089/api.do?action=createpatrol";
//        String url = "http://www.zxmoa.com:9000/api.do?action=createpatrol";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        rlist.add(new BasicNameValuePair("riverid", workLog.getRiverId()));
        rlist.add(new BasicNameValuePair("userid", workLog.getUserId()));
        rlist.add(new BasicNameValuePair("starttime", dateFormatToTime(workLog.getStarttime())));
        rlist.add(new BasicNameValuePair("endtime", dateFormatToTime(workLog.getEndtime())));
        rlist.add(new BasicNameValuePair("distance", workLog.getDistance().toString()));
        rlist.add(new BasicNameValuePair("problem", workLog.getProblem().toString()));
        String result = post(url,rlist);
        return result;
    }

    public static String createtrack(UpPatrol upPatrol, String token) {
        String url = "http://sx.ihezhang.com:8089/api.do?action=createtrack";
//        String url = "http://www.zxmoa.com:9000/api.do?action=createtrack";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        rlist.add(new BasicNameValuePair("patrolid", upPatrol.getPatrolid()));
        rlist.add(new BasicNameValuePair("jsondata", upPatrol.getJsondata()));
        rlist.add(new BasicNameValuePair("map", upPatrol.getMap()));
        String result = post(url,rlist);
        return result;
    }

    public static String deleteRiver(UploadReach reach, String token) {
            String url = "http://sx.ihezhang.com:8089/api.do?action=deleteriver";
            List<NameValuePair> rlist = new ArrayList<NameValuePair>();
            rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
            rlist.add(new BasicNameValuePair("token", token));
            rlist.add(new BasicNameValuePair("riverid", reach.getSrcid()));
            String result = post(url,rlist);
            return result;
    }

    public static String deleteuser(UpUser upUser, String token) {
        String url = "http://sx.ihezhang.com:8089/api.do?action=deleteuser";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        rlist.add(new BasicNameValuePair("userid", upUser.getUserId()));
        String result = post(url,rlist);
        return result;
    }



    public static String createproblem(UpEvent upEvent, String token) {
        String url = "http://sx.ihezhang.com:8089/api.do?action=createproblem";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        rlist.add(new BasicNameValuePair("patrolid",upEvent.getPatrolid()));
        rlist.add(new BasicNameValuePair("createdate",dateFormatToDate(upEvent.getCreatedate())));
        rlist.add(new BasicNameValuePair("problems",upEvent.getProblems()));
        rlist.add(new BasicNameValuePair("description",upEvent.getDescription()));
        rlist.add(new BasicNameValuePair("lng",upEvent.getLng()));
        rlist.add(new BasicNameValuePair("lat",upEvent.getLat()));
        rlist.add(new BasicNameValuePair("location",upEvent.getLocation()));
        rlist.add(new BasicNameValuePair("map",upEvent.getMap()));
        String result = post(url,rlist);
        return result;
    }

    public static String handleproblem(UpEventHandler upEventHandler, String token) {
        String url = "http://sx.ihezhang.com:8089/api.do?action=handleproblem";
        List<NameValuePair> rlist = new ArrayList<NameValuePair>();
        rlist.add(new BasicNameValuePair("userkey", UpUserNameConstant.USERKEY));
        rlist.add(new BasicNameValuePair("token", token));
        rlist.add(new BasicNameValuePair("patrolid",upEventHandler.getProblemid()));
        rlist.add(new BasicNameValuePair("handleuserid",upEventHandler.getHandleuserid()));
        rlist.add(new BasicNameValuePair("handletime",dateFormatToTime(upEventHandler.getHandletime())));
        rlist.add(new BasicNameValuePair("result",upEventHandler.getResult()));
        if (StringUtil.isNotEmptyStr(upEventHandler.getPhoto())) {
            rlist.add(new BasicNameValuePair("result", upEventHandler.getProblemid()));
        }
        String result = post(url,rlist);
        return result;
    }


    /**
     * 转化日期格式为 YYYY/MM/DD HH:mm:ss
     * @param date
     * @return
     */
    public static String dateFormatToTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String a =sdf.format(date);
        return sdf.format(date);
    }
    /**
     * 转化日期格式为 YYYY/MM/DD
     * @param date
     * @return
     */
    public static String dateFormatToDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String a =sdf.format(date);
        return sdf.format(date);
    }
}
