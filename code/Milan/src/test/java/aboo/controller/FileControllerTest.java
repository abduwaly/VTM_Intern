package aboo.controller;

import aboo.bean.FileInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by admin on 2017/5/22.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:dispatcher-servlet.xml"})
public class FileControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private FileController fc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        fc = this.wac.getBean(FileController.class);
    }

    @Test
    public void testSearch() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/file/searchByLen/15")).andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/file/searchByLastModified/5644845")).andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/file/searchByExtension/jpg")).andDo(print());
    }

    @Test
    public void testMockSearchAll() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/file/all"))
                .andDo(print());
    }

    @Test
    public void testSearchByName() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/file/searchByName/foe.doc"))
                .andDo(print());
        mockMvc.perform(MockMvcRequestBuilders.get("/file/searchByName/man"))
                .andDo(print());
    }


//    @Test
//    public void testUpload() throws Exception{
//
//        MockMultipartFile multipartFile = new MockMultipartFile("file", "all.txt", "text/plain", "some text".getBytes());
//
//        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file/upload")
//                .file(multipartFile)
//                .requestAttr("method", RequestMethod.POST)
//                .param("file", "1"))
//                .andExpect(status().is(200));
//    }




    @Test
    public void testDownload() throws Exception{
        MockHttpServletRequest request = new MockMultipartHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        long a = System.currentTimeMillis();
        mockMvc.perform(MockMvcRequestBuilders.get("/file/download/95"));
        long b = System.currentTimeMillis();

        System.out.println("io download takes :"+(b-a));

    }

    @Test
    public void testNioDownload() throws Exception{
        MockHttpServletRequest request = new MockMultipartHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        long c = System.currentTimeMillis();
        mockMvc.perform(MockMvcRequestBuilders.get("/file/nioDownload/95"));
        long d = System.currentTimeMillis();

        System.out.println("nio download takes :"+(d-c));

    }


}
