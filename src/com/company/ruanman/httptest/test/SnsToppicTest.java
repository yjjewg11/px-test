package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.news.SystemConstants;
import com.company.news.jsonform.SnsTopicJsonform;
import com.company.ruanman.httptest.AbstractHttpTest;
import com.company.ruanman.httptest.HttpUtils;
import com.company.ruanman.httptest.JSONUtils;
import com.company.ruanman.httptest.TestConstants;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class SnsToppicTest extends AbstractHttpTest {
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
		
		SnsToppicTest o = new SnsToppicTest();
		// o.testRegSuccess();
		//o.testUpdateSuccess();
        
		//o.testListSuccess();
		
		o.testSaveSuccess();
		
		///o.testUpdateSuccess();
		
//		o.testGetSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(SnsToppicTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testSaveSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		SnsTopicJsonform form = new SnsTopicJsonform();
		form.setContent("aaa");
		
		form.setSection_id(10);
		form.setTitle("dd");
		List<Map<String,String>> itemList=new ArrayList();
		Map dd=new HashMap();
		dd.put("uuid", "");
		dd.put("title", "1");
		dd.put("ind", "2");
		itemList.add(dd);
		dd=new HashMap();
		dd.put("uuid", "");
		dd.put("title", "2");
		dd.put("ind", "3");
		itemList.add(dd);
		
		form.setItemList(itemList);

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/snsTopic/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("-成功", response.getText().indexOf("success") != -1);

	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/announcements/queryMyAnnouncements.json"+user.addParameter_JSESSIONID()
				+"&type=2&groupuuid=4df131a6-042e-4808-b03c-94d99533ea12&classuuid=51a05579-cf42-42aa-aafc-4ef0a520e1e8");

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
				+ "rest/announcements/325afe50-c3b9-4baf-899c-68204c871225.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}

}
