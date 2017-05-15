package hello;

import hello.search.FileSearchService;
import hello.storage.StorageFileNotFoundException;
import hello.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import hello.webInfo;
import hello.WebInfoService;

import java.awt.Dialog.ModalExclusionType;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@Controller
public class FileUploadController {

    private final StorageService storageService;
    private final FileSearchService fileSearchService;
    
    @Autowired
    WebInfoService webInfoService;
  

 
    @Autowired
    public FileUploadController(StorageService storageService, FileSearchService fileSearchService) {
        this.storageService = storageService;
        this.fileSearchService = fileSearchService;
    }
    
    @RequestMapping("/")
    public String listUploadedFiles(Model model) throws IOException
    {
    	webInfo home=webInfoService.findById(19);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
    	model.addAttribute("home",home);
        return "jsp/Default71a5";
    }
    @RequestMapping("/admin")
    public String admin(Model model) throws IOException
    {
    	List<webInfo> webpages=webInfoService.findAllWebPages();
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
    	model.addAttribute("webpages",webpages);
        return "jsp/example";
    }
    
    
    
    @RequestMapping(value = { "/callpaper" }, method = RequestMethod.GET)
    public String callpaper(Model model){
    
    	webInfo callpaper=webInfoService.findById(10);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
    	model.addAttribute("callpaper",callpaper);
		return "jsp/Default789b";
    }
    
    @RequestMapping(value = { "/submission" }, method = RequestMethod.GET)
    public String submission(Model model){
    	webInfo submission=webInfoService.findById(15);
    	
    	model.addAttribute("submission",submission);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/Defaultd478";
    	
    	
    }
    
    @RequestMapping(value = { "/registation" }, method = RequestMethod.GET)
    public String registation(Model model)
    {
    	
    	webInfo registration=webInfoService.findById(16);
    	model.addAttribute("registration",registration);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/Defaulta8ef";	
    }
    
    @RequestMapping(value = { "/keynotespeaker" }, method = RequestMethod.GET)
    public String keynotespeaker(Model model){
    	webInfo keynotespeaker=webInfoService.findById(17);
    	model.addAttribute("keynotespeaker",keynotespeaker);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/Default6b73";	
    }
    
    @RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
    public String contact(Model model){
    	webInfo contact=webInfoService.findById(20);
    	model.addAttribute("contact",contact);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/Default84ba";	
		
    }
    
    @RequestMapping(value = { "/home_page" }, method = RequestMethod.GET)
    public String homepage(Model model){
    	webInfo home=webInfoService.findById(19);
    	model.addAttribute("home",home);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/Default71a5";	
    }
    @RequestMapping(value = { "/venuehotel" }, method = RequestMethod.GET)
    public String hotelmapping(Model model){
    	webInfo venuehotel=webInfoService.findById(18);
    	model.addAttribute("venuehotel",venuehotel);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/Venue_Hotel";	
    }
    
    @RequestMapping(value = { "/latestnewsFirst" }, method = RequestMethod.GET)
    public String latestnewsFirst(Model model){
    	webInfo webInfo=webInfoService.findById(24);
    	model.addAttribute("firstnews",webInfo);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/index52be";	
    }
    
    
    @RequestMapping(value = { "/latestnewsSecond" }, method = RequestMethod.GET)
    public String latestnewsSecond(Model model){
    	webInfo webInfo=webInfoService.findById(25);
    	model.addAttribute("secondnews",webInfo);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/indexe41c";	
    }
    
    
    @RequestMapping(value = { "/latestnewsThird" }, method = RequestMethod.GET)
    public String latestnewsThird(Model model){
    	webInfo webInfo=webInfoService.findById(26);
    	model.addAttribute("thirdnews",webInfo);
    	webInfo side=webInfoService.findById(27);
    	model.addAttribute("sidebar",side);
		return "jsp/indexc489";	
    }
    
    
	@RequestMapping(value = { "/delete-page-{pageID}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String pageID) {
		int id=Integer.parseInt(pageID);
		webInfoService.deleteUserById(id);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value = { "/new-webpage" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		webInfo webInfo = new webInfo();
		model.addAttribute("webInfo", webInfo);
		return "jsp/regist";
	}

	
	@RequestMapping(value = { "/new-webpage" }, method = RequestMethod.POST)
	public String saveUser(@Valid webInfo webInfo, BindingResult result,
			ModelMap model) 
	{
		webInfoService.saveWebpage(webInfo);
		return "redirect:/admin";
	}
    
    
	@RequestMapping(value = { "/edit-webpage-{pageID}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String pageID, ModelMap model) {
		int id=Integer.parseInt(pageID);
		webInfo webInfo = webInfoService.findById(id);
		model.addAttribute("webInfo", webInfo);
	
		return "jsp/regist";
	}
	
	@RequestMapping(value = { "/edit-webpage-{pageID}" }, method = RequestMethod.POST)
	public String updateUser(@Valid webInfo webInfo, 
			ModelMap model, @PathVariable int pageID) {

	

		webInfoService.updateWebpage(webInfo);

		
		return "redirect:/";
	}
    
    
    
    
    

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    @RequestMapping("/up")
    public String upload(Model model) throws IOException
    {
    	model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "jsp/uploadForm";
    }
    @PostMapping("/up")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/up";
    }
    
  /*  @GetMapping("/search")
    public String searchFiles(@RequestParam("fileName") String name, Model model) throws IOException {
    	model.addAttribute("result",fileSearchService.searchFile(name));
        return "uploadForm";
    }*/
    
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
