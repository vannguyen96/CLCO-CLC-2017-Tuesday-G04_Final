package hello;
import java.util.List;
import hello.webInfo;
public interface webInfoDAO {
	webInfo findByid(int id);
	List<webInfo> findAllWebpages();
	void save(webInfo webInfo);
	void deleteById(int id);
}
