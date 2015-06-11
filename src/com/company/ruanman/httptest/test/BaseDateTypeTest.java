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

public class BaseDateTypeTest extends AbstractHttpTest {
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
		
		BaseDateTypeTest o = new BaseDateTypeTest();
		// o.testRegSuccess();
		//o.testUpdateSuccess();
        
		//o.testListSuccess();
		
		//o.testAddSuccess();
		
		//o.testUpdateSuccess();
		
		o.testDeleteSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(BaseDateTypeTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		String name="CDNEW5";
			String description="新建权限";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/basedatatype/add.json"+user.addParameter_JSESSIONID()+"&name="+name+"&description="+description
				+"");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加基础参数-成功", response.getText().indexOf("success") != -1);

	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/basedatatype/list.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("基础数据列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testUpdateSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		String name="CDNEW7";
			String description="222222";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/basedatatype/update.json"+user.addParameter_JSESSIONID()+
				"&uuid=0c9d1973-e6df-445d-a25d-75075cb49758&name="+name+"&description="+description);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("修改-成功", response.getText().indexOf("success") != -1);

	}
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testDeleteSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/basedatatype/delete.json"+user.addParameter_JSESSIONID()+
				"&uuid=0c9d1973-e6df-445d-a25d-75075cb49758");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("删除-成功", response.getText().indexOf("success") != -1);

	}
	
	

}
