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
public class BaseStatsCalculator {
    
    private final int finalBaseStats;
    private int centerBoostAmount = 0;
    private int centerBoostAmountFriend = 0;
	
	public BaseStatsCalculator(Card card, UserInput userInput, CardCalculationResults result) {
		
                int initialStat;
            
                if (userInput.getAttribute().contains("Smile")) {
                    initialStat = card.getSmilePoints();
                    
                    if (card.getCardAttribute().contains("Smile")) {
                        initialStat = initialStat + card.getBondPoints();
                    }
                    
                }
                
                else if (userInput.getAttribute().contains("Pure")) {
                    initialStat = card.getPurePoints();
                    
                    if (card.getCardAttribute().contains("Pure")) {
                        initialStat = initialStat + card.getBondPoints();
                    }
                }
                
                else {
                    initialStat = card.getCoolPoints();
                    
                    if (card.getCardAttribute().contains("Cool")) {
                        initialStat = initialStat + card.getBondPoints();
                    }
                    
                }
                
                result.setInitialBaseStat(initialStat);
                
            //    System.out.println(initialStat);
		
		int modifiedBase = calculateTeamBoost(initialStat, userInput);
                
            //    System.out.println(modifiedBase);
                
                modifiedBase = modifiedBase + calculateFlatBoost(initialStat, userInput, card);
                
            //    System.out.println(modifiedBase);
                
                centerBoostAmount = calculateCenterBoost(modifiedBase, userInput, card) + calculateSubBoost(modifiedBase, userInput, card);
                
                if (userInput.isMatchingFriendCenter()) {
                    centerBoostAmountFriend = calculateCenterBoostFriend(modifiedBase, userInput, card) + calculateSubBoostFriend(modifiedBase, userInput, card);
                }
                
            //  System.out.println(finalBaseStats);   
                
            finalBaseStats = modifiedBase + centerBoostAmount + centerBoostAmountFriend;
            
            result.setFinalBaseStat(finalBaseStats);
		
	}
        
        private int calculateCenterBoost(int modifiedBase, UserInput userInput, Card card) {
            
            if (userInput.getCenterSkill() == null) {
                return 0;
            }
            
            if (userInput.getCenterSkill().contains("3")) {
                return (int) Math.ceil(modifiedBase * 0.03);
            }
            
            else if (userInput.getCenterSkill().contains("6")) {
                return (int) Math.ceil(modifiedBase * 0.06);
            }
            
            else if (userInput.getCenterSkill().contains("7")) {
                return (int) Math.ceil(modifiedBase * 0.07);
            }
            
            else if (userInput.getCenterSkill().contains("9")) {
                return (int) Math.ceil(modifiedBase * 0.09);
            }
            
            else if (userInput.getCenterSkill().contains("12")) {
                
                if (userInput.getBasedOn().contains("Smile")) {
                    return (int) Math.ceil(card.getSmilePoints() * 0.12);
                }
                
                else if (userInput.getBasedOn().contains("Pure")) {
                    return (int) Math.ceil(card.getPurePoints() * 0.12);
                }
                
                else if (userInput.getBasedOn().contains("Cool")) {
                    return (int) Math.ceil(card.getCoolPoints() * 0.12);
                }
                
            }
            
            return 0;
            
        }
        
        private int calculateCenterBoostFriend(int modifiedBase, UserInput userInput, Card card) {
            
            if (userInput.getCenterSkillFriend().contains("3")) {
                return (int) Math.ceil(modifiedBase * 0.03);
            }
            
            else if (userInput.getCenterSkillFriend().contains("6")) {
                return (int) Math.ceil(modifiedBase * 0.06);
            }
            
            else if (userInput.getCenterSkillFriend().contains("7")) {
                return (int) Math.ceil(modifiedBase * 0.07);
            }
            
            else if (userInput.getCenterSkillFriend().contains("9")) {
                return (int) Math.ceil(modifiedBase * 0.09);
            }
            
            else if (userInput.getCenterSkillFriend().contains("12")) {
                
                if (userInput.getBasedOnFriend().contains("Smile")) {
                    return (int) Math.ceil(card.getSmilePoints() * 0.12);
                }
                
                else if (userInput.getBasedOnFriend().contains("Pure")) {
                    return (int) Math.ceil(card.getPurePoints() * 0.12);
                }
                
                else if (userInput.getBasedOnFriend().contains("Cool")) {
                    return (int) Math.ceil(card.getCoolPoints() * 0.12);
                }
                
            }
            
            return 0;
            
        }
        
