package marcopolo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import marcopolo.Spitter;
import marcopolo.SpitterForm;
import marcopolo.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author luopeng
 * @date 2019/10/1 21:18
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    //@RequestMapping(value = "/register", method = RequestMethod.POST)
    //public String processRegistration(@Valid Spitter spitter, Errors errors) {
    //    //校验spitter输入，如果错误返回表单
    //    if (errors.hasErrors()) {
    //        return "registerForm";
    //    }
    //    //保存Spitter
    //    spitterRepository.save(spitter);
    //    //从定向到基本信息页
    //    return "redirect:/spitter/" + spitter.getUsername();
    //}

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid SpitterForm spitterForm, Errors errors) throws IOException {
        //校验spitter输入，如果错误返回表单
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        //保存Spitter
        spitterRepository.save(spitter);
        MultipartFile multipartFile = spitterForm.getProfilePicture();
        multipartFile.transferTo(new File("/tmp/spittr/" + spitter.getUsername() + ".jpg"));
        //从定向到基本信息页
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }


}
