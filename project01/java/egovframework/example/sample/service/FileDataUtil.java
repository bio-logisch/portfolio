package egovframework.example.sample.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDataUtil {
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Resource(name = "ReviewService")
	private ReviewService reviewService;
	
	public String[] fileUpload(MultipartFile[] file) throws IOException{
		String[] files=new String[file.length];
		for (int i = 0; i < file.length; i++) {
			if(file[i].getOriginalFilename()!="") {//이 조건문 없으면 파일첨부 안했을시 파일명에 null값 들어가 에러 발생
				String originalName=file[i].getOriginalFilename();
				UUID random = UUID.randomUUID();
				String convertedName = random.toString()+"."+originalName.split("\\.")[1];
				byte[] fileData = file[i].getBytes();
				File target = new File(uploadPath, convertedName);
				FileCopyUtils.copy(fileData, target);
				files[i]=convertedName;
			}else {
				System.out.println(file.length);
			}
		}
		return files;
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource fileDownload(@RequestParam("rno") String rno, @RequestParam("filename") String fileName,HttpServletResponse response) throws IOException {
		File file = new File(uploadPath+"/"+fileName);
		List<String> oName = reviewService.fOriginalList(rno);
		List<String> cName = reviewService.fConvertedList(rno);
		for (int i = 0; i < cName.size(); i++) {
			if(fileName.equals(cName.get(i))) {
				fileName=oName.get(i);
			}
		}
		fileName = textEncode(fileName, cName.size());
			
		response.setContentType("application/download; utf-8");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
		return new FileSystemResource(file);
	}
	
	private String textEncode(String fileName, int loop) {
		for (int i = 0; i < loop; i++) {
				StringBuilder encodedName = new StringBuilder();
				for (int j = 0; j < fileName.length(); j++) {
					if(fileName.charAt(j) > 255) {
						 try {
							encodedName.append(URLEncoder.encode(String.valueOf(fileName.charAt(j)), "UTF-8"));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}else {
						encodedName.append(fileName.charAt(j));
					}
				}
				fileName = encodedName.toString();
		}
		return fileName;
	}
}
