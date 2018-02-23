package edu.eci.arsw.api.primesrepo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
public class PrimesController
{
    @Autowired
    PrimeService primeService;


    @RequestMapping(value = "/primes", method = RequestMethod.GET)
    public ResponseEntity<?> getPrimes(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return new ResponseEntity(mapper.writeValueAsString(primeService.getFoundPrimes()),HttpStatus.ACCEPTED);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(PrimesController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity("No se encuentran los primos",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postPrimes(@RequestBody FoundPrime o){
        primeService.addFoundPrime(o);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/primes/{primenumber}", method = RequestMethod.GET)
    public ResponseEntity<?> getPrimeNumber(@PathVariable String primenumber){
        return new ResponseEntity<>(primeService.getPrime(primenumber),HttpStatus.ACCEPTED);
    }
    

    //TODO implement additional methods provided by PrimeService
    


}
