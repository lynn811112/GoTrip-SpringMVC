package com.ispan.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ispan.model.Comment;
import com.ispan.service.CommentService;

@Controller
//@RequestMapping("comments")
public class CommentController {

	@Autowired
	private CommentService cService;

//	@GetMapping("/init")
//	public static String initializeData() {
//		InitializeData.insertComments(null);
//		return "comment";
//	}
	
	//lynn在做測試!!!

	@GetMapping("/index")
	public String showIndex(Model model) {
		return "index";
	}
	
	@GetMapping("/comments")
	public String showComments(Model model) {
		List<Comment> comments = cService.getAllComments();
		model.addAttribute("comments", comments);
		return "comment";
	}

	@GetMapping("/comments/new")
	public String showForm(Model model) {
		Comment comment = new Comment();
		model.addAttribute("comment", comment);
		return "comment-insert";
	}

	@PostMapping("/comments/new/save")
	public String saveComment(HttpServletRequest request, @ModelAttribute("comment") Comment comment,
							  @RequestParam("images") List<MultipartFile> files) {

		if (comment.getRating() == null)
			comment.setRating(5);
		
		comment.setDate(new Timestamp(System.currentTimeMillis()));
		
		if (!files.isEmpty()) {
			List<String> filePaths = uploadFiles(request, files);
			if (filePaths.size() >= 1)
				comment.setImage1(filePaths.get(0));
			if (filePaths.size() >= 2)
				comment.setImage2(filePaths.get(1));
			if (filePaths.size() >= 3)
				comment.setImage3(filePaths.get(2));
		}
		cService.saveComment(comment);
		return "redirect:/comments";
	}

	@GetMapping("/comments/update")
	public String showUpdateForm(@RequestParam("id") Integer id, Model model) {
		Comment comment = cService.getComment(id);
		model.addAttribute("comment", comment);
		return "comment-update";
	}

	@PostMapping("/comments/update/save")
	public String saveUpdate(HttpServletRequest request, @ModelAttribute("comment") Comment comment,
							 BindingResult result, @RequestParam("images") List<MultipartFile> files,
							 @RequestParam(value = "existedImages", required=false) List<String> existedFiles,
							 @RequestParam(value = "deleteImages", required=false) List<String> deleteFiles) {

		if (result.hasErrors()) {
			return "redirect:/comments";
		}
		// 圖片以MulipartFile另外處理
		List<String> filePaths = updateFiles(request, files, existedFiles, deleteFiles);
		if (filePaths.size() >= 1)
			comment.setImage1(filePaths.get(0));
		if (filePaths.size() >= 2)
			comment.setImage2(filePaths.get(1));
		if (filePaths.size() >= 3)
			comment.setImage3(filePaths.get(2));
		
		cService.updateComment(comment);
		return "redirect:/comments";
	}

	@PostMapping("/comments/delete")
	public String deleteComment(@RequestParam("id") Integer id, Model model) {
		cService.deleteComment(id);
		return "redirect:/comments";
	}
	
	
//	@GetMapping("/upload_images/{name}")
//	public String getPicture(@PathVariable("name") String name) {
//		return name;
//	}

	
	// 上傳檔案得到 list of output file 相對路徑
	private static List<String> uploadFiles(HttpServletRequest request, List<MultipartFile> files){
		// check if the directory exist, make it if there's not
		String appPath = request.getServletContext().getRealPath("");
		String appSaveDir = "data"+ File.separator + "upload_images";
		String savePath = appPath + appSaveDir;
		System.out.println(savePath);
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		List<String> filePaths = new ArrayList<String>();
		String fileName, newfileName, filePath;
		for (MultipartFile file : files) {
			fileName = file.getOriginalFilename();
			if (fileName != null && fileName.length() != 0) {
				try {
					newfileName = System.currentTimeMillis() + "_" + fileName;
					filePath = savePath + File.separator + newfileName;
					if (saveFile(file.getInputStream(), filePath))
						filePaths.add(appSaveDir + File.separator + newfileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return filePaths;
	}

	// 處裡實際檔案io
	private static Boolean saveFile(InputStream is, String filePath) {
		File saveFile = new File(filePath);
		try (OutputStream os = new FileOutputStream(saveFile);
			 BufferedOutputStream bos = new BufferedOutputStream(os);) {
			byte[] buffer = new byte[1024];
			while (is.read(buffer) != -1) {
				bos.write(buffer);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public static List<String> updateFiles(HttpServletRequest request, List<MultipartFile> files, 
										   List<String> existedFiles, List<String> deleteFiles) {
		// 從既有圖片刪除勾選起來的照片
		if (deleteFiles!= null) {
			System.out.println(deleteFiles);
			for (int i = 0 ; i < deleteFiles.size(); i++) {
				existedFiles.remove(deleteFiles.get(i));					
			}
		}
		
		// 修改時新增的圖片
		List<String> uploadImages = uploadFiles(request, files);
		List<String> updateImages = new ArrayList<String>();
		
		// 沒被刪除的既有圖片+本次新增圖片到list，完成評論圖片修改
		if (existedFiles!= null) {
			updateImages.addAll(existedFiles);
		}
		updateImages.addAll(uploadImages);
		return updateImages;
	}


}
