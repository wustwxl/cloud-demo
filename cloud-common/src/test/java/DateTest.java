import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.wust.utils.DateUtil;

public class DateTest {

	@Test
	public void test() throws ParseException {

		String createStr = DateUtil.getCurrDateTime();
		String expiryStr = DateUtil.dayMove(createStr,30);
		Date createDate = DateUtil.parseDate(createStr);
		Date expiryDate = DateUtil.parseDate(expiryStr);

		System.out.println("createDate   "+createDate);

		System.out.println("expiryStr   "+expiryStr);

		System.out.println("expiryDate   "+expiryDate);
	}

}
