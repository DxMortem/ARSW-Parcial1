package edu.eci.arsw.primefinder;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder{
        private static List<PrimeThread> primeThreads = new LinkedList<>();
	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs, int threads) throws InterruptedException{
                
                BigInteger a=_a;
                BigInteger b=_b;
                int numTot = b.intValue()-a.intValue();
                int range = numTot / threads;
                BigInteger tempI;
                BigInteger tempF;
                for(int i=0; i<threads;i++){
                    if(i==threads-1){
                        tempI = BigInteger.valueOf(a.intValue()+range*i);
                        primeThreads.add(new PrimeThread(tempI,b, prs));
                    }else{
                        tempI = BigInteger.valueOf(a.intValue()+range*i);
                        tempF = BigInteger.valueOf(a.intValue()+range*(i+1));
                        primeThreads.add(new PrimeThread(tempI,tempF, prs)); 
                    }
                }
                
                for(PrimeThread i:primeThreads){
                    i.start();
                }
                for(PrimeThread i:primeThreads){
                    i.join();
                }  
	}
        
        public static void pause(){
            for(PrimeThread i:primeThreads){
                i.pause();
            }
        }
        
        public static void inicie(){
            for(PrimeThread i:primeThreads){
                i.inicie();
            }
        }
	
        public static boolean isRunning(){
            boolean running = false;
            for(PrimeThread i:primeThreads){
                if(i.isRunning()){
                    running = true;
                }
            }
            return running;
        }
	
	
	
	
}
