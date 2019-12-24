package marcopolo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import marcopolo.Spittle;
import marcopolo.SpittleForm;
import marcopolo.data.SpittleRepository;
import marcopolo.exception.DuplicateSpittleException;
import marcopolo.exception.SpittleNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/9/28 20:45
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository1;

    /**
     * 注入SpittleRepository
     */
    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository1 = spittleRepository;
    }

    //@RequestMapping(method = RequestMethod.GET)
    //public String spittles(Model model) {
    //    model.addAttribute(spittleRepository1.findSpittles(Long.MAX_VALUE, 20));
    //    return "spittle";
    //}

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository1.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittles(@PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = spittleRepository1.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm from, Model model) {
        try {
            spittleRepository1.save(new Spittle(null, from.getMessage(), new Date(), from.getLongitude(), from.getLatitude()));
            return "redirect:/spittles";
        } catch (DuplicateSpittleException e) {
            return "error/duplicate";
        }

    }

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDulicateSpittle() {
        return "error/duplicate";
    }
}

