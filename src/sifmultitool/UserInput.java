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
public class UserInput {
    
        private String card1ID;
	private String card2ID;
        private String card3ID;
        private String card4ID;
        private String card5ID;
        private String card6ID;
        private String card7ID;
        private String card8ID;
        private String card9ID;
        
        private int card1SkillLevel;
        private int card2SkillLevel;
        private int card3SkillLevel;
        private int card4SkillLevel;
        private int card5SkillLevel;
        private int card6SkillLevel;
        private int card7SkillLevel;
        private int card8SkillLevel;
        private int card9SkillLevel;
	
	private boolean card1Idolized;
	private boolean card2Idolized;
        private boolean card3Idolized;
        private boolean card4Idolized;
        private boolean card5Idolized;
        private boolean card6Idolized;
        private boolean card7Idolized;
        private boolean card8Idolized;
        private boolean card9Idolized;
	
	private String attribute;
	private String song;
	
	private int noteCount;
	private int time;
	
	private double perfectPercent;
	private int finalScore;
	
	private int starNotes;
	
	private String centerSkill;
        private String centerAttribute;
        private String basedOn;
	private String subSkill;
        
        private String centerSkillFriend;
        private String basedOnFriend;
	private String subSkillFriend;
	
	private String card1SIS;
	private String card2SIS;
        private String card3SIS;
        private String card4SIS;
	private String card5SIS;
        private String card6SIS;
        private String card7SIS;
	private String card8SIS;
        private String card9SIS;
	
	private String calculationMethod;
        
        private boolean matchingFriendCenter;
        
        private boolean normalizeSong;

	public String getCard1ID() {
		return card1ID;
	}

	public void setCard1ID(String card1id) {
		card1ID = card1id;
	}

	public String getCard2ID() {
		return card2ID;
	}

	public void setCard2ID(String card2id) {
		card2ID = card2id;
	}

	public boolean isCard1Idolized() {
		return card1Idolized;
	}

	public void setCard1Idolized(boolean card1Idolized) {
		this.card1Idolized = card1Idolized;
	}

	public boolean isCard2Idolized() {
		return card2Idolized;
	}

