package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author luopeng
 * @date 2019/10/16 22:49
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestPart("file") MultipartFile file, Model model) throws IOException {
      String fileName = new String(file.getOriginalFilename().getBytes("UTF-8"));

      //使用multipartFile的transferTo方法将文件存放到桌面
        file.transferTo(new File("C:\\Users\\18370\\Desktop" + file.getOriginalFilename()));
        model.addAttribute("fileName", fileName);
        model.addAttribute("fileSize",file.getSize());

        return "showFile";
    }

}
