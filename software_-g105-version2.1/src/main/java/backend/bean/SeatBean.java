package backend.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 21:49
 */
public class SeatBean {
    @JSONField(name = "type")
    protected String type;

    @JSONField(name = "row")
    protected int row;

    @JSONField(name = "col")
    protected int col;

    @JSONField(name = "state")
    protected int state;

    public entity.Seat converter(){
        return new entity.Seat(this.type,this.row,this.col,this.state);
    }

}
