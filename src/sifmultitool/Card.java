/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifmultitool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Alan
 */
public class Card {
    
    private int cardNumber;
	
	private boolean special;
	
	private String name;
	private String year;
	private String mainUnit;
	private String subUnit;
	
	private String id;
	private String cardAttribute;
	
	private String rarity;
	private boolean promo;
	private String collection;
	
	private String baseStatType;
	private int baseStat;
	private int offStat;
	
	private int bondPoints;

	private String skillType;
	private String skillDetails;
        
        private int[][] skillLevelTable;
	

	public Card(JSONArray cardJSON, UserInput userInput, int cardNumber) {
		JSONObject card;
		
		this.cardNumber = cardNumber;
		
		try {
			card = cardJSON.getJSONObject(0);
			
			this.special = card.getBoolean("is_special");
			
			if (this.special) {
				
				return;
				
			}
			
			this.rarity = card.getString("rarity");
			
			this.promo = card.getBoolean("is_promo");
			
			this.collection = card.getString("translated_collection");
			
			// GET idol information
			
			idolObject(card);
			
			// GET calculator information
			this.id = Integer.toString(card.getInt("id"));
			this.cardAttribute = card.getString("attribute");
			
			SkillDetails(card);
			
				// If card is idolized
				if (isIdolized(userInput, cardNumber) || this.promo) {
					
					this.baseStat = baseStatIdolized(userInput, card);
					
					this.offStat = offStatIdolized(userInput, card);
					
					this.bondPoints = bondPoints();
					
				}
				
				// Else card is not idolized
				else {
					
					this.baseStat = baseStatNotIdolized(userInput, card);
					
					this.offStat = offStatNotIdolized(userInput, card);
					
					this.bondPoints = bondPoints() / 2;
					
				}

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        private boolean isIdolized(UserInput userInput, int cardNumber) {
            
            if (cardNumber == 1) {
                return userInput.isCard1Idolized();
            }
            
            else if (cardNumber == 2) {
                return userInput.isCard2Idolized();
            }
            
            else if (cardNumber == 3) {
                return userInput.isCard3Idolized();
            }
            
            else if (cardNumber == 4) {
                return userInput.isCard4Idolized();
            }        
            
            else if (cardNumber == 5) {
                return userInput.isCard5Idolized();
            }
            
            else if (cardNumber == 6) {
                return userInput.isCard6Idolized();
            }
            
            else if (cardNumber == 7) {
                return userInput.isCard7Idolized();
            }
            
            else if (cardNumber == 8) {
                return userInput.isCard8Idolized();
            }
            
            else  {
                return userInput.isCard9Idolized();
            }
            
        }

	private void SkillDetails(JSONObject card) throws JSONException {
		if (!"N".equals(this.rarity)) {
                    this.setSkillDetails(card.getString("skill_details"));
			
			if (this.getSkillDetails().contains("score")) {
                            this.setSkillType("Score");
			}
			
			else if (this.getSkillDetails().contains("turning")) {
                            this.setSkillType("Perfect Lock");
			}
			
			else {
                            this.setSkillType("Healer");
			}
		}
		
		else {
                    this.setSkillType("");
		}
	}

	private void idolObject(JSONObject card) throws JSONException {
		
		JSONObject idol = card.getJSONObject("idol");
                this.setName(idol.getString("name"));
                this.setYear(idol.getString("year"));
		
		if (!"N".equals(this.rarity)) {
			
                    this.setMainUnit(idol.getString("main_unit"));
                    this.setSubUnit(idol.getString("sub_unit"));
		
		}
	}

	private int baseStatIdolized(UserInput userInput, JSONObject obj) throws JSONException {
		// GET base stat
		if ("Smile".equals(userInput.getAttribute())) {
                    this.setBaseStatType("Smile");
			return obj.getInt("idolized_maximum_statistics_smile");
		}
		
		else if ("Pure".equals(userInput.getAttribute())) {
                    this.setBaseStatType("Pure");
			return obj.getInt("idolized_maximum_statistics_pure");
		}
		
		else if ("Cool".equals(userInput.getAttribute())) {
                    this.setBaseStatType("Cool");
			return obj.getInt("idolized_maximum_statistics_cool");
		}
		
		else {
			return 0;
		}
	}

	private int baseStatNotIdolized(UserInput userInput, JSONObject obj) throws JSONException {
		// GET not idolized base stats
		if ("Smile".equals(userInput.getAttribute())) {
                    this.setBaseStatType("Smile");
			return obj.getInt("non_idolized_maximum_statistics_smile");
		}
		
		else if ("Pure".equals(userInput.getAttribute())) {
                    this.setBaseStatType("Pure");
			return obj.getInt("non_idolized_maximum_statistics_pure");
		}
		
		else if ("Cool".equals(userInput.getAttribute())) {
                    this.setBaseStatType("Cool");
			return obj.getInt("non_idolized_maximum_statistics_cool");
		}
		
		else {
			return 0;
		}
	}
	
	private int offStatIdolized(UserInput userInput, JSONObject card) throws JSONException {
		if (userInput.getCenterSkill().contains("12% Smile")) {
			
			if (userInput.getCenterSkill().contains("Pure")) {
				
				return card.getInt("idolized_maximum_statistics_pure");
				
			}
			
			else if (userInput.getCenterSkill().contains("Cool")) {
				
				return card.getInt("idolized_maximum_statistics_cool");
				
			}
			
			else {
				// Set Off Stat to equal Base Stat
				return this.getBaseStat();
				
			}
			
		}
		
		else if (userInput.getCenterSkill().contains("12% Pure")) {
			
			if (userInput.getCenterSkill().contains("Smile")) {
				
				return card.getInt("idolized_maximum_statistics_smile");
				
			}
			
			else if (userInput.getCenterSkill().contains("Cool")) {
				
				return card.getInt("idolized_maximum_statistics_cool");
				
			}
			
			else {
				// Set Off Stat to equal Base Stat
				return this.getBaseStat();
				
			}
			
		}
		
		else if (userInput.getCenterSkill().contains("12% Cool")) {
			
			if (userInput.getCenterSkill().contains("Smile")) {
				
				return card.getInt("idolized_maximum_statistics_smile");
				
			}
			
			else if (userInput.getCenterSkill().contains("Pure")) {
				
				return card.getInt("idolized_maximum_statistics_pure");
				
			}
			
			else {
				// Set Off Stat to equal Base Stat
				return this.getBaseStat();
				
			}
			
		}
		
		else {
			// Set Off Stat to equal Base Stat
			return this.getBaseStat();
			
		}
	}
	
	private int offStatNotIdolized(UserInput userInput, JSONObject card) throws JSONException {
		if (userInput.getCenterSkill().contains("12% Smile")) {
			
			if (userInput.getCenterSkill().contains("Pure")) {
				
				return card.getInt("non_idolized_maximum_statistics_pure");
				
			}
			
			else if (userInput.getCenterSkill().contains("Cool")) {
				
				return card.getInt("non_idolized_maximum_statistics_cool");
				
			}
			
			else {
				// Set Off Stat to equal Base Stat
				return this.getBaseStat();
				
			}
			
		}
		
		else if (userInput.getCenterSkill().contains("12% Pure")) {
			
			if (userInput.getCenterSkill().contains("Smile")) {
				
				return card.getInt("non_idolized_maximum_statistics_smile");
				
			}
			
			else if (userInput.getCenterSkill().contains("Cool")) {
				
				return card.getInt("non_idolized_maximum_statistics_cool");
				
			}
			
			else {
				// Set Off Stat to equal Base Stat
				return this.getBaseStat();
				
			}
			
		}
		
		else if (userInput.getCenterSkill().contains("12% Cool")) {
			
			if (userInput.getCenterSkill().contains("Smile")) {
				
				return card.getInt("non_idolized_maximum_statistics_smile");
				
			}
			
			else if (userInput.getCenterSkill().contains("Pure")) {
				
				return card.getInt("non_idolized_maximum_statistics_pure");
				
			}
			
			else {
				// Set Off Stat to equal Base Stat
				return this.getBaseStat();
				
			}
			
		}
		
		else {
			// Set Off Stat to equal Base Stat
			return this.getBaseStat();
			
		}
	}

	private int bondPoints() {
		// GET bond points
		if ("N".equals(this.getRarity())) {
			
			return 50;
			
		}
		
		else if ("R".equals(this.getRarity())) {
			
			return 200;
			
		}
		
		else if ("SR".equals(this.getRarity())) {
			
			return 500;
			
		}
		
		else if ("SSR".equals(this.getRarity())) {
			
			return 750;
			
		}
		
		else if ("UR".equals(this.getRarity())) {
			
			return 1000;
			
		}
		
		
		else {
			
			return 0;
			
		}
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public boolean getSpecial() {
		return isSpecial();
	}
	
	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public String getMainUnit() {
		return mainUnit;
	}

	public String getSubUnit() {
		return subUnit;
	}

	public String getId() {
		return id;
	}

	public String getCardAttribute() {
		return cardAttribute;
	}

	public String getRarity() {
		return rarity;
	}
	
	public boolean getPromo() {
		return isPromo();
	}
	
	public String getCollection() {
		return collection;
	}
	
	public String getBaseStatType() {
		return baseStatType;
	}

	public int getBaseStat() {
		return baseStat;
	}
	
	public int getOffStat() {
		return offStat;
	}

	public int getBondPoints() {
		return bondPoints;
	}

	public String getSkillType() {
		return skillType;
	}

	public String getSkillDetails() {
		return skillDetails;
	}

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the special
     */
    public boolean isSpecial() {
        return special;
    }

    /**
     * @param special the special to set
     */
    public void setSpecial(boolean special) {
        this.special = special;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @param mainUnit the mainUnit to set
     */
    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    /**
     * @param subUnit the subUnit to set
     */
    public void setSubUnit(String subUnit) {
        this.subUnit = subUnit;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param cardAttribute the cardAttribute to set
     */
    public void setCardAttribute(String cardAttribute) {
        this.cardAttribute = cardAttribute;
    }

    /**
     * @param rarity the rarity to set
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * @return the promo
     */
    public boolean isPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(String collection) {
        this.collection = collection;
    }

    /**
     * @param baseStatType the baseStatType to set
     */
    public void setBaseStatType(String baseStatType) {
        this.baseStatType = baseStatType;
    }

    /**
     * @param baseStat the baseStat to set
     */
    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    /**
     * @param offStat the offStat to set
     */
    public void setOffStat(int offStat) {
        this.offStat = offStat;
    }

    /**
     * @param bondPoints the bondPoints to set
     */
    public void setBondPoints(int bondPoints) {
        this.bondPoints = bondPoints;
    }

    /**
     * @param skillType the skillType to set
     */
    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    /**
     * @param skillDetails the skillDetails to set
     */
    public void setSkillDetails(String skillDetails) {
        this.skillDetails = skillDetails;
    }

    /**
     * @return the skillLevelTable
     */
    public int[][] getSkillLevelTable() {
        return skillLevelTable;
    }

    /**
     * @param skillLevelTable the skillLevelTable to set
     */
    public void setSkillLevelTable(int[][] skillLevelTable) {
        this.skillLevelTable = skillLevelTable;
    }
    
}
