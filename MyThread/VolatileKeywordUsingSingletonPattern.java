package org.example.MyThread;

public class VolatileKeywordUsingSingletonPattern {

    /** instance is a shared variable it will read or write directly from the RAM not in Cache .... this is my understanding need to recheck once**/
    private volatile static VolatileKeywordUsingSingletonPattern instance ;

    private VolatileKeywordUsingSingletonPattern(){
        System.out.println(" Volatile Keyword Using Singleton Pattern instantiated");
    }

    public static VolatileKeywordUsingSingletonPattern getInstance(){
        if (instance == null){
            synchronized (VolatileKeywordUsingSingletonPattern.class){
                if (instance == null){
                    instance = new VolatileKeywordUsingSingletonPattern();
                }
            }
        }
        return instance;
    }
}
