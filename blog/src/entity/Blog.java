package entity;

public class Blog {
	private int b2b;
	private String bname;
	private String bcontent;
	private int abc;
	
	
	public int getAaaaa() {
		return b2b;
	}

	public void setAaaaa(int aaaaa) {
		this.b2b = aaaaa;
	}

	public int getAbc() {
		return abc;
	}

	public void setAbc(int abc) {
		this.abc = abc;
	}

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
		return b2b;
	}

	public void setBid(int bid) {
		this.b2b = bid;
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
		return "Blog [bid=" + b2b + ", bname=" + bname + ", bcontent="
				+ bcontent + "]/n";
	}
	
	

}
