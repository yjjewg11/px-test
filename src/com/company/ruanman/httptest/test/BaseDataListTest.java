package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.news.SystemConstants;
import com.company.news.jsonform.BaseDataListJsonform;
import com.company.news.jsonform.BaseDataTypeJsonform;
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

public class BaseDataListTest extends AbstractHttpTest {
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
		
		BaseDataListTest o = new BaseDataListTest();
		// o.testRegSuccess();
		//o.testUpdateSuccess();
        
		//o.testListSuccess();
		
		o.testAddSuccess();
		
		//o.testUpdateSuccess();
		
		//o.testDeleteSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(BaseDataListTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAddSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		BaseDataListJsonform form = new BaseDataListJsonform();
		form.setDatakey("1");
		form.setDescription("123456");
		form.setDatavalue("dfadsf");
		form.setEnable(1);
		form.setTypeuuid("d58d1ba6-2731-462d-b734-0546f25366d1");

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/basedatalist/save.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("成功", response.getText().indexOf("success") != -1);

	}

	public void testListSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest
		WebRequest request = new GetMethodWebRequest(TestConstants.host
				+ "rest/basedatalist/getBaseDataListByTypeuuid.json"
				+user.addParameter_JSESSIONID()+"&typeuuid=0f94ebf7-318f-4f0c-af83-a65a2f23125c");

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

		int key=5;
		String value="one banji";
			String description="yige";
			String typeuuid="0f94ebf7-318f-4f0c-af83-a65a2f23125c";
			int enable=0;
			String uuid="d53f2136-0b54-4478-bbd7-f762966a6dd9";
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/basedatalist/save.json"+user.addParameter_JSESSIONID()+
				"&datavalue="+value+"&description="+description+"&datakey="+key+"&typeuuid="+typeuuid+"&enable="+enable
				+"&uuid="+uuid);

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
				TestConstants.host + "rest/basedatalist/delete.json"+user.addParameter_JSESSIONID()+
				"&uuid=6730242a-a5a3-4c28-929b-8dbe172a3ff9");

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("删除-成功", response.getText().indexOf("success") != -1);

	}
	
	

}
