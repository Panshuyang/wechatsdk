/*
 * FileIo.java            2010-12-01
 *
 * Copyright (C) 2010 All rights reserved.
 * 
 */
package org.gx.common.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

/**
 * 文件操作类
 * 
 * @author 	Corey	2010-12-01
 * 
 * @version 1.0
 */
public class FileIo {

    private static final Logger logger = Logger.getLogger(FileIo.class.getName());
    
	/**
	 * 写文本文件内容
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8
	 * @return 文本文件完整绝对路径及文件名
	 */
	public static String writeText(String filePathAndName, String fileContent,
			String encoding) {

		if (encoding.equals(""))
			encoding = "UTF-8";
		filePathAndName = filePathAndName.replace(File.separator, "/");
		PrintWriter myFile = null;
		try {
			File myFilePath = new File(filePathAndName);
			if (!myFilePath.exists()) {
				createFolders(filePathAndName.substring(0, filePathAndName
						.lastIndexOf("/")));
				myFilePath.createNewFile();
			}

			myFile = new PrintWriter(myFilePath, encoding);
			myFile.print(fileContent);
			myFile.flush();

		} catch (Exception e) {
			filePathAndName = "";
		} finally {
			if (myFile != null)
				myFile.close();
		}
		return filePathAndName;
	}

	/**
	 * 追加写文本文件内容
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8 默认UTF-8
	 * @return 文本文件完整绝对路径及文件名
	 */
	public static String appendWriteText(String filePathAndName,
			String fileContent, String encoding) {

		if (encoding.equals(""))
			encoding = "UTF-8";
		filePathAndName = filePathAndName.replace(File.separator, "/");
		FileWriter myFile = null;
		try {
			File myFilePath = new File(filePathAndName);
			if (!myFilePath.exists()) {
				return writeText(filePathAndName, fileContent, encoding);
			}

			myFile = new FileWriter(filePathAndName, true);
			myFile.write(fileContent);
			myFile.flush();
			
		} catch (Exception e) {
			filePathAndName = "";
		} finally {
			try {
				if (myFile != null)
					myFile.close();
			} catch (IOException e) {
				filePathAndName = "";
			}
		}
		return filePathAndName;
	}

