package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Service
public class PrimeServiceStub implements PrimeService
{   
    private List<FoundPrime> primes = new CopyOnWriteArrayList<>();
    @Override
    public void addFoundPrime( FoundPrime foundPrime )
    {
        primes.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        return primes;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        //TODO
        return null;
    }
}
