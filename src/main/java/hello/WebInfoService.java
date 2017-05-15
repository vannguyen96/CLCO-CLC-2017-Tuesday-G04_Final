package hello;

import hello.webInfo;

import java.util.List;

public interface WebInfoService {
	webInfo findById(int id);
	void saveWebpage(webInfo webInfo);
	void updateWebpage(webInfo webInfo);
	void deleteUserById(int id);
	List<webInfo> findAllWebPages();
}
