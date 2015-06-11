package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
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

public class GroupTest extends AbstractHttpTest {
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
		
		GroupTest o = new GroupTest();
		// o.testRegSuccess();
		//o.testMyListSuccess();
//o.testGroupListSuccess();
		o.testAddSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(GroupTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testRegSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		GroupRegJsonform form = new GroupRegJsonform();
		form.setName("jbb");
		form.setGroup_uuid("testuuid");
		form.setTel("13980223889");
		String password = "123456";
		form.setPassword(MD5Until.getMD5String(password));

		form.setAddress("成都市青羊区");
		form.setBrand_name("金苹果");
		form.setCompany_name("金苹果航空港幼儿园-5");
		form.setLink_tel("028-85467899");
		form.setMap_point("116.387884,39.888809");
		form.setType(1);

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/group/reg.json", input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构注册-成功", response.getText().indexOf("success") != -1);

	}

	public void testGroupListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/group/list.json");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	public void testMyListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/group/myList.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		GroupRegJsonform form = new GroupRegJsonform();

		form.setAddress("成都市青羊区");
		form.setBrand_name("金苹果");
		form.setCompany_name("金苹果航空港幼儿园-11");
		form.setLink_tel("028-85467899");
		form.setMap_point("116.387884,39.888809");
		form.setType(1);
		form.setUuid("91ba8426-641f-471d-a252-07132e11934e");

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/group/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构增加-成功", response.getText().indexOf("success") != -1);

	}

}
