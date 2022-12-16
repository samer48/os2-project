package thesleepingBarber;

public class barber implements Runnable{
    Functions barbers;
    private int barbersnumber;
    
    barber(Functions f, int n){
        barbers=f;
        barbersnumber=n;
    }
    
    @Override
    public void run() {
            int i;
            while (true) {
            barbers.takesAnap(barbersnumber);
            i = barbers.enterCustomer(barbersnumber);
            if(i==1) break;
            barbers.doshaving();
            }
        }
    }
