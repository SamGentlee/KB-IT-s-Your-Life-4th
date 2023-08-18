package workshop_0724;

import java.util.Date;

import workshop_0724.Service.RentService;
import workshop_0724.VO.RentCar.MyRentBus;
import workshop_0724.VO.RentCar.MyRentCar;
import workshop_0724.VO.RentCar.MyRentSedan;
import workshop_0724.VO.RentCar.MyRentTruck;
import workshop_0724.VO.RentCar.MyRentVan;
import workshop_0724.VO.User.MyRentCarCompanyUser;
import workshop_0724.VO.User.MyRentCarPersonalUser;
import workshop_0724.VO.User.MyRentCarUser;

public class RentExam {

	public static void main(String[] args) {
		
		RentService rs = new RentService();
		
		MyRentCar rc = new MyRentSedan(1111,30000,"승용차",1990,1990,4);
		rs.add(rc);
		rc = new MyRentVan(2222,60000,"승합차",1990,1990,8,1);
		rs.add(rc);
		rc = new MyRentBus(3333,200000,"버스",1990,1990,20);
		rs.add(rc);
		rc = new MyRentTruck(4444,150000,"트럭",1990,1990,4);
		rs.add(rc);
		
		MyRentCarUser rcUser = new MyRentCarPersonalUser(100,"개인회원","홍길동","010-1111-2222");
		rs.add(rcUser);
		rcUser = new MyRentCarCompanyUser(2000, "법인회원", "(주)멀캠", 111111, "070-123-1234");
		rs.add(rcUser);
		
		rs.rent(100, 1000, 60000, new Date(2023-07-01), 7, new Date(2023-07-07), 17);
		rs.rent(1000, 1000, 60000, new Date(2023-07-02), 7, new Date(2023-07-05), 17);
		
		System.out.println(rs.getRentCount());
		
	}

}
