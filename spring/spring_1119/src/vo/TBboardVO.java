package vo;

import org.springframework.web.multipart.MultipartFile;

public class TBboardVO {
	private String sub, writer, content, pwd,mfile;
	private MultipartFile mfile1;

	

	public MultipartFile getMfile1() {
		return mfile1;
	}

	public void setMfile1(MultipartFile mfile1) {
		this.mfile1 = mfile1;
	}

	public String getSub() {
		return sub;
	}

	public String getMfile() {
		return mfile;
	}

	public void setMfile(String mfile) {
		this.mfile = mfile;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
