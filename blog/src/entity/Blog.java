package entity;

public class Blog {
	private String bid;
	private String bname;
	private String bcontent;
	
	
	public Blog(String bname, String bcontent) {
		super();
		this.bname = bname;
		this.bcontent = bcontent;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", bname=" + bname + ", bcontent="
				+ bcontent + "]/n";
	}
	
	

}
