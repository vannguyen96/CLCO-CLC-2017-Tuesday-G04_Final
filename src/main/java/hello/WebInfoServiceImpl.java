package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.webInfoDAO;
import hello.webInfo;
@Service("webpageService")
@Transactional
public class WebInfoServiceImpl implements WebInfoService {
	@Autowired
	webInfoDAO dao;
	@Override
	public webInfo findById(int id) {
	
		return dao.findByid(id);
	}

	@Override
	public void saveWebpage(webInfo webInfo) {
		dao.save(webInfo);
		
	}

	@Override
	public void updateWebpage(webInfo webInfo) {
		System.out.println(webInfo.getPage_id());
		String s=webInfo.getPage_id().toString();
		int id=Integer.parseInt(s);
		webInfo entity=dao.findByid(id);
		if(entity!=null){
			entity.setDescription(webInfo.getDescription());
			entity.setContent(webInfo.getContent());
		}
	}

	@Override
	public void deleteUserById(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<webInfo> findAllWebPages() {
		return dao.findAllWebpages();
	}

}
