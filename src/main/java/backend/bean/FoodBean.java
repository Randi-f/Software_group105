package backend.bean;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 14:43
 */
public class FoodBean {
    @JSONField(name = "name")
    public  String name;
    @JSONField(name = "introduction")
    public String introduction;

    @JSONField(name = "type")
    public  String type;

    @JSONField(name = "price")
    public int price;

    @JSONField(name = "state")
    public String state;

    public entity.Food converter(){
        return new entity.Food(this.name,this.introduction,this.type,this.price,this.state);
    }

}
