public class O2 {

    public O2(String field1, String field2, String field3, String field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    private String field1;
    private String field2;
    private String field3;
    private String field4;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    @Override
    public String toString() {
        return "O2{" +
            "field1='" + field1 + '\'' +
            ", field2='" + field2 + '\'' +
            ", field3='" + field3 + '\'' +
            ", field4='" + field4 + '\'' +
            '}';
    }
}
