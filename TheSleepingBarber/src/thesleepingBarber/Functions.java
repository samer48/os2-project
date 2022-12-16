package thesleepingBarber;

import java.util.concurrent.locks.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Functions {
    private final int NAP_TIME = 5;
    
    private int numberOFcustomers;    
    private int numberOFbarbers;
    private int numberOFchairs;
    
    private int numberOfCurrentCustomers=0;
    private int sleepingBarberNumber=0;
    private int workingBarbersNumber=0;
    private int customersWaitingNumbers=0;
    private int customersComingLaterNumber=0;
    
    private Lock customerssLock;
    private Lock barbersLock;
    private Semaphore customerSemaphore;
    private Semaphore barbersSemaphore;
    
    private Start startModel;
            
    Functions(int noOFbarbers,int noOFcustomers, int noOFchairs, Start s){        
        numberOFcustomers = noOFcustomers;
        numberOFbarbers = noOFbarbers;
        numberOFchairs = noOFchairs;

        customerssLock = new ReentrantLock();
        barbersLock = new ReentrantLock();
        
        customerSemaphore = new Semaphore(0);
        barbersSemaphore = new Semaphore(0);
        
        startModel = s;
    }
    
    public void takesAnap(int threadNo){
        try {
            barbersLock.lock();
            
            if(workingBarbersNumber>0) { 
                workingBarbersNumber--;
                startModel.workingbarbersNumber(workingBarbersNumber);
            }
            
            sleepingBarberNumber++;
            startModel.sleepingbarbersNumber(sleepingBarberNumber);
            Start.barbersTable.setValueAt("Sleeping", threadNo, 1);
            
            barbersLock.unlock();
            
            customerSemaphore.acquire();
                        
            barbersLock.lock();
            sleepingBarberNumber--;
            startModel.sleepingbarbersNumber(sleepingBarberNumber);
            
            workingBarbersNumber++;
            startModel.workingbarbersNumber(workingBarbersNumber);

            barbersLock.unlock();

        } catch (InterruptedException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    int enterCustomer(int threadNo) {
                    if(numberOfCurrentCustomers==0) return 1;
                    
                    barbersLock.lock();  
                    barbersSemaphore.release();
                    Start.barbersTable.setValueAt("Helping a customer", threadNo, 1);
                    barbersLock.unlock();
                    return 0;
    }
        
    public void doshaving(){ 
        try {
            Thread.sleep(NAP_TIME * 1000);
        } catch (InterruptedException e) {  }
    }
    
    public int check(int threadNo) {
        customerssLock.lock();
        if( numberOfCurrentCustomers == (numberOFchairs+numberOFbarbers) ) {
            customerssLock.unlock();
            return 1;}
            numberOfCurrentCustomers++;
            customerssLock.unlock();
            return 0;
    }
    
    public void comebacklater(int threadNo){
        try {
            customerssLock.lock();
            
            customersComingLaterNumber++;
            
            startModel.customersComingLaterNumber(customersComingLaterNumber);
            Start.customersTable.setValueAt("Coming Back Later", threadNo, 1);
            
            customerssLock.unlock();
            
            Thread.sleep(NAP_TIME * 1000);
            
            customerssLock.lock();
            customersComingLaterNumber--;
            startModel.customersComingLaterNumber(customersComingLaterNumber);
            customerssLock.unlock();
        } catch (InterruptedException e) {  }
    }
    
   public void goToTA(int threadNo) {
        customerssLock.lock();
        customerSemaphore.release();
        
        customersWaitingNumbers++;
        startModel.customersWaitingNumbers(customersWaitingNumbers);
        Start.customersTable.setValueAt("Waiting", threadNo, 1);
        
        try {
            customerssLock.unlock();
            barbersSemaphore.acquire();
           
            customerssLock.lock();
            customersWaitingNumbers--;
            startModel.customersWaitingNumbers(customersWaitingNumbers);
            Start.customersTable.setValueAt("Doing shaving", threadNo, 1);
            customerssLock.unlock();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void leave(int threadNo) {
               customerssLock.lock();
               numberOfCurrentCustomers--;
               Start.customersTable.setValueAt("Leaved", threadNo, 1);
               customerssLock.unlock();
    } 
    
}
