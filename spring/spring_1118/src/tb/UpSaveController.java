package tb;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.TvoDao;
import vo.TBboardVO;

@Controller
public class UpSaveController {
	
	
	@RequestMapping(value="/upsave.kosta", method=RequestMethod.POST)
	public ModelAndView save(@RequestParam("tvo") TBboardVO tvo, HttpServletRequest request){
		//이미지가 저장될 절대 경로를 지정
		//세션을 생성
		ModelAndView mav = new ModelAndView("success");
		HttpSession session = request.getSession();
		String r_path = session.getServletContext().getRealPath("/");
		System.out.println(r_path);
		//시스템에 맞응 documentroot(최상위 경로) 경로를 가져온다.
		String img_path ="\\img\\";
		System.out.println(img_path);
		//조합해서 이미지가 저장될 경로값을 구현
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path);
		//upload된 파일 이름은 path에 설정
		//String oriFn = tvo.getMfile().getOriginalFilename();
		//path.append(oriFn);
		System.out.println(path);
		
		//파일 업로드
		File f = new File(path.toString());
		//try {
			//tvo.getMfile().transferTo(f);
		//} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		//mav.addObject("imgName",oriFn );
		//mav.addObject("path",path);
		return mav;
	}
}
