package com.xxl.job.executor.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.executor.constants.UpUserNameConstant;
import com.xxl.job.executor.domain.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CallApiUtil {

	/**
	 * 问题新增服务
	 * @param problem 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadProblem(UpProblem problem) {
		HttpResponse response = null;
		String result = null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadProblem";
//		String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", problem.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("problemID", problem.getProblemID()));
		rlist.add(new BasicNameValuePair("problemType", problem.getProblemType()));
		rlist.add(new BasicNameValuePair("problemSource", problem.getProblemSource()));
		if(problem.getPatrolID()!=null) {
			rlist.add(new BasicNameValuePair("patrolID", problem.getPatrolID()));
		}
		rlist.add(new BasicNameValuePair("itemList", problem.getItemList()));
		rlist.add(new BasicNameValuePair("riverID", problem.getRiverID()));
		rlist.add(new BasicNameValuePair("handleStyle", problem.getHandleStyle() == null ? "" : problem.getHandleStyle()));
		rlist.add(new BasicNameValuePair("reporterContact", problem.getReporterContact()));
		rlist.add(new BasicNameValuePair("reportTime", problem.getReportTime()));
		rlist.add(new BasicNameValuePair("description", problem.getDescription()));
		rlist.add(new BasicNameValuePair("longitude", problem.getLongitude()==null?"":problem.getLongitude()));
		rlist.add(new BasicNameValuePair("latitude", problem.getLatitude()==null?"": problem.getLatitude()));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist, "UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200){
			JSONObject jo = JSON.parseObject(result);
		if (jo.getBoolean("success") == true) {
			return "true";
		}
		result = "问题ID: " + problem.getProblemID() + " 上报失败，失败原因是：" + jo.getString("message");
		return result;
	}
		return problem.getProblemID()+"	报错500";
	}
	/**
	 * 上报河道信息，请在传入的VO中设置参数userName，表示传入哪一个平台，参数值参照UploadUserName类
	 * @param reach
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadReach(UpReach reach){

		/*List<UpMdReachVO> list = new ArrayList<UpMdReachVO>();
		Reach reach1 = new Reach("huzpt","1","1","1460112324","10000329500000000000000000000000",
				"百墩港支2谷门村段","百墩港支2谷门村段","0A817AB8-FB58-48B6-BD24-9D8F7B6DB89F",
				"百墩港","陈家埭",1.60f,"330521113","谷门村","当地","1300000000",
				"3715","王利华","管理河道","13000000000");
		list.add(reach1);*/
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadRiver";
//			String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", reach.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("riverID", reach.getRiverID()));
		if(reach.getParentID()!=null) {
			rlist.add(new BasicNameValuePair("parentID", reach.getParentID()));
		}
		rlist.add(new BasicNameValuePair("riverName", reach.getRiverName()));
		rlist.add(new BasicNameValuePair("riverAlias", reach.getRiverAlias()==null?"":reach.getRiverAlias()));
		rlist.add(new BasicNameValuePair("riverType", reach.getRiverType()));
		rlist.add(new BasicNameValuePair("startPoint", reach.getStartPoint()==null?"":reach.getStartPoint()));
		rlist.add(new BasicNameValuePair("endPoint", reach.getEndPoint()==null?"":reach.getEndPoint()));
		rlist.add(new BasicNameValuePair("length", reach.getLength()==null?"0":reach.getLength()));
		rlist.add(new BasicNameValuePair("adminDivCode", reach.getAdminDivCode()));
		if(reach.getTownName()!=null) {
			rlist.add(new BasicNameValuePair("townName", reach.getTownName()));
		}
		rlist.add(new BasicNameValuePair("basinCode", reach.getBasinCode()==null?"":reach.getBasinCode()));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(response.getStatusLine().getStatusCode()==200) {//如果状态码为200,就是正常返回
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "河道ID: " + reach.getRiverID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result;
		}
		return reach.getRiverID()+"	报错500";
	}
	/**
	 * 巡查上报服务
	 * @param parolerecord 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadPatrol(UpParolerecord parolerecord){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadPatrol";
//		String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", parolerecord.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("patrolID", parolerecord.getPatrolID()));
		rlist.add(new BasicNameValuePair("riverID", parolerecord.getRiverID()));
		rlist.add(new BasicNameValuePair("patrollerContact", parolerecord.getPatrollerContact()));
		rlist.add(new BasicNameValuePair("startTime", dateFormat(parolerecord.getStartTime())));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(response.getStatusLine().getStatusCode()==200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "巡查ID: " + parolerecord.getPatrolID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result+"    500";
		}
		return parolerecord.getPatrolID();
	}
	/**
	 * 问题处理状态新增服务
	 * @param problemHandle 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadProblemHandle(UpProblemHandle problemHandle){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadProblemHandle";
//		String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", problemHandle.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("handleID", problemHandle.getHandleID()==null?"":problemHandle.getHandleID()));
		rlist.add(new BasicNameValuePair("problemID", problemHandle.getProblemID()));
		rlist.add(new BasicNameValuePair("handlerContact", problemHandle.getHandlerContact()));
		rlist.add(new BasicNameValuePair("handlerOrg", problemHandle.getHandlerOrg()==null?"":problemHandle.getHandlerOrg()));
		if(problemHandle.getStatus()!=null&&problemHandle.getStatus().equals("Z")) {
			rlist.add(new BasicNameValuePair("handleTime", problemHandle.getHandleTime()));
		}else{
			rlist.add(new BasicNameValuePair("handleTime", dateFormat(problemHandle.getBegintime())));
		}
		rlist.add(new BasicNameValuePair("description", problemHandle.getDescription()==null?"":problemHandle.getDescription()));
		rlist.add(new BasicNameValuePair("status", problemHandle.getStatus().equals("F")?"1":"0"));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "处理编号ID: " + problemHandle.getHandleID() + " 上报失败，失败原因是：" + jo.getString("message");
			System.out.println(result);
			return result;
		}
		return problemHandle.getHandleID()+"   5000000000000 ";
	}

	/**
	 * 上报小微水体服务
	 * @param badSmallWater 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadBadSmallWater(UpBadSmallWater badSmallWater){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadBadSmallWater";
//		String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", badSmallWater.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("waterID", badSmallWater.getWaterID()));
		rlist.add(new BasicNameValuePair("waterName", badSmallWater.getWaterName()));
		rlist.add(new BasicNameValuePair("waterType", badSmallWater.getWaterType()==null?"":badSmallWater.getWaterType()));
		rlist.add(new BasicNameValuePair("planEndTime", dateFormat(badSmallWater.getPlanEndTime())));
		rlist.add(new BasicNameValuePair("planDredgingQuantity", badSmallWater.getPlanDredgingQuantity()==null?"0":badSmallWater.getPlanDredgingQuantity().toString()));
		rlist.add(new BasicNameValuePair("mainCause", badSmallWater.getMainCause()));
		rlist.add(new BasicNameValuePair("governObjectives", badSmallWater.getGovernObjectives()==null?"":badSmallWater.getGovernObjectives()));
		rlist.add(new BasicNameValuePair("governMeasures", badSmallWater.getGovernMeasures()));
		rlist.add(new BasicNameValuePair("responsibilityUnit", badSmallWater.getResponsibilityUnit()==null?"":badSmallWater.getResponsibilityUnit()));
		rlist.add(new BasicNameValuePair("responsibilityPerson", badSmallWater.getResponsibilityPerson()));
		rlist.add(new BasicNameValuePair("responsibilityPersonPosition", badSmallWater.getResponsibilityPersonPosition()==null?"":badSmallWater.getResponsibilityPersonPosition()));
		rlist.add(new BasicNameValuePair("responsibilityPersonPhone", badSmallWater.getResponsibilityPersonPhone()==null?"":badSmallWater.getResponsibilityPersonPhone()));
		rlist.add(new BasicNameValuePair("planYear", String.valueOf(badSmallWater.getPlanYear())));
		rlist.add(new BasicNameValuePair("adminDivCode", badSmallWater.getAdminDivCode()));
		rlist.add(new BasicNameValuePair("townName", badSmallWater.getTownName()));
		rlist.add(new BasicNameValuePair("villageName", badSmallWater.getVillageName()));
		rlist.add(new BasicNameValuePair("isCleared", badSmallWater.getIsCleared()));
		rlist.add(new BasicNameValuePair("longitude", badSmallWater.getLongitude().toString()));
		rlist.add(new BasicNameValuePair("latitude", badSmallWater.getLatitude().toString()));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jo = JSON.parseObject(result);
		if (response.getStatusLine().getStatusCode() == 200) {
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "水体编号ID: " + badSmallWater.getWaterID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result;
		}
		return badSmallWater.getWaterID()+" 500 ";
	}
	/**
	 * 上报河道断面
	 * @param upRiverSection 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadRiverSection(UpRiverSection upRiverSection){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadRiverSection";
//		String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", upRiverSection.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("sectionID", upRiverSection.getSectionID()));
		rlist.add(new BasicNameValuePair("sectionType", upRiverSection.getSectionType()));
		rlist.add(new BasicNameValuePair("sectionName", upRiverSection.getSectionName()));
		rlist.add(new BasicNameValuePair("waterFunctionArea", upRiverSection.getWaterFunctionArea()==null?"":upRiverSection.getWaterFunctionArea()));
		rlist.add(new BasicNameValuePair("riverID", upRiverSection.getRiverID()==null?"":upRiverSection.getRiverID()));
		rlist.add(new BasicNameValuePair("targetWaterQuality", upRiverSection.getTargetWaterQuality()==null?"":upRiverSection.getTargetWaterQuality()));
		rlist.add(new BasicNameValuePair("adminDivCode", upRiverSection.getAdminDivCode()));
		rlist.add(new BasicNameValuePair("stationName", upRiverSection.getStationName()));
		rlist.add(new BasicNameValuePair("isTaiLakeImportantSection", upRiverSection.getIsTaiLakeImportantSection()==null?"0":upRiverSection.getIsTaiLakeImportantSection()));
		rlist.add(new BasicNameValuePair("isProvinceAssess", String.valueOf(upRiverSection.getIsProvinceAssess()==null?"0":upRiverSection.getIsProvinceAssess())));
		rlist.add(new BasicNameValuePair("isNationImportant", upRiverSection.getIsNationImportant()==null?"0":upRiverSection.getIsNationImportant()));
		rlist.add(new BasicNameValuePair("badVIndex", upRiverSection.getBadVIndex()==null?"":upRiverSection.getBadVIndex()));
		rlist.add(new BasicNameValuePair("responsiblePerson", upRiverSection.getResponsiblePerson()==null?"":upRiverSection.getResponsiblePerson()));
		rlist.add(new BasicNameValuePair("longitude", upRiverSection.getLongitude()==null?"":upRiverSection.getLongitude().toString()));
		rlist.add(new BasicNameValuePair("latitude",upRiverSection.getLatitude()==null?"":upRiverSection.getLatitude().toString()));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "断面编号: " + upRiverSection.getSectionID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result;
		}
		return upRiverSection.getSectionID()+" 500了\n  ";
	}
	/**
	 * 上报小微水体进展服务
	 * @param badSmallWaterProgress 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadBadSmallWaterProgress(UpBadSmallWaterProgress badSmallWaterProgress){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadBadSmallWaterProgress";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", badSmallWaterProgress.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("progressID", badSmallWaterProgress.getProgressID()));
		rlist.add(new BasicNameValuePair("waterID", badSmallWaterProgress.getWaterID()));
		rlist.add(new BasicNameValuePair("clearProgressSituation", badSmallWaterProgress.getClearProgressSituation()));
		rlist.add(new BasicNameValuePair("isReachStandard", badSmallWaterProgress.getIsReachStandard()));
		rlist.add(new BasicNameValuePair("reportMonth", String.valueOf(badSmallWaterProgress.getReportMonth())));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "进展编号ID: " + badSmallWaterProgress.getProgressID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result;
		}
		return badSmallWaterProgress.getProgressID();
	}

	/**
	 * 上报重点项目计划服务
	 * @param upProPlan
	 * @return
	 */
	public static String uploadProjectPlan(UpProPlan upProPlan){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadProjectPlan";
		MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
		meBuilder.addTextBody("userName", upProPlan.getUserName());
		meBuilder.addTextBody("authKey", UpUserNameConstant.AUTHKEY);
		meBuilder.addTextBody("token", UpUserNameConstant.TOKEN);
		meBuilder.addTextBody("projectTypeID", upProPlan.getProjectTypeID());
		meBuilder.addTextBody("planID", upProPlan.getPlanID());
		meBuilder.addTextBody("projectName", upProPlan.getProjectName());
		meBuilder.addTextBody("planInvestmentFund", upProPlan.getPlanInvestmentFund().toString());
		meBuilder.addTextBody("description", upProPlan.getDescription()==null?"": upProPlan.getDescription());
		meBuilder.addTextBody("leaderUnit", upProPlan.getLeaderUnit());
		meBuilder.addTextBody("timeLimitDescription", upProPlan.getTimeLimitDescription()==null?"":upProPlan.getTimeLimitDescription());
		meBuilder.addTextBody("needFinishThisYear", upProPlan.getNeedFinishThisYear());
		meBuilder.addTextBody("progressRequireDesc", upProPlan.getProgressRequireDesc()==null?"":upProPlan.getProgressRequireDesc());
		meBuilder.addTextBody("responsibleUnit", upProPlan.getResponsibleUnit());
		meBuilder.addTextBody("planYear", String.valueOf(upProPlan.getPlanYear()));
		meBuilder.addTextBody("adminDivCode", upProPlan.getAdminDivCode());
		meBuilder.addTextBody("isBad5Project", upProPlan.isBad5Project().toString());
		if(upProPlan.getExtend()!=null) {
			meBuilder.addTextBody("extend", upProPlan.getProjectTypeID());
		}
		HttpPost post = new HttpPost(url);
		try {
			HttpEntity reqEntity = meBuilder.build();
			post.setEntity(reqEntity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jo = JSON.parseObject(result);
		if(jo.getBoolean("success")==true){
			return "true";
		}
		result = "计划编号:"+upProPlan.getPlanID()+" 上报失败，失败原因是："+jo.getString("message");
		return result;
	}
	/**
	 * 上报重点项目计划进展服务
	 * @param upProPlanProgress 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadProjectPlanProgress(UpProPlanProgress upProPlanProgress){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadProjectPlanProgress";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", upProPlanProgress.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("progressID", upProPlanProgress.getPlanID()));
		rlist.add(new BasicNameValuePair("planID", upProPlanProgress.getPlanID()));
		rlist.add(new BasicNameValuePair("investmentFund", upProPlanProgress.getInvestmentFund().toString()));
		rlist.add(new BasicNameValuePair("projectStatus", upProPlanProgress.getProjectStatus()));
		rlist.add(new BasicNameValuePair("reportMonth", String.valueOf(upProPlanProgress.getReportMonth())));
		if(upProPlanProgress.getExtend()!=null) {
			rlist.add(new BasicNameValuePair("extend", upProPlanProgress.getExtend() ));
		}HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "进展ID: " + upProPlanProgress.getProgressID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result;
		}
		return upProPlanProgress.getProgressID();
	}

	/**
	 * 获取督导单反馈信息
	 * @param upSteeringFeedback 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadSteeringFeedback(UpSteeringFeedback upSteeringFeedback){
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadSteeringFeedback";
		MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
		meBuilder.addTextBody("userName", upSteeringFeedback.getUserName());
		meBuilder.addTextBody("authKey", UpUserNameConstant.AUTHKEY);
		meBuilder.addTextBody("token", UpUserNameConstant.TOKEN);
		meBuilder.addTextBody("handleDetail", upSteeringFeedback.getHandleDetail());
		meBuilder.addTextBody("feedbackTime", dateFormat(upSteeringFeedback.getFeedbackTime()));
		meBuilder.addTextBody("listID", upSteeringFeedback.getListID());
		List<File> fileList = upSteeringFeedback.getPhotos();
		if(fileList!=null) {
			for (File file : fileList) {
				FileBody fileBody = new FileBody(file);
				meBuilder.addPart("photos", fileBody);
			}
		}
		HttpPost post = new HttpPost(url);
		try {
			HttpEntity reqEntity = meBuilder.build();
			post.setEntity(reqEntity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jo = JSON.parseObject(result);
		if(jo.getBoolean("success")==true){
			return "true";
		}
		result = "督导单编号:"+upSteeringFeedback.getListID()+" 上报失败，失败原因是："+jo.getString("message");
		return result;
	}

	/**
	 * 转化日期格式为 YYYY/MM/DD HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String a =sdf.format(date);
		return sdf.format(date);
	}
	/**
	 * 河长信息上报服务
	 * @param uploadRiverMaster 在UserName属性中填写要上报的平台
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String uploadRiverMaster(UploadRiverMaster uploadRiverMaster) {
		/*HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadRiverMaster";
		MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
		meBuilder.addTextBody("userName", uploadRiverMaster.getUserName());
		meBuilder.addTextBody("authKey", UpUserNameConstant.AUTHKEY);
		meBuilder.addTextBody("token", UpUserNameConstant.TOKEN);
		meBuilder.addTextBody("masterID", uploadRiverMaster.getMasterID());
		meBuilder.addTextBody("masterName", uploadRiverMaster.getMasterName());
		meBuilder.addTextBody("masterPosition", uploadRiverMaster.getMasterPosition()==null?"":uploadRiverMaster.getMasterPosition());
		meBuilder.addTextBody("masterMobile", uploadRiverMaster.getMasterMobile()==null?"":uploadRiverMaster.getMasterMobile());
		meBuilder.addTextBody("masterLevel", uploadRiverMaster.getMasterLevel().toString());
		//县级以下不必须
			meBuilder.addTextBody("contactUnit", uploadRiverMaster.getContactUnit()==null?"":uploadRiverMaster.getContactUnit());
			meBuilder.addTextBody("contactNumber", uploadRiverMaster.getContactNumber()==null?"":uploadRiverMaster.getContactNumber());

		meBuilder.addTextBody("organizationName", uploadRiverMaster.getOrganizationName()==null?"":uploadRiverMaster.getOrganizationName());
		meBuilder.addTextBody("riverID",uploadRiverMaster.getRiverID());
		HttpPost post = new HttpPost(url);
		try {
			HttpEntity reqEntity = meBuilder.build();
			post.setEntity(reqEntity);
			response = new DefaultHttpClient().execute(post);
			result=EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jo = JSON.parseObject(result);
		if(jo.getBoolean("success")==true){
			return "true";
		}
		result = "用户编号:"+uploadRiverMaster.getMasterID()+" 上报失败，失败原因是："+jo.getString("message");
		return result;*/
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadRiverMaster";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", uploadRiverMaster.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("masterID", uploadRiverMaster.getMasterID()));
		rlist.add(new BasicNameValuePair("riverID", uploadRiverMaster.getRiverID()));
		rlist.add(new BasicNameValuePair("masterName", uploadRiverMaster.getMasterName()));
		rlist.add(new BasicNameValuePair("masterPosition", uploadRiverMaster.getMasterPosition()==null?"":uploadRiverMaster.getMasterPosition()));
		rlist.add(new BasicNameValuePair("masterMobile", uploadRiverMaster.getMasterMobile()==null?"":uploadRiverMaster.getMasterMobile()));
		rlist.add(new BasicNameValuePair("masterLevel", uploadRiverMaster.getMasterLevel().toString()));
		rlist.add(new BasicNameValuePair("contactUnit", uploadRiverMaster.getContactUnit()==null?"":uploadRiverMaster.getContactUnit()));
		rlist.add(new BasicNameValuePair("contactUnit", uploadRiverMaster.getMasterLevel().toString()));
		rlist.add(new BasicNameValuePair("contactNumber", uploadRiverMaster.getContactNumber()==null?"":uploadRiverMaster.getContactNumber()));
		rlist.add(new BasicNameValuePair("organizationName", uploadRiverMaster.getOrganizationName()==null?"":uploadRiverMaster.getOrganizationName()));
		String result = post(url,rlist);
		if(!result.equals("500")) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "用户编号:" + uploadRiverMaster.getMasterID() + " 上报失败，失败原因是：" + jo.getString("message");
		}else{
			result = "用户编号:" + uploadRiverMaster.getMasterID() + " 上报失败，失败原因是：" +500 ;
		}
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
			body = EntityUtils.toString(entity, "UTF-8");
			if (entity != null) {
				entity.consumeContent();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String upDatePatrol(UpParolerecord parolerecord) {
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UpdatePatrol";
//		String url = "";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", parolerecord.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("patrolID", parolerecord.getPatrolID()));
		rlist.add(new BasicNameValuePair("endTime", dateFormat(parolerecord.getEndTime())));
		rlist.add(new BasicNameValuePair("length", parolerecord.getLength().toString()));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(response.getStatusLine().getStatusCode()==200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "巡查ID: " + parolerecord.getPatrolID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result+"    500";
		}
		return parolerecord.getPatrolID();
	}

	public static String uploadRiverSectionWaterQuality(UpRiverSectionWaterQuality upRiverSectionWaterQuality) {
		HttpResponse response = null;
		String result=null;
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadRiverSectionWaterQuality";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", upRiverSectionWaterQuality.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));//
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("sectionID", upRiverSectionWaterQuality.getSectionID()));
		rlist.add(new BasicNameValuePair("year", upRiverSectionWaterQuality.getYear()));
		rlist.add(new BasicNameValuePair("month", upRiverSectionWaterQuality.getMont()));
		rlist.add(new BasicNameValuePair("waterQuality", upRiverSectionWaterQuality.getWaterQuality()));
		rlist.add(new BasicNameValuePair("transparent", upRiverSectionWaterQuality.getTransparent()));
		rlist.add(new BasicNameValuePair("PH", upRiverSectionWaterQuality.getPH()));
		rlist.add(new BasicNameValuePair("DO", upRiverSectionWaterQuality.getDO()));
		rlist.add(new BasicNameValuePair("CODMn", upRiverSectionWaterQuality.getCODMn()));
		rlist.add(new BasicNameValuePair("TP", upRiverSectionWaterQuality.getTP()));
		rlist.add(new BasicNameValuePair("NH3N", upRiverSectionWaterQuality.getNH3N()));
		rlist.add(new BasicNameValuePair("TN", upRiverSectionWaterQuality.getTN()==null?"":upRiverSectionWaterQuality.getTN()));
		rlist.add(new BasicNameValuePair("integratedPollutionIndex", upRiverSectionWaterQuality.getIntegratedPollutionIndex()==null?"":upRiverSectionWaterQuality.getIntegratedPollutionIndex()));
		rlist.add(new BasicNameValuePair("measureTime", upRiverSectionWaterQuality.getMeasureTime()==null?"":dateFormat(upRiverSectionWaterQuality.getMeasureTime())));
		rlist.add(new BasicNameValuePair("remark", upRiverSectionWaterQuality.getRemark()==null?"":upRiverSectionWaterQuality.getRemark()));
		HttpPost post = new HttpPost(url);
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			response = new DefaultHttpClient().execute(post);
			result= EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() == 200) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			result = "断面编号: " + upRiverSectionWaterQuality.getSectionID() + " 上报失败，失败原因是：" + jo.getString("message");
			return result;
		}
		return upRiverSectionWaterQuality.getSectionID();
	}
	/**
	 * 删除河道信息
	 * @param ReachID 河道ID
	 * @param userName 要删除的平台,参照UploadUserName类
	 * @return 若成功，返回"true"
	 * 	若失败，返回错误信息
	 */
	public static String delReach(String ReachID,String userName){
		HttpClient httpclient = new DefaultHttpClient();
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/DeleteRiver";
//		String url = "";
		HttpPost post = new HttpPost(url);
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", userName));
		rlist.add(new BasicNameValuePair("authKey", "1"));
		rlist.add(new BasicNameValuePair("token", "1"));
		rlist.add(new BasicNameValuePair("riverID", ReachID));
		String result=null;
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(rlist,"UTF-8");
			post.setEntity(entity);
			HttpResponse response=new DefaultHttpClient().execute(post);
			result = EntityUtils.toString(response.getEntity());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jo = JSON.parseObject(result);
		if(jo.getBoolean("success")==true){
			return "true";
		}
		result = "河道ID: "+ReachID+" 删除失败，失败原因是："+jo.getString("message");
		return result;

	}
	public static String delUser(String userid,String userName){
	String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/DeleteRiverMaster";
	List<NameValuePair> rlist = new ArrayList<NameValuePair>();
	rlist.add(new BasicNameValuePair("userName", userName));
	rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));
	rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
	rlist.add(new BasicNameValuePair("masterID", userid));
	String result = post(url,rlist);
	if(!result.equals("500")) {
		JSONObject jo = JSON.parseObject(result);
		if (jo.getBoolean("success") == true) {
			return "true";
		}
		return result;
	}
	return "500";
}

	public static String uploadPurposeCheck(ExeAssChairmanElectronic exeAssChairmanElectronic,String year,String month) {
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadPurposeCheck";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", exeAssChairmanElectronic.getPlatformName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("checkID", exeAssChairmanElectronic.getUploadcode()));
		rlist.add(new BasicNameValuePair("riverMasterID", exeAssChairmanElectronic.getChairmanid()));
		rlist.add(new BasicNameValuePair("baseScore", exeAssChairmanElectronic.getBasicinformationscore().toString()));
		rlist.add(new BasicNameValuePair("patrolScore", exeAssChairmanElectronic.getPatrolstandardinformationscore().toString()));
		rlist.add(new BasicNameValuePair("patrolRecordScore",exeAssChairmanElectronic.getPatrolriverrecordscore().toString()));
		rlist.add(new BasicNameValuePair("patrolTrailScore", exeAssChairmanElectronic.getValidpatrolrivertrackscore().toString()));
		rlist.add(new BasicNameValuePair("problemDealScore", exeAssChairmanElectronic.getEventdisposescore().toString()));
		rlist.add(new BasicNameValuePair("otherScore", String.valueOf(exeAssChairmanElectronic.getAdditionitemscore()+exeAssChairmanElectronic.getSpecialscore())));
		rlist.add(new BasicNameValuePair("year", year));
		rlist.add(new BasicNameValuePair("month", month));
		String result = post(url,rlist);
		return result;
	}

	public static String uploadRiverMinister(UploadRiverMinister uploadRiverMinister) {
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/UploadRiverMinister";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", uploadRiverMinister.getUserName()));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("ministerID", uploadRiverMinister.getMinisterID()));
		rlist.add(new BasicNameValuePair("ministerName", uploadRiverMinister.getMinisterName()));
		rlist.add(new BasicNameValuePair("ministerPosition", uploadRiverMinister.getMinisterPosition()));
		if(StringUtil.isNotEmptyStr(uploadRiverMinister.getMinisterPhone())){
			rlist.add(new BasicNameValuePair("ministerPhone", uploadRiverMinister.getMinisterPhone()));
		}
		rlist.add(new BasicNameValuePair("adminDivCode", uploadRiverMinister.getAdminDivCode()));
		rlist.add(new BasicNameValuePair("ministerLevel", uploadRiverMinister.getMinisterLevel()));
		String result = post(url,rlist);
		return result;
	}

	public static String delRiverMinister(String riverMinister, String userName) {
		String url = "http://web.dcyun.com:10096/rivermaster/api/Upload/DeleteRiverMinister";
		List<NameValuePair> rlist = new ArrayList<NameValuePair>();
		rlist.add(new BasicNameValuePair("userName", userName));
		rlist.add(new BasicNameValuePair("authKey", UpUserNameConstant.AUTHKEY));
		rlist.add(new BasicNameValuePair("token", UpUserNameConstant.TOKEN));
		rlist.add(new BasicNameValuePair("ministerID", riverMinister));
		String result = post(url,rlist);
		if(!result.equals("500")) {
			JSONObject jo = JSON.parseObject(result);
			if (jo.getBoolean("success") == true) {
				return "true";
			}
			return result;
		}
		return "500";
	}
}