	/**
	 * 读取文本文件内容
	 * 
	 * @param filePathAndName
	 *            带有完整绝对路径的文件名
	 * @param encoding
	 *            文本文件打开的编码方式 GBK UTF-8
	 * @return 返回文本文件的内容
	 */
	public static String readText(String filePathAndName, String encoding) {
		if (encoding == null)
			encoding = "UTF-8";
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";
		FileInputStream fs = null;
		InputStreamReader isr = null;
		try {
			fs = new FileInputStream(filePathAndName);
			isr = new InputStreamReader(fs, encoding);

			BufferedReader br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					str.append(data + "\n");
				}

			} catch (Exception e) {
				str.append(e.toString());
			} finally {
				if (fs != null)
					fs.close();
				if (isr != null)
					isr.close();
			}
			st = str.toString();
		} catch (IOException es) {
			st = "";
		}
		return st;
	}

	/**
	 * 写二进制文件
	 * 
	 * @param inputStream
	 *            二进制流
	 * @param newpath
	 *            保存路径
	 * @param newfilename
	 *            保存的文件名
	 * @return 保存的文件名
	 */
	public static String writeFile(InputStream inputStream, String newpath,
			String newfilename) {
		FileOutputStream outStream = null;
		try {
			newpath = newpath.replace(File.separator, "/");
			if (newpath.endsWith("/")) {
				newpath = newpath.substring(0, newpath.length() - 1);
			}
			writeText(newpath + "/" + newfilename, "", "");

			outStream = new FileOutputStream(newpath + "/" + newfilename);

			byte[] buffer = new byte[1024 * 5];
			int byteread = 0;
			while ((byteread = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, byteread);
				outStream.flush();
			}
		} catch (Exception ex) {
			newfilename = "";
		} finally {
			try {
				if (outStream != null)
					outStream.close();
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				newfilename = "";
			}
		}

		return newfilename;
	}

	/**
	 * 写二进制文件
	 * 
	 * @param byteA
	 *            二进数组
	 * @param newpath
	 *            保存路径
	 * @param newfilename
	 *            保存的文件名
	 * @return 保存的文件名
	 */
	public static String writeFile(byte[] byteA, String newpath,
			String newfilename) {
		FileOutputStream outStream = null;
		try {
			newpath = newpath.replace(File.separator, "/");
			if (newpath.endsWith("/")) {
				newpath = newpath.substring(0, newpath.length() - 1);
			}
			writeText(newpath + "/" + newfilename, "", "");

			outStream = new FileOutputStream(newpath + "/" + newfilename);
			outStream.write(byteA);
			outStream.flush();

		} catch (Exception ex) {
			newfilename = "";
		} finally {
			try {
				if (outStream != null)
					outStream.close();
			} catch (IOException e) {
				newfilename = "";
			}
		}

		return newfilename;
	}

	/**
	 * 读取二进制文件
	 * 
	 * @param filePathAndName
	 *            带有完整绝对路径的文件名
	 * @return 二进制流
	 */
	public static byte[] readFile(String filePathAndName) {
		byte[] byteA = null;
		try {
			File file = new File(filePathAndName);
			if (file.exists()) {
				InputStream inputStream = new FileInputStream(file);
				inputStream.read(byteA);
				inputStream.close();
			}
		} catch (Exception ex) {
		}
		return byteA;
	}

	/**
	 * 多级目录创建
	 * 
	 * @param 要创建的目录路径
	 * @return 创建好的目录路径
	 */
	public static String createFolders(String multiFolderPath) {
		String cuttentFolder = "";
		try {
			multiFolderPath = multiFolderPath.replace(File.separator, "/");

			String[] multi = multiFolderPath.split("/");
			if (multi.length == 0)
				return "";

			for (int i = 0; i < multi.length; i++) {
				cuttentFolder += multi[i] + "/";
				createFolder(cuttentFolder);
			}

		} catch (Exception e) {
			cuttentFolder = "";
		}
		return cuttentFolder;
	}

	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            目录
	 * @return 返回目录创建后的路径
	 */
	private static String createFolder(String folderPath) {

		try {
			File myFilePath = new File(folderPath);
			if (!myFilePath.exists())
				myFilePath.mkdir();

		} catch (Exception e) {
			folderPath = "";
		}
		return folderPath;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @return Boolean 成功删除返回true 遭遇异常返回false
	 */
	public static boolean deleteFile(String filePathAndName) {
		boolean ret = false;
		try {
			File myDelFile = new File(filePathAndName);
			if (myDelFile.isFile() && myDelFile.exists()) {
				myDelFile.delete();

				ret = true;
			} else {
				ret = false;
			}

		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param filePath
	 *            文件夹完整绝对路径
	 * @return 成功删除返回true 遭遇异常返回false
	 */
	public static boolean deleteAllFile(String filePath) {
		boolean ret = false;
		filePath = filePath.replace(File.separator, "/");
		File file = new File(filePath);

		if (!file.exists()) {
			return ret;
		}

		if (!file.isDirectory()) {
			return ret;
		}
		String[] tempList = file.list();
		File temp = null;

		for (int i = 0; i < tempList.length; i++) {
			if (filePath.endsWith("/")) {
				filePath = filePath.substring(0, filePath.length() - 1);
			}
			temp = new File(filePath + File.separator + tempList[i]);

			if (temp.isFile()) {
				temp.delete();
				ret = true;
			} else if (temp.isDirectory()) {
				deleteAllFile(filePath + "/" + tempList[i]);// 先删除文件夹里面的文件
				deleteFolder(filePath + "/" + tempList[i]);// 再删除空文件夹
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 *            文件夹完整绝对路径
	 * @return 成功删除返回true 遭遇异常返回false
	 */
	public static boolean deleteFolder(String folderPath) {
		boolean ret = false;
		try {
			deleteAllFile(folderPath);// 删除完里面所有内容
			File myFilePath = new File(folderPath);
			myFilePath.delete(); // 删除空文件夹
			ret = true;
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新绝对路径带文件名
	 * @return 成功复制返回true 遭遇异常返回false
	 */
	public static boolean copyFile(String oldPathFile, String newPathFile) {
		boolean ret = false;
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) { // 文件存在时
				writeText(newPathFile, "", "");
				inputStream = new FileInputStream(oldPathFile); // 读入原文件
				outputStream = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inputStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					outputStream.write(buffer, 0, byteread);
					outputStream.flush();
				}
				ret = true;
			}
		} catch (Exception e) {
		    e.printStackTrace();
			ret = false;
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null)
					outputStream.close();
			} catch (Exception ex) {
				ret = false;
			}
		}
		return ret;
	}

	/**
	 * 复制目录
	 * 
	 * @param oldPath
	 *            准备拷贝的目录
	 * @param newPath
	 *            指定绝对路径的新目录
	 * @param isCopyFolder
	 *            是否复制根目录 true 为复制根目录 false 为不复制根目录，只复制根目录下的所有文件以及文件夹
	 * @return 成功复制返回true 遭遇异常返回false
	 */
	public static boolean copyFolder(String oldPath, String newPath,
			boolean isCopyFolder) {
		boolean ret = false;
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {

			createFolders(newPath);
			oldPath = oldPath.replace(File.separator, "/");
			File file = new File(oldPath);
			String[] files = file.list();
			File temp = null;
			String oldForder;
			for (int i = 0; i < files.length; i++) {
				if (oldPath.endsWith("/")) {
					oldPath = oldPath.substring(0, oldPath.length() - 1);
				}
				oldForder = oldPath.substring(oldPath.lastIndexOf("/") + 1);
				temp = new File(oldPath + File.separator + files[i]);
				if (temp.isFile()) {
					inputStream = new FileInputStream(temp);

					if (isCopyFolder) {
						createFolders(newPath + "/" + oldForder);
						outputStream = new FileOutputStream(newPath + "/"
								+ oldForder + "/" + (temp.getName()).toString());
					} else {
						outputStream = new FileOutputStream(newPath + "/"
								+ (temp.getName()).toString());
					}

					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = inputStream.read(b)) != -1) {
						outputStream.write(b, 0, len);
						outputStream.flush();
					}
					ret = true;
				} else if (temp.isDirectory()) {// 如果是子文件夹
					if (isCopyFolder) {
						copyFolder(oldPath + "/" + files[i], newPath + "/"
								+ oldForder + "/" + files[i], isCopyFolder);
					} else {
						copyFolder(oldPath + "/" + files[i], newPath + "/"
								+ files[i], isCopyFolder);
					}
					ret = true;
				}
			}
		} catch (Exception e) {
			ret = false;
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null)
					outputStream.close();
			} catch (Exception ex) {
				ret = false;
			}
		}
		return ret;
	}

	/**
	 * 移动文件
	 * 
	 * @param oldPath
	 *            准备移动的文件
	 * @param newPath
	 *            移动到新绝对路径带文件名
	 * @return 成功移动返回true 遭遇异常返回false
	 */
	public static boolean moveFile(String oldPath, String newPath) {
		boolean ret = false;
		if (copyFile(oldPath, newPath)) {
			if (deleteFile(oldPath))
				ret = true;
		}
		return ret;
	}

	/**
	 * 移动目录
	 * 
	 * @param oldPath
	 *            准备移动的目录
	 * @param newPath
	 *            移动到指定绝对路径的新目录
	 * @param isMoveFolder
	 *            是否移动根目录 true 为移动根目录 false 为不移动根目录，只移动根目录下的所有文件以及文件夹
	 * @return 成功移动返回true 遭遇异常返回false
	 */
	public static boolean moveFolder(String oldPath, String newPath,
			boolean isMoveFolder) {
		boolean ret = false;
		if (copyFolder(oldPath, newPath, isMoveFolder)) {
			if (deleteFolder(oldPath))
				ret = true;
		}
		return ret;
	}

	/**
	 * 搜索文件夹
	 * 
	 * @param folderPath
	 *            文件夹路径
	 * @param folderName
	 *            要搜索的文件夹名称
	 * @return 返回文件夹路径
	 */
	public static String searchFolders(String folderPath, String folderName) {
		folderPath = folderPath.replace(File.separator, "/");
		try {
			File tempfile = new File(folderPath);
			String tempPath;
			if(!tempfile.exists()) return "";
			if (tempfile.isDirectory()) {
				File[] fList = tempfile.listFiles();
				for (int i = 0; i < fList.length; i++) 
				{
					if (fList[i].isDirectory()) 
					{
						if (folderPath.endsWith("/"))
							folderPath = folderPath.substring(0, folderPath.length() - 1);
						tempPath =  folderPath + "/" + fList[i].getName();
						if ((fList[i].getName()).equals(folderName))
						{
							return tempPath;
						}
						else
						{
							tempPath = searchFolders(folderPath + "/" + fList[i].getName(),folderName);
							if(!tempPath.equals(""))return  tempPath;
						}
					}
				}
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	/**
	 * 搜索文件
	 * 
	 * @param folderPath
	 *            文件夹路径
	 * @param fileName
	 *            要搜索的文件名称
	 * @return 返回文件路径
	 */
	public static String searchFile(String folderPath, String fileName) {
		folderPath = folderPath.replace(File.separator, "/");
		try {
			File tempfile = new File(folderPath);
			String tempPath;
			if(!tempfile.exists()) return "";
			if(tempfile.isFile())
			{
				if(tempfile.getName().equals(fileName)) return folderPath;
			}
			if (tempfile.isDirectory()) {
				File[] fList = tempfile.listFiles();
				for (int i = 0; i < fList.length; i++) 
				{
					if (folderPath.endsWith("/"))
						folderPath = folderPath.substring(0, folderPath.length() - 1);
					tempPath = searchFile(folderPath + "/" + fList[i].getName(),fileName);
					if(!tempPath.equals(""))return  tempPath;
				}
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}
	
	/**
     * 下载网络文件并保存
     * @author Rocye(叶鹏)
     * @param urlStr 网络地址
     * @param filePath 保存后的文件路径
     * @param filename 保存后的文件名
     * @param boolean 保存成功与否
     */
	public static boolean downloadWebFile(String urlStr, String filePath, String filename){
	    InputStream is = null;
	    OutputStream os = null;
	    try{
	        // 构造URL
	        URL url = new URL(urlStr);
	        // 打开连接
	        URLConnection con = url.openConnection();
	        // 输入流
	        is = con.getInputStream();
	        // 1K的数据缓冲
	        byte[] bs = new byte[1024];
	        // 读取到的数据长度
	        int len;
	        // 输出的文件流
	        File fileP = new File(filePath);
	        if(!fileP.exists()){
	            fileP.mkdirs();
	        }
	        os = new FileOutputStream(filePath + filename);
	        // 开始读取
	        while ((len = is.read(bs)) != -1) {
	            os.write(bs, 0, len);
	        }
	        return true;
	    }catch (Exception e) {
	        logger.error("下载图片时：" + e.getMessage());
            return false;
        }finally{
            try {
                if(os != null){
                    os.close();
                }
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
	}   
	
	/**
	 * 判断文件是否存在
	 * @param filePath
	 * @return
	 */
	public static boolean isExit(String filePath){
	    try{
	        File file = new File(filePath);
	        return file.exists();
	    }catch (Exception e) {
	        e.printStackTrace();
            return false;
        }
	}

	/**
	 * 测试方法
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
        FileIo.copyFolder("C:\\zz1\\a\\b", "C:\\zz2\\c", false);
	}
}
