/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifmultitool;

/**
 *
 * @author Umidah
 */
public class ScoreCalculator {
    
    private int noteCount;
    
    private double perfectHit = 1.00;
    
    private double comboMultiplier[] = {1.00, 1.10, 1.15, 1.20, 1.25, 1.30, 1.35};
    
    private double noteType = 1.00;
    
    private double attributeMultiplier = 1.00;
    
    private double groupMultiplier = 1.00;
    
    private double scoreContribution;
    
    public ScoreCalculator(Card card, UserInput userInput, int finalBaseStats) {
        
        if (userInput.getAttribute().equals(card.getCardAttribute())) {
			attributeMultiplier = 1.10;
	}
		
	if (!"N".equals(card.getRarity())) {
			
		if (userInput.getSong().equals(card.getMainUnit())) {
			groupMultiplier = 1.10;
		}
			
	}
        
        scoreContribution = scoreContribution(userInput, finalBaseStats);
                
    }
    
    public int getScoreContribution() {
        return (int) scoreContribution;
    }
    
    private double scoreContribution(UserInput userInput, int finalBaseStats) {
        
		noteCount = userInput.getNoteCount();
		
		
		if (noteCount > 800) {
			return CalculateOver800(finalBaseStats);
		}
		
		else if (noteCount <= 800 && noteCount > 600) {
			return Calculate600To800(finalBaseStats);
		}
		
		else if (noteCount <= 600 && noteCount > 400) {
			return Calculate400To600(finalBaseStats);
		}
		
		else if (noteCount <= 400 && noteCount > 200) {
			return Calculate200To400(finalBaseStats);
		}
		
		else if (noteCount <= 200 && noteCount > 100) {
			return Calculate100To200(finalBaseStats);
		}
		
		else if (noteCount <= 100 && noteCount > 50) {
			return Calculate50To100(finalBaseStats);
		}
		
		else {
			return Calculate0To50(finalBaseStats);
		}
	}
	
	private double CalculateOver800(int finalBaseStats) {
		
		int remainder = noteCount - 800;
		noteCount = noteCount - remainder;
		
		return Calculate600To800(finalBaseStats) + (remainder * perfectCalculator(finalBaseStats, comboMultiplier[6]));
		
	}
	
	private double Calculate600To800(int finalBaseStats) {
		
		int remainder = noteCount - 600;
		noteCount = noteCount - remainder;
		
		return Calculate400To600(finalBaseStats) + (remainder *  perfectCalculator(finalBaseStats, comboMultiplier[5]));
		
	}
	
	private double Calculate400To600(int finalBaseStats) {
		
		int remainder = noteCount - 400;
		noteCount = noteCount - remainder;
		
		return Calculate200To400(finalBaseStats) + (remainder *  perfectCalculator(finalBaseStats, comboMultiplier[4]));
		
	}
	
	private double Calculate200To400(int finalBaseStats) {
		
		int remainder = noteCount - 200;
		noteCount = noteCount - remainder;
		
		return Calculate100To200(finalBaseStats) + (remainder *  perfectCalculator(finalBaseStats, comboMultiplier[3]));
		
	}
	
	private double Calculate100To200(int finalBaseStats) {
		
		int remainder = noteCount - 100;
		noteCount = noteCount - remainder;
		
		return Calculate50To100(finalBaseStats) + (remainder *  perfectCalculator(finalBaseStats, comboMultiplier[2]));
		
	}
	
	private double Calculate50To100(int finalBaseStats) {
		
		int remainder = noteCount - 50;
		noteCount = noteCount - remainder;
		
		return Calculate0To50(finalBaseStats) + (remainder *  perfectCalculator(finalBaseStats, comboMultiplier[1]));
		
	}
	
	private double Calculate0To50(int finalBaseStats) {
		return noteCount * perfectCalculator(finalBaseStats, comboMultiplier[0]);
	}
	
	private double perfectCalculator(int finalBaseStats, double comboMultiplier) {
		
		return Math.floor(finalBaseStats * 0.0125 * perfectHit 
				   						 * comboMultiplier 
				   						 * noteType 
				   						 * attributeMultiplier 
				   						 * groupMultiplier);
		
	}
    
}
