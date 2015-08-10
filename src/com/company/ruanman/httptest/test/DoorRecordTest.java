package com.company.ruanman.httptest.test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sf.json.JSONObject;

import com.company.common.SerializableUtil;
import com.company.news.SystemConstants;
import com.company.news.entity.DoorRecord;
import com.company.news.jsonform.DoorRecordJsonform;
import com.company.news.jsonform.DoorUserJsonform;
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

public class DoorRecordTest extends AbstractHttpTest {
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
		
		DoorRecordTest o = new DoorRecordTest();
		// o.testRegSuccess();
		//o.testMyListSuccess();
//o.testGroupListSuccess();
		//o.testAddSuccess();
		o.testAutobindSuccess();
	}

	/**
	 * supply this test cases as part of a suite
	 * 
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(DoorRecordTest.class);
	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testInertSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		DoorRecordJsonform form = new DoorRecordJsonform();
		form.setGroupuuid("004739cb-856b-4fd0-bfa2-8f352561ebf7");
		form.setPrivate_key("5678");
		
		List<DoorRecord> list=new ArrayList<DoorRecord>();
		
		DoorRecord d=new DoorRecord();
		list.add(d);
		
		d.setCardid("123123");
		d.setDoorid("");
		d.setDt(new Date());

		form.setRecordlist(SerializableUtil.ObjectToString(list));
		
		

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/doorrecord/insert.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("机构注册-成功", response.getText().indexOf("success") != -1);

	}

	/**
	 * Verifies that submitting the login form without entering a name results
	 * in a page containing the text "Login failed"
	 **/
	public void testAutobindSuccess() throws Exception {
		WebConversation conversation = new WebConversation();
		// GetMethodWebRequest

		DoorUserJsonform form = new DoorUserJsonform();
		form.setGroupuuid("7ac3897e-b0d8-4a32-ad61-4f4a96496774");
		form.setPrivate_key("5678");
		form.setCardid("12345678");
		form.setUserName("胡晓");
		form.setIdNo("510322198203290695");
		
		

		String json = JSONUtils.getJsonString(form);
		HttpUtils.printjson(json);
		ByteArrayInputStream input = new ByteArrayInputStream(
				json.getBytes(SystemConstants.Charset));
		PostMethodWebRequest request = new PostMethodWebRequest(
				TestConstants.host + "rest/doorrecord/autobind.json"+user.addParameter_JSESSIONID(), input,
				TestConstants.contentType);

		WebResponse response = tryGetResponse(conversation, request);

		HttpUtils.println(conversation, request, response);
		assertTrue("绑定-成功", response.getText().indexOf("success") != -1);

	}


}
