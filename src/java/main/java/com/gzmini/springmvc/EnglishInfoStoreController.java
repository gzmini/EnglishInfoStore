package main.java.com.gzmini.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import main.java.com.gzmini.bo.EnglishInfoBo;
import main.java.com.gzmini.bo.EnglishSentenceBo;
import main.java.com.gzmini.service.Factory;
import main.java.com.gzmini.vo.EnglishInfoVo;
import main.java.com.gzmini.vo.EnglishSentenceVo;

@Controller
public class EnglishInfoStoreController {
    @RequestMapping(value = "NewWord", method = RequestMethod.POST)
    public String NewWord(@RequestParam("wordname")String wordname,
                          @RequestParam("worddescribe")String worddescribe,
                          Model model) {
        int o_Result = 0;
        if(!wordname.isEmpty() && !worddescribe.isEmpty()) {
            EnglishInfoVo englishinfovo = new EnglishInfoVo();
            englishinfovo.setWordname(wordname.trim());
            englishinfovo.setWorddescribe(worddescribe);
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishInfoBo englishinfobo = factory.createEnglishInfoBO();
                o_Result = englishinfobo.NewWord(englishinfovo);
            }
            catch(Exception exception){
            }
            finally {
                factory.colseConnection();
            }
        }
        else
            return "error";
        model.addAttribute("content",wordname);
        if (o_Result > 0)
            return "success";
        else
            return "existence";
    }
    @RequestMapping(value = "NewSentence", method = RequestMethod.POST)
    public String NewSentence(@RequestParam("sentence")String sentence,
                              Model model){
        if(!sentence.isEmpty()) {
            EnglishSentenceVo englishsentencefovo = new EnglishSentenceVo();
            englishsentencefovo.setSentence(sentence.trim());
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishSentenceBo englishSentenceBo = factory.createEnglishSentenceBO();
                englishSentenceBo.NewSentence(englishsentencefovo);
            }
            catch(Exception exception){
            }
            finally {
                factory.colseConnection();
            }
        }
        else
            return "error";
        model.addAttribute("content",sentence);
        return "success";

    }
    @RequestMapping(value = "ListSentence")
    public ModelAndView ListSentence(){
        List<EnglishSentenceVo> englishsentenceList = new ArrayList<EnglishSentenceVo>();
        Factory factory = new Factory();
        try {
            factory.openConnection();
            EnglishSentenceBo englishsentencebo = factory.createEnglishSentenceBO();
            englishsentenceList = englishsentencebo.getEnglishSentenceList();
        }
        catch(Exception exception){
        }
        finally {
            factory.colseConnection();
        }

        ModelAndView mav = new ModelAndView("listsentence");
        mav.addObject("esl", englishsentenceList);
        return mav;
    }
    @RequestMapping(value = "SearchWord", method = RequestMethod.POST)
    public ModelAndView SearchWord(@RequestParam("searchkeyword")String searchkeyword,
                          @RequestParam("language")String language) {
        List<EnglishInfoVo> englishinfoList = new ArrayList<EnglishInfoVo>();
        if (!searchkeyword.isEmpty()) {
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishInfoBo englishinfobo = factory.createEnglishInfoBO();
                if (language.equals("E"))
                    englishinfoList = englishinfobo.getEnglishInfoByWordName(searchkeyword);

                else
                    englishinfoList = englishinfobo.getEnglishInfoByWordDescribe(searchkeyword);
            } catch (Exception exception) {
            } finally {
                factory.colseConnection();
            }
        }
        ModelAndView mav = new ModelAndView("searchlist");
        mav.addObject("searchlist", englishinfoList);
        return mav;
    }
    @RequestMapping(value = "DeleteWord", method = RequestMethod.GET)
    public String DeleteWord(@RequestParam("id")int id) {
        if(id > 0) {
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishInfoBo englishinfobo = factory.createEnglishInfoBO();
                englishinfobo.DeleteWord(id);
            }
            catch(Exception exception){
            }
            finally {
                factory.colseConnection();
            }
        }
        else
            return "error";
        return "delete";
    }
    @RequestMapping(value = "DeleteSentence", method = RequestMethod.GET)
    public String DeleteSentence(@RequestParam("id")int id) {
        if(id > 0) {
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishSentenceBo englishSentenceBo = factory.createEnglishSentenceBO();
                englishSentenceBo.DeleteSentence(id);
            }
            catch(Exception exception){
            }
            finally {
                factory.colseConnection();
            }
        }
        else
            return "error";
        return "delete";
    }
    @RequestMapping(value = "/EditWord", method = RequestMethod.GET)
    public String EditWord(@RequestParam("id")int id
                            , ModelMap model) {

        EnglishInfoVo englishinfovo = new EnglishInfoVo();
        Factory factory = new Factory();
        try {
            factory.openConnection();
            EnglishInfoBo englishinfobo = factory.createEnglishInfoBO();
            englishinfovo = englishinfobo.getEnglishInfoById(id);
        }
        catch(Exception exception){
        }
        finally {
            factory.colseConnection();
        }
        model.addAttribute("id", englishinfovo.getId());
        model.addAttribute("wordname", englishinfovo.getWordname());
        model.addAttribute("worddescribe", englishinfovo.getWorddescribe());
        return "editword";
    }
    @RequestMapping(value = "UpdateWord", method = RequestMethod.POST)
    public String UpdateWord(@RequestParam("id")int id,
                             @RequestParam("worddescribe")String worddescribe) {
        if(!worddescribe.isEmpty()) {
            EnglishInfoVo englishinfovo = new EnglishInfoVo();
            englishinfovo.setId(id);
            englishinfovo.setWorddescribe(worddescribe);
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishInfoBo englishinfobo = factory.createEnglishInfoBO();
                englishinfobo.UpdateWord(englishinfovo);
            }
            catch(Exception exception){
            }
            finally {
                factory.colseConnection();
            }
        }
        else
            return "error";
        return "update";
    }
    @RequestMapping(value = "/EditSentence", method = RequestMethod.GET)
    public String EditSentence(@RequestParam("id")int id
                                , ModelMap model) {

        EnglishSentenceVo englishSentenceVo = new EnglishSentenceVo();
        Factory factory = new Factory();
        try {
            factory.openConnection();
            EnglishSentenceBo englishsentencebo = factory.createEnglishSentenceBO();
            englishSentenceVo = englishsentencebo.getEnglishSentenceById(id);
        }
        catch(Exception exception){
        }
        finally {
            factory.colseConnection();
        }
        model.addAttribute("id", englishSentenceVo.getId());
        model.addAttribute("sentence", englishSentenceVo.getSentence());
        return "editsentence";
    }
    @RequestMapping(value = "UpdateSentence", method = RequestMethod.POST)
    public String UpdateSentence(@RequestParam("id")int id,
                             @RequestParam("sentence")String sentence) {
        if(!sentence.isEmpty()) {
            EnglishSentenceVo englishSentenceVo = new EnglishSentenceVo();
            englishSentenceVo.setId(id);
            englishSentenceVo.setSentence(sentence);
            Factory factory = new Factory();
            try {
                factory.openConnection();
                EnglishSentenceBo englishsentencebo = factory.createEnglishSentenceBO();
                englishsentencebo.UpdateSentence(englishSentenceVo);
            }
            catch(Exception exception){
            }
            finally {
                factory.colseConnection();
            }
        }
        else
            return "error";
        return "update";
    }
}
