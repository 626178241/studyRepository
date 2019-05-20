package lb.study.other.spring.websocket.websocketinduction.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/20 15:55
 */
@ServerEndpoint(value = "/websocket")
@Slf4j
@Component
public class MyWebSocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * @description 连接建立成功调用的方法
     * @param session：可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/5/20 16:19
     */
    @OnOpen
    public void onOpen(Session session ){
        this.session=session;
        addOnlineCount();
        webSockets.add(this);
        log.info("有新的连接加入！当前连接数=="+onlineCount);
    }

    /**
     * @description 连接关闭时调用
     * @param
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/5/20 16:22
     */
    @OnClose
    public void onClose(){
        webSockets.remove(this);
        subOnlineCount();
        log.info("有一连接关闭！当前连接数=="+onlineCount);
    }

    /**
     * @description 收到客户端消息后调用的方法
     * @param message：客户端发送过来的消息
     * @param session：可选的参数
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/5/20 16:25
     */
    @OnMessage
    public void OnMessage(String message,Session session ){
        log.info("来自客户端的消息:" + message);
        sendInfo(message);
    }

    /**
     * @description 发生错误时调用
     * @param session：可选的参数
     * @param throwable：异常类型
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/5/20 16:28
     */
    @OnError
    public void onError(Session session,Throwable throwable ){
        log.error("发生错误=========="+throwable.getMessage());
        throwable.printStackTrace();
    }

    /**
     * @description 发送消息--这个跟上面的方法不同，这个是自己加的方法（没用注解）
     * @param message：
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/5/20 16:30
     */
    public void sendMessage(String message ) throws IOException {
        System.out.println(session);
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * @description 群发消息，给每台连接的发送消息
     * @param message
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/5/20 17:37
     */
    public static void sendInfo(String message ){
        //群发消息
        for (MyWebSocket item : webSockets) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }

    public Session getSession(){
        return session;
    }
}
