package Future;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.dispatch.Await;
import akka.dispatch.Future;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Duration;
import akka.util.Timeout;

/**
 * Created by liguodong on 2015/12/20.
 */
public class ActorWithFuture {

    public static class Worker extends UntypedActor {

        private final LoggingAdapter log = Logging.getLogger(getContext().system(),this);

        @Override
        public void onReceive(Object message) throws Exception {
            if(message instanceof  String){
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "is going to work!!!");
                System.out.println("The content of the received message is : " + message);

                //发送回去
                this.getSender().tell("Power comes from Love !",this.getSelf());
                System.out.println("The sender's path=" + this.getSender().path());
                getContext().stop(this.getSelf());//停止当前actor

                log.info("|||{} has stopped", this.getSelf().path());
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("The name of current thread is : " + Thread.currentThread().getName());
        ActorSystem system = ActorSystem.create("System");
        //创建workActor
        ActorRef worker = system.actorOf(new Props(Worker.class),"WorkerActor");
        //Timeout给Worker发送信息之后等待结果的超时时间
        Timeout timeout = new Timeout(Duration.create(5,"seconds"));
        Future<Object> future = Patterns.ask(worker,"For Free,For everyone,Forever,For love...",timeout);
        String result = (String) Await.result(future,timeout.duration());
        System.out.println(result);
    }





}
