package tb;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpSaveController {

	@RequestMapping(value = "/upsave.kosta", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("mfile") MultipartFile mfile,
			HttpServletRequest request) {
		// �̹����� ����� ���� ��θ� ����
		// ������ ����
		ModelAndView mav = new ModelAndView("success");
		HttpSession session = request.getSession();
		String r_path = session.getServletContext().getRealPath("/");
		System.out.println(r_path);
		// �ý��ۿ� ���� documentroot(�ֻ��� ���) ��θ� �����´�.
		String img_path = "\\img\\";
		System.out.println(img_path);
		// �����ؼ� �̹����� ����� ��ΰ��� ����
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path);
		// upload�� ���� �̸��� path�� ����
		String oriFn = mfile.getOriginalFilename();
		path.append(oriFn);
		System.out.println(path);

		// ���� ���ε�
		File f = new File(path.toString());
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		mav.addObject("imgName", oriFn);
		return mav;
	}
}
