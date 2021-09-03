package com.csu.im.message;

import com.csu.im.vo.ImTo;
import com.csu.im.vo.ImUser;
import lombok.Data;

@Data
public class ChatImMess {

    private ImUser mine;
    private ImTo to;

}
