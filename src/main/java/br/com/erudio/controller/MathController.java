package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.enums.MathOperations;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.utils.UtilsNumber;

@RestController
public class MathController {
	
	@RequestMapping(value = "/calc/{operation}/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double calc(@PathVariable(value ="operation") MathOperations operation ,
			           @PathVariable(value ="numberOne") String numberOne, 
			           @PathVariable(value ="numberTwo") String numberTwo) throws Exception {
		if(!UtilsNumber.isNumeric(numberOne) || !UtilsNumber.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double n1 = UtilsNumber.convertToDouble(numberOne);
		Double n2 = UtilsNumber.convertToDouble(numberTwo);
		
		switch (operation) {
			case SUM : return n1 + n2;
			case SUBTRACTION : return n1 - n2;
			case DIVISION : return n1 / n2 ;
			case MULTIPLY : return n1 * n2;
			case MEAN : return n1 + n2 / 2 ;
			default: throw new Exception("Invalid Operation");
		}
		
	}
	
}
