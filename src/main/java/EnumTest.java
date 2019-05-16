
public enum EnumTest {
	nornaml("001","wwd","1"),imnormal("001","wwd","1");
	private String code;
	private String text;
	private String show;
	private EnumTest(String code,String text,String show) {
		this.code = code ;
		this.text = text;
		this.show = show;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}
}
