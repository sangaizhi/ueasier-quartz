package cn.zyunc.ueasier.quartz.test.model;

import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
public class ReadResult {

    private String filePath;

    private int successRows;

    private int failureRows;

    private List<Object> successDataList;

    private List<Integer> failureRowIndex;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getSuccessRows() {
        return successRows;
    }

    public void setSuccessRows(int successRows) {
        this.successRows = successRows;
    }

    public int getFailureRows() {
        return failureRows;
    }

    public void setFailureRows(int failureRows) {
        this.failureRows = failureRows;
    }

    public List<Object> getSuccessDataList() {
        return successDataList;
    }

    public void setSuccessDataList(List<Object> successDataList) {
        this.successDataList = successDataList;
    }

    public List<Integer> getFailureRowIndex() {
        return failureRowIndex;
    }

    public void setFailureRowIndex(List<Integer> failureRowIndex) {
        this.failureRowIndex = failureRowIndex;
    }
}
