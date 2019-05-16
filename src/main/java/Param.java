/** 
 * 说明：数据字典 
 */
public class Param {

	private static final long serialVersionUID =1L;
	
	public Param(){}
	
	/**
	 * 定义公共的数据字典rootId为-1，以免为空
	 */
	public static final String PARAM_PUBLIC_ROOTID = "-1";

	
	private String strTypeName;					//类型名称  
	
	private String strParamName;				//字典名称
	
	private String strEasyName;                 //字典简称

	private String strParamCode;				//字典编码  
	
	private String strRemark;					//备注  
	
	private String strState;					//  0启用，1禁用
	
	private Integer intSort;					//序号  
	
	private Integer intOldSort = 0;				//原序号,不存数据库

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "数据字典："+this.getStrEasyName()+"，参数code："+this.getStrParamCode();
	}


	public String getStrTypeName() {
		return strTypeName;
	}
	public void setStrTypeName(String strTypeName) {
		this.strTypeName = strTypeName;
	}
	public String getStrParamName() {
		return strParamName;
	}
	public void setStrParamName(String strParamName) {
		this.strParamName = strParamName;
	}
	public String getStrEasyName() {
		return strEasyName;
	}
	public void setStrEasyName(String strEasyName) {
		this.strEasyName = strEasyName;
	}
	public String getStrParamCode() {
		return strParamCode;
	}
	public void setStrParamCode(String strParamCode) {
		this.strParamCode = strParamCode;
	}
	public String getStrRemark() {
		return strRemark;
	}
	public void setStrRemark(String strRemark) {
		this.strRemark = strRemark;
	}
	public String getStrState() {
		return strState;
	}
	public void setStrState(String strState) {
		this.strState = strState;
	}
	public Integer getIntSort() {
		return intSort;
	}
	public void setIntSort(Integer intSort) {
		this.intSort = intSort;
	}
	public Integer getIntOldSort() {
		return intOldSort;
	}
	public void setIntOldSort(Integer intOldSort) {
		this.intOldSort = intOldSort;
	}
}

