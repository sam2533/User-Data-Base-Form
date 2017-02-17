package com.um.myapp;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.um.myapp.model.FileBucket;
import com.um.myapp.model.MultiFileBucket;
import com.um.myapp.util.FileValidator;
import com.um.myapp.util.MultiFileValidator;



@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private String UPLOAD_LOCATION = "c:/myDocuments/";
	
	@Autowired
	private FileValidator fileValidator;
	@Autowired
	private MultiFileValidator multiFileValidator;
	
	@InitBinder ("fileBucket")
	protected void InitBinderFileBucket(WebDataBinder binder){
		binder.setValidator(fileValidator);
	}
	@InitBinder("mulltiFileBucket")
	protected void InitBinderMultiFileBucket(WebDataBinder binder){
		binder.setValidator(multiFileValidator);
	}
	
	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to Home Page");	
		return "home";
	}
	@RequestMapping(value="/singleUpload", method=RequestMethod.GET)
	public String singleUploadFile(Model model){
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "singleUpload";
	}
	@RequestMapping(value="/singleUpload", method=RequestMethod.POST)
	public String singleUploadFileSave(@Validated FileBucket fileBucket, BindingResult result, Model model) throws IOException{
		if(result.hasErrors()){
			logger.info("GO Back to Single Upload Page");
			return "singleUpload";
		}
		else{
			logger.info("Fetching file.......");
			MultipartFile multipartFile = fileBucket.getFile();
			
			FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("filename", fileName);
			return "singleFileSave";	
		}	
	}
	@RequestMapping(value="/multiFileUpload", method=RequestMethod.GET)
	public String multiUpload(Model model){
		MultiFileBucket filesModel = new MultiFileBucket();
		model.addAttribute("multiFileBucket", filesModel);
		return "multiFileUpload";
	}
	@RequestMapping(value="/multiFileUpload", method=RequestMethod.POST)
	public String multiUploadSave(@Validated MultiFileBucket multiBucket, BindingResult result, Model model) throws IOException{
		if(result.hasErrors()){
			logger.info("Return to Multi file upload page");
			return "multiFileUpload";
		}
		else{
			logger.info("fething multiple files.....");
			List<String> filenames = new ArrayList<String>();
			
			for(FileBucket bucket : multiBucket.getFiles()){
				FileCopyUtils.copy(bucket.getFile().getBytes(), new File(UPLOAD_LOCATION + bucket.getFile().getOriginalFilename()));
				filenames.add(bucket.getFile().getOriginalFilename());
			}
			model.addAttribute("filenames", filenames);
			return "multiFileSave";
		}
	}
}
