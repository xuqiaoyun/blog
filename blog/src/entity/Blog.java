package entity;

public class Blog {
	private int aaaaa;
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

	

	public int getBid() {
		return aaaaa;
	}

	public void setBid(int bid) {
		this.aaaaa = bid;
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
		return "Blog [bid=" + aaaaa + ", bname=" + bname + ", bcontent="
				+ bcontent + "]/n";
	}
	
	

}
