package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
import com.company.news.jsonform.GroupRegJsonform;
import com.company.news.jsonform.StudentJsonform;
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

public class PxStudentTest extends AbstractHttpTest {
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
		
		PxStudentTest o = new PxStudentTest();
		// o.testRegSuccess();
		//o.testListSuccess();
        //o.testGetSuccess();
		o.testAddSuccess();
		
		o.testListSuccess();
		//o.testQuerybyRightSuccess();
		o.testParentContactByMyStudentSuccess();
		o.testGetSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(PxStudentTest.class);
	}




	
	
	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxstudent/getStudentByClassuuid.json"+user.addParameter_JSESSIONID()
				+"&classuuid=4e46f8a7-46d3-4a27-9ce9-b6a6be813b89");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构-成功", response.getText().indexOf("success") != -1);

	}
	
	public void testQuerybyRightSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxstudent/querybyRight.json"+user.addParameter_JSESSIONID()
				+"&classuuid=4e46f8a7-46d3-4a27-9ce9-b6a6be813b89");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构-成功", response.getText().indexOf("success") != -1);

	}
	
	public void testGetSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxstudent/9f4bbe6d-3220-406a-9655-c3e58d6e32ff.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
	
	
	public void testParentContactByMyStudentSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/pxstudent/ParentContactByMyStudent.json"+user.addParameter_JSESSIONID()
				+"&class_uuid=4e46f8a7-46d3-4a27-9ce9-b6a6be813b89");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		StudentJsonform s = new StudentJsonform();

		s.setName("张晓01");
		s.setClassuuid("4e46f8a7-46d3-4a27-9ce9-b6a6be813b89");
		//s.setUuid("9f4bbe6d-3220-406a-9655-c3e58d6e32ff");
		s.setNickname("小甜甜");
		s.setAddress("chengdu");

		String json = JSONUtils.getJsonString(s);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/pxstudent/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}

}
