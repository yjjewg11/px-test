package com.company.ruanman.httptest;

import com.company.ruanman.httptest.test.AnnouncementsTest;
import com.company.ruanman.httptest.test.ClassNewsTest;
import com.company.ruanman.httptest.test.CookbookPlanTest;
import com.company.ruanman.httptest.test.MessageTest;
import com.company.ruanman.httptest.test.UserinfoTest;



public class MainTest {

	
	public void doman() throws Exception{
		{
			UserinfoTest.main(null);
			AnnouncementsTest o = new AnnouncementsTest();

			o.testGetSuccess();
			
		}
	{
			
		CookbookPlanTest o = new CookbookPlanTest();
		o.testListSuccess();
		o.testGetSuccess();
			
		}

		    


	}
  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    {
    	
    	int c=400;
    	//c=1;
    	for(int i=0;i<c;i++){
    		   Thread t = new Thread(new Runnable(){  
    	            public void run(){  
	    	           try {
						new MainTest().doman();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	            }});  
    	        t.start();  
    	}
		


    }
  }
}
