<%@page import="dao.ImgDirDao"%>
<%@page import="vo.ImgDirVO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%

	String path = application.getRealPath("/upload");

	MultipartRequest mr = new MultipartRequest(request, path,
			1024 * 1024 * 5, "euc-kr", new DefaultFileRenamePolicy());


	File s_file = mr.getFile("s_file");

	String fileUrl = application.getContextPath() + "/upload/" + s_file.getName();
	
	//������ �̸��� �����ͺ��̽��� ����.
	//��� �Ķ���͸� vo��ü�� ����
	ImgDirVO vo = new ImgDirVO();
	vo.setWriter(mr.getParameter("writer"));
	vo.setImgpath(s_file.getName());
	//Dao�� ����
	ImgDirDao.getDao().addImg(vo);
	//�̵��� �������� �̵�
	response.sendRedirect("ex3_list.jsp");
%>