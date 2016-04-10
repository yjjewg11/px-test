package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.PushMessageJsonform;
import com.company.ruanman.httptest.AbstractHttpTest;
import com.company.ruanman.httptest.HttpUtils;
import com.company.ruanman.httptest.JSONUtils;
import com.company.ruanman.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class PushMessageTest extends AbstractHttpTest {
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
		
		PushMessageTest o = new PushMessageTest();
		// o.testRegSuccess();
		//o.testUpdateSuccess();
        o.testupdateIOSParentVersionSuccess();
		
		//o.testGetSuccess();
		
		///o.testUpdateSuccess();
		
		//o.testGetSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(PushMessageTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testupdateIOSParentVersionSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		PushMessageJsonform form = new PushMessageJsonform();
		form.setUrl("http://mp.weixin.qq.com/s?__biz=MzI2MzAyNTk2MQ==&mid=401940821&idx=1&sn=1fa2bad7b231a7880cca7541be54e72c#rd");
		form.setTitle("家长IOS版本更新");
		form.setMessage("版本更新到1.5");
		form.setType(0);
		

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
//		PostMethodWebRequest request = new PostMethodWebRequest(
//				TestConstants.host + "rest/pushMessage/updateIOSParentVersion.json"+user.addParameter_JSESSIONID(), input,
//				TestConstants.contentType);

		
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/pushMessage/updateIOSTeacherVersion.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("-成功", response.getText().indexOf("success") != -1);

	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/message/list.json"+user.addParameter_JSESSIONID()
				+"&type=0&useruuid=01e3c4d6-53e8-4fd9-b3df-888b7ba52184");

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
				TestConstants.host + "rest/message/delete.json"+user.addParameter_JSESSIONID()+
				"&uuid=47c9b76a-abd6-4ecc-acb6-168935e3cad3");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("删除权限-成功", response.getText().indexOf("success") != -1);

	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/message/47c9b76a-abd6-4ecc-acb6-168935e3cad3.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}

}
