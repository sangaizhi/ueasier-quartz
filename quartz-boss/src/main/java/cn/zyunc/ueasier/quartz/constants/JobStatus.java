package cn.zyunc.ueasier.quartz.constants;

/**
 * created by sangaizhi on 2017/8/11.
 */
public enum JobStatus {
	RUNNING("1", "RUNNING", "运行"), NOT_RUNNING("0", "NOT_RUNNING", "不运行");

	private String value;
	private String label;
	private String name;

	JobStatus(String value, String label, String name) {
		this.value = value;
		this.label = label;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
