package akka.app.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import akka.app.messages.Result;
import akka.dispatch.Resume;

/**
 * Created by liguodong on 2015/12/17.
 */
public class MasterActor extends UntypedActor{

    //创建AggregateActor是由Akka系统创建的
    //Master只是拿到的一个句柄引用
    private ActorRef aggregateActor = getContext().actorOf(
            new Props(AggregateActor.class),"aggregate");




    private ActorRef reduceActor = getContext().actorOf(
            new Props(new UntypedActorFactory(){
                public UntypedActor create(){
                    return new ReduceActor(aggregateActor);
                }
            }),"reduce");//因为ReduceActor工作完成之后，要交给AggregateActor。


    private ActorRef mapActor = getContext().actorOf(
            new Props(new UntypedActorFactory(){
                public UntypedActor create(){
                    return new MapActor(reduceActor);
                }
            }),"map");


    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            mapActor.tell(message);
        } else if (message instanceof Result){
            aggregateActor.tell(message);
        } else{
            unhandled(message);
        }
    }
}
