package kosta.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import kosta.dao.BoardDao;
import kosta.vo.Board2VO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InsertAction {

	@Autowired
	private BoardDao bdao;

	@Autowired
	private uptest up;

	// ��� insert - form
	@RequestMapping(value = "/writef")
	public String writef(Board2VO vo) {
		System.out.println("���form�̾�");
		return "write";
	}

	// ��� insert
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView write(Board2VO vo) throws UnknownHostException {
		ModelAndView ma = new ModelAndView();
		// ������ �޾ƿ��°�
		InetAddress inet = InetAddress.getLocalHost();
		vo.setReip(inet.getHostAddress());
		bdao.addBoard(vo);
		ma.setViewName("redirect:/list.kosta");
		System.out.println("��� �ۼ��Ϸ�");
		return ma;
	}

	// ��� list
	@RequestMapping(value = "/list")
	public ModelAndView list(Board2VO vo) {
		System.out.println("��� ����Ʈ");
		List<Board2VO> list = bdao.listBoard(vo);
		ModelAndView ma = new ModelAndView();
		ma.setViewName("list");
		ma.addObject("list", list);
		return ma;
	}

	// ��� detail
	@RequestMapping(value = "/detail")
	public ModelAndView detail(int no) {
		System.out.println("detail ����");
		ModelAndView ma = new ModelAndView();
		Board2VO vo = bdao.detailBoard(no);
		ma.setViewName("detail");
		ma.addObject("vo", vo);
		return ma;
	}

	// ���� ��� insert
	@RequestMapping(value = "/reboardf")
	public ModelAndView reboardf(Board2VO vo) {
		ModelAndView ma = new ModelAndView();
		ma.addObject("vo", vo);
		ma.setViewName("reboard");
		System.out.println("���ݴ��form�̾�");
		return ma;
	}

	// ������
	// ���� ��� insert
	@RequestMapping(value = "/reboard", method = RequestMethod.POST)
	public ModelAndView reboard(Board2VO vo) throws UnknownHostException {
		System.out.println("���� ��� ����");
		ModelAndView ma = new ModelAndView();
		// ������ �޾ƿ��°�
		InetAddress inet = InetAddress.getLocalHost();
		vo.setReip(inet.getHostAddress());
		System.out.println("insert update�� :" + vo.getRef() + ", " + vo.getSeq());
		bdao.reupBoard(vo);
		System.out.println("insert update�� :" + vo.getRef() + ", " + vo.getSeq());
		ma.setViewName("redirect:/list.kosta");
		System.out.println("��� �ۼ��Ϸ� list��");
		return ma;
	}

	// ���� ��� tx_insert
	@RequestMapping(value = "/tx_reboardf")
	public ModelAndView tx_reboardf(Board2VO vo) {
		ModelAndView ma = new ModelAndView();
		ma.addObject("vo", vo);
		ma.setViewName("tx_reboard");
		return ma;
	}

	// ���� ��� update insert��
	@RequestMapping(value = "/tx_reboard", method = RequestMethod.POST)
	public ModelAndView update(Board2VO vo) throws UnknownHostException {
		System.out.println(vo.getNo());
		System.out.println("=================================================");
		System.out.println("Ʈ����� ��� ����");
		ModelAndView ma = new ModelAndView();

		// ������ �޾ƿ��°�
		InetAddress inet = InetAddress.getLocalHost();
		vo.setReip(inet.getHostAddress());
		up.reupboard(vo);

		ma.setViewName("redirect:/list?no=" + vo.getNo());
		return ma;
	}

}
