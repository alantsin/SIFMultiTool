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
 * @author Umidah
 */
public class Card {
    
    private int cardNumber;
    private JSONObject card;
	
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
        
        private int smilePoints;
        private int purePoints;
        private int coolPoints;
	
	private int bondPoints;

	private String skillType;
	private String skillDetails;
        
        private double[][] skillLevelTable;
	

	public Card(JSONArray cardJSON, UserInput userInput, int cardNumber) {
		
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
                        
                        if (cardNumber == 1 && userInput.isCard1Idolized() ||
                            cardNumber == 2 && userInput.isCard2Idolized() ||
                            cardNumber == 3 && userInput.isCard3Idolized() ||
                            cardNumber == 4 && userInput.isCard4Idolized() ||
                            cardNumber == 5 && userInput.isCard5Idolized() ||
                            cardNumber == 6 && userInput.isCard6Idolized() ||
                            cardNumber == 7 && userInput.isCard7Idolized() ||
                            cardNumber == 8 && userInput.isCard8Idolized() ||
                            cardNumber == 9 && userInput.isCard9Idolized()) 
                        {
                            this.smilePoints = Integer.parseInt(card.getString("idolized_maximum_statistics_smile"));
                            this.purePoints = Integer.parseInt(card.getString("idolized_maximum_statistics_pure"));
                            this.coolPoints = Integer.parseInt(card.getString("idolized_maximum_statistics_cool"));
                            this.bondPoints = bondPoints();
                            
                        }
                        
                        else {
                            this.smilePoints = Integer.parseInt(card.getString("non_idolized_maximum_statistics_smile"));
                            this.purePoints = Integer.parseInt(card.getString("non_idolized_maximum_statistics_pure"));
                            this.coolPoints = Integer.parseInt(card.getString("non_idolized_maximum_statistics_cool"));
                            this.bondPoints = bondPoints() / 2;
                        }
			
			// GET idol information
			
			idolObject(card);
			
			// GET calculator information
			this.id = Integer.toString(card.getInt("id"));
			this.cardAttribute = card.getString("attribute");
			
			SkillDetails(card);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    public double[][] getSkillLevelTable() {
        return skillLevelTable;
    }

    /**
     * @param skillLevelTable the skillLevelTable to set
     */
    public void setSkillLevelTable(double[][] skillLevelTable) {
        this.skillLevelTable = skillLevelTable;
    }

    /**
     * @return the smilePoints
     */
    public int getSmilePoints() {
        return smilePoints;
    }

    /**
     * @param smilePoints the smilePoints to set
     */
    public void setSmilePoints(int smilePoints) {
        this.smilePoints = smilePoints;
    }

    /**
     * @return the purePoints
     */
    public int getPurePoints() {
        return purePoints;
    }

    /**
     * @param purePoints the purePoints to set
     */
    public void setPurePoints(int purePoints) {
        this.purePoints = purePoints;
    }

    /**
     * @return the coolPoints
     */
    public int getCoolPoints() {
        return coolPoints;
    }

    /**
     * @param coolPoints the coolPoints to set
     */
    public void setCoolPoints(int coolPoints) {
        this.coolPoints = coolPoints;
    }
    
}
