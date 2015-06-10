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

public class RoleTest extends AbstractHttpTest {
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
		
		RoleTest o = new RoleTest();
		// o.testRegSuccess();
		//o.testUpdateSuccess();
        
		o.testListSuccess();
		
		//o.testAddSuccess();
		
		//o.testUpdateSuccess();
		
		//o.testAddSuccess();
		o.testUpdateRightSuccess();
		o.testGetRightSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(RoleTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		String name="园长1";
			String description="新建角色";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/role/add.json"+user.addParameter_JSESSIONID()+"&name="+name+"&description="+description);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("增加-成功", response.getText().indexOf("success") != -1);

	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/role/list.json"+user.addParameter_JSESSIONID());

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	public void testGetRightSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/role/getRight.json"+user.addParameter_JSESSIONID()+"&uuid=2b78f04b-f8f6-49e3-bd80-b378ed2e4a5a");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("列表-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testUpdateSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		String name="家长";
			String description="222222";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/role/update.json"+user.addParameter_JSESSIONID()+
				"&uuid=2b78f04b-f8f6-49e3-bd80-b378ed2e4a5a&name="+name+"&description="+description);

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
				TestConstants.host + "rest/role/delete.json"+user.addParameter_JSESSIONID()+
				"&uuid=3dd64fa1-f155-459b-883d-0ab1d77d5ced");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("删除-成功", response.getText().indexOf("success") != -1);

	}
	
	
	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testUpdateRightSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		String roleuuid="2b78f04b-f8f6-49e3-bd80-b378ed2e4a5a";
			String rightuuid="3bbca1b8-1f3b-4450-aa41-87e65dff72a2,e2d9885f-c5cd-42a1-b588-8ad6a159cb99";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/role/updateRight.json"+user.addParameter_JSESSIONID()+
				"&roleuuid="+roleuuid+"&rightuuid="+rightuuid);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("修改-成功", response.getText().indexOf("success") != -1);

	}
	
	
	

}
