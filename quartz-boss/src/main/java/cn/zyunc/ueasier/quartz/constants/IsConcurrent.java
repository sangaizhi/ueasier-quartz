package cn.zyunc.ueasier.quartz.constants;

/**
 * @author sangaizhi
 * @date 2017/8/11
 */
public enum IsConcurrent {
    YES("1", "YES","是"),
    NO("0","NO", "不是")
    ;
    private String value;
    private String label;
    private String name;

    IsConcurrent(String value, String label, String name) {
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
