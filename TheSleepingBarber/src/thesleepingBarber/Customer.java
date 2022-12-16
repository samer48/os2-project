package thesleepingBarber;

public class Customer implements Runnable{
    Functions customers;
    private int threadNo;
    
    Customer(Functions f, int n){
        customers = f;
        threadNo =n;
    }
    
    @Override
    public void run(){ 
        while(true) {
        int i =customers.check(threadNo);
            
        if(i==1) {
            customers.comebacklater(threadNo);
            continue;
        }
            
        customers.goToTA(threadNo);
            
        customers.doshaving();

        customers.leave(threadNo);
        break;
                    }
        }
    }