	public void setCard2Idolized(boolean card2Idolized) {
		this.card2Idolized = card2Idolized;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int getNoteCount() {
		return noteCount;
	}

	public void setNoteCount(int noteCount) {
		this.noteCount = noteCount;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getPerfectPercent() {
		return perfectPercent;
	}

	public void setPerfectPercent(double perfectPercent) {
		this.perfectPercent = perfectPercent;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getStarNotes() {
		return starNotes;
	}

	public void setStarNotes(int starNotes) {
		this.starNotes = starNotes;
	}

	public String getCenterSkill() {
		return centerSkill;
	}

	public void setCenterSkill(String centerSkill) {
		this.centerSkill = centerSkill;
	}

	public String getSubSkill() {
		return subSkill;
	}

	public void setSubSkill(String subSkill) {
		this.subSkill = subSkill;
	}

	public String getCard1SIS() {
		return card1SIS;
	}

	public void setCard1SIS(String card1sis) {
		card1SIS = card1sis;
	}

	public String getCard2SIS() {
		return card2SIS;
	}

	public void setCard2SIS(String card2sis) {
		card2SIS = card2sis;
	}

	public String getCalculationMethod() {
		return calculationMethod;
	}

	public void setCalculationMethod(String calculationMethod) {
		this.calculationMethod = calculationMethod;
	}

    /**
     * @return the card3ID
     */
    public String getCard3ID() {
        return card3ID;
    }

    /**
     * @param card3ID the card3ID to set
     */
    public void setCard3ID(String card3ID) {
        this.card3ID = card3ID;
    }

    /**
     * @return the card4ID
     */
    public String getCard4ID() {
        return card4ID;
    }

    /**
     * @param card4ID the card4ID to set
     */
    public void setCard4ID(String card4ID) {
        this.card4ID = card4ID;
    }

    /**
     * @return the card5ID
     */
    public String getCard5ID() {
        return card5ID;
    }

    /**
     * @param card5ID the card5ID to set
     */
    public void setCard5ID(String card5ID) {
        this.card5ID = card5ID;
    }

    /**
     * @return the card6ID
     */
    public String getCard6ID() {
        return card6ID;
    }

    /**
     * @param card6ID the card6ID to set
     */
    public void setCard6ID(String card6ID) {
        this.card6ID = card6ID;
    }

    /**
     * @return the card7ID
     */
    public String getCard7ID() {
        return card7ID;
    }

    /**
     * @param card7ID the card7ID to set
     */
    public void setCard7ID(String card7ID) {
        this.card7ID = card7ID;
    }

    /**
     * @return the card8ID
     */
    public String getCard8ID() {
        return card8ID;
    }

    /**
     * @param card8ID the card8ID to set
     */
    public void setCard8ID(String card8ID) {
        this.card8ID = card8ID;
    }

    /**
     * @return the card9ID
     */
    public String getCard9ID() {
        return card9ID;
    }

    /**
     * @param card9ID the card9ID to set
     */
    public void setCard9ID(String card9ID) {
        this.card9ID = card9ID;
    }

    /**
     * @return the card3Idolized
     */
    public boolean isCard3Idolized() {
        return card3Idolized;
    }

    /**
     * @param card3Idolized the card3Idolized to set
     */
    public void setCard3Idolized(boolean card3Idolized) {
        this.card3Idolized = card3Idolized;
    }

    /**
     * @return the card4Idolized
     */
    public boolean isCard4Idolized() {
        return card4Idolized;
    }

    /**
     * @param card4Idolized the card4Idolized to set
     */
    public void setCard4Idolized(boolean card4Idolized) {
        this.card4Idolized = card4Idolized;
    }

    /**
     * @return the card5Idolized
     */
    public boolean isCard5Idolized() {
        return card5Idolized;
    }

    /**
     * @param card5Idolized the card5Idolized to set
     */
    public void setCard5Idolized(boolean card5Idolized) {
        this.card5Idolized = card5Idolized;
    }

    /**
     * @return the card6Idolized
     */
    public boolean isCard6Idolized() {
        return card6Idolized;
    }

    /**
     * @param card6Idolized the card6Idolized to set
     */
    public void setCard6Idolized(boolean card6Idolized) {
        this.card6Idolized = card6Idolized;
    }

    /**
     * @return the card7Idolized
     */
    public boolean isCard7Idolized() {
        return card7Idolized;
    }

    /**
     * @param card7Idolized the card7Idolized to set
     */
    public void setCard7Idolized(boolean card7Idolized) {
        this.card7Idolized = card7Idolized;
    }

    /**
     * @return the card8Idolized
     */
    public boolean isCard8Idolized() {
        return card8Idolized;
    }

    /**
     * @param card8Idolized the card8Idolized to set
     */
    public void setCard8Idolized(boolean card8Idolized) {
        this.card8Idolized = card8Idolized;
    }

    /**
     * @return the card9Idolized
     */
    public boolean isCard9Idolized() {
        return card9Idolized;
    }

    /**
     * @param card9Idolized the card9Idolized to set
     */
    public void setCard9Idolized(boolean card9Idolized) {
        this.card9Idolized = card9Idolized;
    }

    /**
     * @return the card3SIS
     */
    public String getCard3SIS() {
        return card3SIS;
    }

    /**
     * @param card3SIS the card3SIS to set
     */
    public void setCard3SIS(String card3SIS) {
        this.card3SIS = card3SIS;
    }

    /**
     * @return the card4SIS
     */
    public String getCard4SIS() {
        return card4SIS;
    }

    /**
     * @param card4SIS the card4SIS to set
     */
    public void setCard4SIS(String card4SIS) {
        this.card4SIS = card4SIS;
    }

    /**
     * @return the card5SIS
     */
    public String getCard5SIS() {
        return card5SIS;
    }

    /**
     * @param card5SIS the card5SIS to set
     */
    public void setCard5SIS(String card5SIS) {
        this.card5SIS = card5SIS;
    }

    /**
     * @return the card6SIS
     */
    public String getCard6SIS() {
        return card6SIS;
    }

    /**
     * @param card6SIS the card6SIS to set
     */
    public void setCard6SIS(String card6SIS) {
        this.card6SIS = card6SIS;
    }

    /**
     * @return the card7SIS
     */
    public String getCard7SIS() {
        return card7SIS;
    }

    /**
     * @param card7SIS the card7SIS to set
     */
    public void setCard7SIS(String card7SIS) {
        this.card7SIS = card7SIS;
    }

    /**
     * @return the card8SIS
     */
    public String getCard8SIS() {
        return card8SIS;
    }

    /**
     * @param card8SIS the card8SIS to set
     */
    public void setCard8SIS(String card8SIS) {
        this.card8SIS = card8SIS;
    }

    /**
     * @return the card9SIS
     */
    public String getCard9SIS() {
        return card9SIS;
    }

    /**
     * @param card9SIS the card9SIS to set
     */
    public void setCard9SIS(String card9SIS) {
        this.card9SIS = card9SIS;
    }

    /**
     * @return the basedOn
     */
    public String getBasedOn() {
        return basedOn;
    }

    /**
     * @param basedOn the basedOn to set
     */
    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    /**
     * @return the matchingFriendCenter
     */
    public boolean isMatchingFriendCenter() {
        return matchingFriendCenter;
    }

    /**
     * @param matchingFriendCenter the matchingFriendCenter to set
     */
    public void setMatchingFriendCenter(boolean matchingFriendCenter) {
        this.matchingFriendCenter = matchingFriendCenter;
    }

    /**
     * @return the normalizeSong
     */
    public boolean isNormalizeSong() {
        return normalizeSong;
    }

    /**
     * @param normalizeSong the normalizeSong to set
     */
    public void setNormalizeSong(boolean normalizeSong) {
        this.normalizeSong = normalizeSong;
    }

    /**
     * @return the centerSkillFriend
     */
    public String getCenterSkillFriend() {
        return centerSkillFriend;
    }

    /**
     * @param centerSkillFriend the centerSkillFriend to set
     */
    public void setCenterSkillFriend(String centerSkillFriend) {
        this.centerSkillFriend = centerSkillFriend;
    }

    /**
     * @return the basedOnFriend
     */
    public String getBasedOnFriend() {
        return basedOnFriend;
    }

    /**
     * @param basedOnFriend the basedOnFriend to set
     */
    public void setBasedOnFriend(String basedOnFriend) {
        this.basedOnFriend = basedOnFriend;
    }

    /**
     * @return the subSkillFriend
     */
    public String getSubSkillFriend() {
        return subSkillFriend;
    }

    /**
     * @param subSkillFriend the subSkillFriend to set
     */
    public void setSubSkillFriend(String subSkillFriend) {
        this.subSkillFriend = subSkillFriend;
    }

    /**
     * @return the centerAttribute
     */
    public String getCenterAttribute() {
        return centerAttribute;
    }

    /**
     * @param centerAttribute the centerAttribute to set
     */
    public void setCenterAttribute(String centerAttribute) {
        this.centerAttribute = centerAttribute;
    }

    /**
     * @return the card1SkillLevel
     */
    public int getCard1SkillLevel() {
        return card1SkillLevel;
    }

    /**
     * @param card1SkillLevel the card1SkillLevel to set
     */
    public void setCard1SkillLevel(int card1SkillLevel) {
        this.card1SkillLevel = card1SkillLevel;
    }

    /**
     * @return the card2SkillLevel
     */
    public int getCard2SkillLevel() {
        return card2SkillLevel;
    }

    /**
     * @param card2SkillLevel the card2SkillLevel to set
     */
    public void setCard2SkillLevel(int card2SkillLevel) {
        this.card2SkillLevel = card2SkillLevel;
    }

    /**
     * @return the card3SkillLevel
     */
    public int getCard3SkillLevel() {
        return card3SkillLevel;
    }

    /**
     * @param card3SkillLevel the card3SkillLevel to set
     */
    public void setCard3SkillLevel(int card3SkillLevel) {
        this.card3SkillLevel = card3SkillLevel;
    }

    /**
     * @return the card4SkillLevel
     */
    public int getCard4SkillLevel() {
        return card4SkillLevel;
    }

    /**
     * @param card4SkillLevel the card4SkillLevel to set
     */
    public void setCard4SkillLevel(int card4SkillLevel) {
        this.card4SkillLevel = card4SkillLevel;
    }

    /**
     * @return the card5SkillLevel
     */
    public int getCard5SkillLevel() {
        return card5SkillLevel;
    }

    /**
     * @param card5SkillLevel the card5SkillLevel to set
     */
    public void setCard5SkillLevel(int card5SkillLevel) {
        this.card5SkillLevel = card5SkillLevel;
    }

    /**
     * @return the card6SkillLevel
     */
    public int getCard6SkillLevel() {
        return card6SkillLevel;
    }

    /**
     * @param card6SkillLevel the card6SkillLevel to set
     */
    public void setCard6SkillLevel(int card6SkillLevel) {
        this.card6SkillLevel = card6SkillLevel;
    }

    /**
     * @return the card7SkillLevel
     */
    public int getCard7SkillLevel() {
        return card7SkillLevel;
    }

    /**
     * @param card7SkillLevel the card7SkillLevel to set
     */
    public void setCard7SkillLevel(int card7SkillLevel) {
        this.card7SkillLevel = card7SkillLevel;
    }

    /**
     * @return the card8SkillLevel
     */
    public int getCard8SkillLevel() {
        return card8SkillLevel;
    }

    /**
     * @param card8SkillLevel the card8SkillLevel to set
     */
    public void setCard8SkillLevel(int card8SkillLevel) {
        this.card8SkillLevel = card8SkillLevel;
    }

    /**
     * @return the card9SkillLevel
     */
    public int getCard9SkillLevel() {
        return card9SkillLevel;
    }

    /**
     * @param card9SkillLevel the card9SkillLevel to set
     */
    public void setCard9SkillLevel(int card9SkillLevel) {
        this.card9SkillLevel = card9SkillLevel;
    }
    
}
