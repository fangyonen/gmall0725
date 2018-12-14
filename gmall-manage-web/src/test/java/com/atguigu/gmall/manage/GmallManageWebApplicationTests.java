package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        String path = GmallManageWebApplicationTests.class.getClassLoader().getResource("tracker.conf").getPath();

        ClientGlobal.init(path);

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(connection,null);

        String[] gifs = storageClient.upload_file("d:/a.PNG", "gif", null);

        //  fdfs的文件路径
        String url = "http://192.168.116.127";

        for (int i = 0; i < gifs.length; i++) {
            url =url +"/"+gifs[i];
        }
        System.out.println(url);
    }

}
