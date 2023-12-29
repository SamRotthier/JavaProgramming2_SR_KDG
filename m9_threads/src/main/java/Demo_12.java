import be.kdg.java2.Model.MonsterFactory;
import be.kdg.java2.Model.Monsters;

import java.util.stream.Stream;

public class Demo_12 {

    public static void main(String[] args) throws Exception {
        //Monsters monsters = new Monsters();
        Monsters monsters = new Monsters(10000);
        Runnable r =  () -> Stream.generate(MonsterFactory::newRandomMonster).limit(5000).forEach(monsters::add);

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("na toevoegen door 2 threads met elk 5000 objecten: monsters = " + monsters.getSize());
    }
}

/*
na 4.3 => Treeset is niet threadsafe
na toevoegen door 2 threads met elk 5000 objecten: monsters = 5002

en error
Exception in thread "Thread-1" java.util.ConcurrentModificationException
	at java.base/java.util.TreeMap$PrivateEntryIterator.nextEntry(TreeMap.java:1486)
	at java.base/java.util.TreeMap$KeyIterator.next(TreeMap.java:1540)
	at be.kdg.java2.Model.Monsters.add(Monsters.java:13)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.stream.SliceOps$1$1.accept(SliceOps.java:200)
	at java.base/java.util.stream.StreamSpliterators$InfiniteSupplyingSpliterator$OfRef.tryAdvance(StreamSpliterators.java:1358)
	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
	at Demo_12.lambda$main$0(Demo_12.java:10)
	at java.base/java.lang.Thread.run(Thread.java:833)
 */

/*
Na 4.4 => ArrayBlockingQueue
na toevoegen door 2 threads met elk 5000 objecten: monsters = 10000
 */