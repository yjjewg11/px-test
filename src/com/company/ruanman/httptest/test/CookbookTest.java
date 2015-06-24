package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
import com.company.news.jsonform.CookbookJsonform;
import com.company.news.jsonform.GroupRegJsonform;
import com.company.news.jsonform.UserRegJsonform;
import com.company.news.rest.RestConstants;
import com.company.news.rest.util.MD5Until;
import com.company.news.rest.util.TimeUtils;
import com.company.ruanman.httptest.AbstractHttpTest;
import com.company.ruanman.httptest.HttpUtils;
import com.company.ruanman.httptest.JSONUtils;
import com.company.ruanman.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CookbookTest extends AbstractHttpTest {
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
		
		CookbookTest o = new CookbookTest();
		// o.testRegSuccess();
		//o.testListSuccess();
//o.testGroupListSuccess();
		o.testAddSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(CookbookTest.class);
	}




	
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/cookbook/list.json"+user.addParameter_JSESSIONID()+"&type=1&groupuuid=91ba8426-641f-471d-a252-07132e11934e");

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
		CookbookJsonform form = new CookbookJsonform();
		form.setName("jbb");
		form.setImg("309556cb-3043-4e8c-ac90-29c3234ba545");
		form.setType(1);

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/cookbook/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}

	
	public void testDeleteSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest


		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/cookbook/delete.json"+user.addParameter_JSESSIONID()
				+"&uuid=c9de1bdc-6f33-4aa5-8ae7-8e2220fa008f");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
}
