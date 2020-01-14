package comple.t3h.learnspring;

public class Girl {
    private HairStyle hairStyle;
    private Accessories accessories;
    private Outfit outfit;

    public Girl(HairStyle hairStyle, Accessories accessories, Outfit outfit) {
        this.hairStyle = hairStyle;
        this.accessories = accessories;
        this.outfit = outfit;
    }

    public HairStyle getHairStyle() {
        return hairStyle;
    }

    public void setHairStyle(HairStyle hairStyle) {
        this.hairStyle = hairStyle;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories accessories) {
        this.accessories = accessories;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "hairStyle=" + hairStyle +
                ", accessories=" + accessories +
                ", outfit=" + outfit +
                '}';
    }
}
