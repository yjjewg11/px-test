package com.company.ruanman.httptest;


import com.company.ruanman.httptest.test.AnnouncementsTest;
import com.company.ruanman.httptest.test.ClassNewsTest;
import com.company.ruanman.httptest.test.UploadFileTest;
import com.company.ruanman.httptest.test.UserinfoTest;

public class MainTest {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    {
      UserinfoTest.main(null);

     // UploadFileTest.main(null);
      AnnouncementsTest.main(null);
      ClassNewsTest.main(null);
    }
  }
}
