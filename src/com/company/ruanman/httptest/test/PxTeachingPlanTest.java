package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.PxTeachingPlanJsonform;
import com.company.ruanman.httptest.AbstractHttpTest;
import com.company.ruanman.httptest.HttpUtils;
import com.company.ruanman.httptest.JSONUtils;
import com.company.ruanman.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class PxTeachingPlanTest extends AbstractHttpTest {
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
		
		PxTeachingPlanTest o = new PxTeachingPlanTest();
		// o.testRegSuccess();
	//o.testGetSuccess();
//o.testGroupListSuccess();
		o.testAddSuccess();
		o.testListSuccess();
		
		o.testGetSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(PxTeachingPlanTest.class);
	}




	
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxteachingplan/list.json"+user.addParameter_JSESSIONID()
				+"&begDateStr=2015-06-10&endDateStr=2015-06-20&classuuid=51a05579-cf42-42aa-aafc-4ef0a520e1e8");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		PxTeachingPlanJsonform t = new PxTeachingPlanJsonform();

		t.setName("英语课");
		t.setClassuuid("51a05579-cf42-42aa-aafc-4ef0a520e1e8");
		t.setReadyfor("带英语书");
		t.setContext("国际第一的英语认证");
	    //t.setUuid("d673f6aa-e5dd-449b-a1d9-b53ebcfec8ad");

		t.setPlandateStr("2015-06-18 13:00:00");
		t.setDuration("1小时");
		

		String json = JSONUtils.getJsonString(t);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/pxteachingplan/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		
		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}

	
	public void testDeleteSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest


		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/teachingplan/delete.json"+user.addParameter_JSESSIONID()
				+"&uuid=aeb7cedc-eed4-4c38-bf88-a723fd4f7a90");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxteachingplan/2ba67ed4-8180-4318-8a2f-c40efebcf46d.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
}
