package cn.zyunc.ueasier.quartz.test.util;

import cn.zyunc.ueasier.quartz.test.model.ReadResult;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
public class FileUtil {

	public static ReadResult readLine(String path) throws FileNotFoundException, UnsupportedEncodingException {
		List<Object> dataList = new ArrayList<Object>();
		List<Integer> failureRowIndex = new ArrayList<Integer>();
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(isr);
		ReadResult readResult = new ReadResult();
		int failureRows = 0;
		while (true) {
			try {
				String line = bufferedReader.readLine();
				if (StringUtils.isBlank(line)) {
					break;
				}
                System.out.println(line);
                dataList.add(line);
			} catch (IOException e) {
				e.printStackTrace();
				failureRows++;
				failureRowIndex.add(failureRows);
			}
		}

		try {
			bufferedReader.close();
			isr.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		readResult.setSuccessDataList(dataList);
		readResult.setFailureRows(failureRows);
		readResult.setFailureRowIndex(failureRowIndex);
		return readResult;
	}



    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        readLine("C:\\Users\\Admin\\Desktop\\testFile.txt");
    }



}
