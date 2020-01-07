package com.briup.smart.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.common.utils.exception.UploadImageException;
import com.briup.smart.web.vm.FieldError;

public class Upload {

	public String uploadPicture(MultipartFile file) {
		Collection<FieldError> fs = new HashSet<>();

		System.out.println("file:" + file);
		System.out.println("fileName:" + file.getName());
		// 获取保存路径
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image";
		System.out.println("路径测试：" + path);
		// 定义上传文件的存放位置
		String filePath = path;

		// 判断文件夹是否存在,不存在则创建
		File file1 = new File(filePath);
		if (!file1.exists()) {
			System.out.println("文件不存在");
			file1.mkdirs();
		}

		// 获取上传文件的名字
		String fileName = file.getOriginalFilename();
		System.out.println("图片真实名字：" + fileName);
		Random random = new Random();
		int num = 1 + random.nextInt(100000);
		fileName = num + fileName;
		// 设置路径 路径字符串 名字符串
		File dest = new File(filePath, fileName);
		// 转储
		try {
			System.out.println("保存图片：" + dest);
			file.transferTo(dest);
			System.out.println("上传图片成功");
		} catch (IllegalStateException e) {
			fs.add(new FieldError("error", "非法状态"));
		} catch (IOException e) {
			fs.add(new FieldError("error", "输入异常"));
		}
		System.out.println("FieldError:" + fs);
		if (!fs.isEmpty()) {
			throw new UploadImageException(fs);
		}
		System.out.println("图片name：" + fileName);
		return fileName;
	}

	// 根据图片名称删除图片
	public String deletePicture(String fileName) {
		System.out.println("删除的图片：" + fileName);

		// 获取保存路径
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image";
		System.out.println("路径测试：" + path);

		File file = new File(path);
		File[] list = file.listFiles();
//		for (File f : list) {
//			System.out.println(f.getName());
//			String[] strings = f.getName().split("\\.");
//			if (strings[0].equals(fileName)) {
//				System.out.println("目标图片：" + f.getName());
//				Boolean boolean1 = f.delete();
//				System.out.println(boolean1);
//				return "成功删除图片";
//			}
//		}
		for (File f : list) {
			System.out.println(f.getName());
			if (f.getName().equals(fileName)) {
				System.out.println("目标图片：" + f.getName());
				Boolean boolean1 = f.delete();
				System.out.println(boolean1);
				return "成功删除图片";
			}
		}
		System.out.println("未找到图片：" + fileName);

		return "未找到图片";
	}

}