        private int calculateSubBoost(int modifiedBase, UserInput userInput, Card card) {
            
            if (userInput.getSubSkill() == null) {
                return 0;
            }
            
            if (userInput.getCenterSkill().contains("7")) {
                
                if (userInput.getSubSkill().contains("μ's") && card.getMainUnit().contains("μ's")) {
                    return (int) Math.ceil(modifiedBase * 0.01);
                }
                
                else if (userInput.getSubSkill().contains("Aqours") && card.getMainUnit().contains("Aqours")) {
                    return (int) Math.ceil(modifiedBase * 0.01);
                }
                
                else if (userInput.getSubSkill().contains("First") && card.getYear().contains("First")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("Second") && card.getYear().contains("Second")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("Third") && card.getYear().contains("Third")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("Printemps") && card.getSubUnit().contains("Printemps")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("Lily") && card.getSubUnit().contains("Lily")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("BiBi") && card.getSubUnit().contains("BiBi")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("CYaRon") && card.getSubUnit().contains("CYaRon")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("AZALEA") && card.getSubUnit().contains("AZALEA")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("Guilty") && card.getSubUnit().contains("Guilty")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
            }
            
            else if (userInput.getCenterSkill().contains("9") ||
                     userInput.getCenterSkill().contains("12")) {
                
                if (userInput.getSubSkill().contains("μ's") && card.getMainUnit().contains("μ's")) {
                    return (int) Math.ceil(modifiedBase * 0.03);
                }
                
                else if (userInput.getSubSkill().contains("Aqours") && card.getMainUnit().contains("Aqours")) {
                    return (int) Math.ceil(modifiedBase * 0.03);
                }
                
                else if (userInput.getSubSkill().contains("First") && card.getYear().contains("First")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("Second") && card.getYear().contains("Second")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("Third") && card.getYear().contains("Third")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("Printemps") && card.getSubUnit().contains("Printemps")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("Lily") && card.getSubUnit().contains("Lily")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("BiBi") && card.getSubUnit().contains("BiBi")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("CYaRon") && card.getSubUnit().contains("CYaRon")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("AZALEA") && card.getSubUnit().contains("AZALEA")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkill().contains("Guilty") && card.getSubUnit().contains("Guilty")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
            }
            
            return 0;
            
        }
        
        private int calculateSubBoostFriend(int modifiedBase, UserInput userInput, Card card) {
            
            if (userInput.getCenterSkillFriend().contains("7")) {
                
                if (userInput.getSubSkillFriend().contains("μ's") && card.getMainUnit().contains("μ's")) {
                    return (int) Math.ceil(modifiedBase * 0.01);
                }
                
                else if (userInput.getSubSkillFriend().contains("Aqours") && card.getMainUnit().contains("Aqours")) {
                    return (int) Math.ceil(modifiedBase * 0.01);
                }
                
                else if (userInput.getSubSkillFriend().contains("First") && card.getYear().contains("First")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("Second") && card.getYear().contains("Second")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkill().contains("Third") && card.getYear().contains("Third")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("Printemps") && card.getSubUnit().contains("Printemps")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("Lily") && card.getSubUnit().contains("Lily")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("BiBi") && card.getSubUnit().contains("BiBi")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("CYaRon") && card.getSubUnit().contains("CYaRon")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("AZALEA") && card.getSubUnit().contains("AZALEA")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
                else if (userInput.getSubSkillFriend().contains("Guilty") && card.getSubUnit().contains("Guilty")) {
                    return (int) Math.ceil(modifiedBase * 0.02);
                }
                
            }
            
            else if (userInput.getCenterSkillFriend().contains("9") ||
                     userInput.getCenterSkillFriend().contains("12")) {
                
                if (userInput.getSubSkillFriend().contains("μ's") && card.getMainUnit().contains("μ's")) {
                    return (int) Math.ceil(modifiedBase * 0.03);
                }
                
                else if (userInput.getSubSkillFriend().contains("Aqours") && card.getMainUnit().contains("Aqours")) {
                    return (int) Math.ceil(modifiedBase * 0.03);
                }
                
                else if (userInput.getSubSkillFriend().contains("First") && card.getYear().contains("First")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("Second") && card.getYear().contains("Second")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("Third") && card.getYear().contains("Third")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("Printemps") && card.getSubUnit().contains("Printemps")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("Lily") && card.getSubUnit().contains("Lily")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("BiBi") && card.getSubUnit().contains("BiBi")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("CYaRon") && card.getSubUnit().contains("CYaRon")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("AZALEA") && card.getSubUnit().contains("AZALEA")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
                else if (userInput.getSubSkillFriend().contains("Guilty") && card.getSubUnit().contains("Guilty")) {
                    return (int) Math.ceil(modifiedBase * 0.06);
                }
                
            }
            
            return 0;
            
        }
        
        private int calculateFlatBoost(int initialStat, UserInput userInput, Card card) {
            
            int flatBoost = 0;
            
            if (card.getCardNumber() == 1) {
                
                if (userInput.getCard1SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard1SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard1SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard1SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 2) {
                
                if (userInput.getCard2SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard2SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard2SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard2SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 3) {
                
                if (userInput.getCard3SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard3SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard3SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard3SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 4) {
                
                if (userInput.getCard4SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard4SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard4SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard4SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 5) {
                
                if (userInput.getCard5SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard5SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard5SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard5SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 6) {
                
                if (userInput.getCard6SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard6SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard6SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard6SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 7) {
                
                if (userInput.getCard7SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard7SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard7SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard7SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else if (card.getCardNumber() == 8) {
                
                if (userInput.getCard8SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard8SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard8SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard8SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            else {
                
                if (userInput.getCard9SIS().contains("Ki")) {
                    flatBoost = flatBoost + 200;
                }
                
                if (userInput.getCard9SIS().contains("Pe")) {
                    flatBoost = flatBoost + 450;
                }
                
                if (userInput.getCard9SIS().contains("Ri")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.10);
                }
                
                if (userInput.getCard9SIS().contains("Cr")) {
                    flatBoost = flatBoost + (int) Math.ceil(initialStat * 0.16);
                }
                
            }
            
            return flatBoost;
            
        }
        
        private int calculateTeamBoost(int initialStat, UserInput userInput) {
            
            int result = 0;
            
            // Veil
            if (userInput.getCard1SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard2SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard3SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard4SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard5SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard6SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard7SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard8SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            if (userInput.getCard9SIS().contains("Ve")) {
                result = result + (int) Math.ceil(initialStat * 0.024);
            }
            
            // Aura
            if (userInput.getCard1SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard2SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard3SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard4SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard5SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard6SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard7SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard8SIS().contains("Au")) {
                result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            if (userInput.getCard9SIS().contains("Au")) {
               result = result + (int) Math.ceil(initialStat * 0.018);
            }
            
            return initialStat + result;
            
        }
	
    public int getFinalBaseStats() {
	return finalBaseStats;
    }

    /**
     * @return the centerBoostAmount
     */
    public int getCenterBoostAmount() {
        return centerBoostAmount;
    }
    
    public int getCenterBoostAmountFriend() {
        return centerBoostAmountFriend;
    }
    
}
