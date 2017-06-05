package aboo.controller;

import aboo.bean.FileInfo;
import aboo.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.util.List;


/**
 * 文件的Controller
 * Created by admin on 2017/5/16.
 *
 * @author Aboo
 *
 */
@Api(value = "文件的controller")
@Controller
@RequestMapping("/file")
public class FileController {
    private Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fs;

    /**
     * 查看所有的文件信息
     * @return {@link FileInfo}的List
     */
    @ApiOperation(value = "查看所有文件信息")
    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<FileInfo> findAll(){ return fs.showAll();}

    /**
     * 根据文件名查询文件
     * @param filename 文件名，从请求url中取得
     * @return 返回匹配的{@link FileInfo}
     */
    @ApiOperation(value = "查询文件[根据文件名]",notes = "根据url里的filename查看文件信息")
    @ResponseBody
    @RequestMapping(value = "/searchByName/{filename:.+}",method = RequestMethod.GET)
    public FileInfo searchByName(@PathVariable String filename){

        log.debug(""+fs.findByFilename(filename)+","+filename);

        return fs.findByFilename(filename);
    }

    /**
     * 根据最后修改时间查询文件
     * @param last_modified 最后修改时间，从url中取得
     * @return 返回匹配的 {@link FileInfo}的List
     */
    @ApiOperation(value = "查询文件[根据最后修改时间]",notes = "根据url里的last_modified查看文件信息")
    @ResponseBody
    @RequestMapping(value = "/searchByLastModified/{last_modified}",method = RequestMethod.GET)
    public List<FileInfo> searchByLastModified(@PathVariable long last_modified){
        log.debug("searchByLastModified:"+last_modified);
        return fs.findByLastModified(last_modified);
    }

    /**
     * 根据文件的扩展名查询文件
     * @param extension 扩展名，从url中取得
     * @return 返回匹配的 {@link FileInfo}的List
     */
    @ApiOperation(value = "查询文件[根据文件名]",notes = "根据url里的extension查看文件信息")
    @ResponseBody
    @RequestMapping(value = "/searchByExtension/{extension}",method = RequestMethod.GET)
    public List<FileInfo> searchByExtension(@PathVariable String extension){
        log.debug("searchByExtension:"+extension);
        return fs.findByExtension(extension);
    }

    /**
     * 根据文件长的查询文件
     * @param len 文件长度（单位为byte），从url中取得
     * @return 返回匹配的 {@link FileInfo}的List
     */
    @ApiOperation(value = "查询文件[根据文件长度]",notes = "根据url里的len查看文件信息")
    @ResponseBody
    @RequestMapping(value = "/searchByLen/{len}",method = RequestMethod.GET)
    public List<FileInfo> searchByLength(@PathVariable long len){
        log.debug("searchByLen:"+len);
        return fs.findByLen(len);
    }

    /**
     * 上传文件
     * @param file
     * @param request
     * @return 上传成功，则返回文件上传路径；上传失败，则返回失败信息
     */
    @ApiOperation(value = "上传文件",notes = "上传文件的大小不超过1G")
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException,IllegalStateException {


        String path = request.getServletContext().getRealPath("WEB-INF/Files");

        if (!file.isEmpty()) {

            File dir = new File(path);
            if(!dir.exists()){   dir.mkdirs();}

            String originalName = file.getOriginalFilename();

            File localFile = new File(path+File.separator+originalName);

            //如果与已有文件冲突，将覆盖他
            if(fs.existFile(originalName)){
                fs.deleteByName(originalName);
            }

            //将文件写入磁盘
            file.transferTo(localFile);

            //取文件信息(后缀名 & MimeType)
            String extension=null;
            if(originalName.split("\\.").length >1){
                extension = originalName.substring(originalName.lastIndexOf(".")+1);
            }
            String mime_type = request.getServletContext().getMimeType(originalName);

            //持久化文件信息
            fs.saveInfo(originalName,extension,mime_type,System.currentTimeMillis(),file.getSize());

            log.debug("upload success ："+localFile);
            return "upload_dir:"+localFile;  //返回文件保存的路径


        }else{
            throw new Error("Empty file is rejected!");
        }

    }


    /**
     * 根据文件id下载文件  (IO)
     * @param id  文件id，从url中取得
     * @param request
     * @param response
     * @throws IOException  下载文件过程中，IO操作出现异常时，抛出异常
     */
    @ApiOperation(value = "下载文件",notes = "根据url里文件id来下载文件")
    @RequestMapping(value="/download/{id}", method = RequestMethod.GET)
    public void download(@PathVariable("id") Long id,HttpServletRequest request,HttpServletResponse response) throws IOException {

        if (id != null && fs.exists(id)) {
            FileInfo fileInfo = fs.findById(id);
            String filename = fileInfo.getFile_name();

            String realPath = request.getServletContext().getRealPath("WEB-INF/Files/");
            File file = new File(realPath, filename);

            if (file.exists()) {
                response.setContentType(fileInfo.getMime_type());// 设置Content-Type为文件的MimeType
                response.addHeader("Content-Disposition", "attachment;filename=" + filename);// 设置文件名
                response.setContentLength((int) fileInfo.getLength());

                //JAVA IO
                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                //Copy bytes from source to destination(outputstream in this example), closes both streams.
                FileCopyUtils.copy(inputStream, response.getOutputStream());

                log.debug("download succeed! ---"+filename);
            }
        }else{
            throw new Error("file who's id="+id+" is not exist!");
        }
    }

    /**
     * 根据文件id下载文件 (NIO)
     * @param id  文件id，从url中取得
     * @param request
     * @param response
     * @throws IOException  下载文件过程中，IO操作出现异常时，抛出异常
     */
    @ApiOperation(value = "下载文件",notes = "根据url里文件id来下载文件")
    @RequestMapping(value="/nioDownload/{id}", method = RequestMethod.GET)
    public void nioDownload(@PathVariable("id") Long id,HttpServletRequest request,HttpServletResponse response) throws IOException {

        if (id != null && fs.exists(id)) {
            FileInfo fileInfo = fs.findById(id);
            String filename = fileInfo.getFile_name();

            String realPath = request.getServletContext().getRealPath("WEB-INF/Files/");
            File file = new File(realPath, filename);

            if (file.exists()) {
                response.setContentType(fileInfo.getMime_type());// 设置Content-Type为文件的MimeType
                response.addHeader("Content-Disposition", "attachment;filename=" + filename);// 设置文件名
                response.setContentLength((int) fileInfo.getLength());

                //NIO 实现
                int bufferSize = 131072;
                FileInputStream fileInputStream = new FileInputStream(file);
                FileChannel fileChannel = fileInputStream.getChannel();
                // 6x128 KB = 768KB byte buffer
                ByteBuffer buff = ByteBuffer.allocateDirect(786432);
                byte[] byteArr = new byte[bufferSize];
                int nRead, nGet;

                try {
                    while ((nRead = fileChannel.read(buff)) != -1) {
                        if (nRead == 0) {
                            continue;
                        }
                        buff.position(0);
                        buff.limit(nRead);
                        while (buff.hasRemaining()) {
                            nGet = Math.min(buff.remaining(), bufferSize);
                            // read bytes from disk
                            buff.get(byteArr, 0, nGet);
                            // write bytes to output
                            response.getOutputStream().write(byteArr);
                        }
                        buff.clear();

                        log.debug("download succeed! ---"+filename);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    buff.clear();
                    fileChannel.close();
                    fileInputStream.close();
                }

            }
        }else{
            throw new Error("file who's id="+id+" is not exist!");
        }
    }


}
