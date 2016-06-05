package com.company.ruanman.httptest.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.rest.util.MD5Until;
import com.company.ruanman.httptest.AbstractHttpTest;
import com.company.ruanman.httptest.HttpUtils;
import com.company.ruanman.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class WenjieAdminTest extends AbstractHttpTest {
	  public UserinfoTest user= new UserinfoTest();
	/**
	 * run this testcase as a suite from the command line
	 * 
	 * @param args
	 *            - ignored
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		// junit.textui.TestRunner.run( suite() );
		
		WenjieAdminTest o = new WenjieAdminTest();
	
		
		o.user.testAdminLoginSuccess();
		
		o.testcameraListToDB();
		
		if(true)return;
		
		//注册用户
		
		List<String[]> list=new ArrayList();

		list.add(new String[]{"18980927900","123456"});
		for(String[] s:list){
			System.out.println("tel="+s[0]);
		
			try {
				o.testParentRegSuccess(s[0],s[1]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
//		list.add(new String[]{"13980881207","123456"});
//		list.add(new String[]{"18727598356","123456"});
//		list.add(new String[]{"18108098156","123456"});
//		list.add(new String[]{"18908043910","123456"});
//		list.add(new String[]{"13076065369","123456"});
//		list.add(new String[]{"15608951189","123456"});
//		list.add(new String[]{"13551088254","123456"});
//		list.add(new String[]{"13558750425","123456"});
//		list.add(new String[]{"18782180071","123456"});
//		list.add(new String[]{"13628015695","123456"});
//		list.add(new String[]{"18683627768","123456"});
		
//		已添加
		
		
//		list.add(new String[]{"15559134488","123456"});
//		list.add(new String[]{"13518130328","123456"});
//		list.add(new String[]{"13982262385","123456"});
//		
//		list.add(new String[]{"13980777023","123456"});
//		list.add(new String[]{"18782106966","123456"});
//		
//		list.add(new String[]{"15928443989","123456"});
//		list.add(new String[]{"15008241665","123456"});
//		list.add(new String[]{"18982275502","123456"});
//		list.add(new String[]{"13540451536","123456"});
//		
//		
		//0412
		//新加
//		list.add(new String[]{"18284511413","123456"});
//		list.add(new String[]{"17713578144","123456"});
//		
		//已添加了
//		list.add(new String[]{"15184302483","123456"});//2016-04-12 15:18:43
//		list.add(new String[]{"13688401125","123456"});//2016-04-11 16:54:18
		
//		list.add(new String[]{"15559134488","123456"});//2016-04-11 17:04:51
		
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(WenjieAdminTest.class);
	}
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testcameraListToDB() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/wenjieAdmin/cameraListToDB.json");
		request.setParameter("JSESSIONID", user.getLoginSessionid());
		WebResponse response = tryGetResponse(conversation, request);
		HttpUtils.println(conversation, request, response);
		
		if(response.getText().indexOf("success") != -1){
//			System.out.println("tel="+tel+",md5="+md5);
		}
//		assertTrue("-成功", response.getText().indexOf("success") != -1);

	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testParentRegSuccess(String tel,String password) throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/wenjieAdmin/parentReg.json");
		request.setParameter("JSESSIONID", user.getLoginSessionid());
		request.setParameter("tel", tel);
		
		String md5=MD5Until.getMD5String(password);
		System.out.println("tel="+tel+",md5="+md5);
		request.setParameter("password",md5);
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		
		if(response.getText().indexOf("success") != -1){
//			System.out.println("tel="+tel+",md5="+md5);
		}
//		assertTrue("-成功", response.getText().indexOf("success") != -1);

	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/accounts/list.json"+user.addParameter_JSESSIONID()
				+"&begDateStr=2015-03-01 12:03:02&groupuuid=4df131a6-042e-4808-b03c-94d99533ea12&classuuid=23101220-0cae-423c-acda-b3642ddcb501");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testDeleteSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/announcements/delete.json"+user.addParameter_JSESSIONID()+
				"&uuid=007acd53-f63b-4547-96b7-9f8862dc7d6c");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("删除权限-成功", response.getText().indexOf("success") != -1);

	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/accounts/941a9fc0-fbed-4a8f-a5fe-4596a15da772.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}

}
