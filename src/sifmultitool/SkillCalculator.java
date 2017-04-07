/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifmultitool;

/**
 *
 * @author Alan
 */
public class SkillCalculator {
    
    private String activationCondition;
    private double activationConditionNumber;
    private int activationCount;
    
    private int skillContribution;
    
    public SkillCalculator(Card card, UserInput userInput, double[][] skillTable, int skillLevel) {
        
        skillParser(card, userInput);
        
        double contribution = 0;
        
        if (card.getSkillType().equals("Score")) {
            
            contribution = skillTable[skillLevel - 1][1] * activationCount;
            
            if (userInput.getCalculationMethod().equals("Average")) {
               
                contribution = contribution * (0.01 * skillTable[skillLevel - 1][0]);
                        
            }
            
            if (isSIS(card, userInput, "Ch")) {
                contribution = contribution * 2.5;
            }
            
        }
        
        else if (card.getSkillType().equals("Perfect Lock")) {
            
        }
        
        else if (card.getSkillType().equals("Healer")) {
            
            if (isSIS(card, userInput, "He")) {
                contribution = 480 * skillTable[skillLevel - 1][1] * activationCount;
            
                if (userInput.getCalculationMethod().equals("Average")) {
               
                    contribution = contribution * (0.01 * skillTable[skillLevel - 1][0]);
                        
                }
                
            }
            
        }
        
        skillContribution = Math.round((long) contribution);
        
    }
    
    private boolean isSIS(Card card, UserInput userInput, String SIS) {
        
        if (card.getCardNumber() == 1) {
                
            if (userInput.getCard1SIS().contains(SIS)) {
                return true;
            }
               
        }
            
        else if (card.getCardNumber() == 2) {
            
            if (userInput.getCard2SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 3) {
            
            if (userInput.getCard3SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 4) {
            
            if (userInput.getCard4SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 5) {
            
            if (userInput.getCard5SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 6) {
            
            if (userInput.getCard6SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 7) {
            
            if (userInput.getCard7SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 8) {
            
            if (userInput.getCard8SIS().contains(SIS)) {
                    return true;
            }
                
        }
        
        else if (card.getCardNumber() == 9) {
            
            if (userInput.getCard9SIS().contains(SIS)) {
                    return true;
            }
                
        }
    
        return false;
        
    }
    
    private void skillParser(Card card, UserInput userInput) {
        
        String[] skillDetails = card.getSkillDetails().split(",");
        
        activationCondition = skillDetails[0];
        
        activationConditionNumber = Double.parseDouble(skillDetails[0].replaceAll("[\\D]", ""));
        
        if (activationCondition.contains("perfect")) {
            int noteCount = Math.round((long) ((0.01 * userInput.getPerfectPercent()) * userInput.getNoteCount()));
            activationCount = Math.round((long) (noteCount / activationConditionNumber));
        }
        
        else if (activationCondition.contains("seconds")) {
            activationCount = Math.round((long) (userInput.getTime() / activationConditionNumber));
        }
        
        else {
            activationCount = Math.round((long) (userInput.getNoteCount() / activationConditionNumber));
        }

    }

    /**
     * @return the skillContribution
     */
    public int getSkillContribution() {
        return skillContribution;
    }
    
}