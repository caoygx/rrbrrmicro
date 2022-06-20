import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.no.global.entity.QueryBean;
import com.rrbrr.kity.entity.FamilyMember;
import com.rrbrr.kity.mapper.FamilyMemberMapper;
import com.rrbrr.kity.service.impl.BaseServiceImpl;
import com.rrbrr.kity.service.impl.FamilyMemberServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class jsonTest {



    @Test
    public void test(){
        String json = "{\"root\":{\"data\":{\"id\":\"cdfryz77uwao\",\"created\":1628592816150,\"text\":\"导入\"},\"children\":[{\"data\":{\"id\":\"cdgn01y2gutc\",\"created\":1628680354899,\"text\":\"csv2x1x\"},\"children\":[]},{\"data\":{\"id\":\"cdh84jktqt4w\",\"created\":1628739950045,\"text\":\"csvx2x2\"},\"children\":[]},{\"data\":{\"id\":\"cecogmmbquio\",\"created\":1631934393451,\"text\":\"csxv313\"},\"children\":[]},{\"data\":{\"id\":\"cecoh358exhc\",\"created\":1631934429423,\"text\":\"gz\"},\"children\":[]},{\"data\":{\"id\":\"cecohs2i7vnk\",\"created\":1631934483678,\"text\":\"zip\"},\"children\":[]}]},\"template\":\"default\",\"theme\":\"fresh-blue\",\"version\":\"1.4.43\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject root = jsonObject.getJSONObject("root");

        //parseJson(root);


    }

//    @Autowired
//    FamilyMemberServiceImpl familyMemberService;

    @Test
    public void test2(){

        FamilyMemberServiceImpl familyMemberService = new FamilyMemberServiceImpl();
        QueryBean queryBean = new QueryBean();
        queryBean.setPage(1);
        FamilyMember familyMember = new FamilyMember();
        familyMember.setStatus(1);
        IPage<FamilyMember> familyMemberIPage = familyMemberService.selectPage(queryBean, familyMember, 1);
        System.out.println(familyMemberIPage);

    }





}
