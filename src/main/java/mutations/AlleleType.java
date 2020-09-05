package mutations;

public enum AlleleType {
    HEIGHT, BOOTS, CHEST, GLOVES, HELMET, WEAPON;

    public static AlleleType getAlleleType(final int position) {
        switch (position) {
            case 0:
                return HEIGHT;
            case 1:
                return BOOTS;
            case 2:
                return CHEST;
            case 3:
                return GLOVES;
            case 4:
                return HELMET;
            default:
                return WEAPON;
        }
    }
}
