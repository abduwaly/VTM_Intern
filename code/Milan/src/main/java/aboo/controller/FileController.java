package aboo.controller;

import aboo.bean.FileInfo;
import aboo.bean.User;
import aboo.service.FileService;
import javafx.scene.control.Separator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import java.util.List;


/**
 * Created by admin on 2017/5/16.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    private Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fs;

    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<FileInfo> find_all(HttpServletRequest request){

        return fs.showAll();
    }

    @ResponseBody
    @RequestMapping(value = "/searchByName/{filename}",method = RequestMethod.GET)
    public FileInfo searchByName(@PathVariable String filename){
        log.debug("searchByName:"+filename);
        return fs.findByFilename(filename);
    }
    @ResponseBody
    @RequestMapping(value = "/searchByLastModified/{last_modified}",method = RequestMethod.GET)
    public List<FileInfo> searchByLastModified(@PathVariable long last_modified){
        log.debug("searchByLastModified:"+last_modified);
        return fs.findByLastModified(last_modified);
    }
    @ResponseBody
    @RequestMapping(value = "/searchByType/{type}",method = RequestMethod.GET)
    public List<FileInfo> searchByType(@PathVariable String type){
        log.debug("searchByType:"+type);
        return fs.findByType(type);
    }
    @ResponseBody
    @RequestMapping(value = "/searchByLen/{len}",method = RequestMethod.GET)
    public List<FileInfo> searchByLength(@PathVariable long len){
        log.debug("searchByLen:"+len);
        return fs.findByLen(len);
    }
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) {


        String path = request.getRealPath("/WEB-INF/Files/");
        log.debug(path);
        // 判断文件是否存在
        if (!file.isEmpty()) {
            log.debug("2");

            File dir = new File(path);
            if(!dir.exists()){   dir.mkdirs();}

            File localFile = new File(path+File.separator+file.getName());
            try {
                file.transferTo(localFile);
                log.debug("保存成功："+localFile);

                return "upload_dir："+localFile;
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

       return "upload faild!!!";
    }

//    @RequestMapping(value = "/download/{filename}",method = RequestMethod.GET)
//    public String download(@PathVariable String filename, HttpServletRequest request, HttpServletResponse response){
//
//
//        if (filename != null) {
//            String realPath = request.getServletContext().getRealPath("WEB-INF/Files/");
//            File file = new File(realPath, filename);
//            log.debug("0");
//
//            if (file.exists()) {
//
//                log.debug("1");
//
//                response.setContentType("application/force-download");// 设置强制下载不打开
//                response.addHeader("Content-Disposition",
//                        "attachment;file=" + filename);// 设置文件名
//                byte[] buffer = new byte[1024];
//                FileInputStream fis = null;
//                BufferedInputStream bis = null;
//                try {
//                    fis = new FileInputStream(file);
//                    bis = new BufferedInputStream(fis);
//                    OutputStream os = response.getOutputStream();
//                    int i = bis.read(buffer);
//                    while (i != -1) {
//                        os.write(buffer, 0, i);
//                        i = bis.read(buffer);
//                    }
//                    log.debug("2");
//
//                } catch (Exception e) {
//                    // TODO: handle exception
//                    e.printStackTrace();
//                } finally {
//                    if (bis != null) {
//                        try {
//                            bis.close();
//                        } catch (IOException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                        }
//                    }
//                    if (fis != null) {
//                        try {
//                            fis.close();
//                        } catch (IOException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//
//        return "";
//    }



}
